package italo.kmeans.demo.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import italo.kmeans.demo.gui.KMeansFrame;

public abstract class KMeansFrameAdapter implements ActionListener {

    private KMeansFrame kmeansFrame;

    public KMeansFrameAdapter(KMeansFrame kmeansFrame) {
        this.kmeansFrame = kmeansFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == kmeansFrame.getCarregar()) {
            carregarDadosAction();
        } else if (e.getSource() == kmeansFrame.getLimpar()) {
            limparAction();
        } else if (e.getSource() == kmeansFrame.getPlotar()) {
            plotarAction();
        } else if (e.getSource() == kmeansFrame.getGerarDados()) {
            gerarDadosAction();
        } else if (e.getSource() == kmeansFrame.getClassificar()) {
            classificarAction();
        } else if (e.getSource() == kmeansFrame.getClasses()) {
            classesAction();
        }
    }

    public abstract void carregarDadosAction();

    public abstract void classificarAction();

    public abstract void classesAction();

    public abstract void plotarAction();

    public abstract void gerarDadosAction();

    public abstract void limparAction();

}
