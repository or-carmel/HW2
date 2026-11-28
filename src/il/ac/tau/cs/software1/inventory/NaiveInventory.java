package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;
	private Collectible[] items;
	private int counts;

	public NaiveInventory() {
		items = new Collectible[INITIAL_CAPACITY];
	}

	@Override
	public void collect(Collectible collectible) {
	    if (counts == items.length) {
        	Collectible[] items1 = new Collectible[2 * items.length];
        	for (int j = 0; j < counts; j++) {
            	items1[j] = items[j];
        	}
        	items = items1;
    	}
    	items[counts] = collectible;
    	counts++;
    }


	@Override
	public float getTotalWeight() {
		float totalWeight = 0;
		for (int i = 0; i < counts; i++) {
        	totalWeight += items[i].getWeight();
    	}
    	return totalWeight;
	}

	@Override
	public int getCurrentCount() {
		return counts;
	}

	public Collectible[] getCollArr() {
		return items;
	}
}
