public class BreakContinue {
    public static int get_n_sums_after(int[] a, int i, int n){
        if(n > a.length - i - 1){
            n = a.length - i - 1;
        }
        int sum = a[i];
        for(int j = 1;j <= n;j++){
            sum = sum + a[i+j];
        }
        return sum;
    }

    public static void windowPosSum(int[] a, int n) {
        for(int i = 0;i < a.length;i++){
            if(a[i] > 0){
                a[i] = get_n_sums_after(a, i, n);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}