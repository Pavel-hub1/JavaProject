import java.util.Date;

public class Product {

    private String name;


    private double cost;

    private int shelf;


    private Date loadDate = new Date();


    public Product(String name, double cost, int shelf) {
        this.name = name;
        this.cost = cost;
        this.shelf = shelf;
    }


    public Product() {
        this("0", 0, 0);
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    @Override
    public String toString() {
        return String.format("наименование %s цена %f дата загрузки %s", name, cost, loadDate.toString(), shelf);
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getShelf() {
        return shelf;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.name.equals(((Product) obj).name) && this.cost == (((Product) obj).cost) && this.shelf == (((Product) obj).shelf));
    }

    @Override
    public int hashCode() {
        return name.hashCode() + (int) cost + (int) shelf;
    }
}