package co.edu.uptc.arquitectura.calculadora_binaria.view;

import co.edu.uptc.arquitectura.calculadora_binaria.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JPanel panel_operaciones;
    private JPanel panel_contenido;
    private CardLayout cardLayout;
    private JLabel label_oprs;
    private JButton button_suma;
    private JButton button_resta;
    private JButton button_mult;
    private JButton button_div;
    private JButton button_despl;
    private JButton button_exten;
    public View() {
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Calculadora");
        this.setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout(10,10));
        panel_operaciones = new JPanel(new GridLayout(7,1));
        label_oprs = new JLabel("OPERACIONES");
        label_oprs.setHorizontalAlignment(JLabel.CENTER);
        Font font = label_oprs.getFont();
        label_oprs.setFont(new Font(font.getName(),Font.PLAIN,20));
        button_suma = new JButton("SUMA");
        button_resta = new JButton("RESTA");
        button_mult = new JButton("MULTIPLICACIÓN");
        button_div = new JButton("DIVISIÓN");
        button_despl = new JButton("Desplazamiento");
        button_exten = new JButton("Extensión");
        panel_contenido = new JPanel();
        cardLayout = new CardLayout();
        panel_contenido.setLayout(cardLayout);

        panel_operaciones.add(label_oprs);
        panel_operaciones.add(button_suma);
        panel_operaciones.add(button_resta);
        panel_operaciones.add(button_mult);
        panel_operaciones.add(button_div);
        panel_operaciones.add(button_despl);
        panel_operaciones.add(button_exten);

        button_suma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanel(new PanelSuma());
            }
        });
        button_resta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanel(new PanelResta());
            }
        });
        this.add(panel_operaciones, BorderLayout.WEST);
        this.add(panel_contenido, BorderLayout.CENTER);
    }

    private void mostrarPanel(Panel panel) {
        panel_contenido.removeAll();
        panel_contenido.add(panel.getComponent());
        ((CardLayout) panel_contenido.getLayout()).show(panel_contenido, "Frame");
        revalidate();
        repaint();
    }

}
