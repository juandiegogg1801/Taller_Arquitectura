package co.edu.uptc.arquitectura.calculadora_binaria.controller;

import co.edu.uptc.arquitectura.calculadora_binaria.model.Model;
import co.edu.uptc.arquitectura.calculadora_binaria.view.PanelSuma;
import co.edu.uptc.arquitectura.calculadora_binaria.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Controller{
    private String comboUno;
    private String comboDos;
    private JTextField jTextField;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JLabel resultBinario;
    private JLabel resultDecimal;
    private JLabel sobreflujo;
    private Model model;

    public Controller(String comboUno, String comboDos, JTextField jTextField, JTextField jTextField2, JTextField jTextField3, JTextField jTextField4, JLabel resultBinario, JLabel resultDecimal, JLabel sobreflujo) {
        this.comboUno = comboUno;
        this.comboDos = comboDos;
        this.jTextField = jTextField;
        this.jTextField2 = jTextField2;
        this.jTextField3 = jTextField3;
        this.jTextField4 = jTextField4;
        this.resultBinario = resultBinario;
        this.resultDecimal = resultDecimal;
        this.sobreflujo = sobreflujo;
        model = new Model();
    }

    public boolean validar() {
        if (comboDos.equals("Binario")) {
            // validar campos
            if (validar_Campo(jTextField)==true) {
                if (validar_Campo(jTextField2)==true) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            if (validar_Campo(jTextField3)==true) {
                if (validar_Campo(jTextField4)==true) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
    public boolean validar_Campo(JTextField jTextField) {
        if (comboDos.equals("Binario")) {
            // validar campos
            if (espacioVacio(jTextField)==true) {
                // validar numero binario
                if (validarBinario(jTextField.getText())==true) {
                    // validar num bits
                    if (validarNumBits(comboUno, jTextField.getText())==true) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            // validar campos
            if (espacioVacio(jTextField)==true) {
                // validar numero decimal
                if (validarDecimal(jTextField.getText())==true) {
                    // validar rango
                    if (validarRango(comboUno, jTextField.getText())) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public boolean espacioVacio(JTextField jTextField) {
        if (jTextField.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarBinario(String string) {
        for (char character : string.toCharArray()) {
            if (character != 0 || character != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean validarDecimal(String string) {
        for (char character : string.toCharArray()) {
            if (character != 0 || character != 1 || character != 2 || character != 3 || character != 4 || character != 5 || character != 6 || character != 7 || character != 8 || character != 9) {
                return false;
            }
        }
        return true;
    }

    public boolean validarNumBits(String n, String num) {
        int N = Integer.parseInt(n);
        int i = 0;
        for (char character : num.toCharArray()) {
            i++;
        }
        if (N==i) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarRango(String n, String num) {
        int N = Integer.parseInt(n);
        double min = Math.pow(-2, N);
        double max = Math.pow(2, N)-1;
        double numero = Double.parseDouble(num);
        if (numero >= min && numero <= max) {
            return true;
        } else {
            return false;
        }
    }

    public void sumar() {
        //model.sumar(Integer.parseInt(numUno.getText()), Integer.parseInt(numDos.getText()));
        //result.setText(result.getText()+" "+String.valueOf(model.getResultado()));
    }
}
