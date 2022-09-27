package personal.walker.a.notes;

import personal.walker.Solution;

import java.net.SocketImplFactory;

public class LC1680 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(concatenatedBinary(3));
        System.out.println(concatenatedBinary(12));
        System.out.println(concatenatedBinary(48));
        System.out.println(concatenatedBinary(418));
        //  System.out.println(concatenatedBinary(10000));
        System.out.println(concatenatedBinary(995));
        // System.out.println(pow2(3));
//       for (int i = 0 ; i < 64; i ++){
//           System.out.println(pow2(i));
//       }
    }

    // (a ^ n) % x = [(a % x) ^ n] % x
    // 2 ^ 64 % 1000000007 = [(2 ^ 32) % 1000000007] ^ 2   % 1000000007
    // 2 ^ 63 % 1000000007 = 2 ^ 31 * 2 * 32  = 2 ^ 31 % % 1000000007 *  2 ^ 32 % 1000000007
    int constant = 1000000007;
    public int concatenatedBinary(int n) {
        int result = 0;


        int binaryIndex = 0;
        for (int i = n; i >= 1; i--) {
            int temp = i;
            while (temp > 0) {
                if (temp % 2 == 1) {
                    // calculate Math.pow(2,index)

                    // if index > 32 && index % 2 = 0
                        // index /= 2, else index -= 1 than index /= 2
                    result += pow2(binaryIndex);
                    result %= constant;
                }
                temp >>= 1;
                binaryIndex++;
            }
        }
        return result;
    }

    public long pow2(int power){
        if (power == 0){
            return 1;
        }
        long a = 1;
        if ((power & 0x01) == 1){
            a *= 2;
            power--;
        }
        if (power == 0){
            return a;
        }
        a =  ((a % constant ) * (pow2(power / 2) % constant) * (pow2( power / 2) % constant)) % constant;
        return a % constant;
    }
}
