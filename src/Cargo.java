public class Cargo {
    private final DeliveryType deliveryType;
    private final double weight;
    private final double distance;

    public Cargo(double weight, double distance, DeliveryType deliveryType) {
        this.distance = distance;
        this.weight = weight;
        this.deliveryType = deliveryType;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public double getWeight() {
        return weight;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Вес: " + weight + ", Дистанция: " + distance + ", Тип доставки: " + deliveryType;
    }
}
