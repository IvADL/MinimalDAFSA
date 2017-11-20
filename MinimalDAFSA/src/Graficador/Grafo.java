package Graficador;
// version del compilador java 1.6.0_13
// Autor: Pedro Cardoso Rodriguez
// cardp_2004@yahoo.com.mx
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Grafo extends Panel implements MouseListener, MouseMotionListener{

  private ArrayList<Nodo> lista;
  private ArrayList<Arista> aristas;
  private boolean bandera;
  private int contador;
  private Programa programa;
  private int xcrece=40;
  private int ycrece=50;

  public Grafo(Programa programa){
    this.programa=programa;
    lista= new ArrayList<Nodo>();
    aristas= new ArrayList<Arista>();
    contador=65;
    bandera=false;
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public void paint(Graphics g){
    g.setColor(Color.WHITE);
    g.fillRect(0,0,getSize().width,getSize().height);
    for(int i=0;i<aristas.size();i++){
      Arista arista = aristas.get(i);
      if(arista.verde) g.setColor(Color.GREEN);
      else g.setColor(Color.BLACK);
      g.drawLine(arista.x1,arista.y1,arista.x2,arista.y2);
      g.setColor(Color.RED);
      g.drawString(""+arista.peso,(arista.x1+arista.x2)/2,(arista.y1+arista.y2)/2);
    }
    for(int i=0;i<lista.size();i++){
      g.setColor(Color.BLACK);
      Nodo nodot=lista.get(i);
      g.fillOval(nodot.x-15,nodot.y-15,30,30);
      g.setColor(Color.WHITE);
      g.drawString(""+(char)nodot.numero,nodot.x-7,nodot.y+5);
    }
  }

  public void nuevo(){
    Nodo nodo=new Nodo();
    nodo.numero=contador;
    contador++;//el indice de los nodos
    nodo.x=xcrece;
    nodo.y=ycrece;
    xcrece=xcrece+80;
    System.out.println("x : "+nodo.x+" y : " + nodo.y);
    if(contador==66)nuevo2();
    repaint();
    lista.add(nodo);
  }
  private void nuevo2(){
	  Nodo nodo=new Nodo();
	  nodo.numero=90;
	  nodo.x=xcrece;
	  nodo.y=ycrece+50;
	  lista.add(nodo);
  }

  public void limpia(){
    lista.clear();
    aristas.clear();
    contador=65;
    bandera=false;
    repaint();
  }

  public ArrayList<Nodo> nodos(){
    return lista;
  }

  public void nuevaarista(char n1, char n2, String peso){
    Arista arista;
    for(int i=0;i<aristas.size();i++){
      arista = aristas.get(i);
      if((arista.nodo1==n1 && arista.nodo2==n2)||(arista.nodo2==n1 && arista.nodo1==n2)){
        programa.muestramensaje("Ya existe la arista");
        return;
      }
    }
    arista = new Arista();
    arista.nodo1=n1;
    arista.nodo2=n2;
    arista.peso=peso;
    arista.verde=false;
    for(int i=0;i<lista.size();i++){
      Nodo nodot=lista.get(i);
      if((char)nodot.numero==n1){
        arista.x1=nodot.x;
        arista.y1=nodot.y;
      }
      else if((char)nodot.numero==n2){
        arista.x2=nodot.x;
        arista.y2=nodot.y;
      }
    }
    aristas.add(arista);
    repaint();
  }
  

  public void mouseClicked(MouseEvent e){
    if(bandera){
      bandera=false;
      programa.botones(contador<91,true,true);
      repaint();
    }
  }
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  public void mousePressed(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}

  public void mouseDragged(MouseEvent e){}
  public void mouseMoved(MouseEvent e){
    if(bandera){
      Nodo nodo=lista.get(lista.size()-1);
      nodo.x=e.getX();
      nodo.y=e.getY();
      System.out.println("x : "+nodo.x+" y : " + nodo.y);
      repaint();
    }
  }
}