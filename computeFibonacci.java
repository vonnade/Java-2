int computeFibonacci (int n) {
	int result = 1;
	int lastResult = 1;
	
	for (int x = 0; x < n -2; x++) {
		int temp = result;
		result = result + lastResult;
		lastResult = temp;
	}
	return result;
}