	/**
	 * Computes the remainder when dividing the number represented by the input
	 * parameter by 97. Implements the procedure described at
	 * https://en.wikipedia.org/wiki/International_Bank_Account_Number#Modulo_operation_on_IBAN
	 * to process very large numbers.
	 * 
	 * @param digits
	 *            The number to process, represented as a string
	 * @return The result of digits mod 97
	 */
	int mod97(String digits) {
		int n = Integer.valueOf(digits.substring(0, 9));
		int d = n % 97;
		digits = digits.substring(9);

		// Process the rest of the number
		while (digits.length() > 1) {
			int end = Math.min(7, digits.length());
			n = Integer.valueOf(d + digits.substring(0, end));
			d = n % 97;
			digits = digits.substring(end);
		}
		return d;
	}
