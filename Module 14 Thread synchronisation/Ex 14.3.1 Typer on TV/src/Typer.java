class Typer extends Thread {
    /* put your code here */
    String massage;
    public Typer(String massage) {
        this.massage = massage;
    }

    @Override
    public void run() {
        synchronized (System.out) {
            for (int i = 0; i < massage.length(); i++) {
                if (!isInterrupted()) {
                    System.out.print(massage.charAt(i));
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        interrupt();
                        break;
                    }
                } else break;
            }
        }
    }
}