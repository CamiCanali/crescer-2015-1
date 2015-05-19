package desagio;

import java.util.ArrayList;
import java.util.List;

public class Desafio {
	
	public List<Integer> indiceMaiusculas(String s){
		boolean temUppercase = !s.equals(s.toLowerCase());
		List<Integer> lista = new ArrayList<Integer>();
		for(int i = 0; i<s.length(); i++){
			if(temUppercase){
				lista.add(i);
			}
		}
		return lista;
	}
	
	public static void main (String args[]){
		Desafio d = new Desafio();
		d.indiceMaiusculas("CWI SoFtware");
		ArrayList<Integer> esperado = [0,1,2,4,6];
		ArrayList<Integer> obtido = ;
		assertEquals(esperado, obtido);
		
	}
}
