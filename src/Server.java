import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        System.out.println("Server started");
        int port = 16161;
        while (true) {

            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection accepted");

            String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

            String codingOrRelax = in.readLine();
            out.println(String.format("%s, you whant %s?", name, codingOrRelax));

            while (true) {
                String scanNL = in.readLine();
                if (scanNL.equals("coding")) {
                    out.println(String.format("%s you are good student! Let's do it!", name));
                    break;
                } else {
                    out.println("Error!*(&(*^&* Try again");
                    continue;
                }
            }

            serverSocket.close();
        }
    }
}