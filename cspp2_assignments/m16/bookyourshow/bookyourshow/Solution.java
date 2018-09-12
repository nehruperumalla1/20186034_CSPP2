import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for book your show.
 */
class BookYourShow {

	private int sh_size;
	private int p_size;
	Patron[] patrons;
	Show[] shows;
	public BookYourShow() {
		this.patrons = new Patron[10];
		this.shows = new Show[10];
		this.sh_size = 0;
		this.p_size = 0;
	}
	public void resize() {
		shows = Arrays.copyOf(shows, 2 * shows.length);
		patrons = Arrays.copyOf(patrons, 2 * patrons.length);
	}

	public void addAShow(Show show) {
		if(sh_size >= shows.length) {
			resize();
		}
		shows[sh_size] = show;
		sh_size += 1;
	}

	public void addAPatron(Patron patron) {
		if (p_size >= patrons.length) {
			resize();
		}
		patrons[p_size] = patron;
		p_size += 1;
	}
	public int sh_size() {
		return sh_size;
	}

	public int p_size() {
		return p_size;
	}
	public Show getAShow(String name, String time) {
		for (int i = 0; i < sh_size; i++) {
			if(name.equals(shows[i].getName()) && time.equals(shows[i].gettime())) {
				return shows[i];
			}
		}
		return null;
	}

	public void bookAShow(String m_name, String time, Patron patron) {
		addAPatron(patron);
		Show book = new Show();
		book = getAShow(m_name, time);
		if (getAShow(m_name, time) != null) {
			if (aseat(patron.getSeats(), book)) {
				for (int i = 0; i < patron.getSeats().length; i++) {
					for (int j = 0; j < book.seats().length; j++) {
						if(book.seats()[j].equals(patron.getSeats()[i])) {
							book.seats()[j] = "N/A";
						}
					}
				}
			}
		}
	}

	public boolean aseat(String[] seat, Show show) {
		int c = 0;
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < show.seats().length; j++) {
				if(show.seats()[j].equals(seat[i])) {
					c += 1;
				}
			}
		}
		if (c == seat.length) {
			return true;
		}
		return false;
	}

	public String printTicket(String name, String time, String num) {
		String str = "No Show";
		if(getAShow(name, time) != null) {
			str = "Invalid";
			for (int i = 0; i < p_size; i++) {
				if(patrons[i].getNum().equals(num)) {
					str = num + " " + name + " " + time;
				}
			}
		}
		return str;
	}

	public void showAll() {

	}
}
/**
 * Class for show.
 */
class Show {
	/**
	 * { Movie Name }.
	 */
	private String mov_name;
	/**
	 * { Date_Time of Show }.
	 */
	private String date_time;
	/**
	 * { Seats }.
	 */
	private String[] seats;
	/**
	 * Constructs the object.
	 */
	public Show() {
		// Empty Constructor.
	}
	/**
	 * Constructs the object.
	 *
	 * @param      movie   The movie
	 * @param      timing  The timing
	 * @param      seats   The seats
	 */
	public Show(final String movie, final String timing, final String[] seats) {
		this.mov_name = movie;
		this.date_time = timing;
		this.seats = seats;
	}
	public String getName() {
		return this.mov_name;
	}

	public String gettime() {
		return this.date_time;
	}

	public String[] seats() {
		return this.seats;
	}
}
/**
 * Class for patron.
 */
class Patron {
	/**
	 * { Name of Customer }.
	 */
	private String name;
	/**
	 * { Mobile Number }.
	 */
	private String num;
	/**
	 * { Seats Booked }.
	 */
	private String[] b_seats;
	/**
	 * Constructs the object.
	 *
	 * @param      cust_name  The customer name
	 * @param      phn        The phn
	 * @param      seats      The seats
	 */
	public Patron(final String cust_name, final String phn, final String[] seats) {
		this.name = cust_name;
		this.num = phn;
		this.b_seats = seats;
	}

	public String getName() {
		return this.name;
	}

	public String getNum() {
		return this.num;
	}

	public String[] getSeats() {
		return this.b_seats;
	}
}
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1], seats));
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show.toString());
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                System.out.println(bys.printTicket(check[1], tokens[1], tokens[2]));
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}
