package GeneradorTexto;

public class GeneradorTxt {
	public static void main(String[] args){
		//Letras Ascii 97=a 98=b 99=c ..... 122=z
		int letini=97;
		int letfin=100;
		int npalabras=5;
		int longitudPalabra=5;
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
		for(String a:diccionario)
			System.out.println(a);
		ordenarTexto(diccionario);
		System.out.println("ORDENADO");
		for(String a:diccionario)
			System.out.println(a);
	}
	public static boolean estaPalabra(String pal,String[] dic,int j){
		boolean esta=false;
		int i=0;
		while( i<j && !esta){
			esta=(dic[i].equals(pal))?true:false;
			i++;
		}		
		return esta;
	}
	public static void ordenarTexto(String[] cadena){
		for(int i=0;i<cadena.length;i++){
			String pal=cadena[i];
			for(int j=i;j<cadena.length;j++)
				if(cadena[j].compareTo(pal)>0){
					String aux=pal;
					pal=aux;
					cadena[j]=aux;
				}
			cadena[i]=pal;
		}
	}
}
