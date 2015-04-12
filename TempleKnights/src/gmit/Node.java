package gmit;
/*
 * g00284875 Patrick Dunning
 * Temple Knights Text based Game
 */
import java.util.*;
public class Node {
	
	
	private String nodeName;
	private String currentNode;
	private Node parent;
	private Map<Node, Integer> children = new HashMap<Node, Integer>();
	private boolean visited = false;
	private boolean goalNode;
	private int approxDistance = 0;
	private int distanceTravelled = 0;
	private float danger = 0.0f;
	private float terrain = 0.0f;
	private List<Exit> exit = new ArrayList<Exit>();
	private List<Character> character = new ArrayList<Character>();
	
	//Constructors
	public Node(String name){
		this.nodeName = name;
	}
	public Node(String name, int goalDistance){
		this.nodeName = name;
		this.approxDistance = goalDistance;
	}
	
	public Node[] children(){
		return (Node[]) children.keySet().toArray(new Node[children.size()]);
	}
	
	public boolean isLeaf(){
		if (children.size() > 0){
			return false;
		}else{
			return true;
		}
	}
	
	public void addChildNode(Node child, int distance){
		children.put(child, new Integer(distance));
	}
	
	public void removeChild(Node child){
		children.remove(child);
	}
	
	//Getters and Setters for each Variable
	public Node getParent()
	{
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public int getDistanceToNode(Node n){
		return children.get(n);
	}
	
	public int getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(int depth) {
		this.distanceTravelled = depth;
	}
	
	public float getScore() {
		return HeuristicCalculator.getHeuristicValue(distanceTravelled, approxDistance, terrain, danger);
	}
	
	public int getChildNodeCount(){
		return children.size();
	}
	public void setDanger(float danger) {
		this.danger = danger;
	}
	public float getDanger() {
		return danger;
	}
	public float getTerrain() {
		return terrain;
	}
	public void setTerrain(float terrain) {
		this.terrain = terrain;
	}

	
	
	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isGoalNode() {
		return goalNode;
	}

	public void setGoalNode(boolean goalNode) {
		this.goalNode = goalNode;
	}
	
	public int getGoalDistance() {
		return approxDistance;
	}
	
	public void setGoalDistance(int goalDistance) {
		this.approxDistance = goalDistance;
	}
	
	public String toString() {
		return this.nodeName;
	}
	
	public List<Exit> getExit() {
		return exit;
	}
	public void setExit(List<Exit> exit) {
		this.exit = exit;
	}
	public List<Character> getCharacter() {
		return character;
	}
	public void setCharacter(List<Character> character) {
		this.character = character;
	}
	public String getCurrentNode() {
		return currentNode;
	}
	public void setCurrentNode(String currentNode) {
		this.currentNode = currentNode;
	}
}
