import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Random;

public class CitySimTest {
	
	//Reusable CitySim reference
	CitySim _sim;
	//Create a new CitySim before each test
	@Before
	public void setup(){
		_sim = new CitySim();
	}
	
	//Assert that creating a new CitySim does not return a null reference
	@Test
	public void testCitySimExists(){
		assertNotNull(_sim);
	}
	
	//Driving should return the Id of the next city 
	//Create a mock random number generator and a mock location with a hard coded array.
	//It should return the first element of the array.
	@Test
	public void testDrive(){
		int[] tempArray = {1,2};
		Random mockRand = mock(Random.class);
		TheLocation mockLocation = mock(TheLocation.class);
		when(mockLocation.getNextIds()).thenReturn(tempArray);
		when(mockRand.nextInt()).thenReturn(1);
		assertEquals(1, _sim.drive(mockLocation, mockRand));
	}
	
	//If the currentLocation is null, should return -1
	//Create a mock random number generator and a mock location
	//Set the mock Location to null
		@Test
		public void testDriveLocationNull(){
			Random mockRand = mock(Random.class);
			TheLocation mockLocation = mock(TheLocation.class);
			mockLocation = null;
			assertEquals(-1, _sim.drive(mockLocation, mockRand));
		}
	
	//If the Random number generator is null, should return -1
	//Create a mock random number generator and a mock location
	//Set the mock random number generator to null
		@Test
		public void testDriveRandomNull(){
			Random mockRand = mock(Random.class);
			TheLocation mockLocation = mock(TheLocation.class);
			mockRand = null;
			assertEquals(-1, _sim.drive(mockLocation, mockRand));
		}
	
	//If the location ArrayList is empty, should return -1
	//Create a mock random number generator and an array list
	//Since the array list never has anything put in, should return -1
		@Test
		public void testStartIsEmpty(){
			Random mockRand = mock(Random.class);
			ArrayList<TheLocation> locationArray = new ArrayList<TheLocation>();
			assertEquals(-1, _sim.start(locationArray, mockRand));
		}
		
		//If the Random number generator passed in is null, should return -1
		//Create a mock random number generator and an array list
		//Set the mock random number generator to null
		@Test
		public void testStartRandomNull(){
			Random mockRand = mock(Random.class);
			ArrayList<TheLocation> locationArray = new ArrayList<TheLocation>();
			mockRand = null;
			assertEquals(-1, _sim.start(locationArray, mockRand));
		}
		
	
}
