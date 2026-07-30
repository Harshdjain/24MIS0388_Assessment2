public class BankTransaction1 {
    public static void main(String[] args) {

        int[] account = {101, 102, 103, 104};
        String[] type = {"Deposit", "Withdrawal", "Deposit", "Withdrawal"};
        double[] amount = {5000, 12000, 8000, 2000};

        int n = account.length;
        double[] balance = new double[n];

        double totalDeposit = 0;
        double totalWithdrawal = 0;


        for (int i = 0; i < n; i++) {

            if (type[i].equalsIgnoreCase("Deposit")) {
                totalDeposit += amount[i];
                balance[i] = amount[i];
            } else {
                totalWithdrawal += amount[i];
                balance[i] = -amount[i];
            }
        }

        System.out.println("Total Deposits = $" + totalDeposit);
        System.out.println("Total Withdrawals = $" + totalWithdrawal);

        double maxBalance = balance[0];
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (balance[i] > maxBalance) {
                maxBalance = balance[i];
                maxIndex = i;
            }
        }

        System.out.println("\nAccount with Highest Balance: " + account[maxIndex]);
        System.out.println("Balance = $" + maxBalance);

        System.out.println("\nSuspicious Withdrawals (Greater than $10000):");
        for (int i = 0; i < n; i++) {
            if (type[i].equalsIgnoreCase("Withdrawal") && amount[i] > 10000) {
                System.out.println("Account " + account[i] + " : $" + amount[i]);
            }
        }

        System.out.println("\nFinal Balances:");
        for (int i = 0; i < n; i++) {
            System.out.println("Account " + account[i] + " : $" + balance[i]);
        }
    }
}