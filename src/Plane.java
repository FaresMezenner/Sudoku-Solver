import java.util.ArrayList;

public class Plane {


    public Cell[][] plane = new Cell[9][9];
    private boolean[][][] squareIsSolvedFor = new boolean[3][3][9];
    private boolean solved = false;

    public Plane(int values[][]) {

        setPlane(values);

    }

    public Cell[][] getPlane() {
        return plane;
    }

    public void setPlane(int values[][]) {
        initializeCells(values);
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    private void initializeCells(int values[][]) {
        for(int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                plane[i][j] = new Cell(values[i][j], new ArrayList<Integer>());

                if(values[i][j]!=0) squareIsSolvedFor[i/3][j/3][values[i][j]-1] = true;
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

    void solve(){
        ArrayList<Integer> impossible = new ArrayList<>();
        while (!isSolved()){

            for(int i=0; i<9; i++){
                setSolved(true);
                for (int j=0; j<9; j++){
                    if(!plane[i][j].isSolved()){
                        setSolved(false);
                        impossible = scanColum(j);
                        impossible = addListToList(impossible, scanLine(i));
                        //ArrayList<Integer> list = scanSquare(i, j);
                        impossible = addListToList(impossible, scanSquare(i, j));
                        plane[i][j].setImpossibleValues(impossible);
                        if (plane[i][j].isSolved()){
                            squareIsSolvedFor[i/3][j/3][plane[i][j].getValue()-1] = true;
                        }
                    }
                }

            }

            solveSquares();
            impossible = new ArrayList<>();
        }
    }

    ArrayList<Integer> scanColum(int j){
        ArrayList<Integer> impossible = new ArrayList<>();
        for ( int k =0; k<9;k++){
            if (plane[k][j].isSolved()){
                impossible.add(plane[k][j].getValue());
            }
        }
        return impossible;
    }

    ArrayList<Integer> scanLine(int i){
        ArrayList<Integer> impossible = new ArrayList<>();
        for ( int k =0; k<9;k++){
            if (plane[i][k].isSolved()){
                impossible.add(plane[i][k].getValue());
            }
        }
        return impossible;
    }
    ArrayList<Integer> scanSquare(int i, int j){
        ArrayList<Integer> impossible = new ArrayList<>();
        int k = i/3, h = j/3;


        for(int l=0; l<3; l++){
            for (int c=0; c<3; c++){
                int a = (3*k) + l , b = (3*h) + c;
                    if(plane[a][b].isSolved()){

                        if (plane[a][b].isSolved()){
                            impossible.add(plane[a][b].getValue());
                        }

                    }
                }
            }
        return impossible;
    }

    ArrayList<Integer> addListToList(ArrayList<Integer> list1, ArrayList<Integer> list2){
        for(int i : list1){
            if(!list2.contains(i)) list2.add(i);
        }
        return list2;
    }

    public void solveSquares(){
        int[] toSolve = new int[2];
        int a,b;
        boolean moreThanOne;
        for (int n=1; n<=9; n++){
            for(int l=0; l<3; l++){
                for (int c=0; c<3; c++){
                    toSolve = null;
                    moreThanOne = false;
                    if ( !squareIsSolvedFor[l][c][n-1]){
                        for (int h=0; h<3; h++){
                        for (int k=0; k<3; k++){
                            a = (3*l) + h;
                            b = (3*c) + k;
                            if (!plane[a][b].isSolved() && plane[a][b].getPossibleValues().contains(n)){
                                if (!moreThanOne){
                                    toSolve = new int[] {a,b};
                                    moreThanOne = true;
                                } else {
                                    toSolve = null;

                                }
                            }
                        }
                    }
                        if (toSolve != null){
                            plane[toSolve[0]][toSolve[1]].setValue(n);
                            squareIsSolvedFor[toSolve[0]/3][toSolve[1]/3][n-1] = true;
                        }

                    }


                }
            }
        }
    }


}
