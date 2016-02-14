package baodavi;
public class PowXN {
	public double pow(double x, int n) {

		if (n == Integer.MIN_VALUE) {
			return 1 / (pow(x, Integer.MAX_VALUE) * x);
		}

		if (n < 0) {
			return 1 / pow(x, -n);
		}

		if (n == 0) {
			return 1;
		}

		double tmp = pow(x, n / 2);
		if (n % 2 == 0) {
			return tmp * tmp;
		} else {
			return tmp * tmp * x;
		}
	}

	public static void main(String[] args) {
		// PowXN ins = new PowXN();
		// double res = ins.pow(1, -2147483648);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}
}
