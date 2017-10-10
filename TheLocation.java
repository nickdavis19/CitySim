
public class TheLocation {
	
	int _id = -1; //Integer representation of the location
	String _name; //String representation of the location
	int[] _nextIdArray; //Stores the Ids of the next locations it can travel to
	
	
	public TheLocation(int id, String name){
		_id = id;
		_name = name;
	}
	
	//Returns the Id
	public int getId(){
		return _id;
	}
	
	//Returns the name
	public String getName(){
		return _name;
	}
	
	//Returns the array of nextIds
	public int[] getNextIds(){
		return _nextIdArray;
	}
	
	//Sets the nextId array
	public void setNextIds(int id1, int id2){
		_nextIdArray = new int[] {id1, id2};
	}
}