import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket mySocket;

    public ClientHandler(Socket socket) {

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

                System.out.println(message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
