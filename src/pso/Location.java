package pso;

import java.util.Random;

public class Location {
	private char[] x = new char[22];
	private char[] y = new char[22];
	//constructor
	public Location(){
		Random ran = new Random();
		for(int i = 0; i<x.length; i++){
			if(ran.nextBoolean()){
				x[i] = '1';
			}else{
				x[i] = '0';
			}
			if(ran.nextBoolean()){
				y[i] = '1';
			}else{
				y[i] = '0';
			}
		}
	}
	public Location copy(){
		Location cpl = new Location();
		cpl.x = String.valueOf(this.x).toCharArray();
		cpl.y = String.valueOf(this.y).toCharArray();
		return cpl;
	}
	public char[] getX() {
		return x;
	}
	public void setX(char[] x) {
		this.x = x;
	}
	public char[] getY() {
		return y;
	}
	public void setY(char[] y) {
		this.y = y;
	}
	
	
}
