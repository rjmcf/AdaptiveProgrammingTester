public class Main {

    public static void main(String[] args) {
        int n = 5;
        n *= 2;
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}