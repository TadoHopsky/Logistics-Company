import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShippingCalculator sc = new ShippingCalculator();
        sc.getFirstInfoForUser();

        while (true){
            try{
                int cargo = sc.getCargoFromUser(scanner);
                int distance = sc.getDistanceFromUser(scanner);

                if(cargo <= 0 || distance <= 0){
                    System.err.println("Ошибка: данные должны быть положительными");
                    continue;
                }

                System.out.println(sc.calculatePrice(cargo, distance));
            }catch (NumberFormatException e){
                System.err.println("Ошибка вода от пользователя\nОжидается число\n" + e);
            }

            System.out.println("Хотите рассчитать еще одну доставку? (yes/no)");
            String userInput = scanner.nextLine();

            if(!userInput.equalsIgnoreCase("yes")){
                break;
            }
        }
        scanner.close();
    }
}
