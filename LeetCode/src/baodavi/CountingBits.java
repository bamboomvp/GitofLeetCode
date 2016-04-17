package baodavi;

/*
0    0000    0
-------------
1    0001    1
-------------
2    0010    1
3    0011    2
-------------
4    0100    1
5    0101    2
6    0110    2
7    0111    3
-------------
8    1000    1
9    1001    2
10   1010    2
11   1011    3
12   1100    2
13   1101    3
14   1110    3
15   1111    4
*/

//下面这种方法相比第一种方法就要简洁很多了，这个规律找的更好，规律是，从1开始，
//遇到偶数时，其1的个数和该偶数除以2得到的数字的1的个数相同，
//遇到奇数时，其1的个数等于该奇数除以2得到的数字的1的个数再加1，参见代码如下：

// The real reason is: the current number to be right shifted to get another number, that number is already calculated and stored!!!
public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i = 1; i <= num; i++){
        	res[i] = res[i >>> 1] + (i % 2);
        }
        return res;
    }
}
