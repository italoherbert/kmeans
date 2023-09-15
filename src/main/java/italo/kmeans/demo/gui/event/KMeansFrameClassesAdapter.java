package italo.kmeans.demo.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import italo.kmeans.demo.gui.KMeansFrameClasses;

public abstract class KMeansFrameClassesAdapter implements ActionListener, WindowListener {

    private KMeansFrameClasses kmeansFrameClasses;

    public KMeansFrameClassesAdapter(KMeansFrameClasses kmeansFrameClasses) {
        this.kmeansFrameClasses = kmeansFrameClasses;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == kmeansFrameClasses.getAdicionar()
                || e.getSource() == kmeansFrameClasses.getTfClasse()) {
            adicionarClasseAction();
        } else if (e.getSource() == kmeansFrameClasses.getRemover()) {
            removerClasseAction();
        } else if (e.getSource() == kmeansFrameClasses.getOk()) {
            okAction();
        }
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        okAction();
    }

    public abstract void adicionarClasseAction();

    public abstract void removerClasseAction();

    public abstract void okAction();

}
