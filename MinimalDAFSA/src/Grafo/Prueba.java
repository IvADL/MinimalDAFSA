package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Prueba {
public static void main(String[] args) {
	
	
	 
  Vertice v1=new Vertice();
  Vertice v2=new Vertice();
  Vertice v3=new Vertice();
  v1.addArista('a',v3);
  v1.addArista('c',v3);
  v2.addArista('a',v3);
  v2.addArista('c',v1);
 // v2.addArista('h', v3);
 // v1.addArista('k',v3);
 // v1.addArista('m', v3);
  //v1.addArista('l', v3);
  
  System.out.println(v1.esEquivalente(v2));
  
  /*
  HashMap<Character,String> a=new HashMap<Character,String>();
  a.put('a', "aa");
  a.put('b', "aa");
  a.put('c', "aa");
  //Para cambiar las direcciones
 System.out.println(a.replace('a', "bb"));
 System.out.println(a.get('a'));
 */
  
 /* 
  //Del hashMap Vertice Array
  for(Vertice a:v3.aristasAnt.keySet()){
	  for(char c:v3.aristasAnt.get(a))
		  System.out.println(c);
  }*/
  //c.addArista('c', d);
  //d.addArista('a',c);
  
}
	}


