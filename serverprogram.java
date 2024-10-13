import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            // Create a server socket listening on port 12345
            serverSocket = new ServerSocket(12345);
            System.out.println("Server started. Waiting for connections...");

            // Wait for a client connection
            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create input and output streams to communicate with the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read the message from the client
            String message = in.readLine();
            System.out.println("Received from client: " + message);

            // Send a response back to the client
            out.println("Hello from server!");

            // Close streams and sockets
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
