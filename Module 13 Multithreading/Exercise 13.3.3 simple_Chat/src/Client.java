import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Client implements Runnable {
    Socket socket;
    ChatServer server;
    Scanner in;
    PrintStream out;
    private String name;
    int countOfClient = 0;

    public Client(Socket socket, ChatServer server){
        this.socket = socket;
        this.server = server;
        name = "Anonymous_#" + ++countOfClient;
        // запускаем поток
        Thread thread = new Thread(this);
        thread.start();
    }

    void send (String massage) {
        out.println(name + ": " + massage);
    }

    public void run() {
        try {
            // получаем потоки ввода и вывода
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // создаем удобные средства ввода и вывода
            in = new Scanner(is);
            out = new PrintStream(os);

            // читаем из сети и пишем в сеть
            out.println("Welcome to Our little chat! \n Your name in the chat is \"" + name + "\". \nIf you want change your name, write command -name YOURNAME");
            String input = in.nextLine();

            while (!input.equals("bye")) {
                if (input.startsWith("-name ")) {

                }
                server.sendAll(input);
                try {
                    input = in.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("Client " + name + " has disconnected.");
                    countOfClient--;
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}