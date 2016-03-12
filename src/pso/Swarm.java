package pso;

import java.util.ArrayList;
import java.util.Random;

public class Swarm {
	public static ArrayList<Particle> swarm;
	//public static Location gBestL;
	
	public Swarm(int size){
		swarm = new ArrayList<Particle>();
		Particle particle = new Particle();
		Particle.gBest = particle.copy();
		swarm.add(particle);
		for(int i = 1; i< size; i++){
			particle = new Particle();
			if(particle.getFitness()>Particle.gBest.getFitness()){
				Particle.gBest = particle.copy();
			}
			swarm.add(particle);
		}
	}
	//Evolutionary
	public void evolve(double w){
		for(int i = 0;i < swarm.size(); i++){
			//find the Lbest
//			Particle LB = swarm.get(i);
//			if(i == 0){
//				if(swarm.get(1).getFitness()>LB.getFitness()){
//					LB = swarm.get(i);
//				}
//				
//			}else if(i == swarm.size()-1){
//				if(swarm.get(i-1).getFitness()>LB.getFitness()){
//					LB = swarm.get(i-1);
//				}
//				
//			}else{
//				if(swarm.get(i-1).getFitness()>LB.getFitness()){
//					LB = swarm.get(i-1);
//				}
//				if(swarm.get(i+1).getFitness()>LB.getFitness()){
//					LB = swarm.get(i+1);
//				}
//			
//			}
//			swarm.set(i, move(swarm.get(i), LB, w));
			swarm.set(i, move(swarm.get(i), swarm.get(i).getgBest(), w));
		}
	}
	//getNew state of Particle
		public Particle move(Particle p,Particle LB, double w){
			//System.out.println("");
			//System.out.println("moveStart"+ String.valueOf(p.getCurrL().getX()));
			//new Velocity
			Random ran = new Random();
			Velocity newV = new Velocity();
			//Update x
			double newV_X = w*p.getCurrV().getV_x()
					+PSO.c1*ran.nextDouble()*(PSOTool.bitToInt(p.getpBest().getX())-PSOTool.bitToInt(p.getCurrL().getX()))
					+PSO.c2*ran.nextDouble()*(PSOTool.bitToInt(LB.getCurrL().getX())-PSOTool.bitToInt(p.getCurrL().getX()));
			if(newV_X>PSO.Vmax){
				newV_X = PSO.Vmax;
			}else if(newV_X<-PSO.Vmax){
				newV_X = -PSO.Vmax;
			}
			newV.setV_x(newV_X);
			//Update y
			double newV_Y = w*p.getCurrV().getV_y()
					+PSO.c1*ran.nextDouble()*(PSOTool.bitToInt(p.getpBest().getY())-PSOTool.bitToInt(p.getCurrL().getY()))
					+PSO.c2*ran.nextDouble()*(PSOTool.bitToInt(LB.getCurrL().getY())-PSOTool.bitToInt(p.getCurrL().getY()));
			if(newV_Y>PSO.Vmax){
				newV_Y = PSO.Vmax;
			}else if(newV_Y<-PSO.Vmax){
				newV_Y = -PSO.Vmax;
			}
//			System.out.println();
//			
//			System.out.println("v_y_Original="+p.getCurrV().getV_y()+";   V_y="+ newV_Y);
			newV.setV_y(newV_Y);
			
			p.setCurrV(newV);
			//location
			int L_X = PSOTool.bitToInt(p.getCurrL().getX())+(int)newV_X;
			int L_Y = PSOTool.bitToInt(p.getCurrL().getY())+(int)newV_Y;
//			System.out.println();
//			
//			System.out.println("l_y_Original="+PSOTool.bitToInt(p.getCurrL().getY())+";   l_y="+ PSOTool.bitToInt(p.getCurrL().getY()));
			Location newL = new Location();
			newL.setX(PSOTool.IntToBit(L_X));
			newL.setY(PSOTool.IntToBit(L_Y));
			p.setCurrL(newL);
			p.calcFit();
			
			if(PSOTool.calculateFit(newL)>PSOTool.calculateFit(Particle.gBest.getCurrL())){
				Particle.gBest = p.copy();
			}
			//System.out.println("move end "+ String.valueOf(p.getCurrL().getX()));
			return p;
			
		}
		
	public Particle getParticle(int index){
		return swarm.get(index);
	}
}
