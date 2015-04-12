/*
 * g00284875 Patrick Dunning
 * Temple Knights Text based Game
 */

package gmit;

public class Weapon {

	private String name;
	private int value;
	private Location loc;
	
	//getter and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Location getLoc() {
		return loc;
	}
	public void setLoc(Location loc) {
		this.loc = loc;
	}
	
	//Use method
	public void use()
	{
		System.out.println("They have " + name);
	}
	
}
