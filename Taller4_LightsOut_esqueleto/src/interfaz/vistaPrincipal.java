package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.util.Collection;
import java.util.PriorityQueue;

import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import interfaz.crearTablero;
import javax.swing.*;
import uniandes.dpoo.taller4.modelo.*;
import interfaz.*;

public class vistaPrincipal extends JFrame implements MouseListener{
	
	private boolean[][] tablero;
	//Paneles
	private static opciones panelOpciones;
	private static crearTablero panelTablero;
	private config panelConfiguracion;
	private static menuInfo panelInformacion;
	private int tamano = 5;
	private static Tablero tab;
	private static Top10 top;
	private static JLabel jugadas;
	private static boolean iluminado;
	private static boolean ganado;
	private static JLabel jugador = new JLabel();
	
	public vistaPrincipal()
	{	
		
		setTitle("Lights out");
		setLayout( new BorderLayout( ) );
        Dimension dimension = new Dimension(600, 600);		
		setSize(dimension);
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		panelOpciones = new opciones( this );
        add( panelOpciones, BorderLayout.NORTH );
        
        panelConfiguracion = new config(this);
        add(panelConfiguracion, BorderLayout.EAST);
        
        panelInformacion = new menuInfo(this);
        add(panelInformacion, BorderLayout.SOUTH);

        tab = new Tablero(tamano);
        //tablero = tab.darTablero();
        panelTablero = new crearTablero(this, tab, tamano);
        add(panelTablero, BorderLayout.CENTER);
        
        jugadas = panelInformacion.getJugada();
        top = new Top10();
        iluminado = tab.tableroIluminado();
   
        revisarGano(this);
        repaint();
        addWindowListener(new WindowAdapter()
    	{
    	public void windowClosing(WindowEvent e)
    	{
    	salvarTop10();
    	}
    	});
 
	}
	
	public static void salvarTop10() {
		if (ganado) {
			boolean entra = top.esTop10(Integer.parseInt(jugadas.getText()));
			if (entra) {
				top.agregarRegistro(jugador.getText(), Integer.parseInt(jugadas.getText()));
			}
		}
	}
	
	public static Tablero getTableroaActual() {
		return tab;
	}
	
	public static Top10 getTopActual() {
		return top;
	}
	
	public static menuInfo getMenuInfo() {
		return panelInformacion;
	}
	
	public static void setTableroActual(Tablero actual) {
		tab = actual;
	}
	
	public static void setIluminado(Boolean ilum, vistaPrincipal interfaz) {
		iluminado = ilum;
		revisarGano(interfaz);
	}
	
	public static void revisarGano(vistaPrincipal interfaz) {
		if (Integer.parseInt(jugadas.getText()) >1 && iluminado) {
			
        	JDialog gano = new JDialog(interfaz, "", true);
        	gano.getContentPane().setBackground(Color.decode("#E4F6F8"));
        	gano.setLayout( new BorderLayout() );
        	tab.reiniciar();
        	JLabel datos = new JLabel("Ha ganado :)");
        	gano.add(datos, BorderLayout.CENTER);
        	gano.setSize(300,300); 
        	gano.setBackground(Color.decode("#222021"));
        	gano.setVisible(true);
        	ganado = true;
 
        	
        } else {
			ganado = false;
		}
	}
	
	public static void setJugadas(String jugad) {
		jugadas.setText(jugad);
	}
	
	public static void setPanelInfo(menuInfo info) {
		panelInformacion = info;
		jugador = panelInformacion.getNombre();
		panelInformacion.repaint();
		panelInformacion.updateUI();
	}
	public static crearTablero getPanelTablero() {
		return panelTablero;
	}
	
	public static opciones getPanelOpciones() {
		return panelOpciones;
	}
	
	
	public static void main(String[] args) {
		FlatLightLaf.install();
		vistaPrincipal interfaz = new vistaPrincipal( );
        interfaz.setVisible( true );
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		
}
