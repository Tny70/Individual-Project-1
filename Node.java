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

    public static void solutionPath(Node child) {

    }
}



