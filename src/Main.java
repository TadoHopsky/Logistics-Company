import java.util.Scanner;

public class Main {

    private static final double DOLLAR_EXCHANGE_RATE = 90.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShippingCalculator sc = new ShippingCalculator();
        WarehouseManager wm = new WarehouseManager();

        wm.loadFromFile();
        sc.getFirstInfoForUser(scanner, wm);

        while (true) {
            System.out.println("""
            Выберите действие:
            1. Рассчитать новый груз
            2. Показать тяжелые грузы
            3. Очистить склад
            0. Выход""");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
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

                        System.out.println("Добавить этот расчет в базу склада? (yes/no)");
                        if(scanner.nextLine().equalsIgnoreCase("yes")){
                            wm.addCargo(cargoModel);
                        }

                    }catch (NumberFormatException e){
                        System.err.println("Ошибка вода от пользователя\nОжидается число\n" + e);
                    }

                    sc.getAnswerAboutRepeat();
                    String userInput = scanner.nextLine();

                    if(!userInput.equalsIgnoreCase("yes")){
                        break;
                    }
                }

            } else if (choice.equals("2")) {
                System.out.println("Введите порог веса: ");
                double threshold = Double.parseDouble(scanner.nextLine());
                wm.findHeavyCargo(threshold);
            } else if (choice.equals("3")) {
                wm.clearInventory();
                System.out.println("Склад очищен.");
            } else if (choice.equals("0")) {
                break; // Выход из цикла
            }
        }
        /*  while (true){
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

                System.out.println("Добавить этот расчет в базу склада? (yes/no)");
                if(scanner.nextLine().equalsIgnoreCase("yes")){
                    wm.addCargo(cargoModel);
                }

            }catch (NumberFormatException e){
                System.err.println("Ошибка вода от пользователя\nОжидается число\n" + e);
            }

            sc.getAnswerAboutRepeat();
            String userInput = scanner.nextLine();

            if(!userInput.equalsIgnoreCase("yes")){
                break;
            }
        }

         */
        wm.showAllCargo();
        wm.saveToFile();

        scanner.close();
    }
}