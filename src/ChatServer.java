import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    private final int portNumber;
    private ServerSocket serverSocket;
    private ExecutorService executorService;

    public ChatServer(int portNumber) {

        this.portNumber = portNumber;
        initServer();

    }

    private void initServer() {

        try {
            serverSocket = new ServerSocket(portNumber);
            executorService = Executors.newCachedThreadPool();
            startListen();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void startListen() {
        System.out.println("started listen");
        while(!serverSocket.isClosed()) {

            try {
                Socket clientSocket = serverSocket.accept();

                System.out.println("new connection");

                executorService.submit(new ClientHandler(clientSocket));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
