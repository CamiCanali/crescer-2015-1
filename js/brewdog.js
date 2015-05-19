<script>
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
 params.sort(function(a,b){
   return a.localeCompare(b);
 });

 var stringsearch = "o", str = "this is foo bar";
for (var count = -1, index = 0; index != -1; count++, index = str.indexOf(stringsearch, index + 1));
count;
function brewdog(str, str2){
  for(var count =-1, index = 0, index != -1; count++, index = str.localeCompare(str2), index + 1);
  return count;
}
</script>
