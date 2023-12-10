package co.edu.uptc.presentacion.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import co.edu.uptc.Logica.*;

public class DivisionPanel extends JFrame implements Panel, ActionListener, MouseListener, FocusListener {
    private JPanel panel;
    private JLabel lbBits, lbBit1, lbBit2, lbDec1, lbDec2, lbCosBin, lbCosDec, lbResBin, lbResDes, lbFlujo, lbTittle, bintoDec1, bintoDec2, dectoBin1, dectoBin2;
    private JComboBox<String> combBits;
    private JTextField textBin1, textBin2, textDec1, textDec2;
    private JButton buttonBin, buttonDec, buttonReset;
    private Font letra;
    private String titulo;
    private int numBits;
    private JTextField textFieldActual;
    private division division;
    private boolean sobreflujo;

    public DivisionPanel(int ancho, int alto, String name) {
        this.titulo = name;
        division = new division();
        letra = new Font("Helvetica", 3, 16);
        panel = new JPanel();
        panel.setSize(ancho, alto);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        initComponents();
    }
    public void initComponents() {
        //Labels
        lbTittle = new JLabel(titulo);
        lbTittle.setBounds(250, 0, 150, 30);
        lbTittle.setFont(letra);

        lbBits = new JLabel("No de Bits");
        lbBits.setBounds(10, 50, 80, 30);
        lbBits.setFont(letra);

        lbBit1 = new JLabel("Binario1:");
        lbBit1.setBounds(10, 130, 80, 30);
        lbBit1.setFont(letra);

        lbBit2 = new JLabel("Binario2:");
        lbBit2.setBounds(270, 130, 80, 30);
        lbBit2.setFont(letra);

        bintoDec1 = new JLabel("--------");
        bintoDec1.setBounds(80, 160, 150, 30);
        bintoDec1.setFont(letra);

        bintoDec2 = new JLabel("--------");
        bintoDec2.setBounds(340, 160, 80, 30);
        bintoDec2.setFont(letra);

        lbDec1 = new JLabel("Decimal1:");
        lbDec1.setBounds(10, 220, 490, 30);
        lbDec1.setFont(letra);

        lbDec2 = new JLabel("Decimal2:");
        lbDec2.setBounds(270, 220, 80, 30);
        lbDec2.setFont(letra);

        dectoBin1 = new JLabel("-----");
        dectoBin1.setBounds(90, 240, 150, 30);
        dectoBin1.setFont(letra);

        dectoBin2 = new JLabel("----");
        dectoBin2.setBounds(350, 240, 150, 30);
        dectoBin2.setFont(letra);

        lbCosBin = new JLabel("Cociente Binario: ");
        lbCosBin.setBounds(10, 300, 300, 30);
        lbCosBin.setFont(letra);

        lbCosDec = new JLabel("Cociente Decimal: ");
        lbCosDec.setBounds(10, 350, 300, 30);
        lbCosDec.setFont(letra);

        lbResBin = new JLabel("Residuo Binario: ");
        lbResBin.setBounds(10, 400, 300, 30);
        lbResBin.setFont(letra);

        lbResDes = new JLabel("Residuo Decimal: ");
        lbResDes.setBounds(10, 450, 300, 30);
        lbResDes.setFont(letra);

        lbFlujo = new JLabel("Hay desbordamiento? ");
        lbFlujo.setBounds(15, 500, 300, 30);
        lbFlujo.setFont(letra);

        //COMBOBOX
        combBits = new JComboBox<String>();
        combBits.setBounds(100, 50, 80, 25);
        combBits.addItem("----");
        combBits.addItem("4");
        combBits.addItem("8");
        combBits.addItem("16");
        combBits.addActionListener(this);

        //TextFields
        textBin1 = new JTextField("0");
        textBin1.setBounds(80, 130, 150, 30);
        textBin1.addActionListener(this);
        textBin1.addMouseListener(this);
        textBin1.addFocusListener(this);

        textBin2 = new JTextField("0");
        textBin2.setBounds(340, 130, 150, 30);
        textBin2.addActionListener(this);
        textBin2.addMouseListener(this);
        textBin2.addFocusListener(this);

        textDec1 = new JTextField("0");
        textDec1.setBounds(90, 220, 150, 30);
        textDec1.addActionListener(this);
        textDec1.addMouseListener(this);
        textDec1.addFocusListener(this);

        textDec2 = new JTextField("0");
        textDec2.setBounds(350, 220, 140, 30);
        textDec2.addActionListener(this);
        textDec2.addMouseListener(this);
        textDec2.addFocusListener(this);

        //Buttons
        buttonBin = new JButton("<");
        buttonBin.setBounds(500, 130, 47, 30);
        buttonBin.setFont(letra);
        buttonBin.addActionListener(this);

        buttonDec = new JButton("<");
        buttonDec.setBounds(500, 220, 47, 30);
        buttonDec.setFont(letra);
        buttonDec.addActionListener(this);

        buttonReset = new JButton("reset");
        buttonReset.setBounds(450, 540, 80, 30);
        buttonReset.setFont(letra);
        buttonReset.addActionListener(this);

        panel.add(lbBit1);
        panel.add(lbBit2);
        panel.add(lbBits);
        panel.add(lbDec1);
        panel.add(lbDec2);
        panel.add(lbCosBin);
        panel.add(lbCosDec);
        panel.add(lbFlujo);
        panel.add(lbResBin);
        panel.add(lbResDes);
        panel.add(lbTittle);
        panel.add(bintoDec1);
        panel.add(bintoDec2);
        panel.add(dectoBin1);
        panel.add(dectoBin2);
        panel.add(textBin1);
        panel.add(textBin2);
        panel.add(textDec1);
        panel.add(textDec2);
        panel.add(combBits);
        panel.add(buttonBin);
        panel.add(buttonDec);
        panel.add(buttonReset);
    }

