public class Plane {


    public Cell[][] plane = new Cell[9][9];

    public Plane(Cell[][] plane) {
        this.plane = plane;
    }

    public Cell[][] getPlane() {
        return plane;
    }

    public void setPlane(Cell[][] plane) {
        this.plane = plane;
    }
}
