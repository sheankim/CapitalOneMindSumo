
public class City {
	private String name;
	private String state;
	private int population_2010;
	private int population_2012;
	
	public City(String name, String state, int population_2010, int population_2012){
		this.name = name;
		this.state = state;
		this.population_2010 = population_2010;
		this.population_2012 = population_2012;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPopulation_2010() {
		return population_2010;
	}
	public void setPopulation_2010(int population_2010) {
		this.population_2010 = population_2010;
	}
	public int getPopulation_2012() {
		return population_2012;
	}
	public void setPopulation_2012(int population_2012) {
		this.population_2012 = population_2012;
	}
	
	public double calculateGrowth(){
		return ((double)(population_2012-population_2010)/population_2010)*100;
	}
	
}
