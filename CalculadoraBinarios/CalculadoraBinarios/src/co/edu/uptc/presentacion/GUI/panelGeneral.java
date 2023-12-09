package co.edu.uptc.presentacion.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import co.edu.uptc.Logica.*;

public class panelGeneral implements Panel,ActionListener,MouseListener,FocusListener{
	
	private JPanel panel;
	private JLabel titulo,nBits,binario1,binario2,binarioR,binarioR1,Dbinario1,Dbinario2,decimal1,decimal2,decimalR,decimalR1,BDecimal1,BDecimal2,desbor,desbor1;
	private JComboBox<String> nBits1;
	private JTextField Bnum1,Bnum2,Dnum1,Dnum2;
	private JButton calcular,Dcalcular,reset;
	private Font letra1;
	
    private JTextField textFieldActual;

    private division div = new division();
    private suma suma = new suma();
    private resta resta = new resta();
    private multiplicacion multi = new multiplicacion();
    
    int numBits;
    
	public panelGeneral(int ancho, int alto, String name){
		
		
        letra1=new Font("Helvetica",3, 16);
		panel = new JPanel();
        panel.setSize(ancho,alto);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        
        //LABELS

        titulo = new JLabel(name);
        titulo.setBounds(250, 0, 150, 30);
        titulo.setFont(letra1);

        nBits = new JLabel("No de Bits");
        nBits.setBounds(10, 50, 80, 30);
        nBits.setFont(letra1);

        binario1 = new JLabel("Binario1:");
        binario1.setBounds(10, 130, 80, 30);
        binario1.setFont(letra1);
        
        Dbinario1 = new JLabel("--------");
        Dbinario1.setBounds(80, 160, 150, 30);
        Dbinario1.setFont(letra1);
        
        Dbinario2 = new JLabel("--------");
        Dbinario2.setBounds(340, 160, 80, 30);
        Dbinario2.setFont(letra1);


        binario2 = new JLabel("Binario2:");
        binario2.setBounds(270, 130, 80, 30);
        binario2.setFont(letra1);


        binarioR = new JLabel("Resultado Binario: ");
        binarioR.setBounds(10, 350, 150, 30);
        binarioR.setFont(letra1);

        binarioR1 = new JLabel("------");
        binarioR1.setBounds(160, 350, 600, 30);
        binarioR1.setFont(letra1);
        
        

        decimal1 = new JLabel("Decimal1:");
        decimal1.setBounds(10, 220, 490, 30);
        decimal1.setFont(letra1);


        decimal2 = new JLabel("Decimal2:");
        decimal2.setBounds(270, 220, 80, 30);
        decimal2.setFont(letra1);

        BDecimal1 = new JLabel("-----");
        BDecimal1.setBounds(90, 240, 150, 30);
        BDecimal1.setFont(letra1);
        
        BDecimal2 = new JLabel("----");
        BDecimal2.setBounds(350, 240, 150, 30);
        BDecimal2.setFont(letra1);


        decimalR = new JLabel("Resultado Decimal: ");
        decimalR.setBounds(10, 400, 150, 30);
        decimalR.setFont(letra1);

        decimalR1 = new JLabel("------");
        decimalR1.setBounds(160, 400, 150, 30);
        decimalR1.setFont(letra1);

        desbor = new JLabel("Hay desbordamiento? ");
        desbor.setBounds(15, 540, 200, 30);
        desbor.setFont(letra1);


        desbor1 = new JLabel("-----");
        desbor1.setBounds(200, 540, 80, 30);
        desbor1.setFont(letra1);


        //COMBOBOX
		nBits1 = new JComboBox<String>();
		nBits1.setBounds(100,50,80, 25);
		nBits1.addItem("----");
		nBits1.addItem("4");
		nBits1.addItem("8");
		nBits1.addItem("16");
		nBits1.addActionListener(this);
		
        // TEXTFIELD
        Bnum1 = new JTextField("0");
        Bnum1.setBounds(80, 130, 150, 30);
        Bnum1.addActionListener(this);
        Bnum1.addMouseListener(this);
        Bnum1.addFocusListener(this); // Agregar FocusListener

        Bnum2 = new JTextField("0");
        Bnum2.setBounds(340, 130, 150, 30);
        Bnum2.addActionListener(this);
        Bnum2.addMouseListener(this);
        Bnum2.addFocusListener(this); // Agregar FocusListener

        Dnum1 = new JTextField("0");
        Dnum1.setBounds(90, 220, 150, 30);
        Dnum1.addActionListener(this);
        Dnum1.addMouseListener(this);
        Dnum1.addFocusListener(this); // Agregar FocusListener

        Dnum2 = new JTextField("0");
        Dnum2.setBounds(350, 220, 140, 30);
        Dnum2.addActionListener(this);
        Dnum2.addMouseListener(this);
        Dnum2.addFocusListener(this); // Agregar FocusListener
		

		//button
		calcular = new JButton("<");
		calcular.setBounds(500, 130,47,30);
		calcular.setFont(letra1);
		calcular.addActionListener(this);
		
		Dcalcular = new JButton("<");
		Dcalcular.setBounds(500,220,47, 30);
		Dcalcular.setFont(letra1);
		Dcalcular.addActionListener(this);
		
		reset = new JButton("reset");
		reset.setBounds(450, 540, 80, 30);
		reset.setFont(letra1);
		reset.addActionListener(this);
		
        
        
        panel.add(titulo);
        panel.add(nBits);
        panel.add(binario1);
        panel.add(Dbinario1);
        panel.add(Dbinario2);
        panel.add(binario2);
        panel.add(binarioR);
        panel.add(binarioR1);
        panel.add(decimal1);
        panel.add(decimal2);
        panel.add(BDecimal1);
        panel.add(BDecimal2);
        panel.add(decimalR);
        panel.add(decimalR1);
        panel.add(desbor);
        panel.add(desbor1);
        
        panel.add(nBits1);
        
        panel.add(Bnum1);
        panel.add(Bnum2);
        panel.add(Dnum1);
        panel.add(Dnum2);
        
        panel.add(calcular);
        panel.add(Dcalcular);
        panel.add(reset);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
        String bin1 = Bnum1.getText();
        String bin2 = Bnum2.getText();
        String dec1 = Dnum1.getText();
        String dec2 = Dnum2.getText();
        

        if (!isValidBinary(Bnum1.getText()) || !isValidBinary(Bnum2.getText())) {
            System.out.println("Error: Ingresa valores binarios válidos");
            return;
        }

        // Validar los campos de decimales
        if (!isValidDecimal(Dnum1.getText()) || !isValidDecimal(Dnum2.getText())) {
            System.out.println("Error: Ingresa valores decimales válidos");
            return;
        }
        
        if(e.getSource() == nBits1) {
        	numBits = Integer.parseInt(nBits1.getSelectedItem().toString());
        }

        if (e.getSource() == calcular) {
            if (nBits1.getSelectedItem() == null || nBits1.getSelectedItem().toString() == "----") {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona el numero de bits.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                realizarOperacionBinarios();
            }
        }

        if (e.getSource() == Dcalcular) {
            if (nBits1.getSelectedItem() == null || nBits1.getSelectedItem().toString() == "----") {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona el numero de bits.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                realizarOperacionDecimales();
            }
        }
        
        if(e.getSource() == reset) {
        	reset();
        }
		
	}
	
	
	// Método adicional para convertir decimal a binario (manejo de números negativos)
	private String decimalToBinary(long decimalValue) {
	    if (decimalValue >= 0) {
	        return Long.toBinaryString(decimalValue);
	    } else {
	        // Calcular el complemento a dos para números negativos
	        String positiveBinary = Long.toBinaryString(Math.abs(decimalValue));
	        return "1" + String.format("%" + positiveBinary.length() + "s", "").replace(' ', '0');
	    }
	}
	
