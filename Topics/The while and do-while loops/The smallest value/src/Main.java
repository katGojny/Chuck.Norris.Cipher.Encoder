import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        long n = 1;
        long tn = n;
        while (tn <= m) {
            tn *= ++n;
        }
        System.out.println(n);// start coding here
    }
}

