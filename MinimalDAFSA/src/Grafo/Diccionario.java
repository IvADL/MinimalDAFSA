package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Diccionario {
	
	 Vertice raiz;
	 Stack<Vertice> pilaR;
	
	public Diccionario(){
		raiz=new Vertice();
		pilaR=new Stack<Vertice>();
	}
	public void addPalabra(String word){
		Stack<Vertice> pilX=new Stack<Vertice>();
		Vertice aux=addWord(word);
		pilX=buildStack(aux,pilX);
        minim(pilX);
		
	}
	private Vertice addWord(String word){
		
		Vertice aux=raiz;
		char[] array=word.toCharArray();
		
		int i=0;
		while(i<word.length()&&aux.estaArista(array[i])){
			aux=aux.sigNodo(array[i]);
			i++;
		}
		Vertice sig;	
		while(i<word.length()){
			
			sig=new Vertice();
			aux.addArista(array[i],sig);
			aux=sig;
			i++;
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
	//Busca Nodos Equivalentes
    public void minim(Stack <Vertice> x){
    	Vertice aux,verEq;
   
    	while(!x.isEmpty()){
    	
    		aux=x.pop();
    		verEq=equivalenciaPila(aux, pilaR);
    		
    		if(verEq!=null){
    			Vertice.idVertice--;
    			//REESTRUCTURAR y Eliminar un Vertice
    		   HashMap<Vertice,ArrayList<Character>> aristas=aux.aristasAnt;
    		   //Obtengo los Vertice anteriores al Nodo a eliminar
    		   for(Vertice it:aristas.keySet()){
    			   //Redirecciono el apunte a el nodoEquivalente verEq
    			   for(char c:aristas.get(it)){
    				   it.getAristas().replace(c,verEq);
    			   }
    		   }
    		}
    		else pilaR.push(aux);		
    	}
    }
    private Vertice equivalenciaPila(Vertice x,Stack<Vertice> pilaR){
    	
    	for(int i=pilaR.size()-1;i>=0;i--)
    		if(x.esEquivalente(pilaR.get(i)))
    				return pilaR.get(i);
    	return null;
    }
    public  void mostrar(){
		ArrayList<String>dic=new ArrayList<String>();
		mostrar(dic,"",raiz);
		for(String a:dic)
			System.out.println(a);
		
	}
    public void vertices(){
    	ArrayList<Vertice>aux=new ArrayList<Vertice>();
    	vertices(aux,raiz);
    	for(Vertice i:aux)
    		System.out.println(i);
    }
    public void vertices(ArrayList<Vertice> a,Vertice aux){
    	a.add(aux);
    	for(char c:aux.getAristas().keySet()){
            vertices(a, aux.getAristas().get(c));
    	}
    }
	public void mostrar(ArrayList<String>a,String pal,Vertice aux){
	       
		if(aux.isEstadoFinal())
			a.add(pal);
		for(char c:aux.getAristas().keySet())
			mostrar(a,pal+c,aux.getAristas().get(c));
	}
    
    
}
