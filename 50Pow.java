/*
Implement pow(x, n).
*/

// key point: x^n = x^(n/2) * x^(n/2) * x^(n%2)
public class Solution {
    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        if (n == 1) {
            return x;
        }
        
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = n * -1;
        }
        
        int k = n / 2;
        int l = n % 2;
        
        double t1 = pow(x, k);
        double t2 = pow(x, l);
        
        if (isNegative) {
            return 1 / (t1 * t1 * t2);
        } else {
            return t1 * t1 * t2;
        }
    }
}