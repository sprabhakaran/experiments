function decrementAndAdd(a, b){
   function add(c, d){
      return c + d;
   }
   a--;
   b = b - 1;
   return add(a,b)
}

// test the code
function incrementAndMultiply(a, b){
    function multiply(c, d){
      return c * d;
    }
    a++;
    b = b + 1;
    return multiply(a, b)
}
