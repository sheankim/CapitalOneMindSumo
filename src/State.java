
public class State {
	private String name;
	private int population_2010;
	private int population_2012;
	
	public State(String name){
		this.name = name;
		population_2010 = 0;
		population_2012 = 0;
	}
	
	public void addCity2010(City city){
		population_2010 += city.getPopulation_2010();
	}
	
	public void addCity2012(City city){
		population_2012 += city.getPopulation_2012();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
