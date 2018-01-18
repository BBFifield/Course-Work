/**
 * Created by Brandon on 2017-03-02. Student I.D.: 201238730
 * Interface for implementing positional classes.
 */
public interface Position<E> {
    /**
     * Gets the element in this position
     * @return the element in this position
     */
    public E getElement();

    /**
     * Sets the element in this position
     * @param element - the element to be set
     * @return the element which was set
     */
    public E setElement(E element);
}
