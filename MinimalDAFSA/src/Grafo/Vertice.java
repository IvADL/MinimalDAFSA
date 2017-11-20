package Grafo;

import java.util.ArrayList;
import java.util.HashMap;

public class Vertice {

	public static int idVertice=0;
	private boolean estadoFinal;
	private int id;

	private HashMap<Character,Vertice> aristasV;
	public  HashMap<Vertice,ArrayList<Character>> aristasAnt;

	public Vertice(){

		aristasV=new HashMap<Character,Vertice>();
		aristasAnt=new HashMap<Vertice,ArrayList<Character>>();
		estadoFinal=false;
		setId(idVertice++);

	}

	public boolean isEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(boolean estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	public HashMap<Character,Vertice> getAristas(){
		return aristasV;
	}
	//Realiza una conexion entre Dos vertices v1-->v2, poniendo como arista el valor de character 'a'
	//Establece una conexion hacia atras v1<--v2
	public void addArista(char a,Vertice destino){
		ArrayList<Character> aristas;
		aristasV.put(a, destino);
		if(destino.aristasAnt.containsKey(this)){
			//Ya lo tiene guardado en un arrayList
			destino.aristasAnt.get(this).add(a);
		} 
		else {    
			aristas=new ArrayList<Character>();
			aristas.add(a);
			destino.aristasAnt.put(this,aristas);
		}
	}
	//Verifica si tiene una arista con dicha clave
	public boolean estaArista(char c){
		return aristasV.containsKey(c);
	}
	//Si No contiene una arista con dicha clave Null
	public Vertice sigNodo(char c){
		return aristasV.get(c);
	}
	//Numero de Id Asignado a un Nodo
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString(){
		return "Vertice "+id;
	}
	//Son equivalenste si tienes las mismas clave, las claves dirigen a los mismos Nodos
	//Y EL MISMO ESTADO 
	public boolean esEquivalente(Vertice v2){
		HashMap<Character,Vertice> aristasV2=v2.getAristas();
	
		if(aristasV.size()==aristasV2.size()&&isEstadoFinal()==v2.isEstadoFinal()){
			for(char c:aristasV.keySet())
				if(aristasV.get(c)!=aristasV2.get(c))
					return false;
			return true;
			
		}
		return false;
	}
    
  
}
