import java.util.Scanner;

public class Main {

    private static final double DOLLAR_EXCHANGE_RATE = 90.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShippingCalculator sc = new ShippingCalculator();
        sc.getFirstInfoForUser();

        while (true){
            try{
                double cargo = sc.getCargoFromUser(scanner);
                double distance = sc.getDistanceFromUser(scanner);
                DeliveryType deliveryType = sc.getDeliveryType(scanner);

                if(cargo <= 0 || distance <= 0){
                    System.err.println("Ошибка: данные должны быть положительными");
                    continue;
                }

                System.out.println("Есть промокод? Введите его или нажмите Enter, чтобы пропустить:");
                String promo = scanner.nextLine();

                Cargo cargoModel = new Cargo(cargo, distance, deliveryType);

                double total = sc.calculatePrice(cargoModel, promo);
                System.out.println("Итог: " + total + " руб.");
                System.out.println("Итог: " + Math.ceil(total / DOLLAR_EXCHANGE_RATE) + " USD.");

            }catch (NumberFormatException e){
                System.err.println("Ошибка вода от пользователя\nОжидается число\n" + e);
            }

            sc.getAnswerAboutRepeat();
            String userInput = scanner.nextLine();

            if(!userInput.equalsIgnoreCase("yes")){
                break;
            }
        }
        scanner.close();
    }
}