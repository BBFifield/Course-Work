/**
 * Created by Brandon on 2017-03-16. None of this works for question2 but I submitted some work
 * that might look what the final compilable class files would look like anyways.
 */
public class DiEdge<E> implements Comparable<E> {
    private E element;
    private DiVertex<E> v;
    private DiVertex<E> w;

    /**
     * Constructs and DiEdge to be used in the Graph ADT.
     * @param v - a DiVertex on one side of the DiEdge
     * @param w - a DiVertex on the other side of the DiEdge.
     */
   /** public DiEdge(DiVertex<E> v, DiVertex<E> w, E element) {
        if(v.compareTo(w.getElement()) <=0) {
            this.v = v;
        }
        else {
            this.w = w;
        }
        this.element = element;
    }
**/
    public int compareTo(E element) {
        return -1;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DiVertex<E> getV() {
        return v;
    }

    public DiVertex<E> getW() {
        return w;
    }

    public boolean equals(Object otherDiEdge) {
        if(otherDiEdge.getClass() != DiEdge.class) {
            return false;
        }
        DiEdge<E> e = (DiEdge<E>) otherDiEdge;
        return e.v.equals(this.v) && e.w.equals(this.w);
    }

    public String toString() {
        return "DiVertex v: " + v.getElement() + "   DiVertex w: " + w.getElement() + "   DiEdge: " + element;
    }




}
