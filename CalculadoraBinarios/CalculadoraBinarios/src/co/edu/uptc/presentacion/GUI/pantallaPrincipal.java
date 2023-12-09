package co.edu.uptc.presentacion.GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.presentacion.GUI.*;




public class pantallaPrincipal extends JFrame implements ActionListener {
	
	private panelGeneral panelSuma,panelResta,panelMultiplicacion;
	
	private extensionP extensionP;
	private desplazamientoP desplazamientoP;
	
	private JPanel principal,contenido;	
	private JButton suma,resta,multiplicacion,division,desplazamiento,extension;
	private JLabel titulo;
	private Font letra,letra1;
	 	
	//constructor
	public pantallaPrincipal() {	
		setSize(790, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Calculator");
		setLayout(null);//definir tamaño

        
        principal = new JPanel();
        contenido = new JPanel();
        titulo = new JLabel("Operaciones");
        suma = new JButton("Suma");
        resta = new JButton("Resta");
        multiplicacion = new JButton("Multiplicacion");
        division = new JButton("Division");
        desplazamiento = new JButton("Desplazamiento");
        extension = new JButton("Extension");
        letra=new Font("Helvetica",3, 24);
        letra1=new Font("Helvetica",3, 16);

        			
	}
	
	public void pantallaInicio() {
		
	    panelSuma = new panelGeneral(564,600,"Suma"); 
	    panelResta = new panelGeneral(564,600,"Resta");
	    panelMultiplicacion = new panelGeneral(564,600,"Multiplicacion");
	    desplazamientoP = new desplazamientoP(564,600,"Desplazamiento");
	    extensionP = new extensionP(564,600,"Extension");
		
        // panel principal
        principal.setBounds(0, 0, 200, getHeight());
        principal.setBackground(Color.white);
        principal.setLayout(null);

        // panel contenido
        contenido.setBounds(204,5,564,600);
        contenido.setBackground(Color.white);
        contenido.setLayout(null);
		//labels		
		titulo.setBounds(10, 10, 180, 40);
		titulo.setFont(letra);	

		//Botones
		suma.setBounds(20, 70, 160, 60);
		suma.setFont(letra1);
		suma.addActionListener(this);
		
		resta.setBounds(20, 150, 160, 60);
		resta.setFont(letra1);
		resta.addActionListener(this);
		
		multiplicacion.setBounds(20, 230, 160, 60);
		multiplicacion.setFont(letra1);
		multiplicacion.addActionListener(this);
		
		division.setBounds(20, 310, 160, 60);
		division.setFont(letra1);
		division.addActionListener(this);
		
		desplazamiento.setBounds(20, 390, 160, 60);
		desplazamiento.setFont(letra1);
		desplazamiento.addActionListener(this);
		
		extension.setBounds(20, 470, 160, 60);
		extension.setFont(letra1);
		extension.addActionListener(this);

	
        
        principal.add(titulo);
        principal.add(suma);
        principal.add(resta);
        principal.add(multiplicacion);
        principal.add(division);
        principal.add(desplazamiento);
        principal.add(extension);

        
        add(principal);
        add(contenido);
		setVisible(true);
	}
	
	
	
	//Acciones de los botones
	@Override
	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
        if (componente.equals(suma)) {
            contenido.removeAll();
            panelSuma.reset();
            contenido.add(panelSuma.getComponent());
            panelSuma.getComponent().setVisible(true); // Mostrar el panelSuma
            revalidate();
            repaint();
        }
        if(componente.equals(resta)) {
            contenido.removeAll();
            panelResta.reset();
            contenido.add(panelResta.getComponent());
            panelResta.getComponent().setVisible(true); // Mostrar el panelResta
            revalidate();
            repaint();
        }
        if(componente.equals(multiplicacion)) {
            contenido.removeAll();
            panelMultiplicacion.reset();
            contenido.add(panelMultiplicacion.getComponent());
            panelMultiplicacion.getComponent().setVisible(true); // Mostrar el panelResta
            revalidate();
            repaint();
        }
        if(componente.equals(division)) {

            revalidate();
            repaint();
        }
        if(componente.equals(extension)) {
            contenido.removeAll();
            contenido.add(extensionP.getComponent());
            extensionP.getComponent().setVisible(true); // Mostrar el panelResta
            revalidate();
            repaint();
        }
        if(componente.equals(desplazamiento)) {
            contenido.removeAll();
            desplazamientoP.reset();
            contenido.add(desplazamientoP.getComponent());
            desplazamientoP.getComponent().setVisible(true); // Mostrar el panelResta
            revalidate();
            repaint();
        }
        
        
		
	}

}
