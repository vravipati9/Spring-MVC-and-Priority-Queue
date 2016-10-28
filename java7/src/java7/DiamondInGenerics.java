package java7;

import java.util.ArrayList;
import java.util.List;

public class DiamondInGenerics {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		List<? extends Number> list1 = new ArrayList<>();
		System.out.println("Success");
	}
}
