public class Cell {

    private boolean solved;
    private int value;
    private int[] possibleValues = new int[9];
    private int[] impossibleValues = new int[9];

    public Cell(boolean solved, int value, int[] possibleValues, int[] impossibleValues) {
        this.solved = solved;
        this.value = value;
        this.possibleValues = possibleValues;
        this.impossibleValues = impossibleValues;
    }


    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int[] getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(int[] possibleValues) {
        this.possibleValues = possibleValues;
    }

    public int[] getImpossibleValues() {
        return impossibleValues;
    }

    public void setImpossibleValues(int[] impossibleValues) {
        this.impossibleValues = impossibleValues;
    }
}
