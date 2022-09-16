import java.util.ArrayList;

public class Plane {


    public Cell[][] plane = new Cell[9][9];

    public Plane(int values[][]) {

        initializeCells(values);

    }

    public Cell[][] getPlane() {
        return plane;
    }

    public void setPlane(Cell[][] plane) {
        this.plane = plane;
    }

    private void initializeCells(int values[][]) {
        for(int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                plane[i][j] = new Cell(values[i][j], new ArrayList<Integer>());
            }
        }
    }

    void printPlane(){
        for(int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                System.out.print(plane[i][j].getValue() + " ,");
            }

            System.out.print("\n");
        }
    }

}
