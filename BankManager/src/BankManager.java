public class BankManager {
    public static void main(String[] args) {
        CheckingAccount account1 = new CheckingAccount();
        SavingsAccount account2 = new SavingsAccount();
        CertificateOfDeposit account3 = new CertificateOfDeposit();

        account1.balance = 1000.00;
        account2.balance = 2000.00;
        account3.balance = 3000.00;

        account1.account = "0001-1";
        account2.account = "0001-2";
        account3.account = "0001-3";

        System.out.println(account1.account + " - " + account1.balance);
        System.out.println(account2.account + " - " + account2.balance);
        System.out.println(account3.account + " - " + account3.balance);
    }
}
