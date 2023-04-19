package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class menuInfo extends JPanel implements ActionListener{
	private vistaPrincipal interfazP;
	private static JLabel nombre;
	private JLabel jugadas;
	private static JLabel numJugadas;
	private JLabel jugador;
	
	public menuInfo(vistaPrincipal interfaz) {
		// Panel para menú inferior
		interfazP = interfaz;
		setSize(100,100);
		setPreferredSize(new Dimension(100, 100));
		
		BoxLayout layoutInfo = new BoxLayout(this, BoxLayout.X_AXIS);
		
		nombre = new JLabel("Nombre");
		nombre.setPreferredSize(new Dimension(70,50));
		nombre.setMaximumSize(new Dimension(70,50));
		
		setLayout(layoutInfo);
		
		setBackground(Color.decode("#FFD3D6"));
		add(Box.createHorizontalStrut(30));
		jugadas = new JLabel("Jugadas");
		add(jugadas);
		add(Box.createHorizontalStrut(10));
		numJugadas = new JLabel("0"); 
		add(numJugadas);
		add(Box.createHorizontalStrut(30));
		jugador = new JLabel("Jugador");
		add(jugador);
		add(Box.createHorizontalStrut(10));
		add(nombre);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void setNombre(JLabel nombreN) {
		nombre = nombreN;
		
		
	}
	public static void setJugada(String numero) {
		numJugadas.setText(numero);
	}
	
	public static JLabel getJugada() {
		return numJugadas;		
	}
	
	public static JLabel getNombre() {
		return nombre;		
	}
	
}
