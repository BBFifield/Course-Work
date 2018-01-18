/**
 * Created by Brandon on 2017-01-19. Student I.D.: 201238730
 * Creates entrant objects.
 */
public class Entrant {
    private String name;
    private int entryNumber;
    private int completionTime;

    /**
     * Constructs and entrant object.
     * @param name - the name of the entrant.
     */
    public Entrant(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the entrant.
     * @return the name of the entrant.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the entry number of the entrant.
     * @return the entry number.
     */
    public int getEntryNumber() {
        return entryNumber;
    }

    /**
     * Gets the completion time for the competition for this entrant.
     * @return the completition time.
     */
    public int getCompletionTime() {
        return completionTime;
    }

    /**
     * Sets the name of the entrant.
     * @param name - the name of the entrant to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the entry number of the entrant.
     * @param entryNumber - the entry number of the entrant.
     */
    public void setEntryNumber(int entryNumber) {
        this.entryNumber = entryNumber;
    }

    /**
     * Sets the completition time for the entrant for the race.
     * @param completionTime - the completion time for the entrant.
     */
    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * Gets a string which was converted from info of the entrant.
     * @return the string.
     */
    public String toString() {
        return String.format("Entrant Number: %d%nName: %s%nCompletion Time: %d mins%n%n",entryNumber, name, completionTime);
    }
}
