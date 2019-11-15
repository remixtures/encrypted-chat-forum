import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket mySocket;
    private String name;
    private ChatServer chatServer;

    public ClientHandler(Socket socket , String name , ChatServer chatServer) {
        this.name = name;
        mySocket = socket;
    }

    @Override
    public void run() {
        startListening();
    }

    private void startListening() {

        System.out.println("started liten");

        while (!mySocket.isClosed()) {

            byte[] bytes = new byte[1024];
            try {

                int bytesRead = mySocket.getInputStream().read(bytes);

                String message = new String(bytes, 0 , bytesRead);

                //readMessage(message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void readMessage(String message) {

        String[] messageArray = message.split(" ");
        if (messageArray[0].equals("/alias")){
            name = messageArray[1];
        }

    }

    public void sendMessage(String message) {

        try {
            mySocket.getOutputStream().write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }
}
