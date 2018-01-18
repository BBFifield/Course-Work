import java.util.ArrayList;

/**
 * Created by Brandon on 2017-03-16. Student I.D.: 201238730
 * A class used to supply vertices to the Adjacency List Graph ADT.
 */
public class Vertex<E> {

    private E element;
    private ArrayList<Edge<E>> incidenceCollection;

    /**
     * Constructs vertex objects
     * @param element - the element to be stored at this vertex
     */
    public Vertex(E element) {
        this.element = element;
        this.incidenceCollection = new ArrayList<>();
    }

    /**
     * Gets the element stored at this vertex
     * @return the element stored at this vertex
     */
    public E getElement() {
        return this.element;
    }

    /**
     * Sets the element to be stored at this vertex
     * @param element - the element to be set
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Adds an incident edge to this vertex
     * @param edge - the edge to be added
     */
    public void addIncidentEdge(Edge<E> edge) {
        if(this.incidenceCollection.contains(edge)) {
            return;
        }
        this.incidenceCollection.add(edge);
    }

    /**
     * Checks to see if an edge is an incident edge on this vertex
     * @param edge - the edge to be checked
     * @return
     */
    public boolean hasEdge(Edge<E> edge) {
        return this.incidenceCollection.contains(edge);
    }

    /**
     * Gets the number of incident edges associated with this vertex
     * @return the size of the list.
     */
    public int getIncidenceCollectionSize() {
        return this.incidenceCollection.size();
    }

    /**
     * Gets the incident edges associated with this vertex
     * @return an ArrayList of incident edges.
     */
    public ArrayList<Edge<E>> getIncidenceCollection() {
        return this.incidenceCollection;
    }

    /**
     * Removes incident edge from this vertex
     * @param position - the position of the edge to be removed in the list.
     * @return the edge which was removed
     */
    public Edge<E> removeEdge(int position) {
        return this.incidenceCollection.remove(position);
    }

    /**
     * Removes an incident edge from this vertex
     * @param edge - the edge to be removed
     */
    public void removeEdge(Edge<E> edge) {
        this.incidenceCollection.remove(edge);
    }

    /**
     * Determines whether or not two vertices are the same
     * @param otherVertex - the vertex to be compared to
     * @return a boolean value representing true if one is equal to the other, false otherwise
     */
    public boolean equals(Object otherVertex) {
        if(otherVertex.getClass() != Vertex.class) {
            throw new RuntimeException("InvalidComparisonException: Not an instance of class Vertex.");
        }
        Vertex<E> v = (Vertex<E>) otherVertex;
        return this.element.equals(v.element);
    }

    /**
     * Gets a string representation of the element at this vertex.
     * @return a string of this vertex object.
     */
    public String toString() {
        return "Vertex: " + element.toString();
    }
}
