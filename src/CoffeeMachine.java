import java.util.Scanner;

public class CoffeeMachine {
    Ingredients ingredients=new Ingredients();
    Scanner scanner = new Scanner(System.in);

    public void take() {
        System.out.println("Money taken: $" + ingredients.getMoney());
        ingredients.setMoney(0);
    }
    public void fillIngredients(int waterToAdd, int milkToAdd, int beansToAdd) {
        ingredients.setWater(ingredients.getWater()+waterToAdd);
        ingredients.setMilk(ingredients.getMilk()+milkToAdd);
        ingredients.setCoffeeBeans(ingredients.getCoffeeBeans()+beansToAdd);
    }

    public void show() {
        System.out.println("Water: " + ingredients.getWater() + " ml");
        System.out.println("Milk: " + ingredients.getMilk()+ " ml");
        System.out.println("Beans: " + ingredients.getCoffeeBeans() + " g");
        System.out.println("Money: $" + ingredients.getMoney());
    }

    public void buy(String coffeeType) {
        int waterNeeded = 0;
        int milkNeeded = 0;
        int beansNeeded = 0;
        int price = 0;

        if (coffeeType.equals( "espresso")) {
            waterNeeded = 250;
            milkNeeded = 0;
            beansNeeded = 16;
            price = 4;
        }
        else if(coffeeType.equals("latte")) {
            waterNeeded = 350;
            milkNeeded = 75;
            beansNeeded = 20;
            price = 7;
        }
        else if (coffeeType.equals("cappuccino")) {
            waterNeeded = 200;
            milkNeeded = 100;
            beansNeeded = 12;
            price = 6;
        }
        else{
            System.out.println("Sorry "+coffeeType+"is not available");
        }

        if (ingredients.getWater()< waterNeeded) {
            System.out.println("Sorry, insufficient water");
        } else if(ingredients.getMilk() < milkNeeded) {
            System.out.println("Sorry, insufficient milk");
        } else if (ingredients.getCoffeeBeans() < beansNeeded) {
            System.out.println("Sorry, insufficient beans");
        } else {
            System.out.println("Dispensing " + coffeeType);
            System.out.println("cost of "+coffeeType+" "+price);
            System.out.println("Enter amount "+price);
            int amount=scanner.nextInt();
            if(amount<price){
                System.out.println("You paid only "+amount+" Please pay remaining "+(price-amount));
                amount=scanner.nextInt();
                System.out.println("You paid "+amount);
                System.out.println("Thank you! Hopping that your day will go as special as this coffee");

            }
            else if(amount==price){
                System.out.println("Thank you! Hopping that your day will go as special as this coffee");
            }
            ingredients.setWater(ingredients.getWater()-waterNeeded);
            ingredients.setMilk(ingredients.getMilk()-milkNeeded);
            ingredients.setCoffeeBeans(ingredients.getCoffeeBeans()-beansNeeded);
            ingredients.setMoney(ingredients.getMoney()+price);
        }
    }

    public void analytics() {
        System.out.println("Number of cups sold: " + ingredients.getMoney() / 4);
        System.out.println("Money earned: $" + ingredients.getMoney());
        System.out.println("Water consumed: " + ingredients.getWater()+ " ml");
        System.out.println("Milk consumed: " + ingredients.getMilk()+ " ml");
        System.out.println("Beans consumed: " + ingredients.getCoffeeBeans() + " g");
    }
}