package interfaz;

import java.awt.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class config extends JPanel implements ActionListener{
	private vistaPrincipal interfazP;
	private JButton nuevo;
	private JButton reiniciar;
	private JButton top10;
	private JButton cambiar;
	private Tablero tab;
	private int tamanoNuevo;
	private int dificNueva =0;
	private crearTablero panelTablero;
	private opciones opcion;
	private Top10 topActual;
	private JLabel nuevoNombre;
	private menuInfo info; 
	
	public config(vistaPrincipal interfaz) {
		//Panel para configuracion de la partida 
		interfazP = interfaz;
		setSize(200,200);
		setPreferredSize(new Dimension(200, 200));
		BoxLayout layoutConfig = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layoutConfig);
		setBackground(Color.decode("#FFE5F1"));
		add(Box.createVerticalStrut(20));
		
		nuevo = new JButton("Nuevo");
		nuevo.setActionCommand("nuevo");
		nuevo.addActionListener(this);
		setAlignmentX(nuevo.RIGHT_ALIGNMENT);
		setAlignmentY(nuevo.RIGHT_ALIGNMENT);
		add(nuevo);
		
		add(Box.createVerticalStrut(20));
		
		reiniciar = new JButton("Reiniciar");
		reiniciar.setActionCommand("reiniciar");
		reiniciar.addActionListener(this);
		setAlignmentX(reiniciar.RIGHT_ALIGNMENT);
		setAlignmentY(reiniciar.RIGHT_ALIGNMENT);
		add(reiniciar);
		add(Box.createVerticalStrut(20));
		
		top10 = new JButton("Top 10");
		top10.setActionCommand("top10");
		top10.addActionListener(this);
		setAlignmentX(top10.RIGHT_ALIGNMENT);
		setAlignmentY(top10.RIGHT_ALIGNMENT);
		add(top10);
		add(Box.createVerticalStrut(20));
		
		cambiar = new JButton("Cambiar Jugador");
		cambiar.setActionCommand("Cambiar Jugador");
		cambiar.addActionListener(this);
		setAlignmentX(cambiar.RIGHT_ALIGNMENT);
		setAlignmentY(cambiar.RIGHT_ALIGNMENT);
		add(cambiar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if (comando.equals("nuevo")) {
			JComboBox<String> tamanoSelec =  new JComboBox<String>();
			JComboBox<String> dificultad =  new JComboBox<String>();
			JDialog ventanaNuev = new JDialog(interfazP , "Nueva Partida", true);  
			ventanaNuev.setLayout( new FlowLayout() );  
			ventanaNuev.getContentPane().setBackground(Color.decode("#E4F6F8"));
			
	        tamanoSelec.addItem("5x5");
			tamanoSelec.addItem("6x6");
			tamanoSelec.addItem("7x7");
			tamanoSelec.setMaximumSize(new Dimension(70, 30));
			tamanoSelec.setActionCommand("tamano"); 
			
			tamanoSelec.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
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
	        });
			
			dificultad.addItem("Fácil");
			dificultad.addItem("Medio");
			dificultad.addItem("Dificil");
			dificultad.setMaximumSize(new Dimension(70, 30));
			dificultad.setActionCommand("dific"); 
			dificultad.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	String selectedItem = (String) dificultad.getSelectedItem();
	            	if (selectedItem.equals("Fácil")) {
	        			dificNueva =1;
	        			tab = interfazP.getTableroaActual();
	        			tab.desordenar(dificNueva);
	        			//panelTablero.recargarDif(tab);
	        			interfazP.setTableroActual(tab);
	        		}
	        		else if (selectedItem.equals("Medio")) {
	        			dificNueva =2;
	        			tab = interfazP.getTableroaActual();
	        			tab.desordenar(dificNueva);
	        			//panelTablero.recargarDif(tab);
	        			interfazP.setTableroActual(tab);

	        			
	        		}
	        		else if (selectedItem.equals("Dificil")) {
	        			dificNueva =3;
	        			tab = interfazP.getTableroaActual();
	        			tab.desordenar(dificNueva);
	        			//panelTablero.recargarDif(tab);
	        			interfazP.setTableroActual(tab);
	        		}
	        		tab.salvar_tablero();
	            }
	        });
			
	        JButton confirmar = new JButton ("OK");  
	        confirmar.addActionListener ( new ActionListener()  
	        {  
	            public void actionPerformed( ActionEvent e )  
	            {  
	            	ventanaNuev.setVisible(false);
	            	
	            }  
	        });  
	        ventanaNuev.add(new JLabel("Seleccione el tamaño que desee: "));
	        ventanaNuev.add( tamanoSelec); 
	        ventanaNuev.add(new JLabel("Seleccione la dificultad que desee: "));
	        ventanaNuev.add( dificultad);
	        ventanaNuev.add(confirmar);   
	        ventanaNuev.setSize(300,300); 
	       
	        ventanaNuev.setVisible(true);  
		}
		else if (comando.equals("reiniciar")) {
			tab = interfazP.getTableroaActual();
			tab.reiniciar();
		}
		else if (comando.equals("Cambiar Jugador")) {
			JDialog ventanaNuev = new JDialog(interfazP , "Cambiar Jugador", true);  
			ventanaNuev.setLayout( new FlowLayout() );
			
			ventanaNuev.getContentPane().setBackground(Color.decode("#E4F6F8"));
			JLabel datos = new JLabel("Ingrese su nombre:");
			JTextField nombre = new JTextField("Nombre", 10);
			nombre.setPreferredSize(new Dimension(70,50));
			nombre.setMaximumSize(new Dimension(70,50));
			JLabel etiqueta = new JLabel("");
			nombre.addActionListener( new ActionListener()  
	        {  
	            public void actionPerformed( ActionEvent e )  
	            {  
	            	etiqueta.setText(nombre.getText());   
	            	info = interfazP.getMenuInfo();
	            	info.setNombre(etiqueta);
	            	interfazP.setPanelInfo(info);
	          
	            }  
	        });
			
			JButton confirmar = new JButton ("OK");  
	        confirmar.addActionListener ( new ActionListener()  
	        {  
	            public void actionPerformed( ActionEvent e )  
	            {  
	            	ventanaNuev.setVisible(false);
	            	
	            }  
	        }); 
	        
	        ventanaNuev.add(datos);
	        ventanaNuev.add(nombre);
	        ventanaNuev.add(confirmar);
	        ventanaNuev.setSize(300,300); 
	        ventanaNuev.setVisible(true);
			
		}
		else if (comando.equals("top10")) {
			JDialog ventanaNuev = new JDialog(interfazP , "Top 10", true);  
			new BoxLayout(ventanaNuev, BoxLayout.Y_AXIS);  
			ventanaNuev.setBackground(Color.decode("#E4F6F8"));
			
			
			JButton confirmar = new JButton ("OK");  
	        confirmar.addActionListener ( new ActionListener()  
	        {  
	            public void actionPerformed( ActionEvent e )  
	            {  
	            	ventanaNuev.setVisible(false);
	            	
	            }  
	        });  
	        topActual = interfazP.getTopActual();
	        Collection reg = topActual.darRegistros();
	        Iterator iterator = reg.iterator();
	        JList listaNombres=new JList();
	        DefaultListModel modelo = new DefaultListModel();
	        
	        int counter = 1;
	        while (iterator.hasNext()) {
	        	
	            modelo.addElement(Integer.toString(counter) + " " + iterator.next());
	            counter = counter +1;
	        }

	        
	        
	      
	        listaNombres.setFont(new Font("Arial",Font.BOLD,25));
	        
	        DefaultListCellRenderer renderer = (DefaultListCellRenderer) listaNombres.getCellRenderer();
	        renderer.setHorizontalAlignment(SwingConstants.CENTER);
	        
	        listaNombres.setModel(modelo);
	        
	        listaNombres.setBackground(Color.decode("#222021"));
	        listaNombres.setForeground(Color.decode("#E4F6F8"));
	        
	        ventanaNuev.add(listaNombres);
	        ventanaNuev.add(new JScrollPane(listaNombres));
	        ventanaNuev.setSize(300,300); 
	        ventanaNuev.setBackground(Color.decode("#222021"));
	        ventanaNuev.setVisible(true); 
			
		}
		
		
	}
	
	
}
