public class SampleClass{
    public double calculate(double price, double percent){
        if (price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }

        if (percent < 0 || percent > 100){
            return price;
        }

        double discount = price * (percent / 100.0);
        return price - discount;
    }
}
