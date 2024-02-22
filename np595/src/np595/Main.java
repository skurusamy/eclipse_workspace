package np595;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Node {
  public int data;
  public List<Node> neighbors;
  public boolean isVisited;

  public Node(final int data) {
    this.data = data;
    this.isVisited = false;
    this.neighbors = new ArrayList<>();
  }
}

class Graph {
    public List<Node> myAdjList;

    public Graph() {
      this.myAdjList = new ArrayList<>();
    }
    void addNode(final int nodeVal){
        Node val = new Node(nodeVal);
        myAdjList.add(val);
    }
    void addUndirectedEdge(final Node first, final Node second){
        if(myAdjList.contains(first) && myAdjList.contains(second) && notTheSame(first,second) 
            && !(first.neighbors.contains(second)) && !(second.neighbors.contains(first)))
        {
            first.neighbors.add(second);
            second.neighbors.add(first);
        }
    }
    void removeUndirectedEdge(final Node first, final Node second){
        if(myAdjList.contains(first) && myAdjList.contains(second) && notTheSame(first,second)){
            first.neighbors.remove(second);
            second.neighbors.remove(first);
        }
    }

    public HashSet<Node> getAllNodes(){
        final HashSet<Node> myNodes = new HashSet<>();
        for(final Node nodeVal: myAdjList){
            if(!(myNodes.contains(nodeVal))){
                myNodes.add(nodeVal);
            }
        }
        return myNodes;
    }
    Node getNodeAtIndx(int i){
      return myAdjList.get(i);
    }
    Node getNode(int value){
       Node found = null;
       for(Node get: myAdjList){
         if(get.data == value){
            found = get;
         }
       }
       return found;
    }
    boolean notTheSame(final Node input1, final Node input2){
      if(input1.data == input2.data){
        return false;
      }
      return true;
    }
    void printMyGraph(){
      for(final Node myNode: myAdjList){
        System.out.print(myNode.data + ": ");
        for(final Node adjacent: myNode.neighbors){
           System.out.print(adjacent.data + " ");
        }
        System.out.println();
      }
    }
}

class Main {
  public static void main(final String[] args) {
    ArrayList<Node> myList = new ArrayList<>();
    ArrayList<Node> myListDfsIter = new ArrayList<>();
    ArrayList<Node> myListBftIter = new ArrayList<>();
    /*
    //GraphSearch tools = new GraphSearch();
    Graph graph = new Graph();
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);
    graph.addNode(5);
    graph.addNode(6);
    graph.addNode(7);
    graph.addNode(8);
    Node one = graph.getNode(1);
    Node two = graph.getNode(2);
    Node three = graph.getNode(3);
    Node four = graph.getNode(4);
    Node five = graph.getNode(5);
    Node six = graph.getNode(6);
    Node seven = graph.getNode(7);
    Node eight = graph.getNode(8);
    graph.addDirectedEdge(one, two);
    graph.addDirectedEdge(two, four);
    graph.addDirectedEdge(three, four);
    graph.addDirectedEdge(one, four);
    graph.addDirectedEdge(three, five);
    graph.addDirectedEdge(four, five);
    graph.addDirectedEdge(four, six);
    graph.addDirectedEdge(six, seven);
    graph.addDirectedEdge(five, seven);
    graph.addDirectedEdge(five, eight);
    //graph.addUndirectedEdge(eight, five);
    graph.printMyGraph();
    
   */

    Graph myGraph = createRandomUnweightedGraph(15);
    GraphSearch tools = new GraphSearch();
    Node four = myGraph.getNode(4);
    Node twelve = myGraph.getNode(12);

    //System.out.println("DFS Recursive 4 to 12: ");
    //myList = tools.DFSRec(four, twelve);
    //printList(myList);
    //System.out.println();

    //System.out.println("DFS Iterative 4 to 12: ");
    //myListDfsIter = tools.DFSIter(four, twelve);
    //printList(myListDfsIter);
    //System.out.println();

    //System.out.println("BFT Iter: ");
    //myListBftIter = tools.BFTIter(myGraph);
    //printList(myListBftIter);
    //System.out.println();  
  }
  
  static void printList(ArrayList<Node> myList){
    for(Node value: myList){
      System.out.print(value.data + " ");
    }
    System.out.println();
  }

