package pso;
//该有的属性
//自己当前的速度和位置

public class Particle {
	//current location and velocity
	private Location currL;
	private Velocity currV;	
	private Location pBest;                   //history best location
	public static Particle gBest;						//Globle best particle
	private double fitness;
	
	//constructor
	public Particle(){
		currL = new Location();
		currV = new Velocity();
		pBest = currL;
		fitness = PSOTool.calculateFit(currL);
	}
	public Particle copy(){
		Particle cp = new Particle();
		cp.setCurrL(this.currL.copy());
		cp.calcFit();
		return cp;
	}
	public double getFitness(){
		return fitness;
	}
	public void calcFit(){
		this.fitness = PSOTool.calculateFit(currL);
	}
	public Location getCurrL() {
		return currL;
	}
	public void setCurrL(Location currL) {
		this.currL = currL;
	}
	public Velocity getCurrV() {
		return currV;
	}
	public void setCurrV(Velocity currV) {
		this.currV = currV;
	}
	public Location getpBest() {
		return pBest;
	}
	public void setpBest(Location pBest) {
		this.pBest = pBest;
	}
	public void setgBest(Particle gBest) {
		Particle.gBest = gBest;
	}
	public Particle getgBest() {
		return gBest;
	}

	
	//Getter and Setter
	
	
}
