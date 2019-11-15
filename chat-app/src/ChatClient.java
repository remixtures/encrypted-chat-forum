import org.academiadecodigo.bootcamp.Prompt;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatClient {


    private final int portNumber;
    private final String host;
    private Socket clientSocket;
    private ExecutorService executorService;
    private KeyboardHandler keyboardHandler;


    public ChatClient(String host , int portNumber) {

        this.host = host;
        this.portNumber = portNumber;

        initClient();

    }

    public static void main(String[] args) {

        ChatClient chatClient = new ChatClient("localhost" , 8080);
        chatClient.startListening();
    }

    private void initClient() {

        try {
            clientSocket = new Socket(host , portNumber);
            executorService = Executors.newSingleThreadExecutor();
            executorService.execute(new KeyboardHandler(this));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void startListening() {

        while (!clientSocket.isClosed()) {

            byte[] bytes = new byte[1024];

            try {

                int bytesRead = clientSocket.getInputStream().read(bytes);

                String message = new String(bytes, 0, bytesRead);

                System.out.println(message);

            } catch (IOException e) {

                e.printStackTrace();

            }
        }

    }

    public void sendMessage(String message) {

        try {
            clientSocket.getOutputStream().write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

