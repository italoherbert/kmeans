package italo.kmeans.demo.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class KMeansFrameClassificar extends JFrame {

    private static final long serialVersionUID = 1L;

    public final static int[] LARGURAS_DEFAULT = {20, 100, 100, 100, 100};

    private Tabela tabela;

    public KMeansFrameClassificar() {
        inicializar();
        Container c = getContentPane();
        c.add("Center", getPCentro());
    }

    public static void main(String[] args) {
        KMeansFrameClassificar k = new KMeansFrameClassificar();
        String[] colunas = {"Nº", "Coluna1", "Coluna2", "Coluna3", "Coluna4"};
        String[][] dados = {};
        k.setDados(dados, colunas);
        k.setLarguraColunas(LARGURAS_DEFAULT);
        k.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        k.setSize(300, 300);
        k.setLocation(100, 100);
        k.setVisible(true);
    }

    private void inicializar() {
        tabela = new Tabela();
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    private JPanel getPCentro() {
        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createTitledBorder("Resultado ca Classificação"));
        p.setLayout(new GridLayout());
        p.add(new JScrollPane(tabela));
        return p;
    }

    public void setDados(Object[][] dados, Object[] colunas) {
        tabela.getModelo().setDataVector(dados, colunas);
    }

    public void setDados(Vector<Vector<Object>> dados, Vector<Object> colunas) {
        tabela.getModelo().setDataVector(dados, colunas);
    }

    public void setLarguraColunas(int[] larguras) {
        tabela.setLarguraColunas(larguras);
    }

}
