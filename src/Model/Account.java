package Model;

public abstract class Account {
    public static float tariffCheck(int cityMetric1, int cityMetric2, float weight, boolean isFragile) {
    	int basePrice = 3000;
		int pricePerMetric = 2000;
		int pricePerKg = 2000;
		int priceFragileStuff = 10000;
		
		int diffMetric = Math.abs(cityMetric1 - cityMetric2);
		
		int weightRounded = Math.round(weight);
		
		return basePrice + diffMetric * pricePerMetric + weightRounded * pricePerKg + (isFragile ? priceFragileStuff : 0);
    }
}
