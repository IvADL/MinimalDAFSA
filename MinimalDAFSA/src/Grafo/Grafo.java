package Grafo;

public class Grafo {
	private Nodo raiz;
    private Nodo fin;
	public Grafo(){
		raiz=new Nodo();
		fin=new Nodo();
		
	}
	public void addPalabra(String palabra){
		Nodo aux=raiz;
		int n=palabra.length();
		char clave;
       int i=0;
       while(i<n&&aux.estaArista(clave=palabra.charAt(i))){
    	   aux=aux.sigNodo(clave);
    	   i++;
       }
       //Falta agregar letras
       if(i<n){
    	   String pal=palabra.substring(i);
    	   completarPalabra(aux,pal);
    	 }       
     }
	//Crea un serie de Nodos para completar la palabra
	public void completarPalabra(Nodo aux,String pal){	    
		char array[]=pal.toCharArray();
		Nodo sig;
		int i=0;
		for(;i<array.length-1;i++){
		    sig=new Nodo();
			aux.addArista(array[i],sig);
			aux=sig;
		}
		aux.addArista(array[i],fin);		
	}
	public static void main(String []args){
          
		Grafo a=new Grafo();
		a.addPalabra("abbba");
	     a.addPalabra("abcas");
	     a.addPalabra("aas");
	    System.out.println(Nodo.val);

	}
}
