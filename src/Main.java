import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CoffeeMachine machine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Enter Your Option");
            System.out.println("1) buy");
            System.out.println("2) fillIngredients");
            System.out.println("3) show");
            System.out.println("4) analytics");
            System.out.println("5) exit");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.println("Enter coffee type (espresso, latte, cappuccino):");
                    String coffeeType = scanner.next();
                    machine.buy(coffeeType);
                    break;
                case 2:
                    System.out.println("Enter amount of water to add:");
                    int waterToAdd = scanner.nextInt();
                    System.out.println("Enter amount of milk to add:");
                    int milkToAdd = scanner.nextInt();
                    System.out.println("Enter amount of beans to add:");
                    int beansToAdd = scanner.nextInt();
                    machine.fillIngredients(waterToAdd, milkToAdd, beansToAdd);
                    break;
                case 3:
                    machine.show();
                    break;
                case 4:
                    machine.analytics();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid action");
                    break;
            }
        }
    }
}