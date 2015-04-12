package gmit;
/*
 * g00284875 Patrick Dunning
 * Temple Knights Text based Game
 */
public class HeuristicCalculator {

	public static float getHeuristicValue(int distanceTravelled,
			int approxGoalDistance, float terrain, float danger) {
		return distanceTravelled + approxGoalDistance
				+ (approxGoalDistance * terrain)
				+ (approxGoalDistance * danger);
	}

}
