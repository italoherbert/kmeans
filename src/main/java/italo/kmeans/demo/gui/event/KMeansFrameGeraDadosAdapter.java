package italo.kmeans.demo.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import italo.kmeans.demo.gui.KMeansFrameGeraDados;

public abstract class KMeansFrameGeraDadosAdapter implements ActionListener {

    private KMeansFrameGeraDados geraDadosFrame;

    public KMeansFrameGeraDadosAdapter(KMeansFrameGeraDados geraDadosFrame) {
        this.geraDadosFrame = geraDadosFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == geraDadosFrame.getOk()) {
            okAction();
        } else if (e.getSource() == geraDadosFrame.getCancelar()) {
            cancelarAction();
        }
    }

    public abstract void okAction();

    public abstract void cancelarAction();

}
