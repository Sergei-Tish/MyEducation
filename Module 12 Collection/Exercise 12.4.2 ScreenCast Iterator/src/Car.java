public class Car {
    private String brand;
    private String name;
    private boolean onSale;

    public Car(String brand, String name, boolean onSale) {
        this.brand = brand;
        this.name = name;
        this.onSale = onSale;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    @Override
    public String toString() {
        return "Car {" +
                "brand= " + brand +
                ", name= " + name +
                ", onSale= " + onSale +
                "}";
    }
}
