package genetics;

import java.util.LinkedList;
import java.util.Random;
import exceptions.NoPossibilityToCreateIndividualWhichYoudLikeToCreateAndICannotChangeItSoIThrowAnExceptionAndIThinkYouWillLikeItBecauseIDontHaveAnythingBetterToDoItsOnly2OClockNightIsYoung;

/* TODO
no ten tego
fitness, ale nie wiem gdzie
dynamiczne zmniejszanie liczby grup
spięcie tego razem
też może wpadnę na uczelnię wcześniej, jak się zbiorę i nauczę
*/

// jest idea, żeby wrzucić tego głupiego rand do jakiegoś interfejsu, bo mnie denerwuje już 
/**
 * @author Krzysztof Spytkowski
 * @date 29 mar 2014
 */
public class Individual implements Comparable<Individual> {

    private final int[] chromosome; // table of subgraph's vertices (0 - not exists, 1 - exists)
    private int activeGenesAmount; // amount of vertices in subgraph
    private double fitness; // shows how well individual is adopted in population
    private int numberOfSubgraphs; // actual number of groups in chromosome

    /**
     * Constructor - creates subgraph that has size of kCliqueSize - chooses
     * appropriate amount of genes (vertices) and puts them into chromosome
     * (table)
     *
     * @param graphSize - graph's size (amount of vertices)
     * @param kCliqueSize - k-clique size (amount of vertices)
     */
    public Individual(int graphSize, int kCliqueSize) {
        // wyjatki?!
        this.activeGenesAmount = kCliqueSize;
        chromosome = new int[graphSize];
        LinkedList<Integer> helpList = new LinkedList<>();
        for (int i = 0; i < graphSize; i++) {
            helpList.add(i);
        }
        Random rand = new Random();
        for (int i = 0; i < kCliqueSize; i++) {
            int k = helpList.get(rand.nextInt(graphSize - i));
            chromosome[k] = 1;
            helpList.remove((Integer) k);
        }
        // TO TEST VERSION
        // chromosome = new byte[graphSize];
        // Random rand = new Random();
        // for (int i = 0; i < graphSize; i++) {
        // if (rand.nextBoolean()) {
        // chromosome[i] = 1;
        // this.activeGenesAmount++;
        // }
        // }

    }

    /* MY VERSION */
    /* wukat */
    /* please, don't really care about it, I can be serious */
    /* sometimes */
    /**
     * Constructor - creates graph (maximum size), every index in chromosome is
     * a vertex and value assigned to vertex indicates to subgraph which
     * contains this vertex
     *
     * @param graphSize - graph's size (amount of vertices)
     * @param numberOfGroups - number of subgraphs
     * @throws
     * NoPossibilityToCreateIndividualWhichYoudLikeToCreateAndICannotChangeItSoIThrowAnExceptionAndIThinkYouWillLikeItBecauseIDontHaveAnythingBetterToDoItsOnly2OClockNightIsYoung
     * - excetion thrown when number of groups is bigger than graph size,
     * because it doesn't really make sense
     */
    public Individual(int graphSize, int numberOfGroups, boolean nextVersion) throws NoPossibilityToCreateIndividualWhichYoudLikeToCreateAndICannotChangeItSoIThrowAnExceptionAndIThinkYouWillLikeItBecauseIDontHaveAnythingBetterToDoItsOnly2OClockNightIsYoung { // next version - added temporarily, only to change signature
        //this.activeGenesAmount = 0; // not needed at all
        if (numberOfGroups > graphSize) {// not nice, may couse some stupid things
            throw new NoPossibilityToCreateIndividualWhichYoudLikeToCreateAndICannotChangeItSoIThrowAnExceptionAndIThinkYouWillLikeItBecauseIDontHaveAnythingBetterToDoItsOnly2OClockNightIsYoung("Number of groups too big");
        }
        numberOfSubgraphs = numberOfGroups;
        chromosome = new int[graphSize];
        Random rand = new Random();
        for (int i = 0; i < graphSize; i++) {
            chromosome[i] = rand.nextInt(numberOfGroups); // groups coded from 0 to numberOfGroups - 1
        }
    }

    /**
     * Copy constructor
     *
     * @param i - individual
     */
    public Individual(Individual i) {
        this.activeGenesAmount = i.getActiveGenesAmount();
        this.chromosome = i.chromosome.clone();
        this.fitness = i.getFitness();
    }

    /**
     * Constructor - creates blank Individual (all genes are 0)
     *
     * @param chromosomeLength - amount of genes
     *
     */
    public Individual(int chromosomeLength) {
        this.activeGenesAmount = 0;
        this.chromosome = new int[chromosomeLength];
        this.fitness = 0.0;
    }

    /**
     * Getter
     *
     * @return length of chromosome
     */
    public int getChromosomeLength() {
        return chromosome.length;
    }

    /**
     * Getter
     *
     * @param index - index of gene
     * @return value of gene: 0 - not exists, 1 - exists
     */
    public int getValueOfGene(int geneIndex) {
        return chromosome[geneIndex];
    }

