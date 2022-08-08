import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;

class SimpleGraphView {
	public

	    Graph<Integer, String> g;
	    
	    public SimpleGraphView() {
	        
	        g = new SparseGraph<Integer, String>();
	        
	        g.addVertex((Integer)1);
	        g.addVertex((Integer)2);
	        g.addVertex((Integer)3); 
	        g.addVertex((Integer)4); 

	        
	        g.addEdge("Edge-A", 1, 2); 
	        g.addEdge("Edge-B", 2, 3);
	        g.addEdge("Edge-C", 1, 3);
	        g.addEdge("Edge-D", 3, 4);
	        
	    }

}
