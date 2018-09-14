/**
 * Shopping Cart.
 * @author Nehru Perumalla.
 */
import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for item.
 */
class Item {
    /**
     * Name.
     */
    private String name;
    /**
     * quantity of Products.
     */
    private int quantity;
    /**
     * Price per Unit.
     */
    private double uprice;
    /**
     * Constructs the object.
     *
     * @param      pname      The pname
     * @param      pquantity  The pquantity
     * @param      price      The price
     */
    Item(final String pname, final int pquantity, final int price) {
        this.name = pname;
        this.quantity = pquantity;
        this.uprice = price;
    }
    /**
     * Constructs the object.
     *
     * @param      name1      The name 1
     * @param      quantity1  The quantity 1
     */
    Item(final String name1, final int quantity1) {
        this.name = name1;
        this.quantity = quantity1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the quantity.
     *
     * @return     The quantity.
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * Sets the quantity.
     *
     * @param    quantity1  The quantity
     */
    public void setQuantity(final int quantity1) {
        this.quantity = quantity1;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public Double getPrice() {
        return uprice;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        s += name + " " + quantity + " " + uprice;
        return s;
    }
}
/**
 * Class for shopping cartesian.
 */
class ShoppingCart {
    /**
     * Size of Catalog.
     */
    private int size;
    /**
     * Size of Cart.
     */
    private int csize;
    /**
     * Catalog Items.
     */
    private Item[] items;
    /**
     * Cart Items.
     */
    private Item[] citems;
    /**
     * Coupons.
     */
    private String[] coupons;
    /**
     * Available Coupon.
     */
    private boolean couponAvailable;
    /**
     * Coupon Percentage.
     */
    private double c;
    /**
     * Tax variable.
     */
    private double tax;
    /**
     * Disc.
     */
    private double disc;
    /**
     * Constructs the object.
     */
    ShoppingCart() {
        size = 0;
        csize = 0;
        couponAvailable = false;
        items = new Item[TEN];
        citems = new Item[TEN];
        coupons = new String[]{"IND10", "IND20", "IND30", "IND50"};
        c = 0.0;
        disc = 0.0;
        tax = 0.0;
    }
    /**
     * { function_description }.
     */
    public void resize() {
        items = Arrays.copyOf(items, items.length * 2);
        citems = Arrays.copyOf(citems, citems.length * 2);
    }
    /**
     * Adds to catalog.
     *
     * @param      item  The item
     */
    public void addToCatalog(final Item item) {
        if (size >= items.length) {
            resize();
        }
        items[size] = item;
        size += 1;
    }
    /**
     * Adds to cartesian.
     *
     * @param      item  The item
     */
    public void addToCart(final Item item) {
        if (csize >= citems.length) {
            resize();
        }
        int index = indexOfCItem(item);
        if (index == -1) {
            for (int i = 0; i < size; i++) {
                if (items[i].getName().equals(item.getName())
                    && (items[i].getQuantity() >= item.getQuantity())) {
                    citems[csize] = item;
                    csize += 1;
                }
            }
        } else {
            int quantity = citems[index].getQuantity() + item.getQuantity();
            Item temp = items[index];
            if (temp.getQuantity() >= item.getQuantity()) {
                citems[index].setQuantity(quantity);
            }
        }
    }
    /**
     * { Index of Cart Item }.
     *
     * @param      item  The item
     *
     * @return     { Returns Integer Value }
     */
    public int indexOfCItem(final Item item) {
        for (int i = 0; i < csize; i++) {
            if (citems[i].getName().equals(item.getName())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * { Index of Catalog Item }.
     *
     * @param      item  The item
     *
     * @return     { Returns Integer Value }
     */
    public int indexOfItem(final Item item) {
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(item.getName())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Removes a from cart.
     *
     * @param      item  The item
     */
    public void removeFromCart(final Item item) {
        int k = indexOfCItem(item);
        if (k != -1) {
            if (citems[k].getQuantity() == item.getQuantity()) {
                for (int i = k; i < csize; i++) {
                    citems[i] = citems[i + 1];
                }
                csize -= 1;
            } else if (citems[k].getQuantity() > item.getQuantity()) {
                citems[k].setQuantity(
                    citems[k].getQuantity() - item.getQuantity());
            } else {
                System.out.println("Not Applicable");
            }
        }
    }
    /**
     * Shows the cart.
     */
    public void showCart() {
        for (int i = 0; i < csize; i++) {
            System.out.println(citems[i].getName() + " "
                + citems[i].getQuantity());
        }
    }
    /**
     * Shows the catalog.
     */
    public void showCatalog() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[i]);
        }
    }
    /**
     * Total Amount Method.
     *
     * @return     { returns Double }
     */
    public double totalAmount() {
        double amount = 0.0;
        int k = 0;
        for (int i = 0; i < csize; i++) {
            k = indexOfItem(citems[i]);
            if (k != -1) {
                amount += items[k].getPrice() * citems[i].getQuantity();
            }
        }
        return amount;
    }
    /**
     * TEN.
     */
    private static final int TEN = 10;
    /**
     * PO Variable.
     */
    private static final double PO = 0.15;
    /**
     * Gets the payable amount.
     *
     * @return     The payable amount.
     */
    public double getPayableAmount() {
        double amount = totalAmount();
        disc = amount * c / TEN;
        amount -= disc;
        tax = amount * PO;
        amount += tax;
        return amount;
    }
    /**
     * Three.
     */
    private static final int THREE = 3;
    /**
     * Determines if coupon.
     *
     * @param      coupon  The coupon
     */
    public void isCoupon(final String coupon) {
        for (int i = 0; i < coupons.length; i++) {
            if (coupon.equals(coupons[i]) && !couponAvailable) {
                c = Character.getNumericValue(coupons[i].charAt(THREE));
                couponAvailable = true;
                break;
            }
        }
        if (!couponAvailable) {
            System.out.println("Invalid coupon");
        }
    }
    /**
     * Printing Invoice Method.
     */
    public void printInvoice() {
        for (int i = 0; i < csize; i++) {
            int k = indexOfItem(citems[i]);
            System.out.println(citems[i].getName() + " "
                + citems[i].getQuantity() + " " + items[k].getPrice());
        }
        System.out.println("Total:" + totalAmount());
        System.out.println("Disc%:" + disc);
        System.out.println("Tax:" + tax);
        System.out.println("Payable amount: " + getPayableAmount());
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructor.
     */
    private Solution() {
        /**
         * Constructor.
         */
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart s = new ShoppingCart();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "Item":
                    String[] str = tokens[1].split(",");
                    s.addToCatalog(new Item(str[0], Integer.parseInt(str[1]),
                        Integer.parseInt(str[2])));
                break;
                case "add":
                    str = tokens[1].split(",");
                    s.addToCart(new Item(str[0],
                        Integer.parseInt(str[1])));
                break;
                case "remove":
                    str = tokens[1].split(",");
                    s.removeFromCart(new Item(str[0],
                        Integer.parseInt(str[1])));
                break;
                case "show":
                    s.showCart();
                break;
                case "catalog":
                    s.showCatalog();
                break;
                case "coupon":
                    s.isCoupon(tokens[1]);
                break;
                case "totalAmount":
                    System.out.println("totalAmount: " + s.totalAmount());
                break;
                case "payableAmount":
                    System.out.println("Payable amount: "
                        + s.getPayableAmount());
                break;
                case "print":
                    System.out.println("Name   quantity   Price");
                    s.printInvoice();
                break;
                default:
                break;
            }
        }
    }
}
