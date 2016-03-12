package project1;
import java.lang.Math;
import java.math.BigDecimal;

import BigDecimalMa.BigDecimalMath;
public class Tool {
	/**************************************************************************
	 * Fitness Function
	 * Most important part
	 * @param individual
	 * @return fitness
	 *
	 */
	public static double calculateFitness(Individual individual){
		//To be implemented
		//FitnessFunc
		double[] xAndy = bitStrToDouble(individual.getIndividual());
		BigDecimal constant = new BigDecimal(0.00004768372718899898);
		BigDecimal bx = new BigDecimal(Double.toString(xAndy[0]));
		BigDecimal by = new BigDecimal(Double.toString(xAndy[1]));
		double x = (bx.multiply(constant)).subtract(new BigDecimal(100)).doubleValue();
		double y = (by.multiply(constant)).subtract(new BigDecimal(100)).doubleValue();
		double x2 = java.lang.Math.pow(x, 2);
		double y2 = java.lang.Math.pow(y, 2);
		double result = ((Math.pow(Math.sin(Math.sqrt(x2+y2)),2)-0.5)/Math.pow(1+(0.001*(x2+y2)), 2))+0.5;
		
//		BigDecimal x = (bx.multiply(constant)).subtract(new BigDecimal(100));
//		BigDecimal y = (by.multiply(constant)).subtract(new BigDecimal(100));
//		x = BigDecimalMa.BigDecimalMath.pow(x.abs(), new BigDecimal(2));
//		y = BigDecimalMa.BigDecimalMath.pow(y.abs(), new BigDecimal(2));
//		BigDecimal numerator = BigDecimalMath.sqrt(x.add(y));
//		numerator = BigDecimalMath.pow((BigDecimalMath.sin(numerator)).abs(), new BigDecimal(2)).subtract(new BigDecimal(0.5));
//		BigDecimal denominator = (x.add(y)).multiply(new BigDecimal(0.001)).add(new BigDecimal(1));
//		denominator = BigDecimalMath.pow(denominator.abs(), new BigDecimal(2));
		
		
//		double result = (numerator.divide(denominator)).doubleValue();
			
		return result;
		
	}

	
	//public tool
	public static double[] bitStrToDouble(char[] individual){
		double[] xAndy = new double[2];
		char[] x = new char[22];
		char[] y = new char[22];
		for(int i = 0; i< x.length; i++){
			x[i] = individual[i];
		}
		for(int i = 0; i< y.length; i++){
			y[i] = individual[i+y.length];
		}
		xAndy[0] = Integer.parseInt(new String(x), 2);
		xAndy[1] = Integer.parseInt(new String(y),2);
		
		return xAndy;
	}
	public static void main(String[] arg){
		char[] a = {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',
				'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','1','1'};
		double[] xAndy = bitStrToDouble(a);
		System.out.println(xAndy[0]+" "+xAndy[1]);
	}
	
}
