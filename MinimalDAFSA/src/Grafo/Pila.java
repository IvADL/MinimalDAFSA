package Grafo;

public class Pila <E>{

	private Nodo<E>pil;
	public Pila(){
		pil=null;
	} 
	public void adicPila(E dato){
		pil=new Nodo<E>(dato,pil);
	}
	public void elimPila(){
	 if(!vacioPila())
		 pil=pil.next();
	}
	public E infoPila(){
		return pil==null?null:pil.info();
	}
	public boolean vacioPila(){
		return pil==null?true:false;
	}
	
	
}
