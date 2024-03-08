package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        final int PORT = 1234;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor TCP iniciado. Esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("STATUS: Conectado al servidor");

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                // Espera el texto del cliente y responde con el mismo texto (echo)
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    if (inputLine.equals("FIN")) {
                        break;
                    }

                    System.out.println("STATUS: Esperando echo");
                    System.out.println("echo: " + inputLine);
                    writer.println(inputLine);
                }

                reader.close();
                writer.close();
                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
