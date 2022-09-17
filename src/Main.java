import java.util.ArrayList;

public class Main {


    private static int[][] values = new int[9][9];

    public static void main(String[] args) {
        initializeValues();
        Plane plane = new Plane(values);
        System.out.println("The plane you entered:");
        plane.printPlane();
        plane.solve();
        System.out.println("\n\n\nThe Solution:");
        plane.printPlane();



    }


    static void initializeValues(){
        //zero means empty cell
        values = new int[][]{
                {0, 0, 0, 8, 6, 0, 0, 0, 0},
                {0, 9, 0, 0, 3, 5, 0, 2, 0},
                {0, 1, 0, 9, 4, 0, 0, 7, 0},
                {6, 4, 0, 0, 0, 0, 2, 8, 0},
                {0, 3, 2, 0, 0, 0, 0, 9, 4},
                {1, 8, 0, 0, 0, 0, 3, 6, 0},
                {0, 0, 0, 7, 1, 0, 0, 0, 0},
                {0, 7, 0, 0, 8, 6, 0, 5, 0},
                {0, 2, 0, 5, 9, 0, 0, 1, 0}};
        /**
                {0, 0, 6, 1, 0, 2, 5, 0, 0},
                {0, 3, 9, 0, 0, 0, 1, 4, 0},
                {0, 0, 0, 0, 4, 0, 0, 0, 0},
                {9, 0, 2, 0, 3, 0, 4, 0, 1},
                {0, 8, 0, 0, 0, 0, 0, 7, 0},
                {1, 0, 3, 0, 6, 0, 8, 0, 9},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 5, 4, 0, 0, 0, 9, 1, 0},
                {0, 0, 7, 5, 0, 3, 2, 0, 0}};

         */
    }


}