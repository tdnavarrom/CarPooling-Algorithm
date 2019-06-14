import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Reader{

  static ArrayList<Node> arr = new ArrayList<>();

  public static Graph readFile(int num_Nodes, float p){
    final String nombreDelArchivo = "dataset-ejemplo-U="+num_Nodes+"-p="+p+".txt";



    Graph graph = new Graph(num_Nodes, p);
    try {
      BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
      String lineaActual = br.readLine();
      String [] cadenaParticionada;
      for (int i = 0; i < 3; i++) lineaActual = br.readLine(); // Descarta las siguientes 3 lineas
      
      for (int i = 0; i < num_Nodes; i++){

        lineaActual = br.readLine();

        cadenaParticionada = lineaActual.split(" ");
        int id = Integer.parseInt(cadenaParticionada[0]);
        double cord_x = Double.parseDouble(cadenaParticionada[1]);
        double cord_y = Double.parseDouble(cadenaParticionada[2]);

        Node nodeTemp;

        if (cadenaParticionada.length == 4){
          String name = cadenaParticionada[3];
          nodeTemp = new Node(id, cord_x, cord_y, name);
        }else {
          nodeTemp = new Node(id, cord_x, cord_y);
        }



        graph.addNode(nodeTemp);
      }

      for (int i = 0; i <= 3; i++) lineaActual = br.readLine();

      while(lineaActual != null){
        cadenaParticionada = lineaActual.split(" ");
        int id_node_Source = Integer.parseInt(cadenaParticionada[0]);
        int id_node_Destiny = Integer.parseInt(cadenaParticionada[1]);
        int cost = Integer.parseInt(cadenaParticionada[2]);

        if(id_node_Destiny != id_node_Source) graph.addSuccesor(id_node_Source,id_node_Destiny,cost);

        if (id_node_Destiny == 1) {
          arr.add(graph.getNode(id_node_Source));
        }

        lineaActual = br.readLine();

      }

      br.close();

    }catch(IOException ioe) {
      System.out.println("Error leyendo el archivo de entrada: " + ioe.getMessage());
    }

    return graph;
  }


  public static void main(String[] args){

    float p = 1.1f;
    int v = 11;

    long beforeUsedMem= Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long startTime = 0;
    long endTime=0;

    Graph graph = readFile(v, p);


    Collections.sort(arr);

    for(Node n: arr){
      Collections.sort(n.edgesToGo, Comparator.comparing(Edge::getCost));
    }

    startTime=System.currentTimeMillis();

    graph.getNode(1).rideSharing = true;

    for(int i = arr.size() - 1; i >= 0; i--){

      if (!arr.get(i).rideSharing){
        int tacs = 0;
        int taci = 0;
        int contp = 0;
        int idNodeI = arr.get(i).getID();
        int idNodeF = 1;
        int f = arr.get(i).getF();
        int idNor = idNodeI;

        graph.pasajeros(idNodeI, idNodeF, idNor, taci, tacs, contp, f);

      }

    }

    endTime = System.currentTimeMillis();

    graph.getSolution(v, p);


    long timeElapsed = endTime - startTime;
    System.out.println("Execution time in milliseconds: " + timeElapsed);

    long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
    long actualMemUsed=afterUsedMem-beforeUsedMem;
    System.out.println("Memory used " + actualMemUsed + "mb");

  }

}
