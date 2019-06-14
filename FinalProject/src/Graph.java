
/**
 * Class that creates the graph , determines which nodes will share a ride and prints the answer.
 * @author Tomas Navarro
 * @author Pablo Correa
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Graph {

    int num_Nodes;
    float p;
    private HashMap<Integer,Node> Map = new HashMap<>();
    private ArrayList<Integer>indices = new ArrayList<>();

    public Graph(int num_Nodes, float p) {
        this.num_Nodes = num_Nodes;
        this.p = p;
    }

    public Node getNode(int node_id){
        return Map.get(node_id);
    }

    public void addSuccesor (int id_node_Source, int id_node_Destiny, int cost){

        Node node_Destiny = Map.get(id_node_Destiny);
        Node node_Source = Map.get(id_node_Source);

        Edge edge = new Edge(node_Source, node_Destiny, cost);

        if (id_node_Destiny == 1) {
            node_Source.setF(cost);
        }else node_Source.edgesToGo.add(edge);

    }

    public void addNode(Node node){
        Map.put(node.getID(),node);
    }


    public void pasajeros(int idNodeI, int idNodeF, int idNor, int taci, int tacs, int contp, int f){

       // System.out.println(idNodeI + ":" + idNodeF + ":" + idNor + ":" + taci + ":" + tacs + ":" + contp+ ":" + f);

        if (idNodeI == idNor && !Map.get(idNor).rideSharing) {

            Map.get(idNor).peopleToPickUp.add(Map.get(idNor));
            indices.add(idNor);
        }

        int g_star = 0;

        if (contp < 5 && !Map.get(idNodeI).rideSharing){
            tacs = 1000000;

            for(int i = 0; i < Map.get(idNodeI).edgesToGo.size(); i++){
                int aux = Map.get(idNodeI).edgesToGo.get(i).node_Destiny.getID();

                if(!Map.get(idNodeI).edgesToGo.get(i).node_Destiny.rideSharing || idNodeI != aux) {

                    int g = Map.get(idNodeI).edgesToGo.get(i).getCost();
                    int h = Map.get(idNodeI).edgesToGo.get(i).node_Destiny.getF();

                    int tcalc = taci + g + h;


                    boolean comparator = true;

                    if (tacs > tcalc) {
                        tacs = tcalc;
                        idNodeF = aux;
                        g_star = g;

                    }else comparator = false;

                    if (tacs < p * f && comparator) {
                        Map.get(idNor).peopleToPickUp.add(Map.get(idNodeF));
                        Map.get(idNodeF).rideSharing = true;
                        pasajeros(idNodeF, 1, idNor, taci + g_star, 0, contp, f);
                    }

                }
            }

            Map.get(idNor).rideSharing = true;

        }

    }

    public void getSolution(int num_Nodes, float p){

      final String nombreDelArchivo = "result-ejemplo-U="+num_Nodes+"-p="+p+".txt";

      try {
          PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");

          Node[] tempArr = new Node[indices.size()];

          for(int i = 0; i < indices.size(); i++){

              tempArr[i] = Map.get(indices.get(i));

          }

          for(int i = 0; i < tempArr.length; i++){

              escritor.print("Node Car: "+tempArr[i].getID()+" Nodes to pick up: ");
              for(int j = 0; j < tempArr[i].peopleToPickUp.size(); j++) {
                  escritor.print(tempArr[i].peopleToPickUp.get(j).getID() + "-");
              }
              escritor.println();
          }

          System.out.println("Carros Usados: " + tempArr.length);
          System.out.println("Reduccion de Carros Total: " + (num_Nodes - tempArr.length));
          escritor.close();
      }
      catch(IOException ioe) {
          System.out.println("Error escribiendo el archivo de salida " + ioe.getMessage() );
      }

    }

}
