package co.edu.uptc.presentacion.GUI;

import java.awt.Color;
import co.edu.uptc.Logica.*;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.edu.uptc.presentacion.GUI.Panel;

public class extensionP implements Panel {

	private JPanel panel;
	private Font letra1;
	private JLabel titulo,JinputBinarioLabel,inputBitsLabel;
    private JTextField inputBinarioField;
    private JTextField inputBitsField;
    private JTextArea resultadoArea;
    private JButton reset,extenderButton;
    
    private extension extension = new extension();
    private boolean Editable = false;

	
    public extensionP(int ancho, int alto,String name){
    	
        letra1=new Font("Helvetica",3, 16);
		panel = new JPanel();
        panel.setSize(ancho,alto);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        
        titulo = new JLabel(name);
        titulo.setBounds(220, 0, 150, 30);
        titulo.setFont(letra1);
        
        JinputBinarioLabel = new JLabel("Número binario:");
        JinputBinarioLabel.setFont(letra1);
        JinputBinarioLabel.setBounds(50, 100, 150, 40);
        panel.add(JinputBinarioLabel);

        inputBinarioField = new JTextField(20);
        inputBinarioField.setFont(letra1);
        inputBinarioField.setBounds(190, 105, 210, 30);
        panel.add(inputBinarioField);

        inputBitsLabel = new JLabel("Número de bits (4, 8, o 16):");
        inputBitsLabel.setFont(letra1);
        inputBitsLabel.setBounds(50, 160, 250, 40);
        panel.add(inputBitsLabel);

        inputBitsField = new JTextField(5);
        inputBitsField.setFont(letra1);
        inputBitsField.setBounds(270, 165,100, 30);
        panel.add(inputBitsField);

        extenderButton = new JButton("Extender");
        extenderButton.setFont(letra1);
        extenderButton.setBounds(130, 240, 250, 40);
        
		reset = new JButton("reset");
		reset.setBounds(450, 540, 80, 30);
		reset.setFont(letra1);
		reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reset();
            }
        });
        
        panel.add(extenderButton);

        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setFont(letra1);
        resultadoArea.setBounds(40,330,400, 40);
        resultadoArea.setEditable(Editable);
        panel.add(resultadoArea);
        
        extenderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (inputBinarioField.getText().isEmpty() || inputBitsField.getText().isEmpty()) {
                    mostrarError("Ambos campos son obligatorios.");
                    return;
                }
                String numeroBinario = inputBinarioField.getText();
                if (!numeroBinario.matches("[01]+")) {
                    mostrarError("El número binario ingresado no es válido.");
                    return;
                }
                int bits;
                try {
                    bits = Integer.parseInt(inputBitsField.getText());
                } catch (NumberFormatException ex) {
                    mostrarError("Ingrese un número válido en el campo de bits.");
                    return;
                }

                if (bits != 4 && bits != 8 && bits != 16) {
                    mostrarError("El número de bits debe ser 4, 8 o 16.");
                    return;
                }

                String resultado = extension.extenderSigno(numeroBinario, bits);
                resultadoArea.setText("El número binario extendido es: " + resultado);
            }
        });
        
        panel.add(titulo);
        panel.add(reset);
}
    
    
	public void reset() {
        inputBinarioField.setText("");
        inputBitsField.setText("");
        resultadoArea.setText("");
        resultadoArea.setEditable(Editable);
	}
	
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
	@Override
	public Component getComponent() {
		return panel;
	}

}
