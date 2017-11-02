package GeneradorTexto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorTxt {
	public GeneradorTxt(int li,int lf,int np,int lp){
		generarArchivoTxt(li,lf,np,lp);
	}
	public static void main(String[] args){
		new GeneradorTxt(97,100,5,5);
	}
	//Genera un archivo con texto aleatorios
	public void generarArchivoTxt(int li,int lf,int np, int lp){
		//Letras Ascii 97=a 98=b 99=c ..... 122=z
		int letini=li;
		int letfin=lf;
		int npalabras=np;
		int longitudPalabra=lp;
		String[] diccionario=new String[npalabras];
		for(int i=0;i<npalabras;i++){
			int longiPal=(int)(Math.random()*(longitudPalabra)+1);
			String palabra="";
			for(int j=0;j<longiPal;j++){
				int letraAle= (int)Math.floor(Math.random()*(letfin-letini)+letini);
				palabra=palabra+(char)letraAle;
			}
			if(estaPalabra(palabra,diccionario,i))
				i--;
			else
				diccionario[i]=palabra;
		}
		texto(diccionario,longitudPalabra);
	}
	//Verifica si pal esta en el array dic con un j de tope de palabras
	public static boolean estaPalabra(String pal,String[] dic,int j){
		boolean esta=false;
		int i=0;
		while( i<j && !esta){
			esta=(dic[i].equals(pal))?true:false;
			i++;
		}		
		return esta;
	}
	//Ordena las palabras por longitud y luego usando compare to
	//Luego crea el archivo txt
	public static void texto(String[] A,int n){
		String[] merge=new String[A.length];
		int p=0;
		for(int i=n;i>0;i--){
			int can=cantidad(A,i);
			String[] aux=new String[can];
			for(int j=0,k=0;j<A.length && k<can;j++)
				if(A[j].length()==i){
					aux[k]=(A[j]);k++;
					}
			ordenarTexto(aux);
			System.arraycopy(aux, 0, merge, p, aux.length);
			p=p+can;
		}
		//Se crea el archivo txt
		File archivo=new File("texto.txt");
		BufferedWriter escribir;
		try {
			escribir = new BufferedWriter(new FileWriter(archivo));
			for(String m:merge)
				escribir.write(m+"\r\n");
			escribir.close();
		} catch (IOException e) {
			System.out.println("ERROR : " + e) ;
		}
	}
	//Señala la cantidad de apariciones en el arreglo A con longitud n
	public static int cantidad(String[] A, int n){
		int c=0;
		for(int i=0;i<A.length;i++)
			if(A[i].length()==n)
				c++;
		return c;
	}
	//Ordena usando compare to
	public static void ordenarTexto(String[] A){
		for (int i = 0; i < A.length; i++) {
			String aux = A[i];
	    	int j = i;
	    	while (j > 0 && aux.compareTo(A[j-1])<0) {
	    		A[j] = A[j-1];
	    	    j--;
	    	}
	    	A[j] = aux;
	    }
	}
	
}
