import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int maxNumber = 0;
        while (scanner.hasNext()) {
            number = scanner.nextInt();
            if (number % 4 == 0) {
                if (number > maxNumber) {
                    maxNumber = number;
                }

            }
          //  System.out.println(maxNumber);
        }
        System.out.println(maxNumber); // start coding here
    }
}