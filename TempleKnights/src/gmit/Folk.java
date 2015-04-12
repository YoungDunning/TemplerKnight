package gmit;
/*
 * g00284875 Patrick Dunning
 * Temple Knights Text based Game
 */

public class Folk extends AbstractGameCharacter{
	private float life = 40.00f;
	
	
	//Once a run() returns, the thread dies
	public void run() {
		while (life > 0.00f){
			//Do some stuff.
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(this.getName() + " has just died...");
	}


	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}

}
