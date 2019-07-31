import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		String str = "#1	安徽.来安光伏发电P	1	0.000";
		String[] strs = str.split("	");
		for (String str1 : strs) {
			System.out.println(str1);
		}
	}
}
