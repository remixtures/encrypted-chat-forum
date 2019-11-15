import java.util.LinkedList;
import java.util.List;

public class ChatRoom {

    private List<ClientHandler> clientsList;

    private String name;

    private int maxClients;

    public ChatRoom(String name, int maxClients) {

        this.name = name;
        clientsList = new LinkedList<>();
        this.maxClients = maxClients;
    }

    public void addClient(ClientHandler clientHandler){

        clientsList.add(clientHandler);
    }

    private void Broadcast(String message){

        for (ClientHandler client: clientsList) {
            client.sendMessage(message);
        }

    }

    public String[] createListOfClients(){

        String[] clientsArray = new String[clientsList.size()];

        for (int i = 0; i < clientsArray.length; i++) {

            clientsArray[i] = clientsList.get(i).getName();

        }
        return clientsArray;
    }





}
