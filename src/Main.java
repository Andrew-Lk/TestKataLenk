/*
Требования:

Важно: из условия я понял, что параметры вводятся через "пробел".

        1. Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b.
        Данные передаются в одну строку (смотри пример)!
        Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
        2. Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
        3. Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.
        На выходе числа не ограничиваются по величине и могут быть любыми.
        4. Калькулятор умеет работать только с целыми числами.
        5. Калькулятор умеет работать только с арабскими или римскими цифрами одновременно,
        при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
        6. При вводе римских чисел, ответ должен быть выведен римскими цифрами,
        соответственно, при вводе арабских - ответ ожидается арабскими.
        7. При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
        8. При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций,
        приложение выбрасывает исключение и завершает свою работу.
        9. Результатом операции деления является целое число, остаток отбрасывается.
        10. Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.
        Результатом работы калькулятора с римскими числами могут быть только положительные числа,
        если результат работы меньше единицы, выбрасывается исключение
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите выражение a +-*/ b:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(calc(input));
    }

    public static String calc(String input) {
        ArrayList<Arg> res = result(input);
        int outResult = 0;
        String  outResultString;
        if (res.size() > 3)
            throw new IllegalArgumentException
                    ("т.к. формат математической операции не удовлетворяет заданию" +
                            " - два операнда и один оператор (+, -, /, *)");
        else if (res.size() < 3)
            throw new IllegalArgumentException("т.к. строка не является математической операцией ");
        else if (res.get(0).getIsRim() != res.get(2).getIsRim())
            throw new IllegalArgumentException("т.к. используются одновременно разные системы счисления ");

        else switch (res.get(1).getArg()) {
                case 1:
                    outResult = res.get(0).getArg() + res.get(2).getArg();
                    break;
                case 2:
                    outResult = res.get(0).getArg() - res.get(2).getArg();
                    break;
                case 3:
                    outResult = res.get(0).getArg() * res.get(2).getArg();
                    break;
                case 4:
                    outResult = res.get(0).getArg() / res.get(2).getArg();
                    break;
            }

        if (res.get(0).getIsRim() == true || res.get(2).getIsRim() == true) {
            if (outResult < 0) throw new IllegalArgumentException("т.к. в римской системе нет отрицательных чисел");
            else if (outResult == 0) throw new IllegalArgumentException("т.к. в римской системе нет 0-ля");

            outResultString = transform_number_to_roman_numeral(outResult);
        } else outResultString = Integer.toString(outResult);

        return outResultString;
    }

    // Индентификация ввода, раскладка на состаные части, присвоение значений.
    private static ArrayList<Arg> result(String inputData) {
        // Раскладываем входные данные на составные частиб помещаем в массив и создаем коллекцию для этих данных.
        String[] arguments = inputData.split(" ");
        ArrayList<Arg> result = new ArrayList<>();
        //Индентефицируем массив и тип числа(арабское, римское), помещаем в коллекцию.
        for (int i = 0; i < arguments.length; i++) {
            switch (arguments[i]) {
                case "0":
                    result.add(i, new Arg(0, false));
                    break;
                case "1":
                    result.add(i, new Arg(1, false));
                    break;
                case "2":
                    result.add(i, new Arg(2, false));
                    break;
                case "3":
                    result.add(i, new Arg(3, false));
                    break;
                case "4":
                    result.add(i, new Arg(4, false));
                    break;
                case "5":
                    result.add(i, new Arg(5, false));
                    break;
                case "6":
                    result.add(i, new Arg(6, false));
                    break;
                case "7":
                    result.add(i, new Arg(7, false));
                    break;
                case "8":
                    result.add(i, new Arg(8, false));
                    break;
                case "9":
                    result.add(i, new Arg(9, false));
                    break;
                case "10":
                    result.add(i, new Arg(10, false));
                    break;
                case "+":
                    result.add(i, new Arg(1, false));
                    break;
                case "-":
                    result.add(i, new Arg(2, false));
                    break;
                case "*":
                    result.add(i, new Arg(3, false));
                    break;
                case "/":
                    result.add(i, new Arg(4, false));
                    break;
                case "I":
                    result.add(i, new Arg(1, true));
                    break;
                case "II":
                    result.add(i, new Arg(2, true));
                    break;
                case "III":
                    result.add(i, new Arg(3, true));
                    break;
                case "IV":
                    result.add(i, new Arg(4, true));
                    break;
                case "V":
                    result.add(i, new Arg(5, true));
                    break;
                case "VI":
                    result.add(i, new Arg(6, true));
                    break;
                case "VII":
                    result.add(i, new Arg(7, true));
                    break;
                case "VIII":
                    result.add(i, new Arg(8, true));
                    break;
                case "IX":
                    result.add(i, new Arg(9, true));
                    break;
                case "X":
                    result.add(i, new Arg(10, true));
                    break;
                default:
                    throw new IllegalArgumentException("Не верное вырожение или не соотвествует условию задачи."+
                            '\n' +"Калькулятор умеет выполнять операции сложения, вычитания," +
                            "умножения и деления с двумя числами от 1 до 10: a + b, a - b, a * b, a / b");
            }
        }

        return result;
    }
//Преобразование арабских в римские
    private static String transform_number_to_roman_numeral(int number) {
        int[] roman_value_list = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman_char_list = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < roman_value_list.length; i += 1) {
            while (number >= roman_value_list[i]){
                number -= roman_value_list[i];
                res.append(roman_char_list[i]);
            }
        }
        return res.toString();
    }
}
