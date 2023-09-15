package italo.kmeans.demo;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import italo.kmeans.KMeans;
import italo.kmeans.KMeansException;
import italo.kmeans.demo.gui.KMeansFrame;
import italo.kmeans.demo.gui.KMeansFrameClasses;
import italo.kmeans.demo.gui.KMeansFrameClassificar;
import italo.kmeans.demo.gui.KMeansFrameGeraDados;
import italo.kmeans.demo.gui.event.KMeansFrameAdapter;
import italo.kmeans.demo.util.Utilitarios;
import italo.kmeans.gui.KMeansChart2DFrame;

public class HandlerKMeansFrame extends KMeansFrameAdapter {

    private KMeansFrame kmeansFrame;
    private KMeansChart2DFrame kmeansChart;
    private KMeansFrameGeraDados geraDadosFrame;
    private KMeansFrameClasses kmeansFrameClasses;
    private KMeansFrameClassificar kmeansFrameClassificar;

    public HandlerKMeansFrame(KMeansFrame kmeansFrame,
            KMeansChart2DFrame kmeansChart, KMeansFrameGeraDados geraDadosFrame,
            KMeansFrameClasses kmeansFrameClasses, KMeansFrameClassificar kmeansFrameClassificar) {
        super(kmeansFrame);
        this.kmeansFrame = kmeansFrame;
        this.kmeansChart = kmeansChart;
        this.geraDadosFrame = geraDadosFrame;
        this.kmeansFrameClasses = kmeansFrameClasses;
        this.kmeansFrameClassificar = kmeansFrameClassificar;
    }

    public void gerarDadosAction() {
        geraDadosFrame.setVisible(true);
    }

    public void limparAction() {
        kmeansFrame.setTextoCaminho("");
        kmeansFrame.setTextoDados("");
    }

    public void plotarAction() {
        double[][] dados = Utilitarios.getDados(kmeansFrame.getTextoDados());
        if (dados == null || dados.length <= 0) {
            JOptionPane.showMessageDialog(null, "Formato de dados invalido !!!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (dados[0].length != 2) {
            JOptionPane.showMessageDialog(null, "Os dados de entrada precisam ser 2D para plotagem !!!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] nomesClasses = Util.geraClasses(kmeansFrameClasses.getListaClassesStr());
        KMeans kmeans = Util.executaKMeans(dados, nomesClasses.length);
        if (kmeans == null) {
            JOptionPane.showMessageDialog(null, "Falha no processamento do KMeans !!!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double[][] centroides = kmeans.getCentroides();
        int[] classes = kmeans.getClasses();
        int[] classesMapOrd = Util.geraMapapeamentoCentroidesOrdenados(kmeans, kmeansFrame.isSortCentroides());
        kmeansChart.setDados(dados);
        kmeansChart.setCentroides(centroides);
        kmeansChart.setClasses(classes);
        kmeansChart.setNomesClasses(nomesClasses);
        kmeansChart.setShowCentroides(kmeansFrame.isShowCentroides());
        kmeansChart.setSortCentroides(kmeansFrame.isSortCentroides());
        kmeansChart.setClassesMapOrd(classesMapOrd);
        kmeansChart.setK(nomesClasses.length);

        kmeansChart.produceChart();
        kmeansChart.setVisible(true);
    }

    public void carregarDadosAction() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("./dados"));
        chooser.setDialogTitle("Abrir Documento");
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        int result = chooser.showOpenDialog(kmeansFrame);
        if (result != JFileChooser.OPEN_DIALOG) {
            return;
        }
        File file = chooser.getSelectedFile();
        if (file.isFile()) {
            String conteudo = Utilitarios.getConteudoArquivo(file);
            if (conteudo == null) {
                JOptionPane.showMessageDialog(null, "Falha no carregamento do arquivo, Verifique o formato !!!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                kmeansFrame.setTextoCaminho(file.getAbsolutePath());
                kmeansFrame.setTextoDados(conteudo);
            }
        }
    }

    public void classesAction() {
        kmeansFrameClasses.setVisible(true);
    }

    public void classificarAction() {
        double[][] dados = Utilitarios.getDados(kmeansFrame.getTextoDados());
        if (dados == null || dados.length <= 0) {
            JOptionPane.showMessageDialog(null, "Formato de dados invalido !!!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            String[] nomesClasses = Util.geraClasses(kmeansFrameClasses.getListaClassesStr());
            KMeans kmeans = Util.executaKMeans(dados, nomesClasses.length);
            if (kmeans == null) {
                JOptionPane.showMessageDialog(null, "Falha no processamento do KMeans !!!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int[] classes = kmeans.getClasses();
            int[] classesMapOrd = Util.geraMapapeamentoCentroidesOrdenados(kmeans, kmeansFrame.isSortCentroides());
            Object[][] dadosStr = Util.geraDadosTabela(dados, classes, classesMapOrd, nomesClasses);
            if (dadosStr != null) {
                int nAtributos = dados[0].length;
                Object[] colunasStr = new Object[nAtributos + 2];
                int[] larguras = new int[nAtributos + 2];
                colunasStr[0] = "Nº";
                larguras[0] = 30;
                for (int i = 0; i < nAtributos; i++) {
                    colunasStr[i + 1] = ("Atributo" + (i + 1));
                    larguras[i + 1] = 50;
                }
                colunasStr[nAtributos + 1] = "Classificação";
                larguras[nAtributos + 1] = 100;
                kmeansFrameClassificar.setDados(dadosStr, colunasStr);
                kmeansFrameClassificar.setLarguraColunas(larguras);
                kmeansFrameClassificar.setVisible(true);
            }
        }
    }

    private static class Util {

        private final static int N_CLASSES_DEFAULT = 5;

        static String[] geraClasses(String[] listaClasses) {
            int nClasses = listaClasses.length;
            String[] nomesClasses;
            if (nClasses <= 0) {
                nClasses = N_CLASSES_DEFAULT;
                nomesClasses = new String[nClasses];
                for (int i = 0; i < nClasses; i++) {
                    nomesClasses[i] = "Classe" + (i + 1);
                }
            } else {
                nomesClasses = listaClasses;
            }
            return nomesClasses;
        }

        static KMeans executaKMeans(double[][] dados, int k) {
            KMeans kmeans = null;
            try {
                kmeans = new KMeans(dados, k);
                kmeans.make();
            } catch (KMeansException e) {
                e.printStackTrace();
            }
            return kmeans;
        }

        static int[] geraMapapeamentoCentroidesOrdenados(KMeans kmeans, boolean ordenarCentroides) {
            int[] classesMapOrd = null;
            if (ordenarCentroides) {
                classesMapOrd = kmeans.sortCentroides();
            } else {
                int k = kmeans.getK();
                classesMapOrd = new int[k];
                for (int i = 0; i < classesMapOrd.length; i++) {
                    classesMapOrd[i] = i;
                }
            }
            return classesMapOrd;
        }

        static String[][] geraDadosTabela(double[][] dados, int[] classes, int[] classesMapOrd, String[] nomesClasses) {
            if (dados.length <= 0) {
                return null;
            }
            int nL = dados.length;
            int nC = dados[0].length;
            String[][] dadosStr = new String[nL][nC + 2];
            for (int i = 0; i < nL; i++) {
                dadosStr[i][0] = String.valueOf(i + 1);
                for (int j = 0; j < nC; j++) {
                    dadosStr[i][j + 1] = String.valueOf(dados[i][j]);
                }
                dadosStr[i][nC + 1] = nomesClasses[classesMapOrd[classes[i]]];
            }
            return dadosStr;
        }

    }

}
