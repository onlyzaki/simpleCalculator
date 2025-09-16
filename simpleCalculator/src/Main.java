import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        set.add("break");
        set.add("stop");
        int operations;
        double[] numbers;
        String afterNum;
        double result = 0;
        char operator;
        String temp;
        String newCheck;
        boolean zeroDiv;
        boolean valid = true;
        while (valid){
            zeroDiv = true;
            System.out.print("how much numbers do you wanna operate: ");
            newCheck = scanner.next();
            if (set.contains(newCheck)){
                break;
            }
            try {
                operations = Integer.parseInt(newCheck);
            }catch (NumberFormatException e){
                System.out.println("Invalid number, try again");
                scanner.nextLine();
                continue;
            }
            if (operations < 0){
                System.out.println("doesn't accept negative numbers, try again");
                continue;
            } else if (operations > 15) {
                System.out.println("too big of an operation, try again");
                continue;
            }
            numbers = new double[operations];

            System.out.print("Enter the operator + | - | * | / | ^ : ");
            operator = scanner.next().charAt(0);
            boolean condition = operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '^';
            if (!condition){
                System.out.println("Invalid operator, try again!");
                continue;
            }

            for(int i = 1; i < operations + 1; i++){
                switch (i){
                    case 1 ,11-> afterNum = "st";
                    case 2 ,12-> afterNum = "nd";
                    case 3 ,13-> afterNum = "rd";
                    default -> afterNum = "th";
                }
                System.out.printf("Enter the %d%s number: ", i, afterNum);
                temp = scanner.next().replace(',','.');
                if (set.contains(temp)){
                    valid = false;
                    break;
                }
                if(temp.equals("ans")){
                    numbers[i -1] = result;
                }else {
                    try {
                        numbers[i -1] = Double.parseDouble(temp);
                    }catch (NumberFormatException e){
                        System.out.println("Invalid input, accepts only numbers!");
                        i--;
                    }
                }
            }
            if (!valid){
                break;
            }
            result = numbers[0];
            switch (operator){
                case '+' ->{
                    result = 0;
                    for (double num : numbers){
                        result += num;
                    }
                }
                case '-' ->{
                    for (int i = 1; i < numbers.length; i++){
                        result -= numbers[i];
                    }
                }
                case '*' ->{
                    for (int i = 1; i < numbers.length; i++){
                        result *= numbers[i];
                    }
                }
                case '/' ->{
                    for (double check : numbers){
                        if (check == 0){
                            System.out.println("can't devide by zero");
                            zeroDiv = false;
                            break;
                        }
                    }
                    if (zeroDiv){
                        for (int i = 1; i < numbers.length; i++){
                            result /= numbers[i];
                        }
                    }

                }
                case '^' ->{
                    result = numbers[numbers.length - 1];
                    for (int i = numbers.length - 2; i >= 0; i--){
                        result = Math.pow(numbers[i], result);
                    }
                }
                default -> {
                    System.out.println("Invalid operator, try again!");
                    continue;
                }
            }
            System.out.printf("This is the result: %,.3f\n", result);
        }
        System.out.println("Thank you for using my app! Made by onlyzaki.");
        scanner.close();
    }
}
