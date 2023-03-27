import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Client implements Runnable {
    private Socket socket;
    private ChatServer server;
    private Scanner in;
    private PrintStream out;

    public String getName() {
        return name;
    }

    private String name;
    private static int countOfAnonymous = 0;

    public int getIdClient() {
        return idClient;
    }

    private final int idClient;

    public Client(Socket socket, ChatServer server){
        this.socket = socket;
        this.server = server;
        name = "Anonymous_" + ++countOfAnonymous;
        idClient = countOfAnonymous;
        // запускаем поток
        Thread thread = new Thread(this);
        thread.start();
    }

    void send (String massage) {
        try {
            out.println(massage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
            out.println("Welcome to Our little chat! Your name in the chat is \"" + name + "\".");
            out.println("If you want change your name, write command -name YOURNEWNAME");
            server.sendAll("New client " + name + " connected!");
            String input = in.nextLine();

            while (!input.equals("bye")) {
                if (input.startsWith("-name ")) {
                    changeClientName(input);
                    try {
                        input = in.nextLine();
                    } catch (RuntimeException e) {
                        break;
                    }
                } else if (input.startsWith("-list")) {
                    serverListOnline();
                    try {
                        input = in.nextLine();
                    } catch (RuntimeException e) {
                        break;
                    }
                } else {
                    server.sendAll(name + ": " + input);
                    try {
                        input = in.nextLine();
                    } catch (RuntimeException e) {
                        break;
                    }
                }
            }
            server.sendAll(name + " has disconnected.");
            System.out.println(name + " has disconnected.");
            server.remove(this);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void serverListOnline() {
        out.print("Now online: ");
        for (Client clientFromList : server.clients) {
            out.print(clientFromList.name + ", ");
        }
        out.println();
    }

    private void changeClientName(String input) {
        String newName = input.substring(6);
        server.sendAll(name + " now have new name - \"" + newName + "\"");
        name = newName;
    }
}