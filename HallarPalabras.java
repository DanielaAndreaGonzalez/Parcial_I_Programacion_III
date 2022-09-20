/**
 * 
 */
package Logica;

import java.util.ArrayList;

/**
 * @author GonzalezHDanielaA
 *
 */
public class HallarPalabras {
public static void main(String[] args) {
    	
    	ArrayList<String> listaPalabras = new ArrayList<>();
    	String [][] matriz = {
    			{"vacio ","carro"   , "baul" , "perro"},
    			{"Casa"  ,"colombia", "moto" , "caza"},
    			{"llanta","reir"    , "archivo" , "silla"},
    			{"cocina","ola","ave","freir"}
    	};
    	//recorrerMatriz(matriz,0,0,listaPalabras);
    	for(String palabra: recorrerMatriz(matriz, 0, 0, listaPalabras)) {
    		System.out.println("Palabras que tienen dos vocales seguidas: "+palabra);
    	}
    	
    	//boolean bandera = false;
    	//System.out.println(verificarVocalesSeguidas("caza", 0, 1,bandera ));
    	
    }

	public static ArrayList<String> recorrerMatriz(String[][] matriz, int i, int j,ArrayList<String> listaPalabras) {
		
		if(i == matriz.length || j == matriz[i].length){
			System.out.println("Fin del recorrido");
		}else{
			//System.out.print(""+ matriz[i][j]);
			if(verificarVocalesSeguidas(matriz[i][j], 0,1,false))
			{
				listaPalabras.add(matriz[i][j]);
			}
			if(j == matriz[i].length-1){
				i++;
				j = 0;
				System.out.println("");
			}else{
				j++;
			}
			recorrerMatriz(matriz, i, j,listaPalabras);
		}
		return listaPalabras;
	}
	
	public static boolean verificarVocalesSeguidas(String palabra, int i, int j,boolean bandera)
	{
		
		if(j==palabra.length()-1)
		{
			if(verificarVocal(palabra.charAt(i)) && verificarVocal(palabra.charAt(j)))
			{
				bandera = true;
			}
			return bandera;
		}
		else
		{
			if(verificarVocal(palabra.charAt(i)) && verificarVocal(palabra.charAt(j)))
			{
				bandera = true;
			}
		}
		return verificarVocalesSeguidas(palabra, i+1, j+1,bandera);
	}
	
	public static boolean verificarVocal(char c)
	{
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
		{
			return true;
		}
		else {
			return false;
		}
		
	}
}
