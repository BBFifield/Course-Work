import java.util.ArrayList;

/**
 * Created by Brandon on 2017-03-16. Student I.D.: 201238730
 * A class to test the both Graph classes (AdjacencyListGraph and Extended Graph)
 */
public class GraphRunner {
    public static void main(String[] args) {
        //Create new ArrayLists of vertices and edges and then pass them to a AdjacencyListGraph constructor.
        ArrayList<Vertex<String>> vertices = new ArrayList<>();
        vertices.add(new Vertex<String>("Brandon"));
        vertices.add(new Vertex<String>("Shawn"));
        vertices.add(new Vertex<String>("Spencer"));
        vertices.add(new Vertex<String>("Lucas"));
        vertices.add(new Vertex<String>("Adam"));
        vertices.add(new Vertex<String>("Griffin"));
        vertices.add(new Vertex<String>("Michelle"));
        vertices.add(new Vertex<String>("Ben"));

        ArrayList<Edge<String>> edges = new ArrayList<>();
        edges.add(new Edge<String>(vertices.get(0), vertices.get(1), "Dog"));
        edges.add(new Edge<String>(vertices.get(1), vertices.get(2), "Cat"));
        edges.add(new Edge<String>(vertices.get(2), vertices.get(3), "Horse"));
        edges.add(new Edge<String>(vertices.get(3), vertices.get(4), "Bird"));
        edges.add(new Edge<String>(vertices.get(4), vertices.get(5), "Wolf"));
        edges.add(new Edge<String>(vertices.get(5), vertices.get(6), "Squirrel"));
        edges.add(new Edge<String>(vertices.get(6), vertices.get(7), "House"));

        AdjacencyListGraph<String> graph = new ExtendedGraph<>(vertices, edges);

        //Initial Graph Structure
        System.out.println("Outputting all incidence edges of every vertex in the initial Graph structure. \n");
        for(Vertex<String> v: vertices) {
            System.out.println(v + "  Degree: " + v.getIncidenceCollection().size());
            for (Edge<String> e : v.getIncidenceCollection()) {
                System.out.println(e);
            }
            System.out.println();
        }

        //Using the replace method and then outputting contents again.
        System.out.print("________________________________________________________________________________________________________________________________");
        System.out.println("\nRenaming Spencer to Solomon, and Adam to Allan and outputting all incidence edges of each vertex again to show results.\n");
        graph.replace(vertices.get(2),"Solomon");
        graph.replace(vertices.get(4),"Allan");
        for(Vertex<String> v: vertices) {
            System.out.println(v + "  Degree: " + v.getIncidenceCollection().size());
            for (Edge<String> e : v.getIncidenceCollection()) {
                System.out.println(e);
            }
            System.out.println();
        }

        //Using the remove method and outputting the contents
        System.out.println("______________________________________________________________________________________________");
        System.out.println("Removing vertex that contains Solomon and then outputting all incidence edges of extended graph.\n");
        ExtendedGraph<String> extendedGraph = (ExtendedGraph<String>) graph;
        extendedGraph.removeVertex(vertices.get(2));
        for(Vertex<String> v: extendedGraph.vertices()) {
            System.out.println(v + "  Degree: " + v.getIncidenceCollection().size());
            for (Edge<String> e : v.getIncidenceCollection()) {
                System.out.println(e);
            }
            System.out.println();
        }

        //Using the insert method and outputting the contents
        System.out.println("______________________________________________________________________________________________");
        System.out.println("Testing the addition of a new edge.\n");
        Vertex<String> newVertexOne = new Vertex<>("Brodie");
        Vertex<String> newVertexTwo = new Vertex<>("Mya");
        extendedGraph.insertEdge(newVertexOne,newVertexTwo,"Ball");
        for(Vertex<String> v: extendedGraph.vertices()) {
            System.out.println(v + "  Degree: " + v.getIncidenceCollection().size());
            for (Edge<String> e : v.getIncidenceCollection()) {
                System.out.println(e);
            }
            System.out.println();
        }
    }
}
