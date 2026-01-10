import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ShippingCalculator sc = new ShippingCalculator();
        sc.getFirstInfoForUser();

        int cargo = sc.getCargoFromUser(scanner);
        int distance = sc.getDistanceFromUser(scanner);

        System.out.println(sc.calculatePrice(cargo, distance));
    }
}
