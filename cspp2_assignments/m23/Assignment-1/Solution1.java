import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.regex.*;
import java.util.Set;
class Data {
	String f1;
	Data(Scanner s1) {
		f1 = "";
		while (s1.hasNextLine()) {
			f1 += s1.nextLine();
			f1 += " ";
		}
		f1 = f1.toLowerCase();
	}

	public String[] formatdata() {
		f1 = f1.replaceAll("[^\\p{Alpha} ]", "");
		String[] data = f1.split(" ");
		return data;
	}

	public String getString() {
		return this.f1;
	}
}

class BagOfWords {
	List<Data> bag;
	HashMap<String, Integer> map;
	HashMap<String, List<Integer>> euc;
	private int dcount;
	BagOfWords() {
		bag = new List<Data>();
		map = new HashMap<String, Integer>();
		euc = new HashMap<String, List<Integer>>();
		int dcount = 0;
	}
	public void addTo(Data data) {
		bag.add(data);
	}

	public List getD() {
		return bag;
	}
	public HashMap getMap() {
		return map;
	}
	public void wordcount(Data data1) {
		String[] data = null;
		int c = 0;
		if (bag.indexOf(data1) != -1) {
			data = bag.get(bag.indexOf(data1)).formatdata();
		}
		for (int i = 0; i < data.length; i++) {
			if (map.containsKey(data[i])) {
				int count = map.get(data[i]);
				map.put(data[i], count + 1);
			} else {
				map.put(data[i], 1);
				c += 1;
			}
			this.dcount = c;
		}
	}

	public double freqcount(BagOfWords b) {
		HashMap<String, Integer> map1 = b.getMap();
		Set keys1 = map.keySet();
		Set keys2 = map1.keySet();
		String[] k1 = keys1.toString().replace("[", "").replace("]", "").split(", ");
		String[] k2 = keys2.toString().replace("[", "").replace("]", "").split(", ");
		for (int i = 0; i < k1.length; i++) {
			for (int j = 0; j < k2.length; j++) {
				if (keys2.contains(k1[i]) && keys1.contains(k2[j])) {
						List<Integer> values = new List<Integer>();
						values.add(map.get(k1[i]));
						values.add(map1.get(k1[i]));
						euc.put(k1[i], values);
				} else if(!keys1.contains(k2[j])) {
					List<Integer> values1 = new List<Integer>();
					values1.add(0);
					values1.add(map1.get(k2[j]));
					euc.put(k2[j], values1);
				} else if(!keys2.contains(k1[i])){
					List<Integer> values2 = new List<Integer>();
					values2.add(map.get(k1[i]));
					values2.add(0);
					euc.put(k1[i], values2);
				}
			}
		}
		// Set set2 = euc.entrySet();
  //     	Iterator iterator2 = set2.iterator();
  //     	while(iterator2.hasNext()) {
  //         Map.Entry mentry2 = (Map.Entry)iterator2.next();
  //         System.out.print("Key is: "+mentry2.getKey() + " & Value is: ");
  //         System.out.println(mentry2.getValue());
  //      }

		double x = 0;
		double y = 0;
		int dot = 0;
		Set keys = euc.keySet();
		String[] k = keys.toString().replace("[", "").replace("]", "").split(", ");
		for (int i = 0; i < euc.size(); i++) {
			x += Math.pow(euc.get(k[i]).get(0), 2);
			y += Math.pow(euc.get(k[i]).get(1), 2);
			dot += euc.get(k[i]).get(0) * euc.get(k[i]).get(1);
		}
		double result = dot/(Math.sqrt(x) * Math.sqrt(y));
		return result * 100;
	}

	public int dcount() {
		return dcount;
	}

}

public class Solution1 {
	public static void main(String[] args) {
		BagOfWords b1 = new BagOfWords();
		Scanner sc = null;
		//String filename = sc.nextLine();
		File file = new File("File5.txt");
		try {
		sc = new Scanner(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Data d = new Data(sc);
		b1.addTo(d);
		b1.wordcount(d);
		System.out.println(b1.dcount());

		BagOfWords b2 = new BagOfWords();
		file = new File("File5.txt");
		try {
		sc = new Scanner(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Data d1 = new Data(sc);
		b2.addTo(d1);
		b2.wordcount(d1);
		System.out.println(b1.freqcount(b2));
	}
}