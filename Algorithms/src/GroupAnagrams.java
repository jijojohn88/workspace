import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class GroupAnagrams {

	public static void main(String[] args) {
		
		
		String[] words = {"abc","bca","tax","pims","mat","atm","xat","simp"};
		Collections.sort(Arrays.asList(words));
		for(String s : words) {
			System.out.print(s + ":");
		}
		HashMap<String, String>group = new HashMap<String,String>();
		for(String s : words) {
			char[] str = s.toCharArray();
			Arrays.sort(str);
			String sorted = new String(str);
			if(group.containsKey(sorted)) {
				group.put(sorted,group.get(sorted) + "," + s);
			}
			else { 
				group.put(new String(str),s);
			}
		}
		
		boolean start =true;
		System.out.println();
		for(Entry<String, String> entry : group.entrySet()) {
			if(!start) {
				System.out.print(",");
			}
			start=false;
			System.out.print("{" + entry.getValue() + "}");
		}
	}
}
