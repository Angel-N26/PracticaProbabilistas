package practicaprobabilistas;

import utilidades.leer;

/**
 * @author Angel Loro, Angel Sánchez
 **/

public class Main {

    public static void main(String [] args){
        PracticaProbabilistas pp = new PracticaProbabilistas(leer.real("Radio: "), leer.real("CX: "), leer.real("CY: "));
        int k = leer.entero("Intervalos?: ");
        double [] intervaloConf = new double[2];
        String ss ="areaNumericoP = " + pp.areaNumericoP(k, intervaloConf) + 
                " Intervalo de confianza[" + intervaloConf[0] + " , " + intervaloConf[1] + "]";
        System.out.println(ss);
        /*Funciones c = new Circunferencia(leer.real("Radio: "), leer.real("CX: "), leer.real("CY: "));
        int k = leer.entero("Intervalos?: ");
        String ss = c + "\nareaRieman = " + c.areaRieman(k) + "\nareaNumericoVM = " + c.areaNumericoVM(k) + 
                " Intervalo de confianza[" + c.intervaloInf() + " , " + c.intervaloSup() +
                "]\nareaNumericoP = " + c.areaNumericoP(k) +" Intervalo de confianza[" + c.intervaloInfP() +
                " , " + c.intervaloSupP() + "]\narea = "+ c.area();
        System.out.println(ss);*/
    }

}
