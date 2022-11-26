package fork;

public class Vertex {
    private String label;
    private boolean visited;

    public Vertex(String label, boolean visited) {
        this.label = label;
        this.visited = visited;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public Object getLabel() {
        return label;
    }
    public boolean getVisited() {
        return visited;
    }
    public String toString() {
        return label;
    }

    public void wasVisited() {
        this.visited = true;
    }
    public void wasNotVisited() {
        this.visited = false;
    }
}
