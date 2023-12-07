package co.edu.uptc.Logica;
public class suma {
	
    public static class ResultadoSuma {
        public String resultado;
        public boolean huboDesbordamiento;

        ResultadoSuma(String resultado, boolean huboDesbordamiento) {
            this.resultado = resultado;
            this.huboDesbordamiento = huboDesbordamiento;
        }
    }

    public static ResultadoSuma sumaEnterosComplementoDos(int enteroA, int enteroB, int numBits) {
        // Convierte los enteros a su representaci�n binaria en complemento a 2
        String binarioA = Integer.toBinaryString(enteroA);
        String binarioB = Integer.toBinaryString(enteroB);
        int maxLength = Math.max(binarioA.length(), binarioB.length());
        maxLength = Math.max(maxLength, numBits);

        binarioA = String.format("%" + maxLength + "s", binarioA).replace(' ', '0');
        binarioB = String.format("%" + maxLength + "s", binarioB).replace(' ', '0');

        // Realiza la suma binaria en complemento a 2
        int carry = 0;
        StringBuilder resultado = new StringBuilder();
        for (int i = maxLength - 1; i >= 0; i--) {
            int bitA = i < binarioA.length() ? Character.getNumericValue(binarioA.charAt(i)) : 0;
            int bitB = i < binarioB.length() ? Character.getNumericValue(binarioB.charAt(i)) : 0;
            int suma = bitA + bitB + carry;

            resultado.insert(0, suma % 2);
            carry = suma / 2;
        }

        // Si hay desbordamiento, descarta el bit m�s alto
        if (carry != 0) {
            resultado.deleteCharAt(0);
        }

        // Ajusta el resultado al n�mero de bits especificado
        resultado = new StringBuilder(resultado.substring(Math.max(0, resultado.length() - numBits)));

        char msbBefore = resultado.charAt(0);
        char msbAfter = resultado.charAt(1);

        // Verificar si hubo desbordamiento
        boolean huboDesbordamiento = msbBefore != msbAfter;

        return new ResultadoSuma(resultado.toString(), !huboDesbordamiento);
    }

    public static ResultadoSuma sumaBinariosComplementoDos(String binarioA, String binarioB, int numBits) {
        int enteroA = binarioADecimalConSigno(binarioA);
        int enteroB = binarioADecimalConSigno(binarioB);

        binarioA = Integer.toBinaryString(enteroA);
        binarioB = Integer.toBinaryString(enteroB);

        int maxLength = Math.max(binarioA.length(), binarioB.length());
        maxLength = Math.max(maxLength, numBits);

        binarioA = String.format("%" + maxLength + "s", binarioA).replace(' ', '0');
        binarioB = String.format("%" + maxLength + "s", binarioB).replace(' ', '0');

        int carry = 0;
        StringBuilder resultado = new StringBuilder();
        for (int i = maxLength - 1; i >= 0; i--) {
            int bitA = i < binarioA.length() ? Character.getNumericValue(binarioA.charAt(i)) : 0;
            int bitB = i < binarioB.length() ? Character.getNumericValue(binarioB.charAt(i)) : 0;
            int suma = bitA + bitB + carry;

            resultado.insert(0, suma % 2);
            carry = suma / 2;
        }

        if (carry != 0) {
            resultado.deleteCharAt(0);
        }

        resultado = new StringBuilder(resultado.substring(Math.max(0, resultado.length() - numBits)));
        char msbBefore = resultado.charAt(0); 
        char msbAfter = resultado.charAt(1);  

        // Verificar si hubo desbordamiento
        boolean huboDesbordamiento = msbBefore != msbAfter;

        return new ResultadoSuma(resultado.toString(), huboDesbordamiento);
    }

    public static int binarioADecimalConSigno(String binario) {
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


