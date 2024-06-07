package Inheritance;

public class Inheritance {
    public static void main(String[] args) {
        AdvanceCalculator scientificCalculator = new AdvanceCalculator();
        int i = scientificCalculator.sum(2, 4);
        int j = scientificCalculator.minus(10, 4);
        double k = scientificCalculator.root(25);

        System.out.println(i + " " + j + " " + k);
    }
}
