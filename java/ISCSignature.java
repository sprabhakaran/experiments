
import org.apache.commons.codec.binary.Hex;
import java.security.PrivateKey;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.Signature;
import java.security.*;
import java.security.interfaces.*;

public class ISCSignature {

	public static final char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static void main(String arg[]){
		try{
			System.out.println(sign());
		}catch(Exception ex){
			System.out.println(ex);
		}
	}

	public static String sign() throws Exception {
		PrivateKey pk = getPrivateKey();
		// NOTE: Currently request URI / query string is not used as it will demand consistent usage by services via URL HttpClient etc
		// So only time is taken as payload for calculating signature , it can also be used for time check in future if required
		// without changing the mechanism
		String currentTimeStr = String.valueOf("1548137750856");
		byte[] reqBytes = currentTimeStr.getBytes();
		/* Create a Signature object and initialize it with the private key */
		// TODO: Should this be made configurable ?
		Signature rsa = Signature.getInstance("MD5withRSA");

		rsa.initSign(pk);
		rsa.update(reqBytes);

		byte[] realSig = rsa.sign();


		String sStr = BASE16_ENCODE(realSig);
		System.out.println(sStr);
		
		return getISCSignatureHash("PaliConnect", currentTimeStr, sStr);
	}

	private static String getISCSignatureHash(String serviceName, String currentTimeStr, String sStr) {
		return serviceName + "-" + currentTimeStr + "-" + sStr;
	}

	public static String BASE16_ENCODE(byte[] input) {
		char[] b16 = new char[input.length * 2];
		int i = 0;
		for (byte c : input) {
			int low = (int) (c & 0x0f);
			int high = (int) ((c & 0xf0) >> 4);
			b16[i++] = HEX[high];
			b16[i++] = HEX[low];
		}
		return new String(b16);
	}

	public static PrivateKey getPrivateKey() {

		String privateKeyStr = "30820155020100300d06092a864886f70d01010105000482013f3082013b020100024100a634f1a8c6250e3fc7d27c9c69cc45833cec5edf5a7b795afb8f3d359bc9e4654bd50c7c84d1c9b8c056c0248382fa093f78d123b9b89ef930ce94f54cd98a090203010001024066acf25517033148498348a3bfe0075949bba3e84b175822d2a0ec693fb27b3aef8ba7d829b9a7370d16a7f6a43bfcb7a97a230a1ead96567ab9c2ff22173501022100eb3f66e717d44f76dbce3566037abb2b679b05ec8b40474fdffb5b1b277b6691022100b4de64780357fe8228d69032fc0018660b0c23b011da6f080af3d7b9353fd7f9022100e549127ec2d707ec8d285b1b66e0c474f5b23effe269701805f2f3457021f241022072831f4f10a6e49f59e5c6f450b26ac0289c6df7eac5c6686c2ec8551d8ea759022100c0c501ffbf6360484461927a5000e17dfa38b0d92fde228f4bbe46f223210651";

		Hex hexCodec = new Hex();
			
        try {
            if (privateKeyStr != null) {
                byte[] privateKeyBytes = (byte[]) hexCodec.decode(privateKeyStr);
                return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
            }
        } catch (Exception se) {
            throw new RuntimeException("Error Initializing PriVateKey :" + se.getMessage()); //No I18N
        }

        return null;
	}

}