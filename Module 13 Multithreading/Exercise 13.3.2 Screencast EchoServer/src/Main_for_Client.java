import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main_for_Client {
    public static void main(String[] args) throws IOException {
        // создаем серверный сокет на порту 1234
        ServerSocket server = new ServerSocket(1234);
        while(true) {
            System.out.println("Waiting...");
            // ждем клиента из сети
            Socket socket = server.accept();
            System.out.println("Client connected!");
            // создаем клиента на своей стороне
            Client client = new Client(socket);
            // запускаем поток
            Thread thread = new Thread(client);
            thread.start();
            /*
        Последние три строки можно написать в две:
            Thread thread = new Thread (new Client(s));
            thread.start();

        Или даже в одну:
            new Thread (new Client(s)).start();
             */
        }
    }
}
