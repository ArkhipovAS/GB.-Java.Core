package lesson2;

public class MyArrayDataException extends Exception{
    public int row;
    public int col;


    public MyArrayDataException(String message, int i, int j) {
        super(message);
        this.col = i;
        this.row = j;
    }

    @Override
    public String toString(){
        return "Wrong data array \n" + "row: " + row + "\ncol: " + col;
    }
}
