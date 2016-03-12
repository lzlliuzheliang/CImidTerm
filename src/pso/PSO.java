package pso;

import java.util.ArrayList;
import java.util.Random;

public class PSO {
	//neighberSet
	public static int neighbors = 1;		//neighbor Size
	public static int swarmSize = 100;		//swarm Size
	public static double c1 = 2, c2 = 2;		
	public static double wStart = 1.7;				//inertia weight
	public static double wEnd = 0.9;
	public static double Vmax = 1000000;
	public static int iteration = 2000;
	//public static Location HisBest;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Swarm swarm = new Swarm(swarmSize);
		System.out.println("initialization fitness: "+ swarm.getParticle(9).getgBest().getFitness());
		System.out.println("initialization fitness9: "+ swarm.getParticle(9).getFitness());
		System.out.println("initialization fitness8: "+ swarm.getParticle(8).getFitness());
		System.out.println("initialization fitness7: "+ swarm.getParticle(7).getFitness());
		System.out.println();
		double gap = (wEnd - wStart)/iteration;
		double w = wStart;
		for(int i = 0; i< iteration; i++){
			swarm.evolve(w);
			System.out.println("iteration-"+i+": "+ swarm.getParticle(9).getgBest().getFitness());
			w+=gap;
		}
		System.out.println("initialization fitness: "+ swarm.getParticle(9).getgBest().getFitness());
		System.out.println("initialization fitness9: "+ swarm.getParticle(9).getFitness());
		System.out.println("initialization fitness8: "+ swarm.getParticle(8).getFitness());
		System.out.println("initialization fitness7: "+ swarm.getParticle(7).getFitness());
	
		
	}
	
	
	

}
