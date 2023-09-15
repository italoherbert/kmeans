package italo.kmeans.demo;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import italo.kmeans.demo.gui.KMeansFrame;
import italo.kmeans.demo.gui.KMeansFrameClasses;
import italo.kmeans.demo.gui.KMeansFrameClassificar;
import italo.kmeans.demo.gui.KMeansFrameGeraDados;
import italo.kmeans.gui.KMeansChart2DFrame;

public class KMeansDemo {

    static {
        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos os Arquivos");
        UIManager.put("FileChooser.lookInLabelText", "Endereço");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar Operação");
        UIManager.put("FileChooser.directoryDescriptionText", "Diretório");
        UIManager.put("FileChooser.fileDescriptionText", "Arquivo Genérico");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do Arquivo:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Arquivos do Tipo:");
        UIManager.put("FileChooser.helpButtonText", "Ajuda");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Inicio");
        UIManager.put("FileChooser.homeFolderToolTipText", "Inicio");
        UIManager.put("FileChooser.lookInLabelText", "Procurar em:");
        UIManager.put("FileChooser.New Folder", "Nova Pasta");
        UIManager.put("FileChooser.newFolderErrorText", "Erro criando uma nova pasta");
        UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir arquivo selecionado");
        UIManager.put("FileChooser.saveButtonText", "Salvar");
        UIManager.put("FileChooser.saveButtonToolTipText", "Salvar arquivo selecionado");
        UIManager.put("FileChooser.updateButtonText", "Atualizar");
        UIManager.put("FileChooser.updateButtonToolTipText", "Atualizar diretório listado");
        UIManager.put("FileChooser.upFolderAccessibleName", "Subir");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir um nível");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.upFolderToolTipText", "subir um nível");
    }

    public static void main(String[] args) {
        KMeansFrame kmeansFrame = new KMeansFrame();
        kmeansFrame.setTitle("Aplicação KMeans");
        kmeansFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kmeansFrame.setSize(600, 500);
        kmeansFrame.setLocation(50, 50);
        kmeansFrame.setVisible(true);

        KMeansChart2DFrame kmeansChart = new KMeansChart2DFrame();
        kmeansChart.pack();
        kmeansChart.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        kmeansChart.setSize(new Dimension(500, 500));
        kmeansChart.setLocation(150, 50);
        kmeansChart.setVisible(false);

        KMeansFrameGeraDados geraDadosFrame = new KMeansFrameGeraDados();
        geraDadosFrame.setTitle("Aplicação KMeans");
        geraDadosFrame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        geraDadosFrame.setSize(300, 200);
        geraDadosFrame.setLocation(100, 100);
        geraDadosFrame.setVisible(false);

        KMeansFrameClasses kmeansFrameClasses = new KMeansFrameClasses();
        kmeansFrameClasses.setTitle("Classes do KMeans");
        kmeansFrameClasses.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        kmeansFrameClasses.setSize(380, 180);
        kmeansFrameClasses.setLocation(100, 100);
        kmeansFrameClasses.setVisible(false);

        KMeansFrameClassificar kmeansFrameClassificar = new KMeansFrameClassificar();
        kmeansFrameClassificar.setTitle("Resultado da Classificação do KMeans");
        kmeansFrameClassificar.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        kmeansFrameClassificar.setSize(300, 300);
        kmeansFrameClassificar.setLocation(150, 150);
        kmeansFrameClassificar.setVisible(false);

        HandlerKMeansFrame handlerKMeansFrame = new HandlerKMeansFrame(kmeansFrame, kmeansChart, geraDadosFrame, kmeansFrameClasses, kmeansFrameClassificar);
        HandlerKMeansFrameGeraDados handlerGeraDadosFrame = new HandlerKMeansFrameGeraDados(geraDadosFrame, kmeansFrame);
        HandlerKMeansFrameClasses handlerKMeansFrameClasses = new HandlerKMeansFrameClasses(kmeansFrame, kmeansFrameClasses);

        kmeansFrame.addCarregarDadosListener(handlerKMeansFrame);
        kmeansFrame.addClassificarListener(handlerKMeansFrame);
        kmeansFrame.addClassesListener(handlerKMeansFrame);
        kmeansFrame.addPlotarListener(handlerKMeansFrame);
        kmeansFrame.addLimparListener(handlerKMeansFrame);
        kmeansFrame.addGerarDadosListener(handlerKMeansFrame);

        kmeansFrameClasses.addAdicionarClasseListener(handlerKMeansFrameClasses);
        kmeansFrameClasses.addRemoverClasseListener(handlerKMeansFrameClasses);
        kmeansFrameClasses.addOkClasseListener(handlerKMeansFrameClasses);
        kmeansFrameClasses.addWindowListener(handlerKMeansFrameClasses);

        geraDadosFrame.addOkListener(handlerGeraDadosFrame);
        geraDadosFrame.addCancelarListener(handlerGeraDadosFrame);
    }

}
