/*
 * authors: Wojciech Kasperek & Krzysztof Spytkowski & Izabela Śmietana
 */
package genetics;

import java.util.LinkedList;
import java.util.Random;

public class CrossingOver {

    private static final Random rand = new Random(); // object that generates random numbers

    /**
     * Starts appropriate crossing-over
     *
     * @param crossingOverType - type of crossing-over
     * @param population - population
     * @param crossingOverProbability - probability od crossing-over
     */
    public static void crossOver(CrossingOverType crossingOverType, Population population, double crossingOverProbability) {
        int amountOfIndividualsToCrossOver = (population.getActualIndividualsAmount() % 2 == 0) ? population.getActualIndividualsAmount() : population.getActualIndividualsAmount() - 1;
        LinkedList<AbstractIndividual> newIndividualsList = new LinkedList<>();
        for (int i = 0; i < amountOfIndividualsToCrossOver; i += 2) {
            AbstractIndividual firstParent = population.getIndividual(i);
            AbstractIndividual secondParent = population.getIndividual(i + 1);
            if (crossingOverProbability > rand.nextDouble()) {
                switch (crossingOverType) {
                    case ONEPOINTWITHTWOCHILDREN:
                        onePointWithTwoChildrenCrossingOver(firstParent, secondParent, newIndividualsList);
                        break;
                    case TWOPOINTSWITHTWOCHILDREN:
                        twoPointsWithTwoChildrenCrossingOver(firstParent, secondParent, newIndividualsList);
                        break;
                    case ONEPOINTWITHONECHILD:
                        onePointWithOneChildCrossingOver(firstParent, secondParent, newIndividualsList);
                        break;
                    case TWOPOINTSWITHONECHILD:
                        twoPointsWithOneChildCrossingOver(firstParent, secondParent, newIndividualsList);
                        break;
                    case UNIFORMCROSSOVER:
                        uniformCrossingOver(firstParent, secondParent, newIndividualsList);
                        break;
                    case WEIGHTEDUNIFORMCROSSOVER:
                        weightedUniformCrossingOver(firstParent, secondParent, newIndividualsList);
                        break;
                }
            }
            newIndividualsList.add(firstParent);
            newIndividualsList.add(secondParent);
        }
        if (population.getActualIndividualsAmount() % 2 == 1) {
            newIndividualsList.add(population.getIndividual(population.getActualIndividualsAmount() - 1));
        }
        population.setIndividuals(newIndividualsList);
    }

    /**
     *
     * Crosses over two Individuals (parents) and makes two new Individuals
     * (children)
     *
     * @param firstParent - first parent
     * @param secondParent - second parent
     * @param newIndividuals - list of new Individuals
     */
    public static void onePointWithTwoChildrenCrossingOver(AbstractIndividual firstParent, AbstractIndividual secondParent, LinkedList<AbstractIndividual> newIndividuals) {
        AbstractIndividual firstChild = firstParent.createIndividual(firstParent);
        AbstractIndividual secondChild = secondParent.createIndividual(secondParent);
        int splitPoint = rand.nextInt(firstChild.getChromosomeLength());
        for (int j = 0; j < firstChild.getChromosomeLength(); j++) {
            firstChild.setGene(j, j < splitPoint ? firstParent.getValueOfGene(j) : secondParent.getValueOfGene(j));
            secondChild.setGene(j, j < splitPoint ? secondParent.getValueOfGene(j) : firstParent.getValueOfGene(j));
        }
        newIndividuals.add(firstChild);
        newIndividuals.add(secondChild);
    }

    /**
     * Crosses over two Individuals (parents) and makes one new Individual
     * (child)
     *
     * @param firstParent - first parent
     * @param secondParent - second parent
     * @param newIndividuals - list of new Individuals
     */
    public static void onePointWithOneChildCrossingOver(AbstractIndividual firstParent, AbstractIndividual secondParent, LinkedList<AbstractIndividual> newIndividuals) {
        AbstractIndividual child = firstParent.createIndividual(firstParent);
        int splitPoint = rand.nextInt(child.getChromosomeLength());
        for (int j = 0; j < child.getChromosomeLength(); j++) {
            child.setGene(j, j < splitPoint ? firstParent.getValueOfGene(j) : secondParent.getValueOfGene(j));
        }
        newIndividuals.add(child);
    }

