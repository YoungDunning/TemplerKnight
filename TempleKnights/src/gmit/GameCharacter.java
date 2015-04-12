package gmit;
/*
 * g00284875 Patrick Dunning
 * Temple Knights Text based Game
 */

public interface GameCharacter extends Runnable
{
	public abstract String getName();
	public abstract int getId();

	public abstract void setName(String name);
	public abstract void setId(int id);

}
