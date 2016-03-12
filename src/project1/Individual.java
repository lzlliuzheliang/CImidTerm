package project1;

import java.util.Random;

public class Individual {
	private char[] individual = new char[44];
	private double fitness;
	
	//Constructor
	public Individual(){
		
	}
	public Individual(boolean initialize){
		if(initialize){
			Random ran = new Random();
			for(int i = 0; i<individual.length; i++){
				if(ran.nextBoolean()){
					this.individual[i] = '1';
				}else{
					this.individual[i] = '0';
				}
			}
			this.calcFit();
		}
	}
	
	
	public char[] getIndividual(){
		return individual;
	}
	public void setIndividual(char[] newIndividual){
		this.individual = newIndividual;
		calcFit();
	}
	public void calcFit(){
		this.fitness = Tool.calculateFitness(this);
	}
	public double getFit(){
		return fitness;
	}
	public double[] getXY(){
		double[] xAndy = Tool.bitStrToDouble(individual);
		return xAndy;
	}
}