	private void realizarOperacionBinarios() {
	    String bin1 = Bnum1.getText();
	    String bin2 = Bnum2.getText();
	    String dec1 = Dnum1.getText();
	    String dec2 = Dnum2.getText();

	    String resultadoBinario = "";
	    int resultadoDecimal = 0;
	    String desbordamiento = "SI";
	    int b1 = 0;

	    try {
	        // Verifica qué operación se está realizando
            if (titulo.getText().equals("Suma")) {
                suma.ResultadoOperacion resultadoSumaBinarios = suma.sumarBinariosComplemento2(bin1, bin2, numBits);
                resultadoBinario = resultadoSumaBinarios.resultado;
                if (resultadoSumaBinarios.huboDesbordamiento) {
                	desbordamiento = "NO";
				}
                //desbordamiento = Boolean.toString(resultadoSumaBinarios.huboDesbordamiento);
                resultadoDecimal = suma.binarioADecimalConSigno(resultadoBinario);
  
                
            } else if (titulo.getText().equals("Resta")) {
                resta.ResultadoResta resultadoResta = resta.restarBinariosComplemento2(bin1, bin2, numBits);
                resultadoBinario = resultadoResta.resultado;
                desbordamiento = Boolean.toString(resultadoResta.huboDesbordamiento);
                resultadoDecimal = resta.binarioADecimalConSigno(resultadoBinario);


            } else if (titulo.getText().equals("Multiplicacion")) {
                resultadoBinario = multi.multiply(Long.parseLong(bin1, 2), Long.parseLong(bin2, 2));

            }

	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "Error en la operación: Ingrese valores válidos.");
	        return;
	    }

