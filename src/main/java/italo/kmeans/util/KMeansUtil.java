package italo.kmeans.util;

public class KMeansUtil {

    public static double[][] reduzir2D(double[][] dados) {
        if (dados == null || dados.length <= 0) {
            return null;
        }
        double[] dado0 = dados[0];
        int dimCompleta = dado0.length;
        int nDados = dados.length;
        int dimReduzida = 2;
        double[][] dadosReduzidos = new double[nDados][dimReduzida];
        inicializarVetor(dadosReduzidos);
        for (int i = 0; i < nDados; i++) {
            for (int j = 0; j < dimCompleta / 2; j++) {
                dadosReduzidos[i][0] *= dados[i][j];
            }
            dadosReduzidos[i][0] = Math.pow(dadosReduzidos[i][0], 1 / (dimCompleta / 2));
            for (int j = (dimCompleta / 2); j < dimCompleta; j++) {
                dadosReduzidos[i][1] += dados[i][j];
            }
            dadosReduzidos[i][0] = Math.pow(dadosReduzidos[i][0], 1 / (dimCompleta - (dimCompleta / 2)));
        }
        return dadosReduzidos;
    }

    public static void inicializarVetor(double[][] vetor) {
        if (vetor == null || vetor.length <= 0) {
            return;
        }
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor[0].length; j++) {
                vetor[i][j] = 0;
            }
        }
    }

}
