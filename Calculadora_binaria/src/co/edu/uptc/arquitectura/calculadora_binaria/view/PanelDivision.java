package co.edu.uptc.arquitectura.calculadora_binaria.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDivision extends JFrame {
    private JTextField textFieldNum1;
    private JTextField textFieldNum2;
    private JButton btnCalcular;
    private JLabel lblResultado;
    public PanelDivision() {
        setLayout(new GridLayout(4, 2));

        textFieldNum1 = new JTextField();
        textFieldNum2 = new JTextField();
        btnCalcular = new JButton("Calcular");
        lblResultado = new JLabel("Resultado:");

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textFieldNum1.getText());
                double num2 = Double.parseDouble(textFieldNum2.getText());
            }
        });

        add(new JLabel("Número 1:"));
        add(textFieldNum1);
        add(new JLabel("Número 2:"));
        add(textFieldNum2);
        add(btnCalcular);
        add(lblResultado);
    }
    public void addDividirListener(ActionListener listener) {
        btnCalcular.addActionListener(listener);
    }
}
