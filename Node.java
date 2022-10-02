import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Node {
    private Node parent;
    private Airports state;
    private Routes actions;
    private Integer pathCost;

    public Node(Node parent, Airports state, Routes actions, Integer pathCost) {
        this.parent = parent;
        this.state = state;
        this.actions = actions;
        this.pathCost = pathCost;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Airports getState() {
        return state;
    }

    public void setState(Airports state) {
        this.state = state;
    }

    public Routes getActions() {
        return actions;
    }

    public void setActions(Routes actions) {
        this.actions = actions;
    }

    public Integer getPathCost() {
        return pathCost;
    }

    public void setPathCost(Integer pathCost) {
        this.pathCost = pathCost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "parent=" + parent +
                ", state=" + state +
                ", actions=" + actions +
                ", pathCost=" + pathCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return Objects.equals(parent, node.parent) && Objects.equals(state, node.state) && Objects.equals(actions, node.actions) && Objects.equals(pathCost, node.pathCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, state, actions, pathCost);
    }

    public void solutionPath() {
        ArrayList<String>cStates = new ArrayList<>();
        String flightOrder;
        Integer pCost = 0;
        String ptCost;
        String adCost;
        String adstops = null;
        ArrayList<String>fileOut = new ArrayList<>();
        Node kid = this;
        System.out.println(kid);
        while (kid.parent != null){
            flightOrder = kid.actions.getAirlineCode()+ " from " + kid.getParent().getState().getAirportIata()+ " to "+ kid.state.getAirportIata()+ " is "+ kid.actions.getStops() +" stops ";
            cStates.add(flightOrder);
            kid = kid.parent;
            pCost +=1;
        }
        ptCost = "Total flights: "+ pCost;
        adCost = "Total additional stops is 0";


        Collections.reverse(cStates);
        for (int i = 0; i < cStates.size(); i++){
            String sentence = i+1 + ". "+ cStates.get(i);
            fileOut.add(sentence);
            System.out.println(sentence);
        }
        fileOut.add(ptCost);
        fileOut.add(adCost);
        System.out.println(ptCost);

        PrintWriter pw=null;
        try{
            pw = new PrintWriter("output.txt");
            for (String line : fileOut) {
                pw.println(line);
            }
            pw.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}



