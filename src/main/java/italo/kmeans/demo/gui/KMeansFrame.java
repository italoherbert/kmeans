package italo.kmeans.demo.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class KMeansFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel lClasses;
    private JLabel lSortCentroides;
    private JLabel lShowCentroides;
    private JComboBox comboClasses;
    private JCheckBox sortCentroides;
    private JCheckBox showCentroides;
    private JTextArea areaDados;
    private JTextField caminho;
    private JButton carregar;
    private JButton cassificacao;
    private JButton classes;
    private JButton plotar;
    private JButton limpar;
    private JButton gerarDados;

    public static void main(String[] args) {
        KMeansFrame k = new KMeansFrame();
        k.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        k.setSize(500, 500);
        k.setLocation(100, 100);
        k.setVisible(true);
    }

    public KMeansFrame() {
        inicializar();
        Container c = getContentPane();
        c.add("Center", getPCentro());
        c.add("South", getPSul());
    }

    private void inicializar() {
        lClasses = new JLabel("Classes");
        lSortCentroides = new JLabel("Ordenar Centroides");
        lShowCentroides = new JLabel("Mostrar Centroides");
        comboClasses = new JComboBox();
        sortCentroides = new JCheckBox();
        showCentroides = new JCheckBox();
        areaDados = new JTextArea(10, 30);
        caminho = new JTextField();
        carregar = new JButton("Carregar");
        cassificacao = new JButton("Classificação");
        classes = new JButton("Classes");
        plotar = new JButton("Plotar");
        gerarDados = new JButton("Gerar Dados");
        limpar = new JButton("Limpar");
        caminho.setEditable(false);
        caminho.setForeground(SystemColor.controlDkShadow);
    }

    private JPanel getPCentro() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder("Dados de Entrada"));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout());
        p1.add(new JScrollPane(areaDados));
        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("Carregar Dados"));
        p2.setLayout(new BorderLayout(5, 5));
        p2.add("Center", caminho);
        p2.add("East", carregar);
        p.add("Center", p1);
        p.add("South", p2);
        return p;
    }

    private JPanel getPSul() {
        JPanel p = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("Classificação dos Dados");
        border.setTitleJustification(TitledBorder.ABOVE_TOP);
        p.setLayout(new BorderLayout());
        p.setBorder(border);
        p.add("North", getPClassesCentroides());
        p.add("South", getPBotoes());
        return p;
    }

    private JPanel getPBotoes() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.setBorder(BorderFactory.createEtchedBorder());
        p.add(cassificacao);
        p.add(classes);
        p.add(plotar);
        p.add(gerarDados);
        p.add(limpar);
        return p;
    }

    private JPanel getPClassesCentroides() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2, 10, 10));
        p.setBorder(BorderFactory.createEtchedBorder());

        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout(5, 5));
        p1.add(lClasses, BorderLayout.WEST);
        p1.add(comboClasses, BorderLayout.CENTER);

        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.add(sortCentroides, BorderLayout.WEST);
        p2.add(lSortCentroides, BorderLayout.CENTER);

        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.add(showCentroides, BorderLayout.WEST);
        p3.add(lShowCentroides, BorderLayout.CENTER);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        return p;
    }

    public void addCarregarDadosListener(ActionListener listener) {
        carregar.addActionListener(listener);
    }

    public void addClassificarListener(ActionListener listener) {
        cassificacao.addActionListener(listener);
    }

    public void addClassesListener(ActionListener listener) {
        classes.addActionListener(listener);
    }

    public void addPlotarListener(ActionListener listener) {
        plotar.addActionListener(listener);
    }

    public void addGerarDadosListener(ActionListener listener) {
        gerarDados.addActionListener(listener);
    }

    public void addLimparListener(ActionListener listener) {
        limpar.addActionListener(listener);
    }

    public boolean isSortCentroides() {
        return sortCentroides.isSelected();
    }

    public boolean isShowCentroides() {
        return showCentroides.isSelected();
    }

    public String getTextoDados() {
        return areaDados.getText();
    }

    public void setTextoDados(String dados) {
        areaDados.setText(dados);
    }

    public void setTextoCaminho(String caminhoStr) {
        caminho.setText(caminhoStr);
    }

    public String getTextoCaminho() {
        return caminho.getText();
    }

    public void addClasseCombo(String classe) {
        comboClasses.addItem(classe);
    }

    public void setClassesCombo(String[] classes) {
        comboClasses.removeAllItems();
        for (String classe : classes) {
            comboClasses.addItem(classe);
        }
    }

    public JButton getGerarDados() {
        return gerarDados;
    }

    public JButton getLimpar() {
        return limpar;
    }

    public JButton getPlotar() {
        return plotar;
    }

    public JCheckBox getShowCentroides() {
        return showCentroides;
    }

    public JCheckBox getSortCentroides() {
        return sortCentroides;
    }

    public JButton getClassificar() {
        return cassificacao;
    }

    public JButton getClasses() {
        return classes;
    }

    public JButton getCarregar() {
        return carregar;
    }

}
