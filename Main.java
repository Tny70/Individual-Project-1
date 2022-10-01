import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Airports.reader();
//        //Airlines.reader();
//        //Routes.reader();
//
//        Node node = new Node();
//        Queue<Node> frontier = new LinkedList<Node>();
//        HashSet<String> explored = new HashSet<String>();
//
//        while (frontier.size() > 0){
//            node = frontier.remove();
//            explored.add(node.getState());
//            System.out.println("Removed: " + node.getState());
//            //Do Suc states
//            }



        PrintWriter pw=null;
        try{
            pw = new PrintWriter("output.txt");
            pw.println("City");
            pw.println("Country");
            pw.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }

    }
}

