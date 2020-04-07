package lesson2;

import java.util.Arrays;

public class MyArraySizeExeption extends Exception{
   private String [] arr1 = new String[2];

   public MyArraySizeExeption (String [] arr1){
       this.arr1 = arr1;
   }

    public String[] getArr1() {
        return arr1;
    }
}


