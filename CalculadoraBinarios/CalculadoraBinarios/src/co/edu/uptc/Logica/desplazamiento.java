package co.edu.uptc.Logica;


public class desplazamiento  {

    // Método para desplazar un bit a la izquierda en una cadena binaria
    public String desplazarBitIzquierda(String binario) {
        return binario.substring(1) + "0";
    }

    // Método para desplazar un bit a la derecha considerando el signo
    public String desplazarBitDerecha(String binario) {
        char signo = binario.charAt(0); // Guardar el bit de signo
        String desplazado = signo + binario.substring(0, binario.length() - 1); // Desplazar manteniendo el signo
        return desplazado;
    }

}
