import java.util.ArrayList;

/**
 * Created by Brandon on 2017-03-16. Student I.D.: 201238730.
 * This is a class which uses an adjacency list to implement the graph ADT.
 */
public class AdjacencyListGraph<E> {

    private ArrayList<Vertex<E>> vertices;
    private ArrayList<Edge<E>> edges;

    /**
     * Constructs a new graph object in the form of an adjacency list.
     * @param v - an ArrayList containing all the vertices in the graph.
     * @param e - an ArrayList collection containing all the edges in the graph.
     */
    public AdjacencyListGraph(ArrayList<Vertex<E>> v, ArrayList<Edge<E>> e) {
        this.vertices = v;
        this.edges = e;
    }

    /**
     * Gets a collection of all the vertices of the graph.
     * @return an ArrayList of all the vertices of the graph.
     */
    public ArrayList<Vertex<E>> vertices() {
        return this.vertices;
    }

    /**
     * Gets a colleciton of all the edges of the graph.
     * @return an ArrayList of all the edges of the graph.
     */
    public ArrayList<Edge<E>> edges() {
        return this.edges;
    }

    /**
     * Gets a collection of all the incident edges of a supplied vertex.
     * @param v - the vertex to get the incident edges of v
     * @return an ArrayList of the incident edges of v
     */
    public ArrayList<Edge<E>> incidentEdges(Vertex v) {
        return v.getIncidenceCollection();
    }

    /**
     * Gets the vertex opposite of the supplied vertex on the specified edge.
     * @param v - the supplied vertex
     * @param e - the supplied edge
     * @return
     */
    public Vertex<E> opposite(Vertex<E> v, Edge<E> e) {
        if(v != e.getV() || v != e.getW()) {
            throw new RuntimeException("InvalidVertexException: Vertex is not incident on given Edge");
        }
        if(v == e.getV()) { return e.getW(); }
        return e.getV();
    }

    /**
     * Gets an array of the end vertices of a specified edge.
     * @param e - the supplied edge
     * @return the endpoints of an edge
     */
    public Vertex<E>[] endVertices(Edge<E> e) {
        return new Vertex[]{e.getV(),e.getW()};
    }

    public boolean areAdjacent(Vertex<E> v, Vertex<E> w) {
        ArrayList<Edge<E>> incidenceCollectionV = v.getIncidenceCollection();
        ArrayList<Edge<E>> incidenceCollectionW = v.getIncidenceCollection();

        for(Edge e:incidenceCollectionV) {
            if(incidenceCollectionW.contains(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Replaces the element in a supplied vertex with a different element.
     * @param v - the vertex whose element will be swapped.
     * @param x - the element which will be swapped in.
     */
    public void replace(Vertex<E> v, E x) {
        v.setElement(x);
    }

    /**
     * Replace the element at the specified edge.
     * @param e - the edge whose element will be swapped
     * @param x - the element which will be swapped in.
     */
    public void replace(Edge<E> e, E x) {
        e.setElement(x);
    }
}
