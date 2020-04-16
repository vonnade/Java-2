boolean checkIBAN (String iban) {
	
	// Convert IBAN to upper case and remove all whitespace
	iban = iban.toUpperCase().replaceAll(" ", "");
		
	// Check the first 2 characters are a valid country code and the length specific to that country
	// If the length doesn't match up an error message will be returned
	String countryCode = iban.substring(0, 2);
	switch (countryCode) {
			case "GB": if (iban.length() == 22){
				break;
			}
			else{
				System.out.println("Invalid IBAN length: " + iban.length());
				return false;
			}
			case "GR": if (iban.length() == 27){
				break;
			}
			else{
				System.out.println("Invalid IBAN length: " + iban.length());
				return false;
			}
			case "SA": if (iban.length() == 24){
				break;
			}
			else{
				System.out.println("Invalid IBAN length: " + iban.length());
				return false;
			}
			case "CH": if (iban.length() == 21){
				break;
			}
			else{
				System.out.println("Invalid IBAN length: " + iban.length());
				return false;
			}
			case "TR": if (iban.length() == 26){
				break;
			}
			else{
				System.out.println("Invalid IBAN length: " + iban.length());
				return false;
			}
			// Display error message for invalid country code
			default: System.out.println("Unknown country code: " + countryCode);
				return false;
		}	

	// Creates a temp IBAN in the calculation format (not yet converted)
	int currentPosition = 0;
	String tempIBAN = iban.substring(4) + iban.substring(0,4);
	String newIBAN = "";
		
	// Runs through every character ensuring it is valid for an IBAN
	while (currentPosition != iban.length()){
		char currentChar = tempIBAN.charAt(currentPosition);
		if ((currentChar >= 'A' && currentChar <= 'Z') || (currentChar >= '0' && currentChar <= '9')){
			// Convert any letters to the integers required and add to new IBAN string
			if (Character.isDigit(currentChar) == false){
				newIBAN = newIBAN + ((int)currentChar - 55);
			}
			else{
				newIBAN = newIBAN + currentChar;
			}
			// Adds one to the position count
			currentPosition++;		
		}
		else{
			// Display error message for any invalid characters
			System.out.println("Invalid character in IBAN: " + currentChar);
			return false;
		}
	}
	// Calculate mod of the new IBAN to see if it's valid, show result
	int ibanCheck = mod97(newIBAN);
	if (ibanCheck == 1){
		return true;
	}
	else{
		return false;
	}
	
}
