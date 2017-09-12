package mainX;

import java.util.Scanner;

public class bankIO {

    static String choice1;
    static int choice, x = 0, balance = 0, accountX=0,account=-20, bal = 0;
    static String[][] database = new String[20][3];

    public static void main(String[] args) {
       while(true){
        menuX();
       }
    }

    public static void menuX() {
        Scanner input = new Scanner(System.in);
        mariam:
        while (true) {
            System.out.println("Welcome to BankApp\nWhat would you like to do today?\n1.Create New Account\n2.Log In to your account\n3. Exit");
            choice1 = input.nextLine();
            try {
                choice = Integer.parseInt(choice1);
            } catch (Exception e) {
                System.out.println("Wrong Input");
                continue mariam;
            }

            if (choice == 1) {
                createNew();
                break;
            } else if (choice == 2) {
                logIn();
                break;
            } else if (choice == 3) {
                System.exit(0);
            } else {
                System.out.println("Wrong Input");
                continue mariam;
            }
        }
    }

    public static void createNew() {
        Scanner input = new Scanner(System.in);
        int yu=2;
        queenbee:
        while(true){
        if(accountX<database.length){
            if(yu==2){
            System.out.println("WELCOME! Create A New Account Here\nEnter your username");
            String theUsername=input.nextLine();
            for(int bv=0;bv<database.length;bv++){
            if(theUsername.equalsIgnoreCase(database[bv][0])){
                System.out.println("Username exists");
                continue queenbee;
            }
            }
             database[accountX][0]=theUsername;
            yu=3;
            }
            System.out.println("Enter your password");
            database[accountX][1] = input.nextLine();
            System.out.println("Account Created Successfully\nYour Username :\t " + database[accountX][0] + "\nYour Password :\t" + database[accountX][1]);
            database[accountX][2] = "0";
            accountX+=1;
            menuX();
        }else{
            System.out.println("Accounts are full, consult admin");
        }
        break;
        }
    }

    public static void logIn() {
        Scanner input = new Scanner(System.in);
        int a = 0;
        userCheck:
        while (true) {
            System.out.println("LogIn Here\nEnter your username");
            String userN = input.nextLine();
            for (int y = 0; y < database.length; y++) {
                if (userN.equalsIgnoreCase(database[y][0])) {
                    account = y;
                    a = 5;
                    break;
                }
            }
            if (a == 0) {
                System.out.println("UserName does not exist!");
                continue userCheck;
            }
            passCheck:
            while (true) {
                System.out.println("LogIn Here\nEnter your password");
                String passW = input.nextLine();
                if (passW.equalsIgnoreCase(database[account][1])) {
                    menu();
                    break;
                } else {
                    System.out.println("Invalid PassWord!");
                    continue passCheck;
                }
            }
            break;
        }
    }

    public static void debit() {
        Scanner input = new Scanner(System.in);
        checkBal:
        while (true) {
            System.out.println("Enter amount you want to withdraw");
            String withdraw = input.nextLine();
            int amount = Integer.parseInt(database[x][2]);
            try {
                bal = Integer.parseInt(withdraw);
            } catch (Exception e) {
                System.out.println("Invalid Amount! Try again");
                continue checkBal;
            }
            int newBal = amount - bal;
            if (bal <= amount) {
                System.out.println("Withdrawal successful\nNew account balance is : " + newBal);
                database[account][2]=""+newBal;
                break;
            } else {
                System.out.println("Your account balance is below : " + withdraw + "\nCurrent balance is" + amount);
                menu();
            }
        }
    }

    public static void credit() {
        Scanner input = new Scanner(System.in);
        int depositX = 0;
        jossy:
        while (true) {
            System.out.println("Enter amount you want to deposit");
            String deposit = input.nextLine();
            int amount = Integer.parseInt(database[x][2]);
            try {
                depositX = Integer.parseInt(deposit);
            } catch (Exception e) {
                System.out.println("Wrong amount format");
                continue jossy;
            }
            int newBal = amount + depositX;
              database[account][2]=""+newBal;
            System.out.println(depositX + "has been credited to your account" + "\nCurrent balance is" + newBal);
            break;
        }
    }

    public static void checkBalance() {
        System.out.println("Your balance is :" + database[account][2]);
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);
        int menuChoice = 0;
        String menuChoiceX;
        menuV:
        while (true) {
            System.out.println("Hello " + database[account][0] + "\nSelect \n1.To Withdraw Cash\n2.To Deposit Cash\n3.To Check Balance\n4.To Log Out");
            menuChoiceX = input.nextLine();
            try {
                menuChoice = Integer.parseInt(menuChoiceX);
            } catch (Exception e) {
                System.out.println("Invalid Input. Use value between 1-4");
                continue menuV;
            }

            if (menuChoice == 1) {
                debit();
            } else if (menuChoice == 2) {
                credit();
            } else if (menuChoice == 3) {
                checkBalance();
            } else if (menuChoice == 4) {
                    account=-20;
                    break;
            } else {
                System.out.println("Invalid Input. Use value between 1-4");
                continue menuV;
            }
        }
    }

}
