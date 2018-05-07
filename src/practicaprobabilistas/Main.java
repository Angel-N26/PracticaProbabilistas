package practicaprobabilistas;

import utilidades.leer;

/**
 * @author Angel Loro, Angel Sánchez
 **/

public class Main {

    public static void main(String [] args){        
        PracticaProbabilistas pp = new PracticaProbabilistas();        
        int k = leer.entero("Numero de veces: ");	
        PracticaProbabilistas pp2 = new PracticaProbabilistas(3,2,2,2);      
        String ss ="Volumen: " + pp.volumen(k) + " Intervalo de confianza[" + pp.getIntConfPos(0) + " , " + pp.getIntConfPos(1) + "]" + 
                "V: " + pp2.volumenEsfera(k);
        leer.pln(ss);

    }

}
