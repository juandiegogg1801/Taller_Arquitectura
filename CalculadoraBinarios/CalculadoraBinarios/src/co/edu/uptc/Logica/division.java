package co.edu.uptc.Logica;

import co.edu.uptc.presentacion.GUI.panelGeneral;

public class division {
	
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
	
    public String divide(Long a,Long b){
        String f = toBinary(Math.abs(a));
        String g = toBinary(Math.abs(b));
        String x="",y="";
        for(int i=0;i<f.length();i++){
            if (f.charAt(i)=='1'){
                x=f.substring(i);
                break;
            }
        }
        for(int i=0;i<g.length();i++){
            if (g.charAt(i)=='1'){
                y=g.substring(i);
                break;
            }
        }
        System.out.println("Binarios naturales \nA "+x+"\nB "+y);
        int cambios= x.length()-y.length();
        String parcial="";
        String rta="";
        parcial=x.substring(0,y.length()-1);
        for(int i =0;i<cambios;i++){
            //parcial=x.substring(i,i+y.length()-1);
            if(mayor(parcial,y)){
                parcial=restar(parcial,y);
                rta=rta+"1";
            }else{
                rta=rta+"0";
            }
            if((i+y.length())!=x.length()) {
                parcial = parcial.substring(1) + x.charAt(i + y.length());
            }else{
                parcial = parcial.substring(1) + x.charAt(i + y.length()-1);
            }
        }

        for(int i=0;i<parcial.length();i++){
            if (parcial.charAt(i)=='1'){
                parcial=parcial.substring(i);
                break;
            }
        }

        if (a<0 && b<0){
            for(int i =0;i<(23-rta.length());i++){
                rta='0'+rta;
            }
            for (int i =0;i<(23-parcial.length());i++){
                parcial='1'+parcial;
            }
        }else if (a>0 && b<0){
            for(int i =0;i<(23-rta.length());i++){
                rta='1'+rta;
            }
            for (int i =0;i<(23-parcial.length());i++){
                parcial='0'+parcial;
            }
        }else if (a<0 && b>0){
            //System.out.println(rta+"  --  "+parcial);
            //System.out.println((rta.length())+"  --  "+(parcial.length()));
            for(int i =0;i<(23-rta.length());i++){
                rta='1'+rta;
            }
            for (int i =0;i<(23-parcial.length());i++){
                parcial='1'+parcial;
            }
        }else if (a>0 && b>0){
            for(int i =0;i<(23-rta.length());i++){
                rta='0'+rta;
            }
            for (int i =0;i<(23-parcial.length());i++){
                parcial='0'+parcial;
            }
        }

        return "Cociente "+rta+" residuo "+parcial;
    }

    public boolean mayor(String a, String b){
        for (int i = 0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                if (a.charAt(i)>b.charAt(i)){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public String restar(String a,String b){
        char [] x=a.toCharArray();
        char [] y=b.toCharArray();
        String rta="";
        for(int i=x.length-1;i>=0;i--){
            if(x[i]==y[i]){
                rta='0'+rta;
            }else if(x[i]=='1'){
                rta='1'+rta;
            }else{
                rta='1'+rta;
                int cont = 1;
                while (true){
                    if(x[i-cont]=='1'){
                        break;
                    }else{
                        x[i-cont]='1';
                    }
                }
            }
        }
        return rta;
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

    public String comp2(String cad){
        String aux = cad.replace('1','a');
        aux=cad.replace('0','1');
        aux=cad.replace('a','0');
        return add2(aux,"000000000000001");
    }

}


