package co.edu.uptc.arquitectura.calculadora_binaria.model;

public class Model {
    private double resultado;
    private double residuo;
    public void sumar(double num1, double num2) {
        resultado = num1 + num2;
    }

    public void restar(double num1, double num2) {
        resultado = num1 - num2;
    }

    public void multiplicar(double num1, double num2) {
        resultado = num1 * num2;
    }

    public void dividir(double num1, double num2) {
        resultado = num1 / num2;
        residuo = num1 % num2;
    }

    public double getResultado() {
        return resultado;
    }

    public double getResiduo() {
        return residuo;
    }
}
