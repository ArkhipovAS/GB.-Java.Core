
package lesson2;
public class MyArray {
    private static final int SIZE = 4;
    private static String [][] arrData = new String[][]{
            {"1", "2", "1", "2"},
            {"3", "4", "1", "2"},
            {"1", "2", "1", "2"},
            {"3", "4", "1", "2"}};

    public static void main(String[] args) {
        calculateArray(arrData);
    }

    private static void calculateArray(String[][] arrData) {
        int sum = 0;
        try {
            for (int i = 0; i < arrData.length; i++) {
                if (arrData.length != SIZE) {
                    throw new MyArraySizeException("Wrong array size");
                }
                for (int j = 0; j <arrData[i].length ; j++) {
                    if (arrData[i].length != SIZE)
                        throw new MyArraySizeException("Wrong array size");
                    try {
                        sum += Integer.parseInt(arrData[i][j]);
                    }
                    catch (NumberFormatException e){
                        throw new MyArrayDataException("Wrong data fromat", i, j);
                    }
                }
            }
        }
        catch (MyArraySizeException e){
            System.out.println(e.toString());
        }
        catch (MyArrayDataException e1){
            System.out.println(e1.toString());
        }
        System.out.println("Sum cell array: " + sum);
    }

}

