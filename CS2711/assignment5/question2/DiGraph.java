import java.util.ArrayList;

    /**
     * Created by Brandon on 2017-03-16. None of this works for question2 but I submitted some work
     * that might look what the final compilable class files would look like anyways.
     */
public class DiGraph<E> {

    private ArrayList<DiVertex<E>> vertices;
    private ArrayList<DiEdge<E>> DiEdges;

    public DiGraph(ArrayList<DiVertex<E>> v, ArrayList<DiEdge<E>> e) {
        this.vertices = v;
        this.DiEdges = e;
    }

    public ArrayList<DiVertex<E>> vertices() {
        return this.vertices;
    }

    public ArrayList<DiEdge<E>> DiEdges() {
        return this.DiEdges;
    }

    public ArrayList<DiEdge<E>> incidentDiEdges(DiVertex v) {
        return v.getIncidenceCollection();
    }

    public DiVertex<E> opposite(DiVertex<E> v, DiEdge<E> e) {
        if (v != e.getV() || v != e.getW()) {
            throw new RuntimeException("InvalidDiVertexException: DiVertex is not incident on given DiEdge");
        }
        if (v == e.getV()) {
            return e.getW();
        }
        return e.getV();
    }

    public DiVertex<E>[] endVertices(DiEdge<E> e) {
        return new DiVertex[]{e.getV(), e.getW()};
    }

    public boolean areAdjacent(DiVertex<E> v, DiVertex<E> w) {
        ArrayList<Edge<E>> incidenceCollectionV = v.getIncidenceCollection();
        ArrayList<Edge<E>> incidenceCollectionW = v.getIncidenceCollection();

        for (Edge e : incidenceCollectionV) {
            if (incidenceCollectionW.contains(e)) {
                return true;
            }
        }
        return false;
    }

    public void replace(DiVertex<E> v, E x) {
        v.setElement(x);
    }

    public void replace(DiEdge<E> e, E x) {
        e.setElement(x);
    }

    public DiVertex insertDiVertex(E element) {
        DiVertex v = new DiVertex<E>(element);
        vertices().add(v);
        return v;
    }
    }
    /**
    public Edge insertDiEdge(DiVertex<E> v, DiVertex<E> w, E element) {
        Edge<E> e = new Edge(v, w, element);
        vertices().add(v);
        vertices().add(w);
        v.addIncidentEdge(e);
        w.addIncidentEdge(e);
        DiEdges().add(e);
        return e;
    }
    /**
    public E removeDiVertex(DiVertex<E> v) {
        ArrayList<DiEdge<E>> incidenceDiEdgesV = v.getIncidenceCollection();
        for(int i = incidenceDiEdgesV.size() - 1; i >= 0; i--) {
            removeDiEdge(incidenceDiEdgesV.get(i));
        }
        vertices().remove(v);
        return v.getElement();
    }

    public E removeDiEdge(Edge<E> e) {
        Vertex<E> v = e.getV();
        Vertex<E> w = e.getW();
        v.removeEdge(e);
        w.removeEdge(e);
        return e.getElement();
    }
}**/
