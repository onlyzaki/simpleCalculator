import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        set.add("break");
        set.add("stop");
        double num1 = 0;
        double num2;
        double result = 0;
        char operator;
        String temp;
        while (true){
            System.out.print("Enter the first number: ");
            temp = scanner.next().replace(',','.');
            if (set.contains(temp)){
                break;
            }
            if (temp.equals("ans")){
                num1 = result;
            }else {
                try {
                    num1 = Double.parseDouble(temp);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, accepts only numbers!");
                    continue;
                }
            }
            System.out.print("Enter the operator + | - | * | / | ^ : ");
            operator = scanner.next().charAt(0);

            System.out.print("Enter the second number: ");
            temp = scanner.next().replace(',','.');
            if (set.contains(temp)){
                break;
            }
            try {
                num2 = Double.parseDouble(temp);
            }catch (NumberFormatException e){
                System.out.println("Invalid input, accepts only numbers!");
                continue;
            }
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> {
                    if (num2 == 0) {
                        System.out.println("Cannot divide by zero, try again!");
                        continue;
                    } else {
                        result = num1 / num2;
                    }
                }
                case '^' -> result = Math.pow(num1, num2);
                default -> {
                    System.out.println("Invalid operator, try again!");
                    continue;
                }
            }
            System.out.println(result);
        }
        System.out.println("Thank you for using my app! Made by onlyzaki.");
        scanner.close();
    }
}