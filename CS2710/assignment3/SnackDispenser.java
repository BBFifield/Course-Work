/**
 *
 * @author Brandon FIfield Student ID: 201238730
 */
public class SnackDispenser {
    public static final int MAX_COINS = 100;
    public static final double MAX_ITEMS = 40;
   
    private int numCoins;
    private int numItems;
    
    public SnackDispenser(int initialCoins, int initialItems) {
        this.numCoins = initialCoins;
        this.numItems = initialItems;
    }
    
    public void removeCoins() {
        this.numCoins = 0;
    }
    
    public void restock(int refillNum) {
        if(numItems + refillNum > MAX_ITEMS) throw new IllegalArgumentException("h");
        else this.numItems += refillNum;
    }
    
    public int getNumCoins() {
        return numCoins;
    }
    
    public int getNumItems() {
        return numItems;
    }
    
    public String toString() {
        return String.format("Number of Coins in Dispenser: %d%n Number of snacks in dispenser: %d%n%n", numCoins, numItems);
    }
}
