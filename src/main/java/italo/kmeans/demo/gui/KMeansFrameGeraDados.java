package italo.kmeans.demo.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class KMeansFrameGeraDados extends JDialog {

    private static final long serialVersionUID = 1L;

    private JLabel lNDados;
    private JLabel lDim;
    private JLabel lMin;
    private JLabel lMax;
    private JTextField tfNDados;
    private JTextField tfDim;
    private JTextField tfMin;
    private JTextField tfMax;
    private JButton ok;
    private JButton cancelar;
    private JPanel pCentro;
    private JPanel pSul;
    private JPanel contentPane;

    public KMeansFrameGeraDados() {
        initComponentes();
        geraContentPane();
        geraPCentro();
        geraPSul();
        Container c = getContentPane();
        c.add("Center", pCentro);
        c.add("South", pSul);
    }

    private void initComponentes() {
        lNDados = new JLabel("Nº de dados:");
        lDim = new JLabel("Dimensão:");
        lMin = new JLabel("Numero minimo:");
        lMax = new JLabel("Número máximo:");
        tfNDados = new JTextField();
        tfDim = new JTextField();
        tfMin = new JTextField();
        tfMax = new JTextField();
        ok = new JButton("Ok");
        cancelar = new JButton("Cancelar");
        pCentro = new JPanel();
        pSul = new JPanel();
        contentPane = new JPanel();
    }

    private void geraContentPane() {
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(new TitledBorder("Geração automática de dados"));
        setContentPane(contentPane);
    }

    private void geraPCentro() {
        pCentro.setLayout(new GridLayout(4, 2, 5, 5));
        pCentro.add(lNDados);
        pCentro.add(tfNDados);
        pCentro.add(lDim);
        pCentro.add(tfDim);
        pCentro.add(lMin);
        pCentro.add(tfMin);
        pCentro.add(lMax);
        pCentro.add(tfMax);

    }

    private void geraPSul() {
        pSul.setLayout(new FlowLayout());
        pSul.add(ok);
        pSul.add(cancelar);
    }

    public void setContentPane(Container c) {
        super.setContentPane(c);
    }

    public double getMin() throws NumberFormatException {
        return Double.parseDouble(tfMin.getText());
    }

    public double getMax() throws NumberFormatException {
        return Double.parseDouble(tfMax.getText());
    }

    public int getNDados() throws NumberFormatException {
        return Integer.parseInt(tfNDados.getText());
    }

    public int getDimensao() throws NumberFormatException {
        return Integer.parseInt(tfDim.getText());
    }

    public void addOkListener(ActionListener listener) {
        ok.addActionListener(listener);
    }

    public void addCancelarListener(ActionListener listener) {
        cancelar.addActionListener(listener);
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public JButton getOk() {
        return ok;
    }

}
