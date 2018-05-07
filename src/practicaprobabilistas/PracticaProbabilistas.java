package practicaprobabilistas;

/**
 * @author Angel Loro, Angel Sánchez
 **/

public class PracticaProbabilistas {
    
    double radio;
    double intervaloConf [];
    
    public PracticaProbabilistas() {
        
    }
    
    public PracticaProbabilistas(double radio) {
        this.radio = radio;
    } 
    
    public double getIntConfPos(int n){
        return intervaloConf[n];
    }
    
    public double volumen(int k) { //area probabilista lanzando k puntos A = casos favorables / casos posibles         
        double[] values = new double[k];         
        double suma = 0.0;
        for (int i = 0; i < k; i++) {
            double x = Math.random();
            double y = Math.random();
            double z = f(x,y);            
            suma += (3.14/4)*z; // Area de la Base por la altura // 1/4 del area de la circunferencia, 4pi/4
            values[i] = (3.14/4)*z;
        }               
        intervaloConf = IntervaloConfProporciones(values);        
        return suma / k; //Teorema de la media
    }
    
    public double volumenEsfera(int k) {
        double dentro = 0, fuera = 0;        
        double vol_prisma;
        for(int i = 0 ; i < k ; i++){                
            double x = Math.random() * radio;
            double y = Math.random() * radio;
            double z = Math.random() * radio;
            // Si el punto esta dentro de la esfera, se incrementa el contador
            if ((x * x + y * y + z * z) <= radio * radio) {
                dentro++;
            } else {
                fuera++;
            }            
        }         
        // V = AreaBase * Altura (Siendo la altura el diametro: 2r)
        vol_prisma = Math.pow(radio, 3);
        // Resultado = (Numero de puntos dentro / puntos totales) * volumen del prisma que lo contiene               
        return 8 * ((dentro / (dentro + fuera)) * vol_prisma); // Se multiplica por 8 para tener en cuenta la esfera completa.
    }
    
    public double f(double x, double y) {
        return (x * x) + (y * y);
    }    
    
    public double [] IntervaloConfProporciones(double[] valores) {
        double[] intervaloP = new double[2];   
        double media = media(valores);
        double cuasiV = cuasiV(valores, media);
        
        intervaloP[0] = media - 1.96 * cuasiV/Math.sqrt(valores.length);
        intervaloP[1] = media + 1.96 * cuasiV/Math.sqrt(valores.length);
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