  static Graph createRandomUnweightedGraph(final int n){
       final Graph graph = new Graph();

       for(int i = 1; i < n; i++){
             graph.addNode(i);
       }
      for(Node first: graph.myAdjList){   
        int lower = ThreadLocalRandom.current().nextInt(1,Math.floorDiv(n,2));
        int range = ThreadLocalRandom.current().nextInt(Math.floorDiv(n,2)+1,n);
        List<Node> randomizedNodeList = createRandomList(graph.myAdjList,lower,range);
         for(Node second: randomizedNodeList){
              graph.addUndirectedEdge(first, second);
         }
      }
       return graph;
  }
  // N nodes connected N 1 -> N 2 -> N 3 
  static Graph createLinkedList(final int n){
       final Graph graph = new Graph();
       for(int i = 1; i < n; i++){
            graph.addNode(i);
       }
       for(int i = 0; i < graph.myAdjList.size()-1; i++){
            graph.addUndirectedEdge(graph.getNodeAtIndx(i), graph.getNodeAtIndx(i+1));
       }
       return graph;
  }
  //randomize my list to create random graph in specified range
  static List<Node> createRandomList(final List<Node> lst,final int lower, final int n){
         //create copy of list
         List<Node> copyList = new ArrayList<Node>(lst);
         Collections.shuffle(copyList);
         //System.out.println(copyList);
         return copyList.subList(lower,n);
  }
}

class GraphSearch {

  public GraphSearch(){}
  
  //sets all nodes to unvisited once we finish our function so they can be reused
  void setAllNodeToDefault(ArrayList<Node> traversed){
      for(Node visit: traversed){
        if(visit.isVisited){
          visit.isVisited = false;
        }
      }
  }

  ArrayList<Node> DFSRec(final Node start, final Node end){
      ArrayList<Node> search = new ArrayList<Node>();
      search = dfsRecHelp(start, end, search);
      setAllNodeToDefault(search);
      return search;
  }
  ArrayList<Node> dfsRecHelp(final Node begin, final Node find, final ArrayList<Node> myList){
      if(!(myList.contains(find))){
           if(!(begin.isVisited)){
               begin.isVisited = true;
               myList.add(begin);
               for(Node next: begin.neighbors){
                   dfsRecHelp(next, find, myList);
               }
           }
      }
      return myList;
  }
  ArrayList<Node> DFSIter(final Node start, final Node end){
      ArrayList<Node> search = new ArrayList<Node>();
      Stack<Node> storage = new Stack<Node>();
      storage.push(start);
      //search.add(start);
      //start.isVisited = true;
      while(!(storage.empty())){
          Node curr = storage.pop();
          curr.isVisited = true;
          search.add(curr);
          if(curr.data == end.data){
              break;
          } 
          for(Node nextDoor: curr.neighbors){
              if(!(nextDoor.isVisited)){
                  storage.push(nextDoor);
                  nextDoor.isVisited = true;
              }
          }
      }
      setAllNodeToDefault(search);
      return search; 
  }
/*
  ArrayList<Node> BFTRec(Graph graph){
      ArrayList<Node> search = new ArrayList<Node>();
      Deque<Node> queue = new ArrayDeque<>();
      return BFTRecHelp(graph,search,queue);
  }
  ArrayList<Node> BFTRecHelp(graph,search,queue){
  }
  
*/

  ArrayList<Node> BFTIter(Graph graph){
      ArrayList<Node> traversal = new ArrayList<Node>();
      Deque<Node> myQueue = new ArrayDeque<>();
      for(Node vertex: graph.myAdjList){
          if(!(vertex.isVisited)){
              vertex.isVisited = true;
              myQueue.addFirst(vertex);
              //vertex.isVisited = true;
              while(!(myQueue.isEmpty())){
                  Node curr = myQueue.removeLast();
                  traversal.add(curr);
                  for(Node nextDoor: vertex.neighbors){
                      if(!(nextDoor.isVisited)){
                          nextDoor.isVisited = true;
                          myQueue.add(nextDoor);                           
                      }
                  }
              }
          }
      }
      setAllNodeToDefault(traversal);
      return traversal;
  }
}
