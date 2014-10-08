/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Calendarizador;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.TimePeriod;
//import org.jfree.data.time.TimePeriod;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author Alejandro
 */

public class Gantt extends ApplicationFrame{
    public Gantt(final String title) {

        super(title);

        final IntervalCategoryDataset dataset = createSampleDataset();

        // create the chart...
        final JFreeChart chart = ChartFactory.createGanttChart(
            "Diagrama de Procesos",  // chart title
            "Proceso",              // domain axis label
            "Tiempo",              // range axis label
            dataset,             // data
            true,                // include legend
            true,                // tooltips
            false                // urls
        );
        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
  //      plot.getDomainAxis().setMaxCategoryLabelWidthRatio(10.0f);
        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.blue);

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    
    /**
     * Creates a sample dataset for a Gantt chart, using sub-tasks.  In general, you won't 
     * hard-code the dataset in this way - it's done here so that the demo is self-contained.
     *
     * @return The dataset.
     */
    private IntervalCategoryDataset createSampleDataset() {

        final TaskSeries s1 = new TaskSeries("Scheduled");
        
        TablaProcesos procesos = new TablaProcesos();
        ArrayList<Integer> startTimes = procesos.getTaskStartTimes();
        ArrayList<Integer> finishTimes = procesos.getTaskFinishTimes();
        
        final Task t1 = new Task("Proceso 1", date(startTimes.get(0)), date(finishTimes.get(0)));
        s1.add(t1);
        
        final Task t2 = new Task("Proceso 2", date(startTimes.get(1)), date(finishTimes.get(1)));
        s1.add(t2);
        
        final Task t3 = new Task("Proceso 3", date(startTimes.get(2)), date(finishTimes.get(2)));
        s1.add(t3);
        
        final Task t4 = new Task("Proceso 4", date(startTimes.get(3)), date(finishTimes.get(3)));
        s1.add(t4);

        final TaskSeriesCollection collection = new TaskSeriesCollection();
        collection.add(s1);

        return collection;
    }

    /**
     * Utility method for creating <code>Date</code> objects.
     *
     * @param millis  the milliseconds.
     *
     * @return a date.
     */
    private static Date date(final int millis) {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(1, millis);
        final Date result = calendar.getTime();
        return result;
    }
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    
    public static void main(final String[] args) {

        final Gantt demo = new Gantt("Gantt Chart Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }
}