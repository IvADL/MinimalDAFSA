package Grafo;

import java.util.ArrayList;

public class Grafo {

	private Vertice raiz;
	private Pila<Vertice> pil;

	public Grafo(){
		raiz=new Vertice();
		pil=new Pila<Vertice>();

	}
	public void addPalabra(String palabra){
		Vertice aux=raiz;
		int n=palabra.length();
		char clave;
		int i=0;
		while(i<n&&aux.estaArista(clave=palabra.charAt(i))){
			aux=aux.sigNodo(clave);
			i++;
		}
		if(i<n){
		
		String pal=palabra.substring(i);
		completarPalabra(aux,pal);		
		
		}
		
		aux.setEstadoFinal(true);
		pil.adicPila(aux);
	}       

	//Crea un serie de Nodos para completar la palabra
	public void completarPalabra(Vertice aux,String pal){	    
		char array[]=pal.toCharArray();
		Vertice sig;
		
		for(int i=0;i<array.length;i++){
			sig=new Vertice();
			aux.addArista(array[i],sig);
			aux=sig;
		}
						
	}
	public  void mostrar(){
		ArrayList<String>dic=new ArrayList<String>();
		mostrar(dic,"",raiz);
		for(String a:dic)
			System.out.println(a);
	}
	public void mostrar(ArrayList<String>a,String pal,Vertice aux){
		if(aux.estadoFinal)
			a.add(pal);
		for(char c:aux.getAristas().keySet())
			mostrar(a,pal+c,aux.getAristas().get(c));


	}
	public static void main(String []args){

		Grafo a=new Grafo();
		a.addPalabra("abbba");
	     a.addPalabra("abcas");
	     a.addPalabra("aas");
	     a.addPalabra("bbba");
	    a.mostrar();
	     System.out.println(Vertice.val);
	
		

	}


}
