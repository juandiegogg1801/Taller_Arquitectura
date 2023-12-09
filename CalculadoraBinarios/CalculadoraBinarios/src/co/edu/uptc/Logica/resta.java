package co.edu.uptc.Logica;

public class resta {

    public static class ResultadoResta {
        public String resultado;
        public boolean huboDesbordamiento;

        ResultadoResta(String resultado, boolean huboDesbordamiento) {
            this.resultado = resultado;
            this.huboDesbordamiento = huboDesbordamiento;
        }
    }

    public static ResultadoResta restarEnteros(int enteroA, int enteroB, int numBits) {
        // Convierte los enteros a su representación binaria en complemento a 2
        String binarioA = Integer.toBinaryString(enteroA);
        String binarioB = Integer.toBinaryString(enteroB);
        int maxLength = Math.max(binarioA.length(), binarioB.length());
        maxLength = Math.max(maxLength, numBits);

        binarioA = String.format("%" + maxLength + "s", binarioA).replace(' ', '0');
        binarioB = String.format("%" + maxLength + "s", binarioB).replace(' ', '0');

        // Calcula el complemento a 2 del segundo número (B)
        StringBuilder complementoB = new StringBuilder();
        for (int i = 0; i < binarioB.length(); i++) {
            complementoB.append((binarioB.charAt(i) == '0') ? '1' : '0');
        }

        int carry = 1;
        StringBuilder sumaComplementoB = new StringBuilder();
        for (int i = maxLength - 1; i >= 0; i--) {
            int bitB = (i < complementoB.length()) ? Character.getNumericValue(complementoB.charAt(i)) : 0;
            int suma = bitB + carry;

            sumaComplementoB.insert(0, suma % 2);
            carry = suma / 2;
        }

        // Realiza la suma binaria entre A y el complemento a 2 de B
        int carrySuma = 0;
        StringBuilder resultado = new StringBuilder();
        for (int i = maxLength - 1; i >= 0; i--) {
            int bitA = (i < binarioA.length()) ? Character.getNumericValue(binarioA.charAt(i)) : 0;
            int bitSumaComplementoB = (i < sumaComplementoB.length()) ? Character.getNumericValue(sumaComplementoB.charAt(i)) : 0;
            int suma = bitA + bitSumaComplementoB + carrySuma;

            resultado.insert(0, suma % 2);
            carrySuma = suma / 2;
        }

        // Verificar si el resultado está fuera del rango permitido por los bits
        int maxPositiveValue = (1 << (numBits - 1)) - 1;
        int minNegativeValue = -(1 << (numBits - 1));

        boolean huboDesbordamiento = false;
        if (Integer.parseInt(resultado.toString(), 2) > maxPositiveValue || Integer.parseInt(resultado.toString(), 2) < minNegativeValue) {
            resultado.deleteCharAt(0); // Descartar el bit más alto
            huboDesbordamiento = true;
        }

        // Ajusta el resultado al número de bits especificado
        resultado = new StringBuilder(resultado.substring(Math.max(0, resultado.length() - numBits)));

        return new ResultadoResta(resultado.toString(), huboDesbordamiento);
    }

    
    public static ResultadoResta restarBinariosComplemento2(String binarioA, String binarioB, int numBits) {
        int maxLengthBinarios = Math.max(binarioA.length(), binarioB.length());
        maxLengthBinarios = Math.max(maxLengthBinarios, numBits);

        // Ajusta la longitud de los números binarios
        binarioA = String.format("%" + maxLengthBinarios + "s", binarioA).replace(' ', '0');
        binarioB = String.format("%" + maxLengthBinarios + "s", binarioB).replace(' ', '0');

        // Calcula el complemento a 2 del segundo número (B)
        StringBuilder complementoB = new StringBuilder();
        for (int i = 0; i < binarioB.length(); i++) {
            complementoB.append((binarioB.charAt(i) == '0') ? '1' : '0');
        }

        int carry = 1;
        StringBuilder sumaComplementoB = new StringBuilder();
        for (int i = maxLengthBinarios - 1; i >= 0; i--) {
            int bitB = (i < complementoB.length()) ? Character.getNumericValue(complementoB.charAt(i)) : 0;
            int suma = bitB + carry;

            sumaComplementoB.insert(0, suma % 2);
            carry = suma / 2;
        }

        // Realiza la suma binaria entre A y el complemento a 2 de B
        int carrySuma = 0;
        StringBuilder resultado = new StringBuilder();
        for (int i = maxLengthBinarios - 1; i >= 0; i--) {
            int bitA = (i < binarioA.length()) ? Character.getNumericValue(binarioA.charAt(i)) : 0;
            int bitSumaComplementoB = (i < sumaComplementoB.length()) ? Character.getNumericValue(sumaComplementoB.charAt(i)) : 0;
            int suma = bitA + bitSumaComplementoB + carrySuma;

            resultado.insert(0, suma % 2);
            carrySuma = suma / 2;
        }

        // Verificar si el resultado está fuera del rango permitido por los bits
        int maxPositiveValue = (1 << (numBits - 1)) - 1;
        int minNegativeValue = -(1 << (numBits - 1));

        boolean huboDesbordamiento = false;
        if (Integer.parseInt(resultado.toString(), 2) > maxPositiveValue || Integer.parseInt(resultado.toString(), 2) < minNegativeValue) {
            resultado.deleteCharAt(0); // Descartar el bit más alto
            huboDesbordamiento = true;
        }

        // Ajusta el resultado al número de bits especificado
        resultado = new StringBuilder(resultado.substring(Math.max(0, resultado.length() - numBits)));

        return new ResultadoResta(resultado.toString(), huboDesbordamiento);
    }

    public static int binarioADecimalConSigno(String binario) {
        if (binario.isEmpty()) {
            return 0;
        }

        boolean esNegativo = binario.charAt(0) == '1';

        // Si es negativo, calcula su complemento a 2
        if (esNegativo) {
            char[] complementoA2 = new char[binario.length()];
            for (int i = 0; i < binario.length(); i++) {
                complementoA2[i] = (binario.charAt(i) == '0') ? '1' : '0';
            }
            return -(Integer.parseInt(new String(complementoA2), 2) + 1); // Devuelve el valor negativo
        }

        return Integer.parseInt(binario, 2);
    }
}



