package project1;

import java.util.ArrayList;

public class Population {
	private ArrayList<Individual> population = new ArrayList<Individual>();
	private Individual bestIndividual;
	private double averageFitness;
	private double[] fitnessStep;
	
	//constructor
	public Population(){
		
	}
	public Population(int size, boolean initialize){
		ArrayList<Individual> newPopulation = new ArrayList<Individual>();
		if(initialize){
			for(int i = 0; i< size; i++){
				Individual ind = new Individual(true);
				newPopulation.add(ind);
			}
		}	
		this.population = newPopulation;
		this.setFitnessStep();
		this.setAverageFitness();
		this.setBestIndividual();		
	}
	
	//set methods
	public void setFitnessStep(){
		double[] fitStep = new double[population.size()];
		for(int i = 0; i< population.size(); i++){
			if(i == 0){
				fitStep[i] = population.get(i).getFit();
			}else{
				fitStep[i] = fitStep[i-1]+population.get(i).getFit();
			}
		}
		this.fitnessStep = fitStep;
	}
	public void setBestIndividual(){
		int bestIndex = 0;
		for(int i = 0; i< population.size(); i++){
			if(population.get(i).getFit()>=population.get(bestIndex).getFit()){
				bestIndex = i;
			}
		}
		bestIndividual = population.get(bestIndex);
	}
	public void setAverageFitness(){
		//To be implemented
		this.averageFitness = (fitnessStep[population.size()-1]/population.size());
	}
	
	//get methods
	public void addIndividual(Individual ind){
		population.add(ind);
	}
	public void setIndividual(Individual ind, int index){
	
		population.set(index, ind);
		setFitnessStep();
		if(ind.getFit()>=bestIndividual.getFit()){
			bestIndividual = ind;
		}
		setAverageFitness();
	}
	public Individual getIndividual(int index){
		return population.get(index);
	}
	public Individual getFittest(){
		return bestIndividual;
	}
	public double getAveFit(){
		return averageFitness;
	}
	public double[] getFitStep(){
		return fitnessStep;
	}

	
}
