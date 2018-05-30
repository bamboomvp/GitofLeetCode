package baodavi;

public class SuperPow {
	public int superPow(int a, int[] b){
		return superPowerSub(a, b, b.length - 1);
	}
	
	private int superPowerSub(int a, int[] b, int index){
		if(index == 0)
			return pow(a, b[index]) % 1337;
		int prev = superPowerSub(a, b, index - 1);
		return (pow(prev, 10) * pow(a, b[index])) % 1337;
	}
	
	private int pow(int x, int n){
		if(n == 0)
			return 1;
		if(n == 1)
			return x % 1337;
		int half = pow(x, n/2);
		if(n % 2 == 0)
			return (half * half) % 1337;
		else
			return (((half*half) % 1337) *(x % 1337)) % 1337;
	}
}
