package co.edu.uptc.arquitectura.calculadora_binaria.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelResta implements Panel {
    private JPanel panel;
    private JTextField textFieldNum1;
    private JTextField textFieldNum2;
    private JButton btnCalcular;
    private JLabel lblResultado;

    public PanelResta() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
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

        panel.add(new JLabel("Número 3:"));
        panel.add(textFieldNum1);
        panel.add(new JLabel("Número 4"));
        panel.add(textFieldNum2);
        panel.add(btnCalcular);
        panel.add(lblResultado);
    }
    public void addRestarListener(ActionListener listener) {
        btnCalcular.addActionListener(listener);
    }

    @Override
    public Component getComponent() {
        return panel;
    }
}
