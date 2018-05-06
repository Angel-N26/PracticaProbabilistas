package practicaprobabilistas;

import utilidades.leer;

/**
 * @author Angel Loro, Angel Sánchez
 **/

public class PracticaProbabilistas {

    double r, cX, cY, linf, lsup; //radio y centro (cX , cY)
    
    public PracticaProbabilistas(double radio) {
        linf = centroX - radio;
        lsup = centroX + radio;
        r = radio;
        cX = centroX;
        cY = centroY;
    } 
    
    public double areaNumericoP(int k, double [] intervaloConf) { //area probabilista lanzando k puntos A = casos favorables / casos posibles         
        //PracticaProbabilistas pp = new PracticaProbabilistas(r,0.0,0.0);
        int buenos = 0;
        for (int n = 0; n < k; n++) {
            double x = Math.random() * r;
            double y = Math.random() * r;
            if (y <= f(x)) {
                buenos++;
            }
        }
        intervaloConf = IntervaloConfProporciones((double) buenos / k, k);
        return 4 * r * r * (double) buenos / k; //buenos/k proporcion;r * r total del area 4* porque es solo un cuadrante
    }
    
    public double f(double x, double y) {
        return Math.pow(x, x_pow) + Math.pow(y, y_pow);
    }
    
    public boolean vale(double x) {
        boolean v = x >= linf && x <= lsup;
        if (!v) {
            leer.pln(x + " no pertenece a " + this);
        }
        return v;
    }
    
    public double[] IntervaloConfProporciones(double p, int n) {
        double[] intervaloP = new double[2];
        System.out.println("p = " + p);
        intervaloP[0] = p - 1.96 * Math.sqrt(p * (1 - p) / n);
        intervaloP[1] = p + 1.96 * Math.sqrt(p * (1 - p) / n);
        return intervaloP;
    }
    
    public double media(double valores[]) {
        double media = 0;
        for (int x = 0; x < valores.length; x++) {
            media = media + valores[x];
        }
        return media / valores.length;
    }

    public double cuasiV(double[] valores, double media) {
        double S = 0;
        for (int x = 0; x < valores.length; x++) {
            S = S + Math.pow(valores[x] - media, 2);
        }
        return Math.sqrt(S / (valores.length - 1));
    }

}
