import java.util.Scanner;

public class BankTransaction {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        int[] account = new int[n];
        String[] type = new String[n];
        double[] amount = new double[n];
        double[] balance = new double[n];

        double totalDeposit = 0;
        double totalWithdrawal = 0;

        // Input
        for (int i = 0; i < n; i++) {

            System.out.println("\nTransaction " + (i + 1));

            System.out.print("Account Number: ");
            account[i] = sc.nextInt();

            System.out.print("Type (Deposit/Withdrawal): ");
            type[i] = sc.next();

            System.out.print("Amount: ");
            amount[i] = sc.nextDouble();

            if (type[i].equalsIgnoreCase("Deposit")) {
                totalDeposit += amount[i];
                balance[i] += amount[i];
            } else {
                totalWithdrawal += amount[i];
                balance[i] -= amount[i];
            }
        }

        // Display total deposits and withdrawals
        System.out.println("\nTotal Deposits = $" + totalDeposit);
        System.out.println("Total Withdrawals = $" + totalWithdrawal);

        // Highest balance
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

        // Suspicious withdrawals
        System.out.println("\nSuspicious Withdrawals (Greater than $10000):");
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (type[i].equalsIgnoreCase("Withdrawal") && amount[i] > 10000) {
                System.out.println("Account " + account[i] + " : $" + amount[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No suspicious withdrawals.");
        }

        // Final balances
        System.out.println("\nFinal Balances:");
        for (int i = 0; i < n; i++) {
            System.out.println("Account " + account[i] + " : $" + balance[i]);
        }

        sc.close();
    }
}