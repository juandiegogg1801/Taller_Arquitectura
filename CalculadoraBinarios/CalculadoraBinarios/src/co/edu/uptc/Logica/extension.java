package co.edu.uptc.Logica;

public class extension  {

    public static String extenderSigno(String binario, int bits) {
        int longitudOriginal = binario.length();
        char signo = binario.charAt(0);

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < bits - longitudOriginal + 1; i++) {
            resultado.append(signo);
        }
        resultado.append(binario.substring(1));

        return resultado.toString();
    }

}
