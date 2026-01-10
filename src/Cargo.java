public class Cargo {
    private String name;
    private double weight;
    private int distance;


    public Cargo(String name, double weight, int distance) {
        this.name = name;
        this.weight = weight;
        this.distance = distance;
    }

    public Cargo(double weight, int distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", distance=" + distance +
                '}';
    }
}
