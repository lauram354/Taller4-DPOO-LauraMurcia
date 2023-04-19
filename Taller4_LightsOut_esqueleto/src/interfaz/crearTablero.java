package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;
public class crearTablero extends JPanel implements MouseListener {
	
	   private vistaPrincipal interfazP;
	   private Rectangle[][] rectangles;
	   private int size;
	   private int vgap;
	   private int hgap;
	   private int height;
	   private String iconFile = "data/luz.png";
	   public boolean[][] tableros;
	   public Tablero actual;
	   private int ultima_fila;
	   private int ultima_columna;
	   public int tamanoSelec;
	   private int jugadas;
	   private boolean iluminado;
	   
	   
	   
	   public crearTablero(vistaPrincipal interfaz, Tablero tableroA, int tamano) {
		  interfazP = interfaz;
		  tamanoSelec = tamano;
		  tableros = tableroA.darTablero();
		  actual = tableroA;

		  rectangles = new Rectangle[tamanoSelec][tamanoSelec];
		  if (tamanoSelec == 6) {
			  size = 59;
			  height = 68;
			  vgap = 5;
			  hgap= 5;
		  }
		  else if (tamanoSelec == 7) {
			  size = 49;
			  height = 56;
			  vgap = 6;
			  hgap = 6;
		  }
		  else {
			  size = 71;
			  height = 81;
			  vgap = 5;
			  hgap = 5;
		  }
		  for (int j= 0; j< tamanoSelec; j++){
		       for (int i= 0; i< tamanoSelec; i++) {
				  rectangles[j][i]= new Rectangle(i*size +vgap*i, j*height + hgap*j, size,height);
		      }
	       }
	      addMouseListener(this);
	   }

	   public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      Graphics2D g2 = (Graphics2D) g;
	      int sizes = rectangles.length;
	      double s = Math.sqrt(sizes);
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	      
	      Image  img = new ImageIcon("data/luz.png").getImage();

	      BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
	          BufferedImage.TYPE_INT_RGB);

	      Graphics g3 = bufferedImage.createGraphics();
	      
	      for (int j= 0; j< tamanoSelec; j++){
		       for (int i= 0; i< tamanoSelec; i++){
		    	   g2.setColor(Color.decode("#FCF1C0"));
		           g2.fillRect(i*size +vgap*i, j*height + hgap*j, size,height);
		    	   if (tableros[i][j]) {
			    	  g2.setColor(Color.decode("#FCF1C0"));
		              g2.fillRect(i*size +vgap*i, j*height + hgap*j, size,height);
		    	   }
		    	   else {
		    		  g2.setColor(Color.decode("#000000"));
			          g2.fillRect(i*size +vgap*i, j*height + hgap*j, size,height);
		    	   }
	              g2.drawImage(img,i*size +vgap*i, j*height + hgap*j, null);

		      }
		
	       } 
	      g3.dispose();
	      repaint();
	      
	      
	   }

	   public void recargar(Tablero tactual, int tamano) {
		   this.actual = tactual;
		   this.tamanoSelec = tamano;
		   this.tableros = tactual.darTablero();
		   if (tamanoSelec == 6) {
				  this.size = 59;
				  this.height = 68;
				  this.vgap = 5;
				  this.hgap= 5;
			  }
			  else if (tamanoSelec == 7) {
				  this.size = 49;
				  this.height = 56;
				  this.vgap = 6;
				  this.hgap = 6;
			  }
			  else {
				  this.size = 71;
				  this.height = 81;
				  this.vgap = 5;
				  this.hgap = 5;
			  }
		   repaint();
	   }
	   public void recargarDif(Tablero tactual) {
		   this.actual = tactual;
		   this.tableros = tactual.darTablero();
		   
		   repaint();
	   }
	   public void mouseClicked(MouseEvent e) {
	   }

	   public void mousePressed(MouseEvent e)
	   {
		   int click_x = e.getX();
		   int click_y = e.getY();
		   int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		   actual.jugar(casilla[0], casilla[1]);
		   iluminado = actual.tableroIluminado();
		   jugadas = actual.darJugadas();
		   interfazP.setJugadas(Integer.toString(jugadas));
		   interfazP.setIluminado(iluminado, interfazP);
		   this.ultima_fila = casilla[0];
		   this.ultima_columna = casilla[1];
		   repaint();
	   }
	   
	   private int[] convertirCoordenadasACasilla(int x, int y)
	   {
		   int ladoTablero = tableros.length;
		   int altoPanelTablero = getHeight();
		   int anchoPanelTablero = getWidth();
		   int altoCasilla = altoPanelTablero / ladoTablero;
		   int anchoCasilla = anchoPanelTablero / ladoTablero;
		   int fila = (int) (y / altoCasilla);
		   int columna = (int) (x / anchoCasilla);
		   return new int[] { fila, columna };
	   }
	   
	   public void mouseReleased(MouseEvent e) {}
	   public void mouseEntered(MouseEvent e) {}
	   public void mouseExited(MouseEvent e) {}
	   


	}