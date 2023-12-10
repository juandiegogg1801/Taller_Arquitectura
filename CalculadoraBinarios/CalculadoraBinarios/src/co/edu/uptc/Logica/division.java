package co.edu.uptc.Logica;

import co.edu.uptc.presentacion.GUI.panelGeneral;

public class division {
    public String[] dividir(String dividendoBinario, String divisorBinario, int bits) {
        // Identificar los signos de dividendo y divisor
        boolean esNegativoDividendo = dividendoBinario.charAt(0) == '1';
        boolean esNegativoDivisor = divisorBinario.charAt(0) == '1';

        // Obtener el valor absoluto del dividendo y divisor
        long dividendo = Long.parseLong(esNegativoDividendo ? complementoA2(dividendoBinario) : dividendoBinario, 2);
        long divisor = Long.parseLong(esNegativoDivisor ? complementoA2(divisorBinario) : divisorBinario, 2);

        // Calcular cociente y residuo
        long cociente = dividendo / divisor;
        long residuo = dividendo % divisor;

        // Ajustar los signos según la tabla
        if ((esNegativoDividendo && !esNegativoDivisor) || (!esNegativoDividendo && esNegativoDivisor)) {
            cociente = -cociente;
        }

        if (esNegativoDividendo) {
            residuo = -residuo;
        }

        // Convertir los resultados a binario
        String dividendoResultado = Long.toBinaryString(dividendo);
        String divisorResultado = Long.toBinaryString(divisor);
        String cocienteResultado = Long.toBinaryString(cociente);
        String residuoResultado = Long.toBinaryString(residuo);

        // Ajustar las longitudes de los resultados
        if (dividendoResultado.length() > bits) {
            dividendoResultado = dividendoResultado.substring(dividendoResultado.length() - bits);
        }

        if (divisorResultado.length() > bits) {
            divisorResultado = divisorResultado.substring(divisorResultado.length() - bits);
        }

        if (cocienteResultado.length() > bits) {
            cocienteResultado = cocienteResultado.substring(cocienteResultado.length() - bits);
        }

        if (residuoResultado.length() > bits) {
            residuoResultado = residuoResultado.substring(residuoResultado.length() - bits);
        }

        return new String[]{dividendoResultado, divisorResultado, cocienteResultado, residuoResultado};
    }

    private String complementoA2(String binario) {
        // Invertir los bits
        StringBuilder complemento = new StringBuilder();
        for (char bit : binario.toCharArray()) {
            complemento.append(bit == '0' ? '1' : '0');
        }

        // Sumar 1 al resultado invertido
        int carry = 1;
        for (int i = complemento.length() - 1; i >= 0; i--) {
            if (complemento.charAt(i) == '0' && carry == 1) {
                complemento.setCharAt(i, '1');
                carry = 0;
            } else if (complemento.charAt(i) == '1' && carry == 1) {
                complemento.setCharAt(i, '0');
            }
        }

        return complemento.toString();
    }
    public double[] divideConSigno(double dividendo, double divisor) {
        // Verificar si el resultado será negativo
        boolean esNegativo = (dividendo < 0) ^ (divisor < 0);

        // Tomar el valor absoluto de los números
        dividendo = Math.abs(dividendo);
        divisor = Math.abs(divisor);

        // Realizar la división
        double cociente = dividendo / divisor;

        // Calcular el residuo
        double residuo = dividendo % divisor;

        // Ajustar el signo del resultado
        if (esNegativo) {
            cociente = -cociente;
            residuo = -residuo;
        }

        // Devolver el resultado en un arreglo
        return new double[]{cociente, residuo};
    }
    public boolean detectarDesbordamiento(String resultado) {
        char msbBefore = resultado.charAt(0);
        char msbAfter = resultado.charAt(1);

        return msbBefore != msbAfter;
    }
}


