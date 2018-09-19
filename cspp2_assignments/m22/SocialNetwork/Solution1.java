import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
class SocialNetwork {
	String name;
	List<String> friends = new List<String>();
	SocialNetwork(String name, String[] friend) {
		this.name = name;
		for (int i = 0; i < friend.length; i++) {
			friends.add(friend[i]);
		}
	}

	public String getName() {
		return this.name;
	}

	public List getFriends() {
		return friends;
	}
	public String toString() {
		String s = getName() + ": [";
		for (int i = 0; i < getFriends().size() - 1; i++) {
			s += getFriends().get(i) + ", ";
		}
		s += getFriends().get(getFriends().size() - 1) + "]";
		return s;
	}
}

class Connections {
	List<SocialNetwork> s = new List<SocialNetwork>();
	Connections() {
	}
	public void addTo(SocialNetwork soc) {
		s.add(soc);
	}
	public void addConnection(String name, String friend) {
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getName().equals(name)) {
				s.get(i).getFriends().add(friend);
			}
		}
	}

	public List getConnections(String name) {
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getName().equals(name)) {
				return s.get(i).getFriends();
			}
		}
		System.out.println("Not a User in Network");
		return null;
	}

	public List getCommonConnections(String name1, String name2) {
		List<String> common = new List<String>();
		List<String> friendsA = getConnections(name1);
		List<String> friendsB = getConnections(name2);
		if (friendsA != null && friendsB != null) {
			for (int i = 0; i < friendsA.size(); i++) {
				if (friendsB.contains(friendsA.get(i))) {
					common.add(friendsA.get(i));
				}
			}
		}
		return common;
	}

	public String toString() {
		String[] keys = new String[s.size()];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = s.get(i).getName();
		}
		Arrays.sort(keys);
		String s = "";
		int i = 0;
		for (i = 0; i < keys.length - 1; i++) {
			s += keys[i] + ": " + getConnections(keys[i]) + ", ";
		}
		s += keys[i] + ": " + getConnections(keys[i]);
		return s;
	}

} 


public class Solution1 {
	public static void main(String[] args) {
		//SocialNetwork s = new SocialNetwork();
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int x = Integer.parseInt(input[1]);
		Connections con = new Connections();
		while (x != 0) {
			String[] line = scan.nextLine().split(" is connected to ");
			String[] friends = line[1].replace(".","").split(", ");
			con.addTo(new SocialNetwork(line[0], friends));
			x -= 1;
		}
		while (scan.hasNext()) {
			String[] func = scan.nextLine().split(" ");
			switch (func[0]) {
				case "addConnections":
					con.addConnection(func[1], func[2]);
				break;
				case "getConnections":
				if (con.getConnections(func[1]) != null) {
					System.out.println(con.getConnections(func[1]));
				}
				break;
				case "CommonConnections":
				System.out.println(con.getCommonConnections(func[1], func[2]));	
				break;
				case "Network":
				System.out.println(con);
				default:
				break;
			}
		}
	}
}