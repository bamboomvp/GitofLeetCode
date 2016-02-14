package baodavi;
public class SingleNumberII {

/*
Haven't seen the right answer, even though it's very easy to test.

In a recent HotSpot VM, the correct answer is Integer.MAX_VALUE - 5. Once you go beyond that:

public class Foo {
  public static void main(String[] args) {
    Object[] array = new Object[Integer.MAX_VALUE - 4];
  }
}
You get:

Exception in thread "main" java.lang.OutOfMemoryError:
  Requested array size exceeds VM limit
*/
	
/*
Going by this article

http://en.wikipedia.org/wiki/Criticism_of_Java#Large_arrays

Java has been criticized for not supporting arrays of more than 2^31−1 (about 2.1 billion) elements. This is a limitation of the language; the Java Language Specification, Section 10.4, states that:

Arrays must be indexed by int values... An attempt to access an array component with a long index value results in a compile-time error.
Supporting large arrays would also require changes to the JVM. This limitation manifests itself in areas such as collections being limited to 2 billion
elements and the inability to memory map files larger than 2 GB. Java also lacks true multidimensional arrays (contiguously allocated single blocks of 
memory accessed by a single indirection), which limits performance for scientific and technical computing.
 */
	public int singleNumber(int[] A) {
		int[] eachBitAcc = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				eachBitAcc[i] += (A[j] >> i) & 1;
			}
		}
		int res = 0;
		for (int k = 0; k < 32; k++) {
			res += ((eachBitAcc[k] % 3) & 1) << k;
		}

		return res;
	}
}
