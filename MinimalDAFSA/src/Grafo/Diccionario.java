package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Diccionario {
	
	private Vertice raiz;
	 Stack<Vertice> pilaR;
	
	public Diccionario(){
		raiz=new Vertice();
		pilaR=new Stack<Vertice>();
	}
	public Vertice addWord(String word){
		
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
    		
    			//REESTRUCTURAR y Eliminar un Vertice
    		   HashMap<Vertice,ArrayList<Character>> aristasAnt=aux.aristasAnt;
    		   for(Vertice it:aristasAnt.keySet())
    			   for(char c:it.aristasAnt.get(it))
    				   it.getAristas().replace(c,verEq);
    			     			
    		}
    		else pilaR.push(aux);		
    	}
    }
    public Vertice equivalenciaPila(Vertice x,Stack<Vertice> pilaR){
    	for(int i=pilaR.size()-1;i>=0;i--)
    		if(x.esEquivalente(pilaR.get(i)))
    				pilaR.get(i);
    	return null;
    }
    public  void mostrar(){
		ArrayList<String>dic=new ArrayList<String>();
		int num=mostrar(dic,"",raiz);
		for(String a:dic)
			System.out.println(a);
		System.out.println(num-1);
	}
	public int  mostrar(ArrayList<String>a,String pal,Vertice aux){
	       
		if(aux.isEstadoFinal())
			a.add(pal);
		int suma=0;
		for(char c:aux.getAristas().keySet())
			suma=suma+mostrar(a,pal+c,aux.getAristas().get(c));
        return 1+suma;

	}
    
    
}
