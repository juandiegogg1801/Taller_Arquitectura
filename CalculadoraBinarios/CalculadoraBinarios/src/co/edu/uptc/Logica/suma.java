package co.edu.uptc.Logica;

public class suma {

    public static class ResultadoOperacion {
        public String resultado;
        public boolean huboDesbordamiento;

        ResultadoOperacion(String resultado, boolean huboDesbordamiento) {
            this.resultado = resultado;
            this.huboDesbordamiento = huboDesbordamiento;
        }
    }

    public static ResultadoOperacion sumarEnteros(int enteroA, int enteroB, int numBits) {
        String binarioA = convertirARepresentacionBinaria(enteroA, numBits);
        String binarioB = convertirARepresentacionBinaria(enteroB, numBits);

        String resultado = sumarBinarios(binarioA, binarioB, numBits);
        boolean huboDesbordamiento = detectarDesbordamiento(resultado);

        return new ResultadoOperacion(resultado, huboDesbordamiento);
    }

    public static ResultadoOperacion sumarBinariosComplemento2(String binarioA, String binarioB, int numBits) {
        String resultado = sumarBinarios(binarioA, binarioB, numBits);
        boolean huboDesbordamiento = detectarDesbordamiento(resultado);

        return new ResultadoOperacion(resultado, huboDesbordamiento);
    }

    private static String convertirARepresentacionBinaria(int numero, int numBits) {
        String binario = Integer.toBinaryString(numero);
        return String.format("%" + numBits + "s", binario).replace(' ', '0');
    }

    static String sumarBinarios(String binarioA, String binarioB, int numBits) {
        int carry = 0;
        StringBuilder resultado = new StringBuilder();
        for (int i = numBits - 1; i >= 0; i--) {
            int bitA = 0;
			try {
				bitA = obtenerBit(binarioA, i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            int bitB = obtenerBit(binarioB, i);
            int suma = bitA + bitB + carry;

            resultado.insert(0, suma % 2);
            carry = suma / 2;
        }

        if (carry != 0) {
            resultado.deleteCharAt(0);
        }

        return resultado.toString();
    }

    private static boolean detectarDesbordamiento(String resultado) {
        char msbBefore = resultado.charAt(0);
        char msbAfter = resultado.charAt(1);

        return msbBefore != msbAfter;
    }

    private static int obtenerBit(String binario, int indice) {
        return (indice < binario.length()) ? Character.getNumericValue(binario.charAt(indice)) : 0;
    }

    public static int binarioADecimalConSigno(String binario) {
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
}



