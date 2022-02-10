import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 16161;
        Scanner scan = new Scanner(System.in);

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {


                out.println("Kirill");
                String name = in.readLine();
                System.out.println(name);
            while (clientSocket.isClosed()) {
                out.println("coding or something else?");
                String codingOrRelax = in.readLine();
                System.out.println(codingOrRelax);

                String scanNL = scan.nextLine();

                out.println(scanNL);
                scanNL = in.readLine();
                System.out.println(scanNL);
//                if(clientSocket.isClosed())
//                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
