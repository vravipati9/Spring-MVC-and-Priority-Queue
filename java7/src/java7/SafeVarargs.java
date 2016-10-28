package java7;

import java.util.ArrayList;
import java.util.List;

public class SafeVarargs {
	public static void main(String[] args) {
		
	}
	
	@java.lang.SafeVarargs
	static List<String> concat(List<String>... lists) {
		List<String> finalList  = new ArrayList<>();
		for (List<String> list : lists) {
			for (String string : list) {
				finalList.add(string);
			}
		}
		return finalList;
	}
}
