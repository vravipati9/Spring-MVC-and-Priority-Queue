package java7;

public class StringInSwitch {

	public static void main(String[] args) {
		
		
	}
	
	int monthNameToDays(String s, int year) {
		if (s.equals("April") ||
				s.equals("June") ||
				s.equals("September") ||
				s.equals("November")) {
			return 30;
		} else if (s.equals("january") ||
				s.equals("March") ||
				s.equals("May") ||
				s.equals("July") ||
				s.equals("August") ||
				s.equals("December")) {
			return 31;
		} else if (s.equals("February")) {
			return 28;
		} else {
			throw new IllegalArgumentException();
		}
	}	
	
	int monthNameToDaysWithSwitch(String s, int year) {
		switch (s) {
		case "April":
		case "June":
		case "September":
			return 30;

		case "january":
		case "March":
		case "July":
			return 31;

		default:
			throw new IllegalArgumentException();
		}
	}	

	
}
