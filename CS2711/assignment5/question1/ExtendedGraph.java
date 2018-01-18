import java.util.ArrayList;

/**
 * Created by Brandon on 2017-03-16. Student I.D.: 201238730.
 * An extension of the AdjacencyGraph class adds update methods functionality.
 */
public class ExtendedGraph<E> extends AdjacencyListGraph<E> {

    /**
     * Constructs a new graph object in the form of an adjacency list.
     * @param v - an ArrayList containing all the vertices in the graph.
     * @param e - an ArrayList collection containing all the edges in the graph.
     */
    public ExtendedGraph(ArrayList<Vertex<E>> v, ArrayList<Edge<E>> e) {
        super(v,e);
    }

    /**
     * Inserts and then returns the vertex inserted into the graph.
     * @param element - the element to be inserted
     * @return return a vertex created using the element supplied.
     */
    public Vertex insertVertex(E element) {
        Vertex v = new Vertex<E>(element);
        vertices().add(v);
        return v;
    }

    /**
     * Inserts an edge into the graph given two end vertices and an element to be stored at the edge.
     * @param v - the first end vertex
     * @param w - the second end vertex
     * @param element - the element to be stored at the edge
     * @return the edge which was created and inserted.
     */
    public Edge insertEdge(Vertex<E> v, Vertex<E> w, E element) {
        Edge<E> e = new Edge(v,w,element);
        vertices().add(v);
        vertices().add(w);
        v.addIncidentEdge(e);
        w.addIncidentEdge(e);
        edges().add(e);
        return e;
    }

    /**
     * Removes a specified vertex from the graph
     * @param v - the vertex to be removed
     * @return the element from the vertex that was removed.
     */
    public E removeVertex(Vertex<E> v) {
        ArrayList<Edge<E>> incidenceEdgesV = v.getIncidenceCollection();
        for(int i = incidenceEdgesV.size() - 1; i >= 0; i--) {
            removeEdge(incidenceEdgesV.get(i));
        }
        vertices().remove(v);
        return v.getElement();
    }

    /**
     * Removes a specified edge from the graph
     * @param e - the edge to be removed
     * @return the element from the edge which was removed.
     */
    public E removeEdge(Edge<E> e) {
        Vertex<E> v = e.getV();
        Vertex<E> w = e.getW();
        v.removeEdge(e);
        w.removeEdge(e);
        return e.getElement();
    }
}
