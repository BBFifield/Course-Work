import java.util.ArrayList;

/**
 * Created by Brandon on 2017-03-16. Student I.D.: 201238730.
 * A class which creates Edge objects to be used with the graph adt.
 */
public class Edge<E> {

    private E element;
    private Vertex<E> v;
    private Vertex<E> w;

    /**
     * Constructs an edge given two vertices.
     * @param v - a vertex on one side of the edge
     * @param w - a vertex on the other side of the edge.
     */
    public Edge(Vertex<E> v, Vertex<E> w, E element) {
        this.v = v;
        this.w = w;
        this.element = element;

        //Add this edge to the vertices' respective incidentEdge lists.
        this.v.addIncidentEdge(this);
        this.w.addIncidentEdge(this);
    }

    /**
     * Gets the element tied to this edge.
     * @return the element at this edge
     */
    public E getElement() {
        return element;
    }

    /**
     * Sets the element at this edge
     * @param element - the element to be set
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Gets the first vertex at this edge.
     * @return the vertex v
     */
    public Vertex<E> getV() {
        return v;
    }

    /**
     * Gets the second vertex stored at this edge
     * @return the vertex w
     */
    public Vertex<E> getW() {
        return w;
    }

    /**
     * Determines whether or not two edges are the same
     * @param otherEdge - the edge to be compared to
     * @return a boolean value representing true if one is equal to the other, false otherwise
     */
    public boolean equals(Object otherEdge) {
        if(otherEdge.getClass() != Edge.class) {
            return false;
        }
        Edge<E> e = (Edge<E>) otherEdge;
        return e.v.equals(this.v) && e.w.equals(this.w);
    }

    /**
     * Gets a string representation of the element, first vertex, and second vertex at this edge.
     * @return a string of this edge object.
     */
    public String toString() {
        return "Vertex v: " + v.getElement() + "   Vertex w: " + w.getElement() + "   Edge: " + element;
    }
}
