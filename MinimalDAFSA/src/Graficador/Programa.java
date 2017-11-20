package Graficador;

import java.awt.*;
import java.awt.event.*;
import java.awt.Dialog;
import java.util.ArrayList;

public class Programa extends Frame implements ActionListener{

  private Button nuevo;
  private Button arista;
  private Button limpia;
  private Button prim;
  private Grafo grafo;
  private Dialog aristan;
  private List nodos1;
  private List nodos2;
  private TextField peso;
  private Button aristac;
  private Dialog mensaje;
  private Label etiqueta;
  
  private int i=0;
  private char con=65;
  private String valpeso=Character.toString(con);

  public Programa(){
	
    Panel panel=new Panel(new GridLayout(4,0));
    grafo = new Grafo(this);
    nuevo = new Button("Nodo");
    nuevo.addActionListener(this);
    nuevo.setActionCommand("nuevo");
    arista = new Button("Arista");
    arista.addActionListener(this);
    arista.setActionCommand("arista");
    prim = new Button("Prim");
    prim.addActionListener(this);
    prim.setActionCommand("prim");
    limpia = new Button("Limpiar");
    limpia.addActionListener(this);
    limpia.setActionCommand("limpia");
    panel.add(nuevo);
    panel.add(arista);
    panel.add(limpia);
    panel.add(prim);
    add(panel,BorderLayout.WEST);
    add(grafo,BorderLayout.CENTER);
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        System.exit(0);
      }
    });
    aristan=new Dialog(this,"Agregar arista",true);
    aristan.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        aristan.setVisible(false);
      }
    });
    aristan.setLayout(new GridLayout(2,4));
    nodos1=new List();
    nodos2=new List();
    peso=new TextField();
    aristac = new Button("Agregar");
    aristac.addActionListener(this);
    aristac.setActionCommand("aristac");
    aristan.add(new Label("Desde nodo:"));
    aristan.add(nodos1);
    aristan.add(new Label("Hasta nodo:"));
    aristan.add(nodos2);
    aristan.add(new Label("Peso:"));
    aristan.add(peso);
    aristan.add(aristac);
    mensaje=new Dialog(this,"Mensaje",true);
    mensaje.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        mensaje.setVisible(false);
      }
    });
    etiqueta = new Label("");
    mensaje.add(etiqueta);
    setTitle("Prueba de Grafo");
    setSize(800,800);
    setVisible(true);
    setLocationRelativeTo(null);
  }

  public void actionPerformed(ActionEvent e){
    String accion=e.getActionCommand();
    if(accion.equals("nuevo")){
      grafo.nuevo();
      
     // botones(false,false,false);
    }
    else if(accion.equals("arista")){
    	ArrayList<Nodo> lista=grafo.nodos();
    	grafo.nuevaarista((char)lista.get(i).numero,(char)lista.get(i+1).numero,valpeso);
    	i++;
    	con++;
    }
      /*ArrayList<Nodo> lista=grafo.nodos();
      nodos1.removeAll();
      nodos2.removeAll();
      for(int i=0;i<lista.size();i++){
        Nodo nodot=lista.get(i);
        nodos1.add(""+(char)nodot.numero);
        nodos2.add(""+(char)nodot.numero);
      }
      aristan.pack();
      peso.setText("");
      aristan.setLocationRelativeTo(this);
      aristan.setVisible(true);
    }
    else if(accion.equals("aristac")){
      creaarista();
      aristan.setVisible(false);
    }*/
    else if(accion.equals("limpia")) grafo.limpia();
  }

  private void creaarista(){
    String nodo1=nodos1.getSelectedItem();
    String nodo2=nodos2.getSelectedItem();
    String valpeso;
    if(nodo1==null||nodo2==null){
      muestramensaje("Nodos seleccionados invalidos");
      return;
    }
    else if(nodo1.equals(nodo2)){
      muestramensaje("Nodos seleccionados invalidos");
      return;
    }
    valpeso=peso.getText();
    if(valpeso.equals(""))
    	muestramensaje("Peso invalido");
    else
    	grafo.nuevaarista(nodo1.charAt(0),nodo2.charAt(0),valpeso);
  }

  public void muestramensaje(String mens){
    etiqueta.setText(mens);
    mensaje.pack();
    mensaje.setLocationRelativeTo(this);
    mensaje.setVisible(true);
  }

  public void botones(boolean b1,boolean b2,boolean b3){
    nuevo.setEnabled(b1);
    arista.setEnabled(b2);
    limpia.setEnabled(b3);
  }

  public static void main(String[] args){
    Programa programa = new Programa();
  }
}