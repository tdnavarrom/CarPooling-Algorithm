
/**
 * Class that represents an edge or arc in the graph
 * @author Tomas Navarro
 * @author Pablo Correa
 */
public class Edge implements Comparable<Edge> {

    private int cost;
    Node node_Source, node_Destiny;

    public Edge(Node node_Source, Node node_Destiny, int cost){
      this.node_Source = node_Source;
      this.node_Destiny = node_Destiny;
      this.cost = cost;
    }

    public int getCost(){
      return this.cost;
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.cost, edge.getCost());
    }
}
