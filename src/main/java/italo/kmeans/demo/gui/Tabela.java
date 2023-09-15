package italo.kmeans.demo.gui;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabela extends JTable {

    private static final long serialVersionUID = 1L;

    private DefaultTableModel modelo;

    public Tabela() {
        super(
                new DefaultTableModel() {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        }
        );
        modelo = (DefaultTableModel) getModel();
    }

    public Tabela(Vector<Vector<Object>> linhas, Vector<Object> colunas) {
        super(linhas, colunas);
    }

    public void addLinhas(Vector<Vector<Object>> linhas) {
        for (int k = 0; k < linhas.size(); k++) {
            modelo.addRow(linhas.elementAt(k));
        }
    }

    public void addColunas(String[] colunas) {
        for (int k = 0; k < colunas.length; k++) {
            modelo.addColumn(colunas[k]);
        }
    }

    public void removerTodasAsLinhas() {
        while (getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void removerLinhas(Vector<Integer> linhas) throws NumberFormatException {
        for (int k = 0; k < linhas.size(); k++) {
            boolean achou = false;
            for (int l = 0; l < this.getRowCount() && !achou; l++) {
                int codigo = Integer.parseInt("" + this.getValueAt(l, 1));
                if (codigo == linhas.get(k)) {
                    this.modelo.removeRow(l);
                    achou = true;
                }
            }
        }

    }

    public void setLarguraColunas(int[] largura) {
        if (largura.length == this.getColumnCount()) {
            try {
                for (int k = 0; k < getColumnCount(); k++) {
                    getColumn(getColumnName(k)).setPreferredWidth(largura[k]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNomeColunas(String[] colunas) {
        modelo.setColumnIdentifiers(colunas);
    }

    public void addColunaInicio() {
        modelo.addColumn("");
        moveColumn(getColumnCount() - 1, 0);
    }

    public Vector<Object> getTupla(int linha) {
        Vector<Object> vetor = new Vector<Object>();
        for (int k = 0; k < modelo.getColumnCount(); k++) {
            vetor.addElement(modelo.getValueAt(linha, k));
        }
        return vetor;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

}
