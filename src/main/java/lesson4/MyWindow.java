package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyWindow extends JFrame {
    public MyWindow(){
        setTitle("Arkhipov chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,600,300);

        setLayout(new GridLayout(2,2));

        JPanel[] jp = new JPanel[4];
        for (int i = 0; i < jp.length; i++) {
            jp[i] = new JPanel();
            add (jp[i]);
            jp[i].setBackground(new Color(100+i*40, 100+i*40, 100+i*40 ));
        }
        jp[0].setLayout(new BorderLayout());
        JTextArea jta = new JTextArea();
        jp[0].add(jta);

        jp[1].setLayout(new FlowLayout());
        JRadioButton [] jrb = new JRadioButton [2];
        ButtonGroup bgr = new ButtonGroup ();
        jrb [0] = new JRadioButton ( "Svyatoslav");
        jrb [1] = new JRadioButton ( "Mitrophan" , true);
        bgr.add(jrb[0]);
        bgr.add(jrb[1]);
        jp[1].add(jrb[0]);
        jp[1].add(jrb[1]);


        jp[2].setLayout(new BorderLayout());
        JTextField enterField = new JTextField(10);
        jp[2].add(enterField);
        enterField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chatName = null;
                if (jrb[1].isSelected() == true) chatName =  jrb[1].getText();
                else chatName =  jrb[0].getText();
                jta.setText(jta.getText() +"\n"+ "(" + getDate() + ") " + chatName +": "+ enterField.getText());
            }
        });


        jp[3].setLayout(new BorderLayout());
        JButton entr = new JButton("Enter");
        jp[3].add(entr);

        entr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chatName = null;
                if (jrb[1].isSelected() == true) chatName =  jrb[1].getText();
                else chatName =  jrb[0].getText();
                jta.setText(jta.getText() +"\n"+ "(" + getDate() + ") " + chatName +": "+ enterField.getText());
            }
        });


        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenu mEdit = new JMenu("Edit");
        JMenuItem miFileNew = new JMenuItem("New");
        JMenuItem miFileExit = new JMenuItem("Exit");
        JMenuItem miFileClear = new JMenuItem("Clear");
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mainMenu.add(mEdit);
        mFile.add(miFileNew);
        mFile.addSeparator();
        mFile.add(miFileExit);
        mEdit.add(miFileClear);

        miFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        miFileClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setText(null);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("BYE");
            }
        });

        setVisible(true);


    }

    private String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date datetime = new Date();
        return dateFormat.format(datetime);
    }

}