    @Override
    public Component getComponent() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String bin1 = textBin1.getText();
        String bin2 = textBin2.getText();
        String dec1 = textDec1.getText();
        String dec2 = textDec2.getText();

        if (!isValidBinary(bin1) || !isValidBinary(bin2)) {
            System.out.println("Error: Ingresa valores binarios v�lidos");
            return;
        }
        if (!isValidDecimal(dec1) || !isValidDecimal(dec2)) {
            System.out.println("Error: Ingresa valores decimales v�lidos");
            return;
        }
        if (e.getSource() == combBits) {
            numBits = Integer.parseInt(combBits.getSelectedItem().toString());
        }
        if (e.getSource() == buttonBin) {
            if (combBits.getSelectedItem() == null || combBits.getSelectedItem().toString() == "----") {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona el numero de bits.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                //validar #bits
                if(bin1.length() == Integer.parseInt(combBits.getSelectedItem().toString())) {
                    if (bin2.length() == Integer.parseInt(combBits.getSelectedItem().toString())) {
                        // Resultados binarios
                        String[] resultsBin = division.dividir(bin1, bin2, numBits);
                        lbCosBin.setText(lbCosBin.getText()+ resultsBin[2]);
                        lbResBin.setText(lbResBin.getText()+ resultsBin[3]);
                        //Resultado decimal
                        double num1 = Double.parseDouble(bintoDec1.getText());
                        double num2 = Double.parseDouble(bintoDec2.getText());
                        double[] resultsDec = division.divideConSigno(num1, num2);
                        lbCosDec.setText(lbCosDec.getText()+ String.valueOf(resultsDec[0]));
                        lbResDes.setText(lbResDes.getText()+ String.valueOf(resultsDec[1]));
                        //sobreflujo
                        sobreflujo = division.detectarDesbordamiento(resultsBin[2]);
                        lbFlujo.setText(lbFlujo.getText()+sobreflujo);;
                    } else {
                        System.out.println("bin2 no cumple");
                    }
                } else {
                    System.out.println("bin1 no cumple");
                }
            }
        }

