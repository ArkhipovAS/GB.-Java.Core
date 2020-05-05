package lesson6;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class TestClient {

    public static DataOutputStream outputStream;
    public static DataInputStream inputStream;

    public void ClientChat(){
        initServerConnection();
    }

    public static void main(String[] args){
        TestClient tc = new TestClient();
        tc.ClientChat();
    }

    public void initServerConnection (){
        try {
            Socket socket = new Socket("localhost", 8189);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            try {
                processMessagesFromServer(socket);
                processMessagesToServer(socket);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }

    public static void closeConnection(Socket socket) {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processMessagesToServer(Socket socket) {
        new Thread(() -> {
            try {
                while (true){
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String msgToServer = reader.readLine();
                    if (msgToServer == "/end"){
                        outputStream.writeUTF(msgToServer);
//                        outputStream.close();
                        break;
                    }
                    outputStream.writeUTF(msgToServer);
                }
            } catch (IOException e) {
                System.err.println("Server connection было closed");
                e.printStackTrace();
            }
//            finally {
//                System.out.println("Client closed socket");
//                closeConnection(socket);
//            }
        }).start();
    }

    public static void processMessagesFromServer(Socket socket) {
        new Thread(() -> {
            try {
                while (true){
                    String messageFromServer = inputStream.readUTF();
                    System.out.println("Server> " + messageFromServer);
                    if(messageFromServer.equals("end session")) {
                        inputStream.close();
                        outputStream.close();
                        socket.close();
                        System.out.println("sckt_close");
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("Server connection was closed");
                e.printStackTrace();
            }
        }).start();
    }
}
