package inte_datos;

import java.util.ArrayList;

public class Node implements Comparable<Node>{

  private int idNode;

  private int f;

  private double cord_x;
  private double cord_y;
  private final String name;

  ArrayList<Edge> edgesToGo;
  ArrayList<Node> peopleToPickUp = new ArrayList<>();
  boolean rideSharing;

  public Node(int idNode, double cord_x, double cord_y, String name){
    this.idNode = idNode;
    this.cord_x = cord_x;
    this.cord_y = cord_y;
    this.name = name;
    this.rideSharing = false;
    this.edgesToGo = new ArrayList<>();

  }

  public Node(int idNode, double cord_x, double cord_y){
    this.idNode = idNode;
    this.cord_x = cord_x;
    this.cord_y = cord_y;
    this.rideSharing = false;
    this.edgesToGo = new ArrayList<>();
    this.name = "";
    
  }

  @Override
  public int compareTo(Node o) {
    return Integer.compare(this.f, o.getF());
  }

  public int getF(){
    return this.f;
  }

  public void setF(int f){
    this.f = f;
  }

  public int getID(){
    return idNode;
  }

}
