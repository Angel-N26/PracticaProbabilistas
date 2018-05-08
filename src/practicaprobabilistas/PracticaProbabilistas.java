package practicaprobabilistas;

/**
 * @author Angel Loro, Angel Sánchez
 *
 */
public class PracticaProbabilistas {

    private double radio;
    private double xP;
    private double yP;
    private double zP;
    private double intervaloConf[];

    public PracticaProbabilistas() { //Apartado A

    }

    public PracticaProbabilistas(double radio, double x, double y, double z) { //Apartado B
        this.radio = radio;
        this.xP = x;
        this.yP = y;
        this.zP = z;
    }

    public double getIntConfPos(int n) {
        return intervaloConf[n];
    }

    public double f(double x, double y) {
        return (x * x) + (y * y);
    }

    public double volumen(int k) {
        double[] valores = new double[k];
        double suma = 0.0, aux;
        for (int i = 0; i < k; i++) {
            double x = Math.random();
            double y = Math.random();
            double z = f(x, y);
            aux = (3.14 / 4) * z; //Base por altura. 1/4 del area de la circunferencia, 4pi/4
            suma += aux;
            valores[i] = aux;

        }
        intervaloConf = IntervaloConfProporciones(valores, k);
        return suma / k; //Teorema de la media
    }

    public double volumenEsfera(int k) {
        double dentro = 0;
        for (int i = 0; i < k; i++) {
            double x = Math.random() * radio;
            double y = Math.random() * radio;
            double z = Math.random() * radio;
            if ((Math.pow(x, xP) + Math.pow(y, yP) + Math.pow(z, zP)) <= radio * radio) { //Comprueba si esta dentro
                dentro++;
            }
        }
        intervaloConf = IntervaloConfProporcionesB(dentro/k, k);
        return 8 * ((dentro / k) * radio*radio*radio); // Resultado = 8* ((puntos dentro / puntos totales) * volumen del prisma) // 8 = esfera completa
    }

    public double[] IntervaloConfProporciones(double[] valores, int n) {
        double[] intervaloP = new double[2];
        double media = media(valores);
        double cuasiV = cuasiV(valores, media);

        intervaloP[0] = media - 1.96 * cuasiV / n;
        intervaloP[1] = media + 1.96 * cuasiV / n;
        return intervaloP;
    }

    public double[] IntervaloConfProporcionesB(double p, int n) {
        double[] intervaloP = new double[2];
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
