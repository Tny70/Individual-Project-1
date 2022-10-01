import java.util.ArrayList;
import java.util.Objects;

public class Node {
    private Node parent;
    private String state;
    private ArrayList<ArrayList<String>> routeFlights;

    private String airlines;


    public Node(Node parent, String state, ArrayList<ArrayList<String>> routeFlights) {
        this.parent = parent;
        this.state = state;
        this.routeFlights = routeFlights;



    }

    public Node(String state) {
        this.state=state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return Objects.equals(parent, node.parent) && state.equals(node.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, state);
    }

}
