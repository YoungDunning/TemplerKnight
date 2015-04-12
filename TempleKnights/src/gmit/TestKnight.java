package gmit;
/*
 * g00284875 Patrick Dunning
 * Temple Knights Text based Game
 */

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class TestKnight {
	public static void main(String[] args) throws Exception{
		String name = "fcl/templerknight.fcl";
		FIS fis = FIS.load(name, true);
		
		if(fis == null){
			System.err.println("Can't load file: " + name + "'");
			return;
		}
		FunctionBlock fBlock = fis.getFunctionBlock("knight");
		
		 // Show 
		JFuzzyChart.get().chart(fBlock);
        
		// Set inputs		
		fis.setVariable("hit", 5.5);
		fis.setVariable("opponent", 4.5);
		
		// Evaluate
		fis.evaluate();
		
		// Show output variable's chart
		Variable life = fBlock.getVariable("life");
		JFuzzyChart.get().chart(life, life.getDefuzzifier(), true);
		
		//Print
		System.out.println(fis);
	}
}
