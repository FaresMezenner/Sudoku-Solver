import java.util.ArrayList;

public class Main {


    private static int[][] values = new int[9][9];

    public static void main(String[] args) {
        initializeValues();
        Plane plane = new Plane(values);
        plane.printPlane();
    }


    static void initializeValues(){
        values = new int[][]{
                {0, 0, 6, 1, 0, 2, 5, 0, 0},
                {0, 3, 9, 0, 0, 0, 1, 4, 0},
                {0, 0, 0, 0, 4, 0, 0, 0, 0},
                {9, 0, 2, 0, 3, 0, 4, 0, 1},
                {0, 8, 0, 0, 0, 0, 0, 7, 0},
                {1, 0, 3, 0, 6, 0, 8, 0, 9},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 5, 4, 0, 0, 0, 9, 1, 0},
                {0, 0, 7, 5, 0, 3, 2, 0, 0}};
    }


}