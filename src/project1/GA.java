package project1;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class GA {
	//GA parameters
	private static int generation = 500;
	private static int popSize = 100;
	private static boolean Elitism = true;
	private static double xoverRate = 0.5;
	private static double mutationRate = 0.01;
	private static int tournamentSize = 5;
	
	/*
	 * ----------MAIN------------
	 */
	public static void main(String[] arg){
		//new Population
		Population pop = new Population(popSize, true);
		System.out.println("initialFitness = "+ pop.getFittest().getFit());
		String[][] context = new String[generation][];
		//EvolvePoplation
		for(int i = 0; i< generation; i++){
			pop = evolvePopulation(pop, Elitism);
//			double[] xAndy = Tool.bitStrToDouble(pop.getFittest().getIndividual());
//			BigDecimal constant = new BigDecimal(0.00004768372718899898);
//			BigDecimal bx = new BigDecimal(Double.toString(xAndy[0]));
//			BigDecimal by = new BigDecimal(Double.toString(xAndy[1]));
//			double x = (bx.multiply(constant)).doubleValue()-100;
//			double y = (by.multiply(constant)).doubleValue()-100;
			
			//System.out.println("generation-"+i+"'s fittest :"+x+";  "+y );
			String[] row = new String[2];
			row[0] = String.valueOf(i);
			row[1] = String.valueOf(pop.getFittest().getFit());
			context[i] = row;
			//System.out.println("generation-"+i+"'s best fitness = "+ pop.getFittest().getFit());
			
		}
		
		//output result to excel
		String[] title = {"generation","fitness"};
		try {
			//t.xls为新建的文件名
			WritableWorkbook book = Workbook.createWorkbook(new File("C:/Users/daniel/workspace/CImidTerm/src/midTermGAresult.xls"));
			//生成名为“第一页”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("第一页", 0);
			//写入内容
			for(int col=0; col<title.length; col++){
				sheet.addCell(new Label(col,0,title[col]));
			}
			for(int row = 0; row<context.length; row++){
				for(int col = 0; col<title.length;col++){
					sheet.addCell(new Label(col,row+1,context[row][col]));
				}
			}
			book.write();
			book.close();
		} catch (IOException | WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		System.out.println("FinalFittest = "+ pop.getFittest().getFit());
		System.out.println("BitString--->"+String.valueOf(pop.getFittest().getIndividual()));
		double[] xAndy = Tool.bitStrToDouble(pop.getFittest().getIndividual());
		BigDecimal constant = new BigDecimal(0.00004768372718899898);
		BigDecimal bx = new BigDecimal(Double.toString(xAndy[0]));
		BigDecimal by = new BigDecimal(Double.toString(xAndy[1]));
		double x = (bx.multiply(constant)).doubleValue()-100;
		double y = (by.multiply(constant)).doubleValue()-100;
		
		System.out.println("X= "+x+"; Y= "+y );
		
		
		
	}
	public static Population evolvePopulation(Population pop, boolean Elitism){
		Population newPopulation = new Population();
		int ElitismOffset =0;
		if(Elitism){
			newPopulation.addIndividual(pop.getFittest());
			ElitismOffset  = 1;
		}
		for(int i = ElitismOffset; i< popSize; i++){
			Individual newIndividual;
			//Crossover
			Individual p1 = tournament(pop, tournamentSize);
			if(java.lang.Math.random()<=xoverRate){
				Individual p2 = tournament(pop, tournamentSize);
				newIndividual = twoPXover(p1, p2);
			}else{
				newIndividual = p1;
			}

			//mutation
			newIndividual = BitwiseMutation(newIndividual);
			newPopulation.addIndividual(newIndividual);		
		}
		newPopulation.setBestIndividual();
		newPopulation.setFitnessStep();
		newPopulation.setAverageFitness();
		
		return newPopulation;
	}
	/*************************************************************************
	 * Runtime Function
	 * Crossover and mutation
	 */
	//XOVER
	public static Individual onePXover(Individual p1, Individual p2){
		Individual newIndividual = new Individual();
		//To be implemented
		return newIndividual;
	}	
	public static Individual twoPXover(Individual p1, Individual p2){
		Individual newIndividual = new Individual();
		char[] c1 = p1.getIndividual();
		char[] c2 = p2.getIndividual();
		Random ran = new Random();
		int pos1 = ran.nextInt(c1.length-1)+1;
		int pos2 = ran.nextInt(c2.length-1)+1;
		
		//if statement
		if(pos1<=pos2){
			for(int i = pos1-1;i<pos2;i++ ){
				c1[i] = c2[i];
			}
		}else{
			for(int i = pos2-1; i< pos1; i++){
				c1[i] = c2[i];
			}
		}
		newIndividual.setIndividual(c1);
		return newIndividual;
	}
	
	public static Individual uniXover(Individual p1, Individual p2){
		Individual newIndividual = new Individual();
		//To be implemented
		return newIndividual;
	}
	//MUTATION
	public static Individual swapMutation(Individual p){
		Individual newIndividual = new Individual();
		Random ran = new Random();
		
		//To be implemented
		return newIndividual;
	}
	public static Individual BitwiseMutation(Individual p){
		Individual newIndividual = new Individual();
		char[] newchar = p.getIndividual().clone();
		//To be implemented
		Random ran = new Random();
		for(int i = 0; i< p.getIndividual().length; i++){
			if(ran.nextDouble()<mutationRate){
				if(newchar[i] == '1'){
					newchar[i] = '0';
				}else{
					newchar[i] = '1';
				}
			}
		}
		newIndividual.setIndividual(newchar);
		return newIndividual;
		
	}
	//parentSelection
	public static Individual tournament(Population pop, int tournamentSize){
		Population tournament = new Population();
		Random ran = new Random();
		for(int i = 0; i< tournamentSize; i++){
			tournament.addIndividual(pop.getIndividual(ran.nextInt(popSize)));
		}
		tournament.setBestIndividual();
		return tournament.getFittest();
	}
	
	
	
	
	
}
