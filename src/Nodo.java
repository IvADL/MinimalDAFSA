
import java.util.HashMap;


public class Nodo {
    public static int val=0;   
	private HashMap<Character,Nodo> aristasV;

	public Nodo(){
	 aristasV=new HashMap<Character,Nodo>();
	 val++;
	}
	public HashMap<Character,Nodo> getAristas(){
		return aristasV;
	}
	public void addArista(char a,Nodo destino){
		aristasV.put(a, destino);
	}
	public boolean estaArista(char c){
		return aristasV.containsKey(c);
	}
	public Nodo sigNodo(char c){
		return aristasV.get(c);
	}
	public String toString(){
	/*   StringBuilder pal=new StringBuilder();
		for(Entry<Character, Nodo> a:aristasV.entrySet()){
			pal.append(a.getKey());
			pal.append(a.getValue());
		}
		return pal.toString();*/
		return null;
	}
	
	public static void main(String args []){
		
		Nodo a=new Nodo();
		Nodo b=new Nodo();
		Nodo d=new Nodo();
		Nodo f=new Nodo();
		a.addArista('c',b );
		b.addArista('d', d);
		d.addArista('e', f );
		
		Nodo g=new Nodo();
		Nodo h=new Nodo();
		Nodo i=new Nodo();
		Nodo j=new Nodo();
		a.addArista('g', g);
		g.addArista('c',h);
		h.addArista('d', i);
		b.addArista('e', j );
		
		System.out.println(a);
		
		
	}
	
	}
