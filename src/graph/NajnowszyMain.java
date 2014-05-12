package graph;

import org.jfree.chart.ChartPanel;

import GUI.Chart;
import exceptions.GeneticAlgorithmException;
import exceptions.NoPossibilityToCreateGraphException;
import genetics.CrossingOverType;
import genetics.IndividualType;
import genetics.Population;

public class NajnowszyMain {

    public static void main(String[] args) {

        GraphRepresentation gr = null;
        try {
            gr = new GraphRepresentation(128, 6326, 67);
            gr.setsearchedKCliqueSize(50);
        } catch (NoPossibilityToCreateGraphException e) {
            e.printStackTrace();
        } catch (GeneticAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Population population = null;
        try {
            population = new Population(100, gr, IndividualType.BINARYCODEDINDIVIDUAL);
            // Population population = new Population(50, gr, IndividualType.BINARYCODEDINDIVIDUAL);
        } catch (GeneticAlgorithmException e) {
            e.printStackTrace();
        }

        Chart myChart = new Chart("K-clique solver", "Individuals' fitness in population", "Iteration", "Fitness");
        ChartPanel myFrame = myChart.getChartPanel();
        myFrame.setVisible(true);
        myFrame.setSize(500, 400);
        myChart.repaintChart();

        for (int i = 1; i < 10; i++) {
            System.out.println("Iteracja " + i);
            System.out.println(population.findBestAdoptedIndividual());
            population.singleLifeCycleKRZYSZTOF(0.6, CrossingOverType.ONEPOINTWITHTWOCHILDREN, 0.05, 0.2);
            myChart.addNewValueToBestSeries(i, population.findBestAdoptedIndividual().getFitness());
            myChart.addNewValueToAverageSeries(i, population.averageIndividualsFitness());
            myChart.addNewValueToWorstSeries(i, population.findWorstAdoptedIndividual().getFitness());
            myChart.repaintChart();
        }
        myChart.saveChartToFile("newChart");
    }
}
