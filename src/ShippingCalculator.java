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

    public Integer getCargoFromUser(Scanner scanner){
        System.out.println("Введите вес груза: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public Integer getDistanceFromUser(Scanner scanner){
        System.out.println("Введите дистанцию: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public Double calculatePrice(int cargo, int distance){
        double finalPrice = BASE_DELIVERY_PRICE;

        if(cargo > WEIGHT_THRESHOLD){
            double tenPercent = finalPrice * HEAVY_CARGO_SURCHARGE_RATE;
            finalPrice += tenPercent;
        }

        if(distance > DISTANCE_THRESHOLD){
            int overDistance = distance - DISTANCE_THRESHOLD;
            finalPrice = (overDistance * PRICE_PER_EXTRA_KM) + finalPrice;
        }
        return finalPrice;
    }
}
