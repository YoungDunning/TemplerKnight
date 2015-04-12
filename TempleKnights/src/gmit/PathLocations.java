package gmit;
/*
 * g00284875 Patrick Dunning
 * Temple Knights Text based Game
 */
public class PathLocations {
	private static PathLocations path = new PathLocations();
	private Node baytSahur;

	public static void main(String[] args) {
		PathLocations.getInstance();
	}

	public static PathLocations getInstance() {
		return path;
	}

	private void transverse(Node n) {
		System.out.println(n);
		n.setVisited(true); // paint the node as visited

		Node[] children = n.children();
		for (int i = 0; i < children.length; i++) {
			if (!children[i].isVisited()) {
				transverse(children[i]);
			}
		}
	}

	public PathLocations() {

		baytSahur = new Node("Bayt Sahur", 416);
		Node templeMnt = new Node("Temple Mount", 408);
		Node jaba = new Node("Jaba", 401);
		Node nazareth = new Node("Nazareth", 320);
		Node alQun = new Node("Al Qunaitra", 313);
		Node damascus = new Node("Damascus", 318);
		Node qarah = new Node("Qarah", 322);
		Node hamah = new Node("Hamah", 302);
		Node antioch = new Node("Antioch", 70);// ish
		Node netanya = new Node("Netanya", 338);
		Node haifa = new Node("Haifa", 296);
		Node sidon = new Node("Sidon District", 249);
		Node beirut = new Node("Beirut", 234);
		Node tripoli = new Node("Tripoli", 219);
		Node latakia = new Node("Latakia", 218);

		Node cyprus = new Node("Cyprus", 0);
		cyprus.setGoalNode(true);

		baytSahur.setDanger(0.0f);
		baytSahur.addChildNode(templeMnt, 100);

		templeMnt.setDanger(0.3f);
		templeMnt.addChildNode(jaba, 29);
		templeMnt.addChildNode(netanya, 99);
		templeMnt.addChildNode(baytSahur, 21);

		jaba.setDanger(0.3f);
		jaba.addChildNode(templeMnt, 29);
		jaba.addChildNode(nazareth, 150);
		jaba.addChildNode(netanya, 99);

		nazareth.setDanger(0.5f);
		nazareth.addChildNode(jaba, 150);
		nazareth.addChildNode(alQun, 75);
		nazareth.addChildNode(haifa, 44);

		alQun.setDanger(0.4f);
		alQun.addChildNode(damascus, 65);
		alQun.addChildNode(nazareth, 75);
		alQun.addChildNode(sidon, 85);
		alQun.addChildNode(beirut, 140);

		damascus.setDanger(0.3f);
		damascus.addChildNode(alQun, 65);
		damascus.addChildNode(qarah, 97);
		damascus.addChildNode(beirut, 50);

		qarah.setDanger(0.2f);
		qarah.addChildNode(damascus, 97);
		qarah.addChildNode(hamah, 123);
		qarah.addChildNode(tripoli, 85);
		qarah.addChildNode(beirut, 90);

		hamah.setDanger(0.6f);
		hamah.addChildNode(qarah, 123);
		hamah.addChildNode(antioch, 180);
		hamah.addChildNode(tripoli, 140);
		hamah.addChildNode(latakia, 138);

		antioch.setDanger(0.8f);
		antioch.addChildNode(hamah, 180);
		antioch.addChildNode(latakia, 138);
		antioch.addChildNode(cyprus, 75);

		netanya.setDanger(0.5f);
		netanya.addChildNode(jaba, 99);
		netanya.addChildNode(haifa, 64);
		netanya.addChildNode(templeMnt, 99);

		haifa.setDanger(0.5f);
		haifa.addChildNode(netanya, 64);
		haifa.addChildNode(nazareth, 44);
		haifa.addChildNode(sidon, 80);

		sidon.setDanger(0.6f);
		sidon.addChildNode(haifa, 80);
		sidon.addChildNode(beirut, 43);
		sidon.addChildNode(alQun, 85);

		beirut.setDanger(0.8f);
		beirut.addChildNode(sidon, 43);
		beirut.addChildNode(tripoli, 140);
		beirut.addChildNode(alQun, 140);
		beirut.addChildNode(damascus, 50);
		beirut.addChildNode(qarah, 90);

		tripoli.setDanger(1.0f);
		tripoli.addChildNode(beirut, 80);
		tripoli.addChildNode(latakia, 140);
		tripoli.addChildNode(qarah, 85);
		tripoli.addChildNode(hamah, 140);

		latakia.setDanger(0.7f);
		latakia.addChildNode(antioch, 90);
		latakia.addChildNode(hamah, 138);
		latakia.addChildNode(tripoli, 140);

		// Dont know how long as you got to include boat journey
		cyprus.setDanger(0.5f);
		cyprus.addChildNode(antioch, 75);

		transverse(cyprus);
	}

	public Node getStartNode() {
		return baytSahur;
	}
	
}