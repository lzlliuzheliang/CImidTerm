package pso;

import java.math.BigDecimal;

public class PSOTool {
	public static int bitToInt(char[] loc){
		int l = Integer.parseInt(new String(loc), 2);
		return l;
	}
	public static char[] IntToBit(int l){
		String s = Integer.toBinaryString(l);
		char[] c = s.toCharArray();
		char[] cs = new char[22];
		for(int i = 0; i<22; i++){
			cs[i] = '0';
		}
		if(c.length>=22){
			for(int i = 0; i<22; i++){
				cs[21-i] = c[c.length-1-i];
			}
		}else if(c.length<22){
			for(int i = 0; i<c.length; i++){
				cs[21-i] = c[c.length-1-i];
			}
		}
	
		return cs;
	}
	public static void main(String[] arg){
		System.out.println(String.valueOf(IntToBit(9)));
		BigDecimal constant = new BigDecimal("0.00004768372719988898");
		System.out.println(constant);
	}
	
	public static double calculateFit(Location l){
		BigDecimal x = new BigDecimal(bitToInt(l.getX()));
		BigDecimal y = new BigDecimal(bitToInt(l.getY()));
		BigDecimal constant = new BigDecimal("0.00004768372719988898");
		x = constant.multiply(x).subtract(new BigDecimal(100));
		y = constant.multiply(y).subtract(new BigDecimal(100));
		
		double x2 = java.lang.Math.pow(x.doubleValue(), 2);
		double y2 = java.lang.Math.pow(y.doubleValue(), 2);
		double result = ((Math.pow(Math.sin(Math.sqrt(x2+y2)),2)-0.5)/Math.pow(1+(0.001*(x2+y2)), 2))+0.5;
		
		return result;
	}
}
