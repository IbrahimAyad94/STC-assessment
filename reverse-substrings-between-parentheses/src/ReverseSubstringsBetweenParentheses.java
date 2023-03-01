public class ReverseSubstringsBetweenParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		resversStringBetweenParentheses(null);
		System.out.println("================================");
		resversStringBetweenParentheses("");
		System.out.println("================================");
		resversStringBetweenParentheses("Test");
		System.out.println("================================");
		resversStringBetweenParentheses("abd(jnb)asdf");
		System.out.println("================================");
		resversStringBetweenParentheses("abdjnbasdf");
		System.out.println("================================");
		resversStringBetweenParentheses("dd(df)a(ghhh)");
		System.out.println("================================");
		resversStringBetweenParentheses("dd(df))a(ghhh)");
		System.out.println("================================");
		resversStringBetweenParentheses("dd(df)a(ghhh()");
		System.out.println("================================");
	}
	
	
	/**
	 * reverse string between parentheses 
	 * @param str
	 */
	public static void resversStringBetweenParentheses(String str) {
		
		// validations 
		if (str == null || str.isEmpty()) {
			System.out.println("The String should not be null or empty");
			return;
		}
		
		if (str.length() > 200) {
			System.out.println("String length should be less than or equal 200 char");
			return;
		}
		
		if (!str.toLowerCase().equals(str)) {
			System.out.println("String should contains lower chars only");
			return;
		}
		
		
		// reverse 
		StringBuilder builder = new StringBuilder();
		int start = -1;
		for (int i = 0; i < str.length(); i++ ) {
			
			// if the string contains right parenthesis before left parenthesis asd)(ad)
			if ((str.charAt(i) + "").equals(")") && start == -1) {
				System.out.println(String.format("The String '%s' is not balanced", str));
				return;
			} 
			
			// if left parenthesis followed by another left parenthesis 
			else if ((str.charAt(i) + "").equals("(") && start != -1) {
				System.out.println(String.format("The String '%s' is not balanced", str));
				return;
			} 
			
			 
			else if ((str.charAt(i) + "").equals("(")) { 
				int end = str.indexOf(')', i);
				
				// if left parenthesis does not followed by right one 
				if (end == -1) {
					System.out.println(String.format("The String '%s' is not balanced", str));
					return;
				}
				
				start = i + 1;
				i = end;
				
				// extract text between left and right parenthesis 
				String stringToBeReversed = str.substring(start, end);
				
				// this to handle cases like aa(ahmed()asd, which string between parenthesis contains another left parenthesis
				if (stringToBeReversed.contains("(")) {
					System.out.println(String.format("The String '%s' is not balanced", str));
					return;
				}

				String reversedStr = reverseString(stringToBeReversed);
				builder.append("(" + reversedStr + ")");
				start = -1;
			} else {
				builder.append(str.charAt(i));
			}
		}
		
		
		System.out.println("Original ==> " + str);
		System.out.println("result ==> " + builder.toString());
		
	}
	
	
	/**
	 * reversse a given string
	 * @param stringToBeRevesed
	 * @return
	 */
	public static String reverseString(String stringToBeRevesed) {
		StringBuilder builder = new StringBuilder();
		for (int i = stringToBeRevesed.length() - 1; i >= 0; i--) {
			builder.append(stringToBeRevesed.charAt(i));
		}
		
		return builder.toString();
	}
}
