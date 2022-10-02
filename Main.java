import java.io.*;
import java.util.*;

public class Main {
    String startingCity;
    String startingCountry;
    String endCity;
    String endCountry;

    public void reading() {
        FileReader fileViewer = null;
        BufferedReader buffReader = null;
        try {
            fileViewer = new FileReader("input.txt");
            buffReader = new BufferedReader(fileViewer);
            String newLine;
            String start = buffReader.readLine();
            String[] lines = start.split(",");
            this.startingCity = lines[0];
            this.startingCountry = lines[1];

            String end = buffReader.readLine();
            String[] lines2 = end.split(",");
            this.endCity = lines2[0];
            this.endCountry = lines2[1];
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

        public ArrayList<Node> nodeCreator(){
            ArrayList<Airports> startAirport = Airports.getAirportsMap().get(startingCity+startingCountry);
            ArrayList<Node> airportNodes = new ArrayList<>();
            for (Airports airport:startAirport){
                Node node = new Node(null, airport, null, 0);
                airportNodes.add(node);
            }
            System.out.println(airportNodes);
            return airportNodes;
    }

    public boolean goalTest(Node child){
        if (child.getState() ==null){
            return false;
        }
        if (child.getState().getAirportCity().equals(endCity)  && child.getState().getAirportCountry().equals(endCountry)){
            return true;
        }
        else{
            return false;
        }
    }

    public Node bfs() {
        Queue<Node> frontier = new LinkedList<Node>();
        ArrayList<Node> airportNode = nodeCreator();

        frontier.addAll(airportNode);

        HashSet<Node> explored = new HashSet<>();

        while (frontier.size() > 0) {
            Node initialNode = frontier.poll();
            explored.add(initialNode);
            if (initialNode.getState() != null) {
                ArrayList<Routes> flights = Routes.routesMap.get(initialNode.getState().getAirportIata());
                for (Routes action : flights) {
                    Node child = new Node(initialNode, Airports.iataAirport.get(action.getDestinationAirportCode()), action, initialNode.getPathCost() + 1);
                    if (!explored.contains(child) && !frontier.contains(child)) {
                        if (goalTest(child)) {
                            System.out.println(child);
                            child.solutionPath();


                            return child;
                        }
                        frontier.add(child);
                    }

                }

            }else {;}


        }
        return null;
    }

    //public void debug(){
        //System.out.println(child);
    //}

    public void writer(){
        PrintWriter pw=null;
        try{
            pw = new PrintWriter("output.txt");
            pw.println("");
            pw.println("done");
            pw.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        Main execute = new Main();

        Airports.reader();
        Airlines.reader();
        Routes.reader();

        execute.reading();
        execute.nodeCreator();
        execute.bfs();
    }
}
