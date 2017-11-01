package Grafo;

import java.util.HashMap;


public class Vertice {
    public static int val=0;
    public boolean estadoFinal;
	
    public boolean isEstadoFinal() {
		return estadoFinal;
	}
	public void setEstadoFinal(boolean estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
	private HashMap<Character,Vertice> aristasV;

	public Vertice(){
	 aristasV=new HashMap<Character,Vertice>();
	 val++;
	}
	public HashMap<Character,Vertice> getAristas(){
		return aristasV;
	}
	public void addArista(char a,Vertice destino){
		aristasV.put(a, destino);
	}
	public boolean estaArista(char c){
		return aristasV.containsKey(c);
	}
	public Vertice sigNodo(char c){
		return aristasV.get(c);
	}/*
	public void mostrar(){
		ArrayList<String >a=new ArrayList<String>();
		mostrar(a,"",this);
		for(String pal:a)
			System.out.println(pal);
	}
	public void mostrar(ArrayList<String>a,String pal,Nodo aux){
	  
		
		for(char d:aux.getAristas().keySet()){
			mostrar(a,pal+d,aux.getAristas().get(d));
		}
	   if(aux.getAristas().size()==0)
		   a.add(pal);
		
	}
	*/
	/*
	public static void main(String args []){
		
		Vertice a=new Vertice();
		Vertice b=new Vertice();
		Vertice d=new Vertice();
		Vertice f=new Vertice();
		a.addArista('c',b );
		b.addArista('d', d);
		d.addArista('e', f );
		
		Vertice g=new Vertice();
		Vertice h=new Vertice();
		Vertice i=new Vertice();
		Vertice j=new Vertice();
		a.addArista('g', g);
		g.addArista('c',h);
		h.addArista('d', f);
		b.addArista('e', f );
		
		//a.mostrar();
		
		
	}*/
	
	}
