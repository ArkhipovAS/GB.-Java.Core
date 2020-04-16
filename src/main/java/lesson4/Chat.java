package lesson4;

import javax.swing.*;

public class Chat {

    public static void main(String[] args) {
        System.out.println("Chat");
//        new MyWindow();
        SwingUtilities.invokeLater(MyWindow :: new);
    }

}
