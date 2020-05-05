package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    private static final int SERVER_PORT = 8189;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Сервер запущен, ожидаем подключения...");
//            try {
//                serverSocket.setSoTimeout(1000);
//            } catch (IOException e) {
//                System.err.println("Превышено время ожидания подключения клиента");
//                e.printStackTrace();
//            }
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            out.writeUTF("Client connected");
            try {
                while (true) {
                    String str = in.readUTF();
                    if (str.equals("/end")) {
                        System.out.println("Client> " + str);
                        out.writeUTF("end session");
                        break;
                    }
                    System.out.println("Client> " + str);
                    out.writeUTF("Эхо: " + str);
                }
            } catch (SocketException e) {
                System.out.println("Connection was close!");
            }
            serverSocket.close();
            System.out.println("Connection was close!");
        } catch (IOException e) {
            System.err.println("Port " + SERVER_PORT + " is already used!");
            e.printStackTrace();
        }

    }
}
