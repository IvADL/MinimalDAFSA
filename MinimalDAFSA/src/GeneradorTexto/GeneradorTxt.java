package GeneradorTexto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorTxt {
	public GeneradorTxt(int li,int lf,int np,int lp){
		generarArchivoTxt(li,lf,np,lp);
	}
	public GeneradorTxt(){}
	public static void main(String[] args){
	
		new GeneradorTxt().generarArchivoTxt(97, 100, 5, 5);
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
	private boolean estaPalabra(String pal,String[] dic,int j){
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
	private void texto(String[] A,int n){
		File archivo=new File("texto.txt");
		BufferedWriter escribir;
		try {
			escribir = new BufferedWriter(new FileWriter(archivo));
		for(int i=n;i>0;i--){
			for(int j=0;j<A.length;j++)
				if(A[j].length()==i)
					escribir.write(A[j]+"\r\n");
		}
			escribir.close();
		} catch (IOException e) {
			System.out.println("ERROR : " + e) ;
		}
	}
	
}
