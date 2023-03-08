import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 1;
        int N = scanner.nextInt();
        while ((number * number) <= N) {
            System.out.println(number * number);
            number++;
        }
        // start coding here
    }
}
