public class DrawTriangle {
    public static void sout_star(int N){
        while(N > 0){
            System.out.print("*");
            N--;
        }
    }
    public static void drawTriangle(int N){
        int i = 0;
        while (i < N){
            i++;
            sout_star(i);
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        drawTriangle(10);
    }
}