public class Cube {
    private int length;

    public Cube(int edgeLength) {
        length = edgeLength;
    }

    public int volume() {
        return length * length * length;
    }

    public String toString() {
        return "The length of the edge is " + length + " and the volume " + volume();
    }
}
