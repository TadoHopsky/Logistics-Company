public class Cargo {
    private double weight;
    private double distance;

    public Cargo(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
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
        return "Cargo{" +
                ", weight=" + weight +
                ", distance=" + distance +
                '}';
    }
}
