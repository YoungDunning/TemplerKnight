package gmit;

/*
 * g00284875 Patrick Dunning
 * Temple Knights Text based Game
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser extends DefaultHandler{
	
	private Location loc;
	private Location ex;
	private Location gChar;
	
	private String temp;
	private ArrayList<Location> locat = new ArrayList<Location>();
    
	boolean location = false;
	boolean description = false;
	boolean exit = false;
	boolean item = false;
	boolean gameCharacter = false;
	boolean searchAlgorithm = false;
	
	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
	{
		//Parser factory used to create SAX parsers
        SAXParserFactory spfac = SAXParserFactory.newInstance();
        //Now parser factory is used to create a SAXParser object
        SAXParser sp = spfac.newSAXParser();
        //Create instance of this class, it defines all the handler methods
        Parser handler = new Parser();
        //Tell parser to parse the input and notify the handler
        sp.parse("TempleKnights.xml", handler);
        
        handler.readList();
        
        String playrName;
        System.out.println("Now that you have seen each discription of the Locations");
        System.out.println("Welcome to Temple Knight: Text Adventure Game");
        
        Scanner in = new Scanner(System.in);
        System.out.println("Please tell me your name:");
        playrName = in.nextLine();
        System.out.println("Greetings " + playrName + "");
        
        
        
        PathLocations pl = new PathLocations();
        Node start = pl.getStartNode();
        start.setVisited(false);
        boolean play = true;
        while(play){
        	
        	System.out.println("What would you like to do:");
        	Scanner sc = new Scanner(System.in);
        	String choice = sc.nextLine();
        	
        	Location loc = new Location();
        	Node currentNode = start;
        	switch (choice) {
			case ("help"):
				System.out.println("----Different commands for help----");
				System.out.println("----1.LOOK-To see where you are!----");
				System.out.println("--- 2.GO: to move from current location ---");
				System.out.println("--- 3.QUIT: to retrieve new item ---");
				break;
			case("LOOK"):
				System.out.println("You appear to be in:" + currentNode.getNodeName() + 
						"\nLocation Description: " + loc.getDescription());
			for(int z = 0; z<currentNode.getCharacter().size(); z++){
				System.out.println(currentNode.getCharacter() + " a: "+ "\n"); 
			}
			break;
			case("GO"):
				System.out.println("Locations Available:" + loc.getTitle() 
						+ "\nDirection:" + loc.getDirection());
				System.out.println("Enter your choice of locations: ");
				choice = sc.nextLine();
				nextNode(choice);
				break;
			case("GET"):
				System.out.println("");
				break;
			case("USE"):
				System.out.println("");
				break;
			case("QUIT"):
				System.out.println("Fairwell "+ playrName +"\nHopefully we will meet again");
				play = false;
			break;
        	}
        }
	}
	
	private static void nextNode(String choice) {
	}

	public void characters(char[] buffer, int start, int length) {
        temp = new String(buffer, start, length);
 }
	
	public void startElement(String uri, String localName, String qName,
			Attributes attr) throws SAXException{
		temp = "";
		if(qName.equalsIgnoreCase("Location")){
			
			loc = new Location();
			int locationID = Integer.parseInt(attr.getValue("id"));
			String locationName = attr.getValue("name");

			loc.setId(locationID);
			loc.setName(locationName);
		}else if(qName.equalsIgnoreCase("Description")){
			
		}else if(qName.equalsIgnoreCase("Exit")){
			ex = new Location();
			String exitTitle = attr.getValue("title");
			String exitDir = attr.getValue("direction");
			
			loc.setTitle(exitTitle);
			loc.setDirection(exitDir);
			
		}else if(qName.equalsIgnoreCase("GameCharacter")){
			gChar = new Location();
			String charName = attr.getValue("name");
			int charId = Integer.parseInt(attr.getValue("id"));
			
			gChar.setName(charName);
			gChar.setId(charId);
			System.out.println("The character that appeared is:" + gameCharacter);
			
		}else if(qName.equalsIgnoreCase("Item")){
//			itm = new Item();
//			String itemName = attr.getValue("name");
//			int itemVal = Integer.parseInt(attr.getValue("value"));
//			//int itemLoc = Integer.parseInt(attr.getValue("id"));
//			
//			itm.setName(itemName);
//			itm.setValue(itemVal);
			//itm.setLocation(itemLoc);
			
			
			
		}else if(qName.equalsIgnoreCase("SearchAlgorithm")){
			
		}
	}
	public void endElement(String uri, String localName, String qName)
				throws SAXException{
		if(qName.equalsIgnoreCase("Location")){
			//add it to the list
			locat.add(loc);
		}else if(qName.equalsIgnoreCase("id")){
			loc.setId(Integer.parseInt(temp));
		}else if(qName.equalsIgnoreCase("name")){
			loc.setName(temp);
		}else if(qName.equalsIgnoreCase("description")){
			loc.setDescription(temp);
		}else if(qName.equalsIgnoreCase("exit")){
			loc.setExit(temp);
		}else if(qName.equalsIgnoreCase("directions")){
			loc.setDirection(temp);
		}else if (qName.equalsIgnoreCase("game-character")){
			loc.setCharacter(temp);
		}
		
	}
	public List<Location> getLocList() {
	        return locat;
	    }
	public void setLocList(ArrayList<Location> locat) {
		this.locat = locat;
	}
	
	private void readList() {
		System.out.println("Number of locations: " +locat.size() + " " );
		Iterator<Location> it = locat.iterator();	
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}
}