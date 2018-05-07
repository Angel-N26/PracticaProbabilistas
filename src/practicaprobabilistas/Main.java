package practicaprobabilistas;

import utilidades.leer;

/**
 * @author Angel Loro, Angel Sánchez
 **/

public class Main {

    public static void main(String[] args) {
        menu();

    }
    public static void menu(){
    
        boolean seguir = true;
        int k ;
        do {
            switch (leer.entero("Indique la opcion que desea realizar:\n\t1)x^2 + y^2 = z\n\t2)x^xP + y^yP + z^zP = r^2\n\t3)Salir\n")) {
                //x^2 + y^2 = z
                case 1:
                    PracticaProbabilistas pp = new PracticaProbabilistas();
                    k = leer.entero("Numero de veces: ");
                    leer.pln("Volumen: " + pp.volumen(k) + " Intervalo de confianza[" + pp.getIntConfPos(0) + " , " + pp.getIntConfPos(1) + "]");
                    break;
                // x^i + y^j+ z^k=r^2
                case 2:
                    PracticaProbabilistas pe = new PracticaProbabilistas(leer.real("radio:\n"),leer.real("xP:\n"),leer.real("yP:\n"),leer.real("zP:\n"));
                    k = leer.entero("Numero de veces: ");
                    leer.pln("Volumen: " + pe.volumen(k));
                    break;

                case 3:
                    seguir = false;
                    break;

                default:
                    leer.pln("Opcion invalida");

            }

        } while (seguir);
    }
}
