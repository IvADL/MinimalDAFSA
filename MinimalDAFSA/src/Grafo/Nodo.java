package Grafo;

public class Nodo<T> implements Comparable<T>{

	private T info;
	private Nodo<T>next;
	public Nodo(T info,Nodo<T>next){
		this.info=info;
		this.next=next;
	}
	public Nodo(T info){
		this(info,null);
	}
	public Nodo<T>next (){
		return next;
	}
	public void setNext(Nodo<T>next){
		this.next=next;
	}
	public T info(){
		return info;
	}
	@Override
	public String toString() {
		return ""+info;
	}
	
	public int compareTo(T dato) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		int a=((Comparable<T>) info).compareTo(dato);
		return a;
	}
	
}
