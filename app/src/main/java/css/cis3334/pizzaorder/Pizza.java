package css.cis3334.pizzaorder;

import java.io.Serializable;

/**
 * Created by tgibbons on 2/10/2017.
 */
public class Pizza implements Serializable {
    public enum pizzaSize { SMALL, MEDIUM, LARGE};
    public static final Double SMALL_PRICE = 7.00;
    public static final Double MEDIUM_PRICE = 9.00;
    public static final Double LARGE_PRICE = 11.00;
    public static final Double EXTRA_CHEESE_PRICE = 1.50;

    private String topping;
    private boolean extraCheese;
    private pizzaSize size;
    private Double price;
    private String description;

    /**
     * Constructor with string for size
     * @param topping
     * @param strSize
     * @param extraCheese
     */
    public Pizza(String topping, String strSize, boolean extraCheese) {
        this.topping = topping;
        if (strSize.equalsIgnoreCase("small")) {
            size = Pizza.pizzaSize.SMALL;
            price = SMALL_PRICE;
            description = "Small " + topping + " pizza";
        } else  if (strSize.equalsIgnoreCase("medium")) {
            size = Pizza.pizzaSize.MEDIUM;
            price = MEDIUM_PRICE;
            description = "Medium " + topping + " pizza";
        } else {
            size = Pizza.pizzaSize.LARGE;
            price = LARGE_PRICE;
            description = "Large " + topping + " pizza";
        }
        this.extraCheese = extraCheese;
        if (extraCheese) {
            price += EXTRA_CHEESE_PRICE;;
            description += " with extra cheese";
        }
    }

    /**
     * Constructor with enum as size
     * @param topping
     * @param size
     * @param extraCheese
     */
    public Pizza(String topping, pizzaSize size, boolean extraCheese) {
        this.topping = topping;
        this.size = size;
        this.extraCheese = extraCheese;
        if (size==pizzaSize.SMALL) {
            price = SMALL_PRICE;
            description = "Small " + topping + " pizza";
        } else if (size==pizzaSize.MEDIUM) {
            price = MEDIUM_PRICE;
            description = "Medium " + topping + " pizza";
        } else {
            price = LARGE_PRICE;
            description = "Large " + topping + " pizza";
        }
        if (extraCheese) {
            price += EXTRA_CHEESE_PRICE;;
            description += " with extra cheese";
        }
    }

    public Double getPrice() {
        return price;
    }

    public String toString() {
        return description;
    }

}
