public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount.Builder(1064590L)
                .withOwner("Sergey")
                .atBranch("NSK")
                .openingBalance(100)
                .atRate(7.2d)
                .build();

        System.out.println(bankAccount);

        System.out.println(bankAccount);
        System.out.println(bankAccount);
    }
}