    /**
     * Getter
     *
     * @return amount of active genes
     */
    public int getActiveGenesAmount() {
        return activeGenesAmount;
    }

    /**
     * Getter of number of subgraphs (groups)
     *
     * @return number of groups
     */
    public int getNumberOfSubgraphs() {
        return numberOfSubgraphs;
    }

    /**
     * Getter
     *
     * @return chromosome - table
     */
    public int[] getChromosome() {
        return chromosome;
    }

    /**
     * Getter
     *
     * @param geneIndex - index of gene
     * @return value of gene
     */
    public int getGene(int geneIndex) {
        return chromosome[geneIndex];
    }

    /**
     * Getter
     *
     * @return fitness
     */
    public double getFitness() {
        return fitness;
    }

    /**
     * Setter
     *
     * @param fitness - fitness
     */
    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    /**
     * Removes gene - makes 0 form 1 in chromosome
     *
     * @param geneIndex - index of gene to remove
     */
    public void removeGene(int geneIndex) {
        chromosome[geneIndex] = 0;
        activeGenesAmount--;
    }

    /**
     * Adds gene - makes 1 form 0 in chromosome
     *
     * @param geneIndex - index of gene to remove
     */
    public void addGene(int geneIndex) {
        chromosome[geneIndex] = 1;
        activeGenesAmount++;
    }

    /**
     * Sets new value to gene to use in byte coding case
     *
     * @param geneIndex - index of gene
     * @param value - value to set
     */
    public void setGene(int geneIndex, int value) {
        if (chromosome[geneIndex] != value && value == 1) {
            activeGenesAmount++;
        } else if (chromosome[geneIndex] != value && value == 0) {
            activeGenesAmount--;
        }
        chromosome[geneIndex] = value;
    }

    /**
     * Inverses gene - makes 0 form 1 or 1 from 0 in chromosome
     *
     * @param geneIndex - index of gene to inverse
     */
    public void inverseGene(int geneIndex) {
        setGene(geneIndex, (chromosome[geneIndex] == 0) ? 1 : 0);
    }

    /**
     * Mutates gene - change gene to any other possible (from 0 to
     * numberOfSubgraphs - 1)
     *
     * @param geneIndex - index of gene to mutate
     */
    public void mutateGene(int geneIndex) {
        setGene(geneIndex, new Random().nextInt(numberOfSubgraphs));
    }

    /**
     * Function sorts/changes genes in chromosome that in result subgraph with
     * the biggest amount of vertexes is labeled as 0 and so on
     */
    public void repairIndividual() {
        LinkedList<Integer> amountOfVertexesInGroup = new LinkedList<>();
        LinkedList<Integer> amountOfVertexesInGroupInProperOrder = new LinkedList<>();
        for (int i = 0; i < numberOfSubgraphs; i++) {
            amountOfVertexesInGroup.add(i, 0);
            amountOfVertexesInGroupInProperOrder.add(i, 0);
        }
        for (int i : chromosome) {
            amountOfVertexesInGroup.set(i, amountOfVertexesInGroup.get(i) + 1);
        }
        int k = 0, temp;
        for (Integer i = chromosome.length; i > 0; i--) {
            while ((temp = amountOfVertexesInGroup.indexOf(i)) != -1) {
                amountOfVertexesInGroupInProperOrder.set(k++, i);
                amountOfVertexesInGroup.set(temp, -1);
            }
        }

        k = 0;
        Integer indexOfSubgraph = 0;
        int range = 0;
        for (Integer i : amountOfVertexesInGroupInProperOrder) {
            range += i;
            for (; k < range; k++) {
                chromosome[k] = indexOfSubgraph;
            }
            indexOfSubgraph++;
        }
    }

    /**
     * Removes group containg the smallest amount of vertices Use only on
     * repaired individual!
     */
    public void removeWorstGroup() {
        numberOfSubgraphs--;
        boolean flag = true;
        for (int i = chromosome.length - 1; i > 0 && flag; i--) {
            if (chromosome[i] == numberOfSubgraphs) {
                chromosome[i]--;
            } else {
                flag = false;
            }
        }
        repairIndividual();
    }

    /**
     * Compares two individuals - better individual has better fitness
     *
     * @param i - individual
     */
    @Override
    public int compareTo(Individual i) {
        if (this.fitness == i.fitness) {
            return 0;
        }
        return (this.fitness > i.fitness) ? 1 : -1;
    }

    /**
     * Checks if "second" individual is better than "first" individual
     *
     * @param first - first individual to compare to
     * @param second - second individual to compare to
     * @return true if second individual is better, false otherwise
     */
    public static Individual isBetter(Individual first, Individual second) {
        return first.compareTo(second) > 0 ? first : second;
    }

    @Override
    public String toString() {
        String s = "Individual: ";
        for (int i : chromosome) {
            s += i;
        }
        s += " ";
        s += fitness;
        return s += "\n";
    }
}
