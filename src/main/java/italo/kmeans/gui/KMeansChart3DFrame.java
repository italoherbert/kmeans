package italo.kmeans.gui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.geom.Arc2D;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class KMeansChart3DFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private String titleChart = "Plotagem do grafico";
    private String xLabel = "Coordenada X";
    private String yLabel = "Coordenada Y";
    //private String zLabel = "Coordenada Z";
    private double[][] dados;
    private double[][] centroides;
    private int[] classes;
    private int[] classesMapOrd;
    private String[] nomesClasses;
    private String nomeCentroide = "Centroides";
    private int k = 0;
    private boolean showCentroides = false;
    private boolean sortCentroides = false;

    public KMeansChart3DFrame() {
        super("KMeans Gr�fico 3D");
    }

    public void produceChart() {
        XYDataset dataset = produceDados();
        JFreeChart chart = ChartFactory.createAreaChart(
                titleChart,
                xLabel,
                yLabel,
                (CategoryDataset) dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );
        XYPlot plot = (XYPlot) chart.getPlot();

        plot.setBackgroundPaint(new GradientPaint(new Point(0, 0), SystemColor.control, new Point(150, 150), SystemColor.WHITE));
        plot.setBackgroundAlpha(0.5f);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(false, true);
        plot.setRenderer(renderer);

        XYItemRenderer itemRenderer = plot.getRenderer();
        itemRenderer.setSeriesPaint(0, Color.RED);
        itemRenderer.setSeriesShape(0, new Arc2D.Double(1, 1, 3, 3, 0, 360, Arc2D.PIE));
        for (int i = 1; i <= k; i++) {
            int x = (int) (Math.random() * 255);
            int y = (int) (Math.random() * 255);
            int z = (int) (Math.random() * 255);
            itemRenderer.setSeriesPaint(i, new Color(x, y, z));
            itemRenderer.setSeriesShape(i, new Arc2D.Double(1, 1, 3, 3, 0, 360, Arc2D.PIE));
        }

        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
    }

    private XYDataset produceDados() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        if (showCentroides) {
            XYSeries serieCentroide = new XYSeries(nomeCentroide);
            for (int i = 0; i < k; i++) {
                serieCentroide.add(centroides[i][0], centroides[i][1]);
            }
            dataset.addSeries(serieCentroide);
        }
        XYSeries[] series = new XYSeries[k];
        for (int i = 0; i < k; i++) {
            series[i] = new XYSeries(nomesClasses[i]);
        }
        for (int i = 0; i < dados.length; i++) {
            int indC = classesMapOrd[classes[i]];
            double x = dados[i][0];
            double y = dados[i][1];
            series[indC].add(x, y);
        }
        for (int i = 0; i < k; i++) {
            dataset.addSeries(series[i]);
        }

        return dataset;

    }

    public String getTitleChart() {
        return titleChart;
    }

    public void setTitleChart(String titleChart) {
        this.titleChart = titleChart;
    }

    public String getXLabel() {
        return xLabel;
    }

    public void setXLabel(String label) {
        xLabel = label;
    }

    public String getYLabel() {
        return yLabel;
    }

    public void setYLabel(String label) {
        yLabel = label;
    }

    public boolean isSortCentroides() {
        return sortCentroides;
    }

    public double[][] getCentroides() {
        return centroides;
    }

    public void setCentroides(double[][] centroides) {
        this.centroides = centroides;
    }

    public int[] getClasses() {
        return classes;
    }

    public void setClasses(int[] classes) {
        this.classes = classes;
    }

    public int[] getClassesMapOrd() {
        return classesMapOrd;
    }

    public void setClassesMapOrd(int[] classesMapOrd) {
        this.classesMapOrd = classesMapOrd;
    }

    public double[][] getDados() {
        return dados;
    }

    public void setDados(double[][] dados) {
        this.dados = dados;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public String getNomeCentroide() {
        return nomeCentroide;
    }

    public void setNomeCentroide(String nomeCentroide) {
        this.nomeCentroide = nomeCentroide;
    }

    public String[] getNomesClasses() {
        return nomesClasses;
    }

    public void setNomesClasses(String[] nomesClasses) {
        this.nomesClasses = nomesClasses;
    }

    public boolean isShowCentroides() {
        return showCentroides;
    }

    public void setShowCentroides(boolean showCentroides) {
        this.showCentroides = showCentroides;
    }

    public void setSortCentroides(boolean sortCentroides) {
        this.sortCentroides = sortCentroides;
    }

}
