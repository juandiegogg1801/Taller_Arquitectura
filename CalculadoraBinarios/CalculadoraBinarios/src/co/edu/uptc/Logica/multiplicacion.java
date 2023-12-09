package co.edu.uptc.Logica;

public class multiplicacion {
	
	 public String add2(String x,String y){
	        //System.out.println(x+"  --  "+y);
	        String rta="";
	        String aca="0";

	        for( int i = x.length()-1; i >= 0;i--){
	            if(aca=="0"){
	                if(x.charAt(i)=='1' && y.charAt(i)=='1'){
	                    rta='0'+rta;
	                    aca="1";
	                }else if((x.charAt(i)=='0' && y.charAt(i)=='1') || (x.charAt(i)=='1' && y.charAt(i)=='0')){
	                    rta='1'+rta;
	                    aca="0";
	                }else if(x.charAt(i)=='0' && y.charAt(i)=='0'){
	                    rta='0'+rta;
	                    aca="0";
	                }
	            }else{
	                if(x.charAt(i)=='1' && y.charAt(i)=='1'){
	                    rta='1'+rta;
	                    aca="1";
	                }else if((x.charAt(i)=='0' && y.charAt(i)=='1') || (x.charAt(i)=='1' && y.charAt(i)=='0')){
	                    rta='0'+rta;
	                    aca="1";
	                }else if(x.charAt(i)=='0' && y.charAt(i)=='0'){
	                    rta='1'+rta;
	                    aca="0";
	                }
	            }
	        }
	        return rta;
	    }

	 public String multiply(Long a, Long b){
	        String x = toBinary(a);
	        String y = toBinary(b);
	        String rta="";
	        String vector[]= new String[32];
	        if(x.charAt(0)=='1'){
	            x="1111111111111111"+x;
	        }else{
	            x="0000000000000000"+x;
	        }
	        if(y.charAt(0)=='1'){
	            y="1111111111111111"+y;
	        }else{
	            y="0000000000000000"+y;
	        }
	        int aux =0;
	        String aux2="";
	        for ( int i =y.length()-1 ; i >=0;i--){
	            if(y.charAt(i)=='1'){
	                aux2=x;
	            }else if(y.charAt(i)=='0'){
	                aux2 = "0000000000000000000000000000000";
	            }
	            //System.out.println("Valor de aux : " + aux);
	            vector[aux]=aux2;
	            //System.out.println("Valor de apos : " + vector[aux]);
	            aux++;
	        }
	        for(int i = 0;i<32;i++){
	            //System.out.println(i);
	            vector[i]=vector[i].substring(i);
	            for(int k = 0;k<i;k++){
	                vector[i]=vector[i]+"0";
	            }
	        }
	        String z = "0000000000000000000000000000000";
	        for(int i =0 ; i<vector.length;i++){
	            //System.out.println("  --  "+vector[i].substring(16));
	            z=add2(z,vector[i]);
	        }
	        return z;
	    }
	    
	    public String multiplicarEnterosConSigno(int entero1, int entero2, int bits) {
	        String binario1 = decimalABinarioConSigno(entero1, bits);
	        String binario2 = decimalABinarioConSigno(entero2, bits);

	        int multiplicando = Integer.parseInt(binario1, 2);
	        int multiplicador = Integer.parseInt(binario2, 2);
	        long resultado = (long) multiplicando * multiplicador;

	        // Verificar si el resultado excede el rango permitido por los bits
	        int maxPositiveValue = (1 << (bits - 1)) - 1;
	        int minNegativeValue = -(1 << (bits - 1));

	        if (resultado > maxPositiveValue || resultado < minNegativeValue) {
	            // El resultado está fuera del rango permitido por los bits
	            resultado = resultado & ((1L << bits) - 1); // Ajustar al rango permitido
	        }

	        return decimalABinarioConSigno((int) resultado, bits);
	    }
	    
	    public static String decimalABinarioConSigno(int numero, int bits) {
	        boolean esNegativo = numero < 0;
	        String binario = Integer.toBinaryString(esNegativo ? (1 << bits) + numero : numero);

	        // Ajustar la longitud de la cadena si es necesario
	        int longitud = Math.min(bits, binario.length());
	        return binario.substring(binario.length() - longitud);
	    }

	    public int binarioADecimalConSigno(String binario) {
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
	    
	    public String toBinary(Long n){
	        String rta = Long.toBinaryString(n);
	        if(n<0){
	            return rta.substring(48);
	        }else{
	            while (rta.length()<15){
	                rta='0'+rta;
	            }
	            if (n<0){
	                rta='1'+rta;
	            }else{
	                rta='0'+rta;
	            }
	            return rta;
	        }

	    }

}
