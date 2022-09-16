import java.util.ArrayList;

public class Cell {


    private int value;
    private ArrayList<Integer> possibleValues = new ArrayList<>();
    private ArrayList<Integer> impossibleValues = new ArrayList<>();

    public Cell( int value, ArrayList<Integer> possibleValues) {

        for (int j=1; j<=9; j++){
            impossibleValues.add(j);
        }

        setValue(value);


        this.possibleValues = possibleValues;
    }



    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        if (value == 0){
            for (int i : possibleValues){
                impossibleValues.remove((Object)i);
                if (!this.possibleValues.contains(i)) this.possibleValues.add(i);
            }
        } else {
            impossibleValues.remove((Object)value);
        }
    }

    public ArrayList<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(ArrayList<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public ArrayList<Integer> getImpossibleValues() {
        return impossibleValues;
    }

    public void setImpossibleValues(ArrayList<Integer> impossibleValues) {
        this.impossibleValues = impossibleValues;
    }



}
