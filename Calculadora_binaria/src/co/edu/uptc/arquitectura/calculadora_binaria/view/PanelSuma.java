package co.edu.uptc.arquitectura.calculadora_binaria.view;
import co.edu.uptc.arquitectura.calculadora_binaria.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSuma implements Panel {
    private JPanel panel;
    private JLabel jLabel;
    private JComboBox comboBox;
    private JComboBox comboBox2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel sum1;
    private JLabel sum2;
    private JLabel resultBinario;
    private JLabel resultDecimal;
    private JTextField jTextField;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JButton jButton;

    public PanelSuma() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 4, 10, 10));
        jLabel = new JLabel("# Bits");
        jLabel1 = new JLabel("Ingreso: ");
        jLabel2 = new JLabel("Ingresar Binario: ");
        jLabel3 = new JLabel("Ingresar decimal: ");
        jLabel4 = new JLabel("Solucion binaria: ");
        jLabel5 = new JLabel("Solucion decimal: ");
        jLabel6 = new JLabel("Sobreflujo: ");
        sum1 = new JLabel("+");
        sum2 = new JLabel("+");
        sum1.setHorizontalAlignment(JLabel.CENTER);
        sum2.setHorizontalAlignment(JLabel.CENTER);
        resultBinario = new JLabel("");
        resultDecimal = new JLabel("");
        jTextField = new JTextField(20);
        jTextField2 = new JTextField(20);
        jTextField3 = new JTextField(20);
        jTextField4 = new JTextField(20);
        jButton = new JButton("Calcular");
        ComboBoxModel comboModel = new DefaultComboBoxModel(new String[] {"4","8","16"});
        comboBox = new JComboBox();
        comboBox.setModel(comboModel);
        ComboBoxModel comboBoxModel = new DefaultComboBoxModel(new String[] {"Seleccionar","Binario","Decimal"});
        comboBox2 = new JComboBox();
        comboBox2.setModel(comboBoxModel);

        panel.add(jLabel);
        panel.add(comboBox);
        panel.add(jLabel1);
        panel.add(comboBox2);
        panel.add(jLabel2);
        panel.add(jTextField);
        panel.add(sum1);
        panel.add(jTextField2);
        panel.add(jLabel3);
        panel.add(jTextField3);
        panel.add(sum2);
        panel.add(jTextField4);
        panel.add(jButton);
        panel.add(createEmptyCell());
        panel.add(createEmptyCell());
        panel.add(createEmptyCell());
        panel.add(jLabel4);
        panel.add(createEmptyCell());
        panel.add(createEmptyCell());
        panel.add(createEmptyCell());
        panel.add(jLabel5);
        panel.add(resultBinario);
        panel.add(createEmptyCell());
        panel.add(createEmptyCell());
        panel.add(jLabel6);
        panel.add(resultDecimal);
        panel.add(createEmptyCell());
        panel.add(createEmptyCell());

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox2.getSelectedItem().equals("Binario")) {
                    jTextField.setEditable(true);
                    jTextField2.setEditable(true);
                    jTextField3.setEditable(false);
                    jTextField4.setEditable(false);
                }else if (comboBox2.getSelectedItem().equals("Decimal")){
                    jTextField.setEditable(false);
                    jTextField2.setEditable(false);
                    jTextField3.setEditable(true);
                    jTextField4.setEditable(true);
                }
            }
        });
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comboUno = (String) comboBox.getSelectedItem();
                String comboDos = (String) comboBoxModel.getSelectedItem();
                Controller controller = new Controller(comboUno, comboDos, jTextField, jTextField2, jTextField3, jTextField4, jLabel4, jLabel5, jLabel6);
                //validar
                if(controller.validar()==true) {
                    controller.sumar();
                }else {
                    System.out.println("DATOS INVALIDOS");
                }
            }
        });
    }

    private JLabel createEmptyCell() {
        return new JLabel();  // No es necesario configurar texto ni icono
    }

    @Override
    public Component getComponent() {
        return panel;
    }
}
