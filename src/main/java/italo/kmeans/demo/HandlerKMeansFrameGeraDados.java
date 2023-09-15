package italo.kmeans.demo;

import javax.swing.JOptionPane;

import italo.kmeans.demo.gui.KMeansFrameGeraDados;
import italo.kmeans.demo.gui.KMeansFrame;
import italo.kmeans.demo.gui.event.KMeansFrameGeraDadosAdapter;
import italo.kmeans.demo.util.Utilitarios;

public class HandlerKMeansFrameGeraDados extends KMeansFrameGeraDadosAdapter {

    private KMeansFrameGeraDados geraDadosFrame;
    private KMeansFrame kmeansFrame;

    public HandlerKMeansFrameGeraDados(KMeansFrameGeraDados geraDadosFrame, KMeansFrame kmeansFrame) {
        super(geraDadosFrame);
        this.geraDadosFrame = geraDadosFrame;
        this.kmeansFrame = kmeansFrame;
    }

    public void cancelarAction() {
        geraDadosFrame.setVisible(false);
    }

    public void okAction() {
        try {
            int nDados = geraDadosFrame.getNDados();
            int dim = geraDadosFrame.getDimensao();
            double min = geraDadosFrame.getMin();
            double max = geraDadosFrame.getMax();
            double[][] dados = Utilitarios.getRandomVector(nDados, dim, min, max);
            if (dados == null) {
                throw new RuntimeException("Falha na geração automatica de dados !!!");
            }
            String dadosStr = Utilitarios.getDadosStr(dados, nDados, dim);
            kmeansFrame.setTextoDados(dadosStr);
            geraDadosFrame.setVisible(false);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Verifique o formato dos campos digitados.", "Geração altomática de dados", JOptionPane.ERROR_MESSAGE);
        }
    }

}
