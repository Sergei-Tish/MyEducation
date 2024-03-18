public class Main {
    public static void main(String[] args) {
        Notifier notifier = new BaseNotifier();
        Notifier notifier1 = new AdvencedDecoratorTG(new BaseNotifier());
        Notifier notifier2 = new AdvencedDecoratorWA(new BaseNotifier());


        String str = notifier.sendData();
        String str1 = notifier1.sendData();
        String str2 = notifier2.sendData();

        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }
}
