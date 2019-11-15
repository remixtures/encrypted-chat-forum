public class ChatApp {

    public static void main(String[] args) {

        ChatServer chatServer = new ChatServer(8080);

        chatServer.startListening();

    }

}