        if (e.getSource() == buttonDec) {
            if (combBits.getSelectedItem() == null || combBits.getSelectedItem().toString() == "----") {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona el numero de bits.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // validar decimal en numero de bits, rango
                //resultado binario
                String[] resultsBin = division.dividir(dectoBin1.getText(), dectoBin2.getText(), numBits);
                lbCosBin.setText(lbCosBin.getText()+ resultsBin[2]);
                lbResBin.setText(lbResBin.getText()+ resultsBin[3]);
                //Resultado decimal
                double num1 = Double.parseDouble(dec1);
                double num2 = Double.parseDouble(dec2);
                double[] resultsDec = division.divideConSigno(num1, num2);
                lbCosDec.setText(lbCosDec.getText()+String.valueOf(resultsDec[0]));
                lbResDes.setText(lbResDes.getText()+ String.valueOf(resultsDec[1]));
                //resultado decimal
                //sobreflujo
                sobreflujo = division.detectarDesbordamiento(resultsBin[2]);
                lbFlujo.setText(lbFlujo.getText()+sobreflujo);;
            }
        }
        if (e.getSource() == buttonReset) {
            reset();
        }
    }
    private boolean isValidBinary(String binary) {
        return binary.matches("[01]+");
    }

    private boolean isValidDecimal(String decimal) {
        return decimal.matches("-?\\d+(\\.\\d+)?");
    }
    public void reset() {
        textBin1.setText("0");
        textBin2.setText("0");
        textDec1.setText("0");
        textDec2.setText("0");
        bintoDec1.setText("----");
        bintoDec2.setText("----");
        dectoBin1.setText("----");
        dectoBin2.setText("----");
        lbCosBin.setText("Cociente binario: ");
        lbResBin.setText("Residuo binario: ");
        lbCosDec.setText("Cociente decimal: ");
        lbResDes.setText("Residuo decimal: ");
        lbFlujo.setText("Hay desbordamiento? ");
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textFieldActual = (JTextField) e.getSource();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            JTextField textField = (JTextField) e.getSource();
            actualizarLabelSegunTextField(textField);
        }
    }

    private void actualizarLabelSegunTextField(JTextField textField) {
        String text = textField.getText();
        numBits = Integer.parseInt(combBits.getSelectedItem().toString());

        if (textField == textBin1) {
            if (isValidBinary(text)) {
                bintoDec1.setText("" + binarioADecimalConSigno(text));
            } else {
                reset();
            }
        } else if (textField == textBin2) {
            if (isValidBinary(text)) {
                bintoDec2.setText("" + binarioADecimalConSigno(text));
            } else {
                reset();
            }
        } else if (textField == textDec1) {
            if (isValidDecimal(text)) {
                dectoBin1.setText("" + decimalABinarioConSigno(Integer.parseInt(text), numBits));
            } else {
                reset();
            }
        } else if (textField == textDec2) {
            if (isValidDecimal(text)) {
                dectoBin2.setText("" + decimalABinarioConSigno(Integer.parseInt(text), numBits));
            } else {
                reset();
            }
        }
    }
    public int binarioADecimalConSigno(String binario) {
        boolean esNegativo = binario.charAt(0) == '1';
        if (esNegativo) {
            char[] complementoA2 = new char[binario.length()];
            for (int i = 0; i < binario.length(); i++) {
                complementoA2[i] = (binario.charAt(i) == '0') ? '1' : '0';
            }
            return -(Integer.parseInt(new String(complementoA2), 2) + 1); // Devuelve el valor negativo
        }

        return Integer.parseInt(binario, 2);
    }

    public String decimalABinarioConSigno(int numero, int bits) {
        boolean esNegativo = numero < 0;
        String binario = Integer.toBinaryString(esNegativo ? (1 << bits) + numero : numero);

        // Ajustar la longitud de la cadena si es necesario
        int longitud = Math.min(bits, binario.length());
        return binario.substring(binario.length() - longitud);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (textFieldActual != null) {
            actualizarLabelSegunTextField(textFieldActual);
        }
    }
}
