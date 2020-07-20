
const crypto = require('crypto');
const URL = require('url');

const PK_HEADER = '\n-----BEGIN PRIVATE KEY-----\n'
const PK_FOOTER = '\n-----END PRIVATE KEY-----\n'

const BASE_URL = 'https://marketplace.walmartapis.com/'

const WALMART_CONSUMER =  "b68d2a72....";
const WALMART_SECRET = "MIICeAIBADANBgkqhkiG9w0BAQEFAA......"
const WALMART_CHANNEL = '0f7274e4-0514-4346-b39d-af100936d'

function generateCorrelationId () {
  return crypto.randomBytes(16).toString('hex')
}

function generateSignature (url, method, timestamp) {
  const privateKey = `${PK_HEADER}${WALMART_SECRET}${PK_FOOTER}`

  // const stringToSign = WALMART_CONSUMER + '\n' +
  //                    url + '\n' +
  //                    method.toUpperCase() + '\n' +
  //                    timestamp + '\n'
  console.log("private key :: ", privateKey);
  const stringToSign = timestamp;

  const sign = crypto.createSign('md5WithRSAEncryption')
  console.log("sign :: ", sign);
  // sign.update("stringToSign")
  return sign.sign(privateKey, 'base64')
}

function doRequest (endpoint, method) {
  const url = URL.resolve(BASE_URL, endpoint)
  const timestamp = Date.now()
  const signature = generateSignature(url, method, timestamp)
  console.log(signature);

  // const headers = {
  //   'WM_SVC.NAME': 'Walmart Marketplace',
  //   'WM_CONSUMER.ID': config.walmart.consumer,
  //   'WM_SEC.TIMESTAMP': timestamp,
  //   'WM_SEC.AUTH_SIGNATURE': signature,
  //   'WM_QOS.CORRELATION_ID': generateCorrelationId(),
  //   'WM_CONSUMER.CHANNEL.TYPE': WALMART_CHANNEL
  // }

  // console.log(headers);
}

doRequest('/v2/feeds', 'get');