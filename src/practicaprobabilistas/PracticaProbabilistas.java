package practicaprobabilistas;

import utilidades.leer;

/**
 * @author Angel Loro, Angel Sánchez
 **/

public class PracticaProbabilistas {

    public static void main(String[] args) {
        //Funciones c = new xElevadoy(leer.entero("potencia?"), leer.real("linf"), leer.real("lsup"));
        Funciones c = new Circunferencia(leer.real("Radio: "), leer.real("CX: "), leer.real("CY: "));
        int k = leer.entero("Intervalos?: ");
        String ss = c + "\nareaRieman = " + c.areaRieman(k) + "\nareaNumericoVM = " + c.areaNumericoVM(k) + 
                " Intervalo de confianza[" + c.intervaloInf() + " , " + c.intervaloSup() + 
                "]\nareaNumericoP = " + c.areaNumericoP(k) +" Intervalo de confianza[" + c.intervaloInfP() + 
                " , " + c.intervaloSupP() + "]\narea = "+ c.area();
        System.out.println(ss);        
    }

}
