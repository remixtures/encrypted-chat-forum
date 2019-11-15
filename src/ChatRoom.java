import java.util.List;

public class ChatRoom {

    private List<ClientHandler> clientsList;

    private String name;

    private int maxClients;

    public ChatRoom(String name, int maxClients) {

        this.name = name;

        this.maxClients = maxClients;

    }



}
