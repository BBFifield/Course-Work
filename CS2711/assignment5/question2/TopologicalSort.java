import java.util.Stack;

/**
 * Created by Brandon on 2017-03-16. None of this works for question2 but I submitted some work
 * that might look what the final compilable class files would look like anyways.
 */
public class TopologicalSort {

    public static void topologicalSort(DiGraph<Integer> graph) {
        Stack s = new Stack();
        for(DiVertex<Integer> v: graph.vertices()) {
            if(v.inCounter() == 0) {
                s.push(v);
            }
        }
        int index = 1;
        while(!s.isEmpty()) {
            DiVertex<Integer> v = (DiVertex<Integer>) s.pop();
            index++;
           // for(DiEdge<String> e: v.outGoing()) {
        //        e.getW().inCounter()--;
          //      if(e.getW().inCounter() == 0) {
            //        s.push(w);
            //    }
           // }
        }
    }
}
