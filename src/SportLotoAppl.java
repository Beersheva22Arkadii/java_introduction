
public class SportLotoAppl {

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in a sequence of 6 random numbers
	 * no additional collections / arrays
	 */
	private static final int N_DIGIT = 6;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("" + 100 + " " + 200);
		long store = 0;
		int d;
		for (int i = 0; i < N_DIGIT; i++) {
			do {
				d = getRandomInt(1, 49); // 10
			} while (BitOperations.getBitValue(store, d) == 1);
			store = BitOperations.setBitValue(store, d, true);
			System.out.println(d + " ");
		}
	}
	
	public static int getRandomInt(int min, int max) {
		return (int)(min + Math.random() * (max - min + 1));
	}

}
