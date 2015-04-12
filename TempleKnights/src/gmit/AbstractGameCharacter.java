package gmit;
/*
 * g00284875 Patrick Dunning
 * Temple Knights Text based Game
 */

public abstract class AbstractGameCharacter implements GameCharacter {
	
	private String name;
	private int id;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
