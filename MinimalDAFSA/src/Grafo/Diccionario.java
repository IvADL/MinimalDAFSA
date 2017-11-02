package Grafo;

import java.util.HashMap;
import java.util.Stack;

public class Diccionario {
	
	private Vertice raiz;
	private Stack<Vertice> pilaR;
	
	public Diccionario(){
		raiz=new Vertice();
		pilaR=new Stack<Vertice>();
	}
	public Vertice addWord(String word){
		
		Vertice aux=raiz;
		char[] array=word.toCharArray();
		
		int i=0;
		while(i<word.length()&&aux.estaArista(array[i]))
			aux=aux.sigNodo(array[i]);			
		
		Vertice sig;	
		while(i<word.length()){
			sig=new Vertice();
			aux.addArista(array[i],sig);
			aux=sig;
		}
		aux.setEstadoFinal(true); 
		
		return aux;
	}
	public Stack<Vertice> buildStack (Vertice aux,Stack<Vertice> x){
		
		x.push(aux);
		HashMap <Character,Vertice> tabla=aux.getAristas();
		for(char c:tabla.keySet()){
			if(!tabla.get(c).isEstadoFinal())
			   x=buildStack(tabla.get(c),x);
		}
		return x;
	}
	//Dos vertice son iguales si tienen la misma cantidad de aristas y esta con iguales
    public void minim(Stack <Vertice> x){
    	Vertice aux;
    	//Comparacion de Dos vertices si son iguales se reestructura
    	while(!x.isEmpty()){
    		aux=x.pop();
    		
    	}
    }
    
}
