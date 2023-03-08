

package chucknorris;

import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input operation (encode/decode/exit):");
        label:
        do {
            String operation = scanner.nextLine();
            switch (operation) {
                case "decode": {
                    System.out.println("Input encoded string:");
                    String input = scanner.nextLine();
                    if (Pattern.matches(".*[^0 |\s].*", input)) {
                        System.out.println("Encoded string is not valid.");
                    } else if (!numberOfBlocksIsEven(input)) {
                        System.out.println("Encoded string is not valid.");
                    } else if (!firstBlockOfEachSequence(input)) {
                        System.out.println("Encoded string is not valid.");
                    } else if (zeroCodeToBinary(input).length() % 7 != 0) {
                        System.out.println("Encoded string is not valid.");
                    } else {
                        try {
                            System.out.println("Decoded string:");
                            binaryToAscii(zeroCodeToBinary(input));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Encoded string is not valid.");
                        }
                    }
                    System.out.println("""


                            Please input operation (encode/decode/exit):""");
                    break;
                }
                case "encode": {
                    System.out.println("Input string:");
                    String input = scanner.nextLine();
                    System.out.println("Encoded string:");
                    System.out.println(zeros(binaryValue(input)));
                    System.out.println("\n" + "Please input operation (encode/decode/exit):");
                    break;
                }
                case "exit":
                    System.out.println("Bye!");
                    break label;
                default:
                    System.out.println("There is no '" + operation + "' operation");
                    System.out.println("\n" + "Please input operation (encode/decode/exit):");
                    break;
            }
        } while (scanner.hasNext());
    }
    private static boolean firstBlockOfEachSequence (String encodedString) {
        String[] arrayString = encodedString.split(" ");
        boolean isCorrect = false;
        for (int i = 0; i < arrayString.length; i++){

                if (arrayString[i].equals("0")) {
                    isCorrect = true;
                    i++;
                } else if (arrayString[i].equals("00")) {
                    isCorrect = true;
                    i++;
                } else {
                    isCorrect = false;
                    break;
                }

        }
        return isCorrect;
    }
    private static boolean numberOfBlocksIsEven (String encodedString) {
        String[] arrayString = encodedString.split(" ");
        return arrayString.length % 2 == 0;
    }
    private static void binaryToAscii(String binaryCode) {
        StringBuilder SB = new StringBuilder(binaryCode);
        int l = SB.length();
        for (int i = 7; i < l; i += 7) {
            SB.insert(i, ' ');
            i++;
            l++;
        }
        String[] array = SB.toString().split(" ");
        try {
            for (String s : array) {
                int dec = Integer.parseInt(s, 2);
                char ch = (char) dec;
                System.out.print(ch);
            }
        } catch (Exception e) {
            System.out.println("Encoded string is not valid.");
        }
    }

    private static String zeroCodeToBinary(String zeroCode) {
        String[] zeroCodeArray = zeroCode.split(" ");
        StringBuilder temp = new StringBuilder();
        int length = zeroCodeArray.length;
        for (int i = 0; i < length; i++) {

            if (zeroCodeArray[i].equals("00")) {
                temp.append(countZeros(zeroCodeArray[i + 1]));
                i++;
            } else if (zeroCodeArray[i].equals("0")) {
                temp.append(countOnes(zeroCodeArray[i + 1]));
                i++;
            }
            else {
                System.out.println(length);
            }
        }
        return temp.toString();
    }
    private static String zeros(String input) {
        input = input + " ";
        int j = 0;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                temp.append(input, j, i + 1).append(" ");
                j = i + 1;
            }
        }
        input = temp.toString();
        String[] arrayString = input.split(" ");
        StringBuilder resultBuilder = new StringBuilder();
        for (String s : arrayString) {
            if (s.charAt(0) == '0') {
                resultBuilder.append("00 ").append(countZeros(s)).append(" ");
            } else if (s.charAt(0) == '1') {
                resultBuilder.append("0 ").append(countZeros(s)).append(" ");
            }
        }
        return resultBuilder.toString();
    }
    private static String countZeros(String arrayString) {
        return "0".repeat(arrayString.length());
    }
    private static String countOnes(String arrayString) {
        return "1".repeat(arrayString.length());
    }


    private static String binaryValue(String input) {
        StringBuilder result1 = new StringBuilder();
        int l = input.length();
        for (int i = 0; i < l; i++){
        String binaryVal = Integer.toBinaryString(input.charAt(i));
            result1.append(String.format("%7s", binaryVal).replace(" ", "0"));
        }
        return result1.toString();
    }
}