	    // Muestra los resultados en los JLabel correspondientes
	    binarioR1.setText(resultadoBinario);
	    //decimalR1.setText(""+resultadoDecimal);
	    desbor1.setText(desbordamiento);
	}
	
	private void realizarOperacionDecimales() {
	    String bin1 = Bnum1.getText();
	    String bin2 = Bnum2.getText();
	    String dec1 = Dnum1.getText();
	    String dec2 = Dnum2.getText();

	    String resultadoBinario = "";
	    int resultadoDecimal = 0;
	    String desbordamiento = "NO";
	    int b1 = 0;

	    try {
	        // Verifica qué operación se está realizando
            if (titulo.getText().equals("Suma")) {
                suma.ResultadoOperacion resultadoSuma = suma.sumarEnteros(Integer.parseInt(dec1), Integer.parseInt(dec2),numBits);
                resultadoBinario = resultadoSuma.resultado;
                if (resultadoSuma.huboDesbordamiento) {
                	desbordamiento = "NO";
				}
                //desbordamiento = Boolean.toString(resultadoSuma.huboDesbordamiento);
                resultadoDecimal = suma.binarioADecimalConSigno(resultadoBinario);
  
                
            } else if (titulo.getText().equals("Resta")) {
                resta.ResultadoResta resultadoResta = resta.restarEnteros(Integer.parseInt(dec1), Integer.parseInt(dec2), numBits);
                resultadoBinario = resultadoResta.resultado;
                desbordamiento = Boolean.toString(resultadoResta.huboDesbordamiento);
                
                resultadoDecimal = resta.binarioADecimalConSigno(resultadoBinario);


            } else if (titulo.getText().equals("Multiplicacion")) {
                String resultado = multi.multiplicarEnterosConSigno(Integer.parseInt(dec1), Integer.parseInt(dec2), numBits);
                resultadoBinario = resultado;
            }

	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "Error en la operación: Ingrese valores válidos.");
	        return;
	    }

	    // Muestra los resultados en los JLabel correspondientes
	    binarioR1.setText(resultadoBinario);
	    decimalR1.setText(""+resultadoDecimal);
	    desbor1.setText(desbordamiento);
	}



	@Override
	public Component getComponent() {
		return panel;
	}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {
        if (textFieldActual != null) {
            actualizarLabelSegunTextField(textFieldActual);
        }
    }
        
        private void actualizarLabelSegunTextField(JTextField textField) {
            String text = textField.getText();

            if (textField == Bnum1) {
                if (isValidBinary(text)) {
                    Dbinario1.setText("" + suma.binarioADecimalConSigno(text));
                } else {
                    reset();
                }
            } else if (textField == Bnum2) {
                if (isValidBinary(text)) {
                    Dbinario2.setText("" + suma.binarioADecimalConSigno(text));
                } else {
                    reset();
                }
            } else if (textField == Dnum1) {
                if (isValidDecimal(text)) {
                    BDecimal1.setText("" + multi.decimalABinarioConSigno(Integer.parseInt(text), numBits));
                } else {
                    reset();
                }
            } else if (textField == Dnum2) {
                if (isValidDecimal(text)) {
                    BDecimal2.setText("" + multi.decimalABinarioConSigno(Integer.parseInt(text), numBits));
                } else {
                    reset();
                }
            }
        }


    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
    
    @Override
    public void focusGained(FocusEvent e) {
        // Este método se llama cuando el JTextField gana el foco (seleccionado)
        if (e.getSource() instanceof JTextField) {
            textFieldActual = (JTextField) e.getSource();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        // Este método se llama cuando el JTextField pierde el foco
        // Si se pierde el foco, actualizamos el JLabel correspondiente
        if (e.getSource() instanceof JTextField) {
            JTextField textField = (JTextField) e.getSource();
            actualizarLabelSegunTextField(textField);
        }
    }


    private boolean isValidBinary(String binary) {
        return binary.matches("[01]+");
    }

    private boolean isValidDecimal(String decimal) {
        return decimal.matches("-?\\d+(\\.\\d+)?");
    }

	public void reset() {
       Bnum1.setText("0");
       Bnum2.setText("0");
       Dnum1.setText("0");
       Dnum2.setText("0");
       binarioR1.setText("----");
       decimalR1.setText("----");
       desbor1.setText("----");	
       Dbinario1.setText("----");
       Dbinario2.setText("----");
       BDecimal1.setText("----");
       BDecimal2.setText("----");
	}
}
