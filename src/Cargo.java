public class Cargo {
    private DeliveryType deliveryType;
    private double weight;
    private double distance;

    public Cargo(double distance, double weight, DeliveryType deliveryType) {
        this.distance = distance;
        this.weight = weight;
        this.deliveryType = deliveryType;
    }

    public Cargo(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Вес груза: " + weight +
                ", Дистанция: " + distance;
    }
}
