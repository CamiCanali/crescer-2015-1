<script>

 var brewdog = function(str,str2){
   var count = 0;
   for(var i = 0, tamanho = Math.max(str.length, str2.length); i < tamanho; i++){
     if(str.charAt(i) !== str2.charAt(i)){
       count++;
     }
   }
   return count;
 };


 console.log(brewdog('bacon', 'beico')); // 4
 [
    { params: ['american ipa','american ipa'],                        esperado: 0 },
    { params: ['russian imperial stout','russian imperial vodka'],    esperado: 5 },
    { params: ['1002012','dfgdf12'],                                  esperado: 5 },
    { params: ['k4rol1n','k4thr1n'],                                  esperado: 3 },
    { params: ['a1df222266%334op;','ssdfjfdkjgsdfgofdgudf9g8dufsg'],  esperado: 26 },
  ].forEach(
    function(ct) {
      var res = brewdog(ct.params[0], ct.params[1]);
      console.assert(res === ct.esperado, 'Errooooou! CT:', ct.params, 'Esperado:', ct.esperado, 'Obtido:', res);
    }
  );

</script>
