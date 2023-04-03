public class Bank {
    private int money = -1000;

    public synchronized void takeCredit(String nameClient) {
        if (money < 1000) {
            System.out.println(nameClient + " Not enough money in the bank.");
        } else {
            money -= 1000;
            System.out.println(nameClient + " Credit taken. Bank money: " + money);
        }
    }

    public synchronized void returnCredit(String nameClient) {
        money += 1000;
        System.out.println(nameClient + " Credit returned. Bank money: " + money);
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        for (int i = 0; i < 3; i++) {
            Client client = new Client(bank);
            client.start();
        }
    }
}

class Client extends Thread {
    private Bank bank;
    String name;
    static int clientCount = 0;
    int myCount;

    public Client(Bank bank) {
        this.bank = bank;
        name = "Cl.#"+ ++clientCount;
        myCount = 100 * clientCount;
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        while (true) {
            bank.takeCredit(name);
            bank.returnCredit(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}