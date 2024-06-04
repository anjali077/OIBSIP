import java.util.*;

class ATM_Interface {
    private String name;
    private String holderName;
    private int PIN;
    private int accountNumber;
    private float balance = 50000f;
    private int transactions = 0;
    private String transactionHistory = "";

    private Scanner scanner = new Scanner(System.in);

    public void register() {
        System.out.print("\nEnter Your Name: ");
        this.name = scanner.nextLine();
        System.out.print("\nEnter Your Holder Name: ");
        this.holderName = scanner.nextLine();
        System.out.print("\nEnter Your PIN: ");
        this.PIN = scanner.nextInt();
        System.out.print("\nEnter Your Account Number: ");
        this.accountNumber = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("\nRegistration completed. Please login.");
    }

    public boolean login() {
        boolean isLoggedIn = false;

        System.out.print("\nEnter Your Holder Name: ");
        String inputHolderName = scanner.nextLine();

        if (inputHolderName.equals(holderName)) {
            System.out.print("\nEnter Your PIN: ");
            int inputPIN = scanner.nextInt();

            if (inputPIN==PIN) {
                System.out.println("\nLogin Successful!");
                isLoggedIn = true;
            } else {
                System.out.println("\nIncorrect PIN");
            }
        } else {
            System.out.println("\nHolder Name not found");
        }

        return isLoggedIn;
    }

    public void withdraw() {
        System.out.print("\nEnter amount to withdraw: ");
        float amount = scanner.nextFloat();

        if (balance >= amount) {
            transactions++;
            balance -= amount;
            System.out.println("\nWithdraw Successful");
            transactionHistory += amount + " Rs Withdrawn\n";
        } else {
            System.out.println("\nInsufficient Balance");
        }
    }

    public void deposit() {
        System.out.print("\nEnter amount to deposit: ");
        float amount = scanner.nextFloat();

        if (amount <= 50000f) {
            transactions++;
            balance += amount;
            System.out.println("\nSuccessfully Deposited");
            transactionHistory += amount + " Rs Deposited\n";
        } else {
            System.out.println("\nSorry, the limit is 50000.00");
        }
    }

    public void transfer() {
        scanner.nextLine(); 
        System.out.print("\nEnter Recipient's Name: ");
        String recipient = scanner.nextLine();
        System.out.print("\nEnter Amount to Transfer: ");
        float amount = scanner.nextFloat();

        if (balance >= amount) {
            if (amount <= 10000f) {
                transactions++;
                balance -= amount;
                System.out.println("\nSuccessfully Transferred to " + recipient);
                transactionHistory += amount + " Rs Transferred to " + recipient + "\n";
            } else {
                System.out.println("\nSorry, the limit is 10000");
            }
        } else {
            System.out.println("\nInsufficient Balance");
        }
    }

    public void transactionHistory() {
        if (transactions == 0) {
            System.out.println("\nNo transactions yet.");
        } else {
            System.out.println("\nTransaction History:\n" + transactionHistory);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM_Interface atm = new ATM_Interface();

        int choice;
        boolean loggedIn = false;

        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. Transfer");
            System.out.println("6. Transaction History");
            System.out.println("7. QUIT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.register();
                    break;
                case 2:
                    loggedIn = atm.login();
                    break;
                case 3:
                    if (loggedIn) {
                        atm.withdraw();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 4:
                    if (loggedIn) {
                        atm.deposit();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 5:
                    if (loggedIn) {
                        atm.transfer();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 6:
                    if (loggedIn) {
                        atm.transactionHistory();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 7:
                    System.out.println("Thank you for using our ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);
    }
}
