import java.util.ArrayList;
import java.util.Random;

public class CitySim {

	ArrayList<TheLocation> _locations = new ArrayList<TheLocation>();
	int _seed;
	
	
	//Advances one iteration of the city simulation
	//The driver will drive to a new location
	//Accepts current location and driver as parameters
	//Returns int Id of the location driven to
	public static int drive(TheLocation curLocation, Random theRandom){
		if(curLocation == null || theRandom == null){
			return -1;
		}
		int[] possibleRoutes = curLocation.getNextIds();
		int choice = theRandom.nextInt(2);//2 is a magic number, represents the size of the id array. The random number must be <=2
		return possibleRoutes[choice]; 
	}
	
	//Sets up the driver in the simulation
	//Randomly picks one of the four cities to start in
	//Accepts array of all locations and the random location chosen as parameters
	//Returns int Id of the starting location
	public static int start(ArrayList<TheLocation> theLocations, Random theRandom){
		if(theLocations.isEmpty() || theRandom == null){
			return -1;
		}
		TheLocation chosenLocation = theLocations.get(theRandom.nextInt(theLocations.size()));
		return chosenLocation.getId();
	}
	
	
	
	
	
	public static void main(String[] args){
		Random rand = new Random(Long.parseLong(args[0]));
		int keepRunning = 0;
		ArrayList<TheLocation> locations = new ArrayList<TheLocation>();
		
		TheLocation hotel = new TheLocation(0, "Hotel");
		hotel.setNextIds(1,3);
		TheLocation diner = new TheLocation(1, "Diner");
		diner.setNextIds(2,5);
		TheLocation coffee = new TheLocation(2, "Coffee");
		coffee.setNextIds(1,3);
		TheLocation library = new TheLocation(3, "Library");
		library.setNextIds(0,6);
		locations.add(hotel);
		locations.add(diner);
		locations.add(coffee);
		locations.add(library);
		
		int totalDrivers = 5;
		for(int i=1; i<=totalDrivers; i++){
				keepRunning = 1;
				int startId = start(locations, rand);
				if(startId == -1){
					System.out.println("Error: No locations or no random number generator");
					System.exit(1);
				}
				
				TheLocation currentLocation = locations.get(startId);
				System.out.println("Driver "+i+" starting in "+currentLocation.getName());
				TheLocation previousLocation;
				while(keepRunning == 1){
					int nextId = drive(currentLocation, rand);
					if(nextId == -1){
						System.out.println("Error: Current location does not exist or no random number generator");
						System.exit(1);
					}
					if(nextId == 5){
						System.out.println("Driver "+i+" has gone to Philadelphia!");
						System.out.println("-----");
						keepRunning = 0;
						break;
					}
					if(nextId == 6){
						System.out.println("Driver "+i+" has gone to Cleveland!");
						System.out.println("-----");
						keepRunning = 0;
						break;
					}
					previousLocation = currentLocation;
					currentLocation = locations.get(nextId);
					if(currentLocation.getId() == 0){
						System.out.println("Driver "+i+" heading from "+previousLocation.getName()+" to "+currentLocation.getName()+" VIA Bill St");
					}
					if(currentLocation.getId() == 2){
						System.out.println("Driver "+i+" heading from "+previousLocation.getName()+" to "+currentLocation.getName()+" VIA Phil St");
					}
					if(currentLocation.getId() == 1 && previousLocation.getId() == 0){
						System.out.println("Driver "+i+" heading from "+previousLocation.getName()+" to "+currentLocation.getName()+" VIA Fourth Ave");
					}
					if(currentLocation.getId() == 1 && previousLocation.getId() == 2){
						System.out.println("Driver "+i+" heading from "+previousLocation.getName()+" to "+currentLocation.getName()+" VIA Phil St");
					}
					if(currentLocation.getId() == 3 && previousLocation.getId() == 2){
						System.out.println("Driver "+i+" heading from "+previousLocation.getName()+" to "+currentLocation.getName()+" VIA Fifth Ave");
					}
					if(currentLocation.getId() == 3 && previousLocation.getId() == 0){
						System.out.println("Driver "+i+" heading from "+previousLocation.getName()+" to "+currentLocation.getName()+" VIA Bill St");
					}
				}
		}
	}
}
