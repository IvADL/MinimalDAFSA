package GeneradorTexto;

public class GeneradorTxt {
	public static void main(String[] args){
		//Letras Ascii 97=a 98=b 99=c ..... 122=z
		int letini=97;
		int letfin=122;
		
		int letraAle= (int)(Math.random()*(letini-letfin)+letini);
		System.out.println((char)letraAle);
	}
}
