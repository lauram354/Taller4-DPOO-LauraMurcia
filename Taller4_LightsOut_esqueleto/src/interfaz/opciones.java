package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import interfaz.vistaPrincipal;

public class opciones extends JPanel implements ActionListener{
	public static final String ACCION_INICIAR_JUEGO = "ACCION_INICIAR_JUEGO";
	
	
	private vistaPrincipal interfazP;
	private JComboBox<String> tamanoSelec =  new JComboBox<String>();
	private ButtonGroup dificultad = new ButtonGroup();
	private JLabel tamano;
	private JLabel dific;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	private Tablero tab;
	private int tamanoNuevo;
	private int dificNueva =0;
	private crearTablero panelTablero;
	
	public opciones(vistaPrincipal interfaz) {
		// Panel para menú superior
	
		interfazP = interfaz; 
		BoxLayout layoutOp = new BoxLayout(this, BoxLayout.X_AXIS);		
		setLayout(layoutOp);
		setBackground(Color.decode("#FFD3D6"));
		
		//Lista de botones de tamaño
		tamano = new JLabel("Tamaño");
		add(tamano);
		add(Box.createHorizontalStrut(10));
		tamanoSelec.addItem("5x5");
		tamanoSelec.addItem("6x6");
		tamanoSelec.addItem("7x7");
		tamanoSelec.setMaximumSize(new Dimension(70, 30));
		tamanoSelec.setActionCommand("tamano");
		tamanoSelec.addActionListener(this);
		add(tamanoSelec);
		
		//Botones de dificultad
		add(Box.createHorizontalStrut(30));
		dific = new JLabel("Dificultad");
		add(dific);
		add(Box.createHorizontalStrut(10));
		facil = new JRadioButton("Fácil");
		medio = new JRadioButton("Medio");
		dificil = new JRadioButton("Dificil");
		dificultad.add(facil);
		dificultad.add(medio);
		dificultad.add(dificil);
		
		facil.setActionCommand("facil");
		facil.addActionListener(this);
		medio.setActionCommand("medio");
		medio.addActionListener(this);
		dificil.setActionCommand("dificil");
		dificil.addActionListener(this);
		
		facil.setBackground(Color.decode("#FFD3D6"));
		medio.setBackground(Color.decode("#FFD3D6"));
		dificil.setBackground(Color.decode("#FFD3D6"));

		
		
		//Añade los botones
		add(facil);
		add(medio);
		add(dificil);
		
	}
	
	public JComboBox getTamanoSelec() {
		return tamanoSelec;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.equals("tamano")) {
			String selectedItem = (String) tamanoSelec.getSelectedItem();
			if(selectedItem.equals("5x5")) {
				tamanoNuevo = 5;
				tab = new Tablero(tamanoNuevo);
				tab.desordenar(dificNueva);
				panelTablero = interfazP.getPanelTablero();
				panelTablero.recargar(tab, tamanoNuevo);
				interfazP.setTableroActual(tab);
			}
			else if(selectedItem.equals("6x6"))
	        {
				tamanoNuevo = 6;
				tab = new Tablero(tamanoNuevo);
				tab.desordenar(dificNueva);
				panelTablero = interfazP.getPanelTablero();
				panelTablero.recargar(tab, tamanoNuevo);
				interfazP.setTableroActual(tab);
	        }
			else if(selectedItem.equals("7x7"))
	        {
				tamanoNuevo = 7;
				tab = new Tablero(tamanoNuevo);
				tab.desordenar(dificNueva);
				panelTablero = interfazP.getPanelTablero();
				panelTablero.recargar(tab, tamanoNuevo);
				interfazP.setTableroActual(tab);
				
	        }
			
		}
		if (comando.equals("facil")) {
			dificNueva =1;
			tab = interfazP.getTableroaActual();
			tab.desordenar(dificNueva);
			panelTablero.recargarDif(tab);
			interfazP.setTableroActual(tab);
		}
		else if (comando.equals("medio")) {
			dificNueva =2;
			tab = interfazP.getTableroaActual();
			tab.desordenar(dificNueva);
			panelTablero.recargarDif(tab);
			interfazP.setTableroActual(tab);

			
		}
		else if (comando.equals("dificil")) {
			dificNueva =3;
			tab = interfazP.getTableroaActual();
			tab.desordenar(dificNueva);
			panelTablero.recargarDif(tab);
			interfazP.setTableroActual(tab);
		}
		tab.salvar_tablero();
	}
	
	
	
}
