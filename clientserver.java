import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            // Connect to the server on localhost at port 12345
            socket = new Socket("localhost", 12345);
            System.out.println("Connected to server.");

            // Create input and output streams to communicate with the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server
            out.println("Hello from client!");

            // Read the response from the server
            String response = in.readLine();
            System.out.println("Received from server: " + response);

            // Close streams and socket
            in.close();
            out.close();
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: localhost.");
            e.printStackTrace();
        }
    }
}
