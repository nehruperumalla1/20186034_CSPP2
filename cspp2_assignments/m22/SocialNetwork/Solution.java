import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
class SocialNetwork {
	HashMap<String, List<String>> map;
	SocialNetwork() {
		map = new HashMap<String, List<String>>();
	}

	public void newConnection(String user, String[] frands) {
		List<String> frnds = new List<String>();
		for (String e : frands) {
			frnds.add(e);
		}
		map.put(user, frnds);
	}
	public void addConnection(String unique, String request) {
		List<String> friends = map.get(unique);
		friends.add(request);
	}

	public List getConnections(String unique) {
		if (map.containsKey(unique)) {
			return map.get(unique);
		}
		return null;
	}

	public List getCommonConnections(String unique1, String unique2) {
		List<String> common = new List<String>();
		if (map.containsKey(unique1) && map.containsKey(unique2)) {
			for (int i = 0; i < map.get(unique1).size(); i++) {
				for (int j = 0; j < map.get(unique2).size(); j++) {
					if (map.get(unique1).get(i).equals(map.get(unique2).get(j))) {
						common.add(map.get(unique1).get(i));
					}
				}
			}
		}
		return common;
	}
}

public class Solution {
	public static void main(String[] args) {
		SocialNetwork s = new SocialNetwork();
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int x = Integer.parseInt(input[1]);
		while (x != 0) {
			String[] line = scan.nextLine().split(" is connected to ");
			String[] friends = line[1].replace(".","").split(", ");
			s.newConnection(line[0], friends);
			x -= 1;
		}
		while (scan.hasNext()) {
			String[] func = scan.nextLine().split(" ");
			switch (func[0]) {
				case "addConnection":
					s.addConnection(func[1], func[2]);
				break;
				case "getConnections":
				System.out.println(s.getConnections(func[1]));
				break;
				case "getCommonConnections":
				System.out.println(s.getCommonConnections(func[1], func[2]));	
				break;
				default:
				break;
			}
		}
	}
}