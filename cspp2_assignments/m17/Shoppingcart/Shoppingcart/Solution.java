import java.util.Arrays;
import java.util.Scanner;
class Item {
	private String name;
	private int quantity;
	private double uprice;
	Item(String pname, int pquantity, int price) {
		this.name = pname;
		this.quantity = pquantity;
		this.uprice = price;
	}
	Item(String name1, int quantity1) {
		this.name = name1;
		this.quantity = quantity1;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return uprice;
	}

	public String toString() {
		String s = "";
		s += name + " " + quantity + " " + uprice;
		return s;
	}
}

class ShoppingCart {
	private int size;
	private int csize;
	private Item[] items;
	private Item[] citems;
	private String[] coupons;
	private boolean couponAvailable;
	private double c;
	ShoppingCart() {
		size = 0;
		csize = 0;
		couponAvailable = false;
		items = new Item[10];
		citems = new Item[10];
		coupons = new String[]{"IND10","IND20","IND30","IND50"};
		c = 0;

	}
	public void resize() {
		items = Arrays.copyOf(items, items.length * 2);
		citems = Arrays.copyOf(citems, citems.length * 2);
	}
	public void addToCatalog(Item item) {
		if (size >= items.length) {
			resize();
		}
		items[size] = item;
		size += 1;
	}

	public void addToCart(Item item) {
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

	public int indexOfCItem(Item item) {
		for (int i = 0; i < csize; i++) {
			if (citems[i].getName().equals(item.getName())) {
				return i;
			}
		}
		return -1;
	}

	public int indexOfItem(Item item) {
		for (int i = 0; i < size; i++) {
			if (items[i].getName().equals(item.getName())) {
				return i;
			}
		}
		return -1;
	}


	public void removeFromCart(Item item) {
		int k = indexOfCItem(item);
		if (k != -1) {
			if (citems[k].getQuantity() == item.getQuantity()) {
				for (int i = k; i < csize; i++) {
					citems[i] = citems[i + 1];
				}
				csize -= 1;
			} else if (citems[k].getQuantity() > item.getQuantity()) {
				citems[k].setQuantity(citems[k].getQuantity() - item.getQuantity());
			} else {
				System.out.println("Not Applicable");
			}
		}
	}

	public void showCart() {
		for (int i = 0; i < csize; i++) {
			System.out.println(citems[i].getName() + " " + citems[i].getQuantity());
		}
	}

	public void showCatalog() {
		for (int i = 0; i < size; i++) {
			System.out.println(items[i]);
		}
	}

	public double totalAmount() {
		double amount = 0.0;
		int k = 0;
		for (int i = 0; i < csize; i++) {
			k = indexOfItem(citems[i]);
			if(k != -1) {
				amount += items[k].getPrice() * citems[i].getQuantity();
			}
		}
		return amount;
	}

	public double getPayableAmount() {
		double amount = totalAmount();
		amount += amount * 0.15;
		amount -= (amount * c/10);
		return amount;
	}

	public void isCoupon(String coupon) {
		for (int i = 0; i < coupons.length; i++) {
			System.out.println("Inside for loop");
			if(coupon.equals(coupons[i]) && !couponAvailable) {
				System.out.println("Inside if");
				c = Character.getNumericValue(coupons[i].charAt(3));
				break;
			}
		}
		couponAvailable = true;
	}

	public void printInvoice() {
		for (int i = 0; i < csize; i++) {
			System.out.println(citems[i]);
		}
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ShoppingCart s = new ShoppingCart();
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
				case "Item":
					String[] str = tokens[1].split(",");
					s.addToCatalog(new Item(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2])));
				break;
				case "add":
					str = tokens[1].split(",");
					s.addToCart(new Item(str[0], Integer.parseInt(str[1])));
				break;
				case "remove":
					str = tokens[1].split(",");
					s.removeFromCart(new Item(str[0], Integer.parseInt(str[1])));
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
					System.out.println("total amount: " + s.totalAmount());
				break;
				case "payableAmount":
					System.out.println("Payable amount: " + s.getPayableAmount());
				break;
				case "print":
					s.printInvoice();
				break;
				default:
				break;
			}
		}
	}
}