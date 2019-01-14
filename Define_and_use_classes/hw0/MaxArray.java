public class MaxArray {
    public static int max(int[] m) {
        int Array_len = m.length;
        int Max = m[0];
		/*
			while loop version
        int i = 1;
        while (i < Array_len){
            if(m[i] > Max){
                Max = m[i];
            }
            i++;
        }
        */
        for(int i = 1; i < Array_len;i++){
            if(m[i] > Max){
                Max = m[i];
            }
        }
        return Max;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));
    }
}