    /**
     *
     * Crosses over two Individuals (parents) and makes two new Individuals
     * (children)
     *
     * @param firstParent - first parent
     * @param secondParent - second parent
     * @param newIndividuals - list of new Individuals
     */
    public static void twoPointsWithOneChildCrossingOver(AbstractIndividual firstParent, AbstractIndividual secondParent, LinkedList<AbstractIndividual> newIndividuals) {
        AbstractIndividual firstChild = firstParent.createIndividual(firstParent);
        int splitPoint = rand.nextInt(firstChild.getChromosomeLength() / 2);
        int secondSplitPoint = rand.nextInt(firstChild.getChromosomeLength() / 2) + firstChild.getChromosomeLength() / 2;
        for (int j = 0; j < firstChild.getChromosomeLength(); j++) {
            firstChild.setGene(j, j < splitPoint || j >= secondSplitPoint ? firstParent.getValueOfGene(j) : secondParent.getValueOfGene(j));
        }
        newIndividuals.add(firstChild);
    }

    /**
     *
     * Crosses over two Individuals (parents) and makes two new Individuals
     * (children)
     *
     * @param firstParent - first parent
     * @param secondParent - second parent
     * @param newIndividuals - list of new Individuals
     */
    public static void twoPointsWithTwoChildrenCrossingOver(AbstractIndividual firstParent, AbstractIndividual secondParent, LinkedList<AbstractIndividual> newIndividuals) {
        AbstractIndividual firstChild = firstParent.createIndividual(firstParent);
        AbstractIndividual secondChild = secondParent.createIndividual(secondParent);
        int splitPoint = rand.nextInt(firstChild.getChromosomeLength() / 2);
        int secondSplitPoint = rand.nextInt(firstChild.getChromosomeLength() / 2) + firstChild.getChromosomeLength() / 2;
        for (int j = 0; j < firstChild.getChromosomeLength(); j++) {
            firstChild.setGene(j, j < splitPoint || j >= secondSplitPoint ? firstParent.getValueOfGene(j) : secondParent.getValueOfGene(j));
            secondChild.setGene(j, j < splitPoint || j >= secondSplitPoint ? secondParent.getValueOfGene(j) : firstParent.getValueOfGene(j));
        }
        newIndividuals.add(firstChild);
        newIndividuals.add(secondChild);
    }

    /**
     * Crosses over two Individuals (parents) and makes one new Individual
     * (child)
     *
     * @param firstParent - first parent
     * @param secondParent - second parent
     * @param newIndividuals - list of new Individuals
     */
    public static void uniformCrossingOver(AbstractIndividual firstParent, AbstractIndividual secondParent, LinkedList<AbstractIndividual> newIndividuals) {
        AbstractIndividual child = firstParent.createIndividual(firstParent);
        for (int j = 0; j < child.getChromosomeLength(); j++) {
            child.setGene(j, rand.nextBoolean() ? firstParent.getValueOfGene(j) : secondParent.getValueOfGene(j));
        }
        newIndividuals.add(child);
    }

    /**
     * Crosses over two Individuals (parents) and makes one new Individual
     * (child)
     *
     * @param firstParent - first parent
     * @param secondParent - second parent
     * @param newIndividuals - list of new Individuals
     */
    public static void weightedUniformCrossingOver(AbstractIndividual firstParent, AbstractIndividual secondParent, LinkedList<AbstractIndividual> newIndividuals) {
        AbstractIndividual child = firstParent.createIndividual(firstParent);
        double ratio = firstParent.getFitness() / (firstParent.getFitness() + secondParent.getFitness());
        for (int j = 0; j < child.getChromosomeLength(); j++) {
            child.setGene(j, ratio > rand.nextDouble() ? firstParent.getValueOfGene(j) : secondParent.getValueOfGene(j));
        }
        newIndividuals.add(child);
    }
}
