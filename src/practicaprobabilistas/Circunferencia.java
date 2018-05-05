package practicaprobabilistas;

/**
 * @author Angel Loro, Angel Sánchez
 **/

public class Circunferencia extends Funciones {

    double r, cX, cY; //radio y centro (cX , cY)

    public Circunferencia(double radio, double centroX, double centroY) {
        super(centroX - radio, centroX + radio);
        r = radio;
        cX = centroX;
        cY = centroY;
    }

    public double radio() {
        return r;
    }

    public Circunferencia(double radio) {//centro (0,0)
        this(radio, 0.0, 0.0);
    }

    public Circunferencia() {////en [0,1] r=1 y centro (0,0)
        this(1.0);
    }

    @Override
    public double f(double x) {
        if (vale(x)) {
            return Math.sqrt(r * r - (x - cX) * (x - cX)) + cY;
        } else {
            return 0;
        }
    }

    @Override
    public double areaRieman(int intervalos) {
        Funciones aux = new Circunferencia(r); //calculo el area sobre la circunferencia de radio r y centro(0, 0)
        double suma = 0.0;
        double inc = r / intervalos;
        double x = 0;
        while (x < r) {
            suma = suma + aux.f(x) * inc;
            x = x + inc;
        }
        return 4 * suma;//*4 porque solo se hace para el primer cuadrante
    }

    @Override
    public double areaNumericoVM(int k) {
        //area probabilista según el teoreama del valor medio. k ell nuemro de medidas
        double[] valores = new double[k]; //para calcular medias, cuasi varianzas e intervalos de confianza
        Funciones aux = new Circunferencia(r);
        double suma = 0.0;
        for (int i = 0; i < k; i++) {
            double x = Math.random() * r;//valor aleatorio de x entre [0,r]
            double y = aux.f(x);//valor de y para esa x
            valores[i] = r * y * 4;
            //Area = base r por altura y multiplicado por 4 porque solo se hace sobre el primer cuadrante
            suma = suma + valores[i];
        }
        intervaloConfianza(valores);
        return suma / k;
    }

    @Override
    public double areaNumericoP(int k) { //area probabilista lanzando k puntos A = casos favorables / casos posibles 
        Funciones aux = new Circunferencia(r);
        int buenos = 0;
        for (int n = 0; n < k; n++) {
            double x = Math.random() * r;
            double y = Math.random() * r;
            if (y <= aux.f(x)) {
                buenos++;
            }
        }
        IntervaloConfProporciones((double) buenos / k, k);
        return 4 * r * r * (double) buenos / k; //buenos/k proporcion;r * r total del area 4* porque es solo un cuadrante
    }

    @Override
    public double area() {//Area del circulo
        return Math.PI * r * r;
    }

    @Override
    public String toString() {
        return "Circunferencia de radio=" + r + " y centro (" + cX + "," + cY + ") " + super.toString();
    }
}
