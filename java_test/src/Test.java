import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
//		Map<Integer, String> map = new  HashMap<Integer, String>();
//		map.put(1, "tt");
//		map.put(5, "ee");
//		map.put(3, "ff");
//		map.put(2, "aa");
//		
//		for(Entry<Integer, String> entry : map.entrySet()){
//			System.out.println(entry.getKey()+"---"+entry.getValue());
//		}
//		ArrayList<String> list= new ArrayList<String>();
//		list.add("cc");
//		list.add("dd");
//		list.add("aa");
//		for(String str: list){
//			System.out.println(str);
//		}
		
		Set<String> set = new TreeSet<String>();
		set.add("w");
		set.add("ff");
		set.add("dd");
		set.add("aa");
		set.add("ss");
		set.add("bb");
		for(String str : set){
			System.out.println(str);
		}
	}
}
