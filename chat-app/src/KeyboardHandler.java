import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class KeyboardHandler implements Runnable {

    private Prompt prompt;

    private ChatClient chatClient;

    public KeyboardHandler( ChatClient chatClient) {

        prompt = new Prompt(System.in, System.out);

        this.chatClient = chatClient;

    }

    @Override
    public void run() {

        startListening();


    }

    private void startListening() {

        StringInputScanner clientInputScanner = new StringInputScanner();

        clientInputScanner.setMessage("What to say");

        while (true) {

            String message = prompt.getUserInput(clientInputScanner);

            chatClient.sendMessage(message);
        }

    }


}
