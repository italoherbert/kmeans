package italo.kmeans.demo.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class KMeansFrameClasses extends JDialog {

    private static final long serialVersionUID = 1L;

    private JLabel lNorte;
    private JList listaClasses;
    private JLabel lClasse;
    private JTextField tfClasse;
    private JButton adicionar;
    private JButton remover;
    private JButton ok;
    private Vector<String> listaClassesStr = new Vector<String>();

    public KMeansFrameClasses() {
        inicializa();
        setLayout(new BorderLayout());
        Container c = getContentPane();
        c.add("North", getPNorte());
        c.add("Center", getPCentro());
        c.add("South", getPSul());
    }

    private void inicializa() {
        lNorte = new JLabel("Lista de Classes do Algoritmo");
        listaClasses = new JList();
        lClasse = new JLabel("Classe");
        tfClasse = new JTextField(15);
        adicionar = new JButton("+");
        remover = new JButton("-");
        ok = new JButton("Ok");
    }

    private JPanel getPNorte() {
        JPanel pNorte = new JPanel();
        pNorte.add(lNorte);
        return pNorte;
    }

    private JPanel getPCentro() {
        JPanel pCentro = new JPanel();
        pCentro.setLayout(new GridLayout());
        pCentro.add(new JScrollPane(listaClasses));
        return pCentro;
    }

    private JPanel getPSul() {
        JPanel pSul = new JPanel();
        pSul.setLayout(new FlowLayout());
        pSul.add(lClasse);
        pSul.add(tfClasse);
        pSul.add(adicionar);
        pSul.add(remover);
        pSul.add(ok);
        return pSul;
    }

    public int getNClasses() {
        return listaClassesStr.size();
    }

    public void adicionarClasse(String classe) {
        listaClassesStr.add(classe);
        listaClasses.setListData(listaClassesStr);
    }

    public void removerClasse(String classe) {
        listaClassesStr.remove(classe);
        listaClasses.setListData(listaClassesStr);
    }

    public void setListaClasses(String[] lista) {
        listaClassesStr = new Vector<String>();
        for (int k = 0; k < lista.length; k++) {
            listaClassesStr.add(lista[k]);
        }
        listaClasses.setListData(listaClassesStr);
    }

    public void setListaClasses(Vector<String> lista) {
        listaClassesStr = lista;
        listaClasses.setListData(listaClassesStr);
    }

    public Vector<String> getListaClasses() {
        return listaClassesStr;
    }

    public String[] getListaClassesStr() {
        String[] classes = new String[listaClassesStr.size()];
        for (int i = 0; i < listaClassesStr.size(); i++) {
            classes[i] = listaClassesStr.get(i);
        }
        return classes;
    }

    public String getTextoClasse() {
        return tfClasse.getText();
    }

    public void setTextoClasse(String texto) {
        tfClasse.setText(texto);
    }

    public void addAdicionarClasseListener(ActionListener listener) {
        adicionar.addActionListener(listener);
        tfClasse.addActionListener(listener);
    }

    public void addRemoverClasseListener(ActionListener listener) {
        remover.addActionListener(listener);
    }

    public void addOkClasseListener(ActionListener listener) {
        ok.addActionListener(listener);
    }

    public JButton getAdicionar() {
        return adicionar;
    }

    public JButton getRemover() {
        return remover;
    }

    public JButton getOk() {
        return ok;
    }

    public JTextField getTfClasse() {
        return tfClasse;
    }

}
