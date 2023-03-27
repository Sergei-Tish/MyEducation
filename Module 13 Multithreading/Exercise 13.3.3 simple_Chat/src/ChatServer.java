import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatServer {
    ArrayList<Client> clients = new ArrayList<>();
    private ServerSocket serverSocket;

    ChatServer() throws IOException { // создаем серверный сокет на порту 1234
        serverSocket = new ServerSocket(1234);
    }

    void sendAll(String message) {
        for (Client client : clients) {
            client.send(message);
        }
    }

    public void run() {
        System.out.println("Waiting for a client...");
        while (true) {
            try {
                Socket socket = serverSocket.accept(); // ждем клиента из сети
                Client newClient = new Client(socket, this); // создаем клиента на своей стороне
                clients.add(newClient); // Добавляем его в лист клиентов
                System.out.println("New client " + newClient.getName() + " connected!");
                //sendAll("New client " + newClient.getName() + " connected!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ChatServer().run();
    }

    void remove(Client clientArg) {

        for (Iterator<Client> iterator = clients.iterator(); iterator.hasNext(); ) {
            Client client = iterator.next();
            if (client.getIdClient() == clientArg.getIdClient()) {
                iterator.remove();
            }
        }
    }
}
