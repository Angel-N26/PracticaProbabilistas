package practicaprobabilistas;

import utilidades.leer;

/**
 * @author Angel Loro, Angel Sánchez
 **/

public class Main {

    public static void main(String [] args){        
        PracticaProbabilistas pp = new PracticaProbabilistas();        
        int k = leer.entero("Numero de veces: ");	
        
        String ss ="Volumen: " + pp.volumen(k) + " Intervalo de confianza[" + pp.getIntConfPos(0) + " , " + pp.getIntConfPos(1) + "]";
        leer.pln(ss);

    }

}
