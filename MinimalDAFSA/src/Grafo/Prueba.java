package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Prueba {
public static void main(String[] args) {
	
	
	Diccionario a=new Diccionario();
	Vertice fin=a.addWord("bijecie");
	Stack<Vertice>x=new Stack<Vertice>();
	x=a.buildStack(fin, x);
    a.minim(x);
   
   Vertice c= a.addWord("bij");
   Stack<Vertice>x2=new Stack<Vertice>();
   x2=a.buildStack(c, x2);
   //System.out.println(x2.get(3));
   //System.out.println(a.pilaR);
   a.minim(x2);
   System.out.println(a.pilaR.get(4));
    /*
	Stack<Vertice>x2=new Stack<Vertice>();
     Vertice fin2=a.addWord("bijg");  
	x2=a.buildStack(fin2, x2);
    a.minim(x2);
    */
   
	
//	a.mostrar();
	
	/*
	Stack a=new Stack<>();
	Stack b=new Stack<>();
	a.push("as");
	a.push("s");
	b=a;
	a.push("r");
	
	 
  Vertice v1=new Vertice();
  Vertice v2=new Vertice();
  Vertice v3=new Vertice();
  v1.addArista('a',v3);
  v1.addArista('c',v3);
  v2.addArista('a',v3);
  v2.addArista('c',v1);*/
 // v2.addArista('h', v3);
 // v1.addArista('k',v3);
 // v1.addArista('m', v3);
  //v1.addArista('l', v3);
  
  //System.out.println(v1.esEquivalente(v2));
  
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


