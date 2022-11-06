
public class Numbers {
static public int getNdigits(long number) {
	int res = 0;
	do {
		number /= 10;
		res++;
	} while(number != 0);
	return res;
}

/**
 * 
 * @param number
 * @return true only if number comprises of 6 digits
 * and sum of first three digits equals the sum of last three digits
 */
static public boolean isHappyNumber(int number) {
	if (getNdigits(number) != 6) {
		return false;
	}
    int sumLeft = 0;
    int sumRight = 0;
	for (int i = 1; i <= 6; i++) {
		int d = number % 10;
		if (i <= 3) {
			sumRight += d;
		} else {
			sumLeft += d;
		}
		number /= 10;
	}
	return sumLeft == sumRight;
}
}
