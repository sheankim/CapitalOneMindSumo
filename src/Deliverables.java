import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Deliverables {
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		HashMap<String, State> container = new HashMap<String, State>();
		Queue<City> lowestGrowthCities = new PriorityQueue<City>(5, cityComparator);
		Queue<City> highestGrowthCities = new PriorityQueue<City>(5, cityMaxComparator);
		Queue<State> highestGrowthState = new PriorityQueue<State>(5, stateComparator);
		
		//Scanner scanner = new Scanner(new File("/Users/sheankim/Documents/workspace/CapitalOneChallenge/src/Metropolitan_Populations__2010-2012.csv"));
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		//System.out.println(scanner.nextLine());
		while(scanner.hasNext()){
			String[] values = scanner.nextLine().split(",");
			City city = new City(values[0].substring(1), values[1].substring(1, values[1].length()-1), Integer.parseInt(values[3]), Integer.parseInt(values[4]));
			if(city.getPopulation_2010() >= 50000){
				lowestGrowthCities.add(city);
				highestGrowthCities.add(city);
			}
			if(container.containsKey(city.getState())){
				State state = container.get(city.getState());
				state.addCity2010(city);
				state.addCity2012(city);
				container.put(state.getName(), state);
			}else{
				State state= new State(city.getState());
				state.addCity2010(city);
				state.addCity2012(city);
				container.put(state.getName(), state);
			}
		}

		scanner.close();
		
		highestGrowthState.addAll(container.values());
		
		System.out.println("The following 5 cities have the highest growth");
		for(int x = 0; x < 5; x++){
			City tmp = highestGrowthCities.poll();
			System.out.println(tmp.getName() + ", " + tmp.getState() + "- Growth: " + tmp.calculateGrowth());
		}
		System.out.println("------------");
		System.out.println("The following 5 cities have the lowest growth");
		for(int x = 0; x < 5; x++){
			City tmp = lowestGrowthCities.poll();
			System.out.println(tmp.getName() + ", " + tmp.getState() + "- Growth: " + tmp.calculateGrowth());
		}
		System.out.println("------------");
		System.out.println("The following 5 states have the largest growth");
		for(int x = 0; x < 5; x++){
			State tmp = highestGrowthState.poll();
			System.out.println(tmp.getName() + "- Growth:  " + tmp.calculateGrowth());
		}
	}

	public static Comparator<City> cityComparator = new Comparator<City>(){

		@Override
		public int compare(City arg0, City arg1) {
			// TODO Auto-generated method stub
			if(arg0.calculateGrowth() < arg1.calculateGrowth()) return -1;
			if(arg0.calculateGrowth() > arg1.calculateGrowth()) return 1;
			return 0;
		}
	};
	
	public static Comparator<City> cityMaxComparator = new Comparator<City>(){

		@Override
		public int compare(City arg0, City arg1) {
			// TODO Auto-generated method stub
			if(arg0.calculateGrowth() < arg1.calculateGrowth()) return 1;
			if(arg0.calculateGrowth() > arg1.calculateGrowth()) return -1;
			return 0;
		}
	};
	
	public static Comparator<State> stateComparator = new Comparator<State>(){

		@Override
		public int compare(State o1, State o2) {
			// TODO Auto-generated method stub
			if(o1.calculateGrowth() < o2.calculateGrowth()) return 1;
			if(o1.calculateGrowth() > o2.calculateGrowth()) return -1;
			return 0;
		}
	};
}
