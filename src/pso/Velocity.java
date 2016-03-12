package pso;

import java.util.Random;

public class Velocity {
	private double v_x, v_y;

	public Velocity(){
		Random ran = new Random();
		v_x = 2*PSO.Vmax*ran.nextDouble()-PSO.Vmax;
		v_y = 2*PSO.Vmax*ran.nextDouble()-PSO.Vmax;
	}
	public double getV_x() {
		return v_x;
	}

	public void setV_x(double v_x) {
		this.v_x = v_x;
	}

	public double getV_y() {
		return v_y;
	}

	public void setV_y(double v_y) {
		this.v_y = v_y;
	}
	
	

}
