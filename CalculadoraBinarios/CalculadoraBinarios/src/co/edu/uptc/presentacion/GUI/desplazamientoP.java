package co.edu.uptc.presentacion.GUI;

import java.awt.Color;
import co.edu.uptc.Logica.*;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class desplazamientoP implements Panel,ActionListener {

	private JPanel panel;
	private Font letra1;
	private JLabel titulo;
    private JTextField textField;
    private JButton leftButton;
    private JButton rightButton;
    private JButton reset;
    private String numeroBinario = "10000111";
    
    private boolean textFieldEditable = false;
    
    private desplazamiento des = new desplazamiento();
	
    public desplazamientoP(int ancho, int alto,String name){
		
        letra1=new Font("Helvetica",3, 16);
		panel = new JPanel();
        panel.setSize(ancho,alto);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        
        
        titulo = new JLabel(name);
        titulo.setBounds(220, 0, 150, 30);
        titulo.setFont(letra1);
        
        textField = new JTextField(numeroBinario, 10);
        textField.setBounds(200,150, 150, 50);
        textField.setFont(letra1);
        textField.setEditable(textFieldEditable);


        leftButton = new JButton("Desplazar izquierda");
        leftButton.setBounds(50,300,200,40);
        leftButton.setFont(letra1);
        leftButton.addActionListener(this);


        rightButton = new JButton("Desplazar derecha");
        rightButton.setBounds(300,300,200,40);
        rightButton.setFont(letra1);
        rightButton.addActionListener(this);
        
		reset = new JButton("reset");
		reset.setBounds(450, 540, 80, 30);
		reset.setFont(letra1);
		reset.addActionListener(this);

        
        panel.add(textField);
        panel.add(leftButton);
        panel.add(rightButton);
        panel.add(reset);
        panel.add(titulo);
}
	
	@Override
	public Component getComponent() {
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leftButton) {
            numeroBinario = des.desplazarBitIzquierda(numeroBinario);
        } else if (e.getSource() == rightButton) {
            numeroBinario = des.desplazarBitDerecha(numeroBinario);
        }
        textField.setText(numeroBinario);
        
        if(e.getSource() == reset) {
        	reset();
        }
		
	}
	public void reset() {
        numeroBinario = "10000111";
        textField.setText(numeroBinario);
        textField.setEditable(textFieldEditable);
	}

}
