import java.util.Scanner;

public class ShippingCalculator {
    private static final double BASE_DELIVERY_PRICE = 500;
    private static final double WEIGHT_THRESHOLD = 10;
    private static final double HEAVY_CARGO_SURCHARGE_RATE = 0.1;
    private static final int DISTANCE_THRESHOLD = 100;
    private static final int PRICE_PER_EXTRA_KM = 5;

    public void getFirstInfoForUser(){
        System.out.println("""
                Добро пожаловать в консольную утилиту для расчета стоимости доставки груза.
                
                Базовая стоимость доставки груза составляет 500р.
                Если вес груза превышает 10кг, то идет наценка 10%.
                Если расстояние > 100км - добавляем 5 руб. за каждый километр свыше первой сотни""");
    }

    public Double getCargoFromUser(Scanner scanner){
        System.out.println("Введите вес груза: ");
        return replaceDoubleSafe(scanner.nextLine());
    }

    public Double getDistanceFromUser(Scanner scanner){
        System.out.println("Введите дистанцию: ");
        return replaceDoubleSafe(scanner.nextLine());
    }

    private Double replaceDoubleSafe(String input){
        return Double.parseDouble(input.replace(",", "."));
    }

    public DeliveryType getDeliveryType (Scanner scanner){
        System.out.println("""
                Введите тип доставки:
                1.Standard
                2.EXPRESS + 50% к итоговой сумме
                3.FRAGILE + 300р (Хрупкий груз | фиксировано)""");
        String inputDeliveryType = scanner.nextLine();

        return switch (inputDeliveryType){
            case "2" -> DeliveryType.EXPRESS;
            case "3" -> DeliveryType.FRAGILE;
            default -> DeliveryType.STANDARD;
        };
    }

    public Double calculatePrice(Cargo cargo){
        double finalPrice = BASE_DELIVERY_PRICE;

        if(cargo.getWeight() > WEIGHT_THRESHOLD){
            double tenPercent = finalPrice * HEAVY_CARGO_SURCHARGE_RATE;
            finalPrice += tenPercent;
        }

        if(cargo.getDistance() > DISTANCE_THRESHOLD){
            double overDistance = cargo.getDistance() - DISTANCE_THRESHOLD;
            finalPrice = (overDistance * PRICE_PER_EXTRA_KM) + finalPrice;
        }

        if(cargo.getDeliveryType() == DeliveryType.EXPRESS){
            finalPrice *= 1.5;
        } else if (cargo.getDeliveryType() == DeliveryType.FRAGILE) {
            finalPrice += 300;
        }

        return finalPrice;
    }
}
