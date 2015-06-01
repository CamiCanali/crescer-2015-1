using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace aula1
{
    class Program
    {
        string _variavel;
        static void Main(string[] args)
        {
            #region dynamic
            dynamic oi = new ExpandoObject();
            oi.Saudacao = "Ta se loco";
            Console.WriteLine(oi.Saudacao);
            #endregion

            #region arrai
            var numeros = new[] { 1, 2, 3}.ToList();// sem o toList não dá para usar o add
            numeros.Add(4);
            numeros.AddRange(new[] { 4, 5 });
            //list é o array list e o ilist é o list
            //string str = "Ana";
            /*for (int i = 0; i < 10000; i++) {
                Console.WriteLine(i);
            }*/

            /*foreach (var i in numeros)
            {
                Console.WriteLine(i);
            }
             * */

            Action<int> imprimir = i => Console.WriteLine(i + "bacon");
            numeros.ForEach(imprimir);
            new[] { 5, 6, 7 }.ToList().ForEach(imprimir);
            new[] { 8, 9, 10 }.ToList().ForEach(imprimir);
           /* numeros.ForEach((i) =>
            {
                Console.WriteLine(i);
            });*/
            #endregion
            #region Extension Methods
             Console.WriteLine("Ana".ToBacon());
            #endregion

             #region Jedi
             var yoda = new Jedi
             {
                 Nome = "Yoda",
                 Grau = Grau.MESTRE
             };
             //yoda.Nome = "Yoda";
             Console.WriteLine(yoda.Nome);
             #endregion

             #region Date Time
             DateTime agora = DateTime.Now;
             #endregion

             Console.ReadLine();
        }

    }
}
