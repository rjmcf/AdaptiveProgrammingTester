public class Main {

    public static void main(String[] args) {
        int a[] = new int[5];
        for (int i = 0; i < 5; i+=2) {

            a[i--] = i;
        }

        for (int i : a) {
            System.out.println(i);
        }


    }
}