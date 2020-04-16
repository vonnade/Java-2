int computeChecksum (String barcode) {
	
	// Reverses the supplied barcode
	String reversedBarcode = new StringBuffer(barcode).reverse().toString();		
	// Declare required vars
	int currentBarcodePosition = 0;
	int checkSum = 0;
	int result = 0;
		
	// Checks what kind of EAN was entered
	if (barcode.length() == 12 || barcode.length() == 7){
		// Loops through every number in the barcode
		while (currentBarcodePosition != barcode.length()){
			// Ensures selected character is a digit
			if (Character.isDigit(reversedBarcode.charAt(currentBarcodePosition))){
				// Even position: add the digit to the sum
				if ((currentBarcodePosition + 1) % 2 == 0){
					int temp = Character.getNumericValue(reversedBarcode.charAt(currentBarcodePosition));
					checkSum = checkSum + temp;
				}
				// Odd position: multiply the digit and weight and then add it to the sum
				else{
					int temp = Character.getNumericValue(reversedBarcode.charAt(currentBarcodePosition));
					int quickSum = 3 * temp;
					checkSum = checkSum + quickSum;
				}
				// Adds one to the position count
				currentBarcodePosition++;
			}
			else{
				// Returns error message and code
				System.out.println("Invalid barcode format");
				result = -2;
				return result;
			}
		}
		// Returns the checksum digit
		int checkDigit = 10 - (checkSum % 10);
		if (checkDigit == 10){
			result = 0;
			return result;
		}
		else{
			result = checkDigit;
			return result;
		}	
	}
	else {
		// Returns error message and code
		System.out.println("Invalid barcode length");
		result = -1;
		return result;
	}

}