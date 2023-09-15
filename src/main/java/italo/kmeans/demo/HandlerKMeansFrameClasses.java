package italo.kmeans.demo;

import italo.kmeans.demo.gui.KMeansFrame;
import italo.kmeans.demo.gui.KMeansFrameClasses;
import italo.kmeans.demo.gui.event.KMeansFrameClassesAdapter;

public class HandlerKMeansFrameClasses extends KMeansFrameClassesAdapter {

    private KMeansFrame kmeansFrame;
    private KMeansFrameClasses kmeansFrameClasses;

    public HandlerKMeansFrameClasses(KMeansFrame kmeansFrame, KMeansFrameClasses kMeansFrameClasses) {
        super(kMeansFrameClasses);
        this.kmeansFrame = kmeansFrame;
        this.kmeansFrameClasses = kMeansFrameClasses;
    }

    public void adicionarClasseAction() {
        kmeansFrameClasses.adicionarClasse(kmeansFrameClasses.getTextoClasse());
        kmeansFrameClasses.setTextoClasse("");
    }

    public void removerClasseAction() {
        kmeansFrameClasses.removerClasse(kmeansFrameClasses.getTextoClasse());
        kmeansFrameClasses.setTextoClasse("");
    }

    public void okAction() {
        String[] classes = kmeansFrameClasses.getListaClassesStr();
        kmeansFrame.setClassesCombo(classes);
        kmeansFrameClasses.setVisible(false);
    }

}
