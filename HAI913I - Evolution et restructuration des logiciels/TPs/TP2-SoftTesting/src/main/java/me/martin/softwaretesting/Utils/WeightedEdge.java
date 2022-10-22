package me.martin.softwaretesting.Utils;

public class WeightedEdge extends Edge{

    private double weight;

    public WeightedEdge(Vertex v1, Vertex v2, double weight) {
        super(v1, v2);
        this.weight = weight;
    }

    @Override
    public String toString() {
        String str = String.format("%1.3f", weight);

        return getV1() + " -("+ str +")-> " + getV2();
    }

    public double getWeight() {
        return weight;
    }
}
