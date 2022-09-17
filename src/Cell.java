import java.util.ArrayList;

public class Cell {

    private boolean solved;
    private int value;
    private ArrayList<Integer> possibleValues = new ArrayList<>();
    private ArrayList<Integer> impossibleValues = new ArrayList<>();

    public Cell( int value, ArrayList<Integer> impossibleValues) {

        for (int j=1; j<=9; j++){
            possibleValues.add(j);
        }

        this.impossibleValues = impossibleValues;
        setValue(value);


    }



    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        if (value == 0){
            setSolved(false);
        } else {
            setSolved(true);
            if (possibleValues.size() != 1){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(value);
                setPossibleValues(list);
            }
        }
    }

    public ArrayList<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(ArrayList<Integer> possibleValues) {
        this.possibleValues = possibleValues;

        for (int i : possibleValues){
            if(impossibleValues.contains(i)) impossibleValues.remove((Object)i);
        }

    }

    public ArrayList<Integer> getImpossibleValues() {
        return impossibleValues;
    }

    public void setImpossibleValues(ArrayList<Integer> impossibleValues) {
        this.impossibleValues = impossibleValues;
        for (int i : impossibleValues){
            if(possibleValues.contains(i)) possibleValues.remove((Object)i);
        }
        solveCell();
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public void addImpossible(int value){

        if(!impossibleValues.contains(value))impossibleValues.add(value);
    }

    public void solveCell(){

        if (getPossibleValues().size() == 1){
            setValue(getPossibleValues().get(0));
        }
    }

}
