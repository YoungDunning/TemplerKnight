package gmit;
/*
 * g00284875 Patrick Dunning
 * Temple Knights Text based Game
 */
public class Item {
	private String name;
	private Location location;
	private int value;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	

}
