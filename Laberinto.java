/**
 * 
 */
package Logica;

/**
 * @author GonzalezHDanielaA
 *
 */
public class Laberinto {
	
	public String [][] laberinto={ 
			 {" ", "P", "X", " ", "P", "P", " ", "P" },
			 {" ", "P", "P", " ", "P", "P", " ", "P" },
			 {" ", " ", " ", " ", " ", " ", " ", " " },
			 {"P", " ", "P", "P", " ", "P", "P", " " },
			 {"P", " ", "X", "P", " ", "P", "P", " " },
			 {" ", " ", " ", " ", " ", " ", " ", " " },
			 {"P", "X", "P", " ", "P", "P", " ", "P" },
		    };
	 
	 public static int contadorPresos;
	 public static int contadorPresosFaltantes;
	
	public static void main(String[] args) {
		Laberinto m = new Laberinto(); 
		m.laberinto[5][7] = "Y"; 	   
		m.resuelve(0, 0); 			   
		System.out.println(m.imprimirLaberinto());
		
		if (contadorPresosFaltantes>0) {
			System.out.println("Sí se escaparaon presos una cantidad de presos faltantes: "+ (contadorPresosFaltantes));			
		}else{
			System.out.println("No se escaparon presos");
		}
		
		System.out.println("Cantidad de presos encontrados: " + contadorPresos);
	}
	
	 public void resuelve(int x, int y){ 
	        if (paso(x, y)) { 			
	            laberinto[x][y] = "S"; 	
		    }
	    }
	    
   private boolean paso(int x, int y ) 
   {

//   	 if (laberinto[x][y]=="Y"){ 
//   		 return true; 
//   	 }
//   	 
//   	 
//   	 if (laberinto[x][y]=="P"||laberinto[x][y]=="-" ||laberinto[x][y]=="*") { // si llegamos a una pared o al mismo punto,
//   		 return false; 
//   	 }
   	
   	if (laberinto[x][y] == "P") {    		
   		contadorPresos = contadorPresos +1;
   		//System.out.println("Hay preso" + contadorPresos);
   	}
   	
   	if (laberinto[x][y] == "X") {    		
   		contadorPresosFaltantes = contadorPresosFaltantes +1;
   		//System.out.println("No hay preso" + contadorPresosFaltantes);
   	}
   	 
   	 laberinto[x][y]="-";  
   	 
   	 boolean result; 
   	 
   	
   	 if (y < laberinto.length) {
   		 result=paso(x, y+1); 
   		 if (result) {
   			 //System.out.println("Cantidad Presos faltantes: " + (26 - contadorPresosFaltantes));
   			 return true; 
   		 }
   		 
   	 }
   	 
   	if (x+1 < laberinto.length) {
       	 result=paso(x+1, y); 
       	 if (result) {
       		 //System.out.println("Cantidad Presos faltantes: " + (26 - contadorPresosFaltantes));
       		 return true;  
       	 }
   	}
   	 
   	if (x > laberinto.length) {
	    	 result=paso(x-1, y); // intentamos ir hacia ARRIBA. Segunda llamada recursiva
	    	 if (result) {
	    		 //System.out.println("Cantidad Presos faltantes: " + (26 - contadorPresosFaltantes));
	    		 return true;  
	    	 }
   	}
   	 
   
   	if (y > laberinto.length) {
   		 result=paso(x, y-1); 
       	 if (result) {
       		 return true; 
       	 }
   	}
   	 
   	 laberinto[x][y]="*"; 
   	 return false; 

      
   }
		
   private String imprimirLaberinto() {
       String salida = "";    
       for (int x=0; x<laberinto.length; x++) { 
           for (int y=0; y<laberinto[x].length; y++) { 
               salida += laberinto[x][y] + " ";
           }
           salida += "\n"; 
       }
       return salida;
   }

}
