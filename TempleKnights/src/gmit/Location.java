package gmit;

/*
 * g00284875 Patrick Dunning
 * Temple Knights Text based Game
 */
import java.util.*;

public class Location {
	private int id;
	private String name;
	private String description;
	private String title;
	private String direction;
	private String exit;
	private String character;

	//Do i leave Exits as a list or do i make em into a private String??
	private List<Exit> exits = new ArrayList<Exit>();
	private List<AbstractGameCharacter> observers = new ArrayList<AbstractGameCharacter>();
	private List<Item> objects = new ArrayList<Item>();
	
	public Location(){
		
	}
	public Location(int id, String name, String description)
	{
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public String getExit() {
		return exit;
	}
	public void setExit(String exit) {
		this.exit = exit;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String gameCharacter) {
		this.character = gameCharacter;
	}
	
	
	public void enter(AbstractGameCharacter gc){
		observers.add(gc);
	}	
	public void exit(GameCharacter gc){
		observers.remove(gc);
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("-------Location Details------- \n");
		sb.append("Id:" + getId());
        sb.append("\n");
		sb.append("Name:" + getName());
        sb.append("\n");
        sb.append("Description:" + getDescription());
		sb.append("\n");
		sb.append("Exits:" + getTitle());
		sb.append("\n");
		sb.append("Direction:" + getDirection());
		sb.append("\n");
		sb.append("Characters:" + getCharacter());
		sb.append("\n");
		sb.append("Items:");
		sb.append("\n");

		return sb.toString();
		
	}
	
	public void look() {
		StringBuffer sb = new StringBuffer();
		sb.append("-------- " + this.name + " -----------\n");
		sb.append(this.description);
		
		sb.append("\nYou see: \n");
		for (GameCharacter gc : observers){
			sb.append(gc.getName());
		}
		sb.append("\nVisible exits are: \n");
		for (Exit e : exits){
			sb.append(e.getDirection());
		}		
		sb.append("\nOoh look a shiny item: \n");
		for(Item item : objects){
			sb.append(item.getName());
		}
		
	}
	


}
