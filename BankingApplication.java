package bank;

import java.util.Scanner;

public class BankingApplication {
    static class BankAccount{
        int balance;
        int previousTransaction;
        String customerName;
        String customerId;

        public BankAccount(String cName,String cId){
            customerId = cId;
            customerName = cName;
        }

        public void deposit(int amount){
            if (amount != 0){
                balance += amount;
                previousTransaction = amount;
            }
        }

        public void withdraw(int amount){
            if (amount != 0){
                balance -= amount;
                previousTransaction = -amount;
            }
        }

        public void getPreviousTransaction(){
            if (previousTransaction > 0 ){
                System.out.println("Deposited: " +previousTransaction);
            }else if (previousTransaction < 0){
                System.out.println("Withdrawn: " +Math.abs(previousTransaction));
            }else{
                System.out.println("No transaction.");
            }
        }
        public void showMenu(){

            Scanner scan = new Scanner(System.in);
            char option;
            System.out.println("=============================================================");
            System.out.println("=================WELCOME TO OUR BANK=========================");
            System.out.println("=============================================================");
            System.out.println("Welcome " +customerName);
            System.out.println("Your ID: " +customerId);
            System.out.println("What would you like to do ?");
            System.out.println("1.Show Balance");
            System.out.println("2.Deposit ");
            System.out.println("3.Withdraw");
            System.out.println("4.Previous Transaction");
            System.out.println("5.Exit");

            do {
                System.out.println("===========================================================");
                System.out.println("===================ENTER AN OPTION=========================");
                System.out.println("===========================================================");
                option = scan.next().charAt(0);
                System.out.println("\n");

                switch (option){
                    case '1':
                        System.out.println("--------------------------------------------------");
                        System.out.println("Balance: " +balance);
                        System.out.println("--------------------------------------------------");
                        System.out.println("\n");
                        break;

                    case '2':
                        System.out.println("--------------------------------------------------");
                        System.out.println("Enter amount to be deposited: ");
                        System.out.println("--------------------------------------------------");
                        int amount = scan.nextInt();
                        deposit(amount);
                        System.out.println(amount+" has been deposited in your account");
                        System.out.println("\n");
                        break;

                    case '3':
                        System.out.println("--------------------------------------------------");
                        System.out.println("Enter amount to be withdrawn: ");
                        System.out.println("--------------------------------------------------");
                        int amount2 = scan.nextInt();
                        withdraw(amount2);
                        System.out.println(amount2+" has been withdrawn from your account");
                        System.out.println("\n");
                        break;

                    case '4':
                        System.out.println("---------------------------------------------------");
                        System.out.println("your previous transaction is: ");
                        getPreviousTransaction();
                        System.out.println("---------------------------------------------------");
                        System.out.println("\n");
                        break;

                    case '5':
                        System.out.println("*******************************************");
                        System.out.println("**********You are Exiting now**************");
                        System.out.println("*******************************************");
                        break;

                    default:
                        System.out.println("Enter valid option! please try again.");
                        break;

                }
            }while (option != '5');
            System.out.println("Thank you for using our services.");
        }
    }

    public static void main(String... args){

        BankAccount account = new BankAccount("Mukul","123");
        account.showMenu();

    }
}
