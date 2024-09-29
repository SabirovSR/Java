package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;

        Scanner scanner = new Scanner (System.in);

        if(scanner.hasNextInt())
            x1 = scanner.nextInt();
        else { System.out.println("Ошибка ввода парамертов! Вводите целые числа"); return; }
        if(scanner.hasNextInt())
            x2 = scanner.nextInt();
        else { System.out.println("Ошибка ввода парамертов! Вводите целые числа"); return; }
        if(scanner.hasNextInt())
            y1 = scanner.nextInt();
        else {System.out.println("Ошибка ввода парамертов! Вводите целые числа"); return; }
        if(scanner.hasNextInt())
            y2 = scanner.nextInt();
        else { System.out.println("Ошибка ввода парамертов! Вводите целые числа"); return; }

        if ((x1<=0) || (x2<=0) || (y1<=0) || (y2<=0) || (x1>12) ||  (x2>12) || (y1>12) || (y2>12))
            System.out.println("Ошибка ввода параметров! Вводите в промежутке от 0 до 12");
        else if (((Math.min(x1, x2) <= y1) && (y1 <= Math.max(x1, x2)) && (y2 >= Math.max(x1, x2))) ||
                ((Math.min(x1, x2) <= y2) && (y2 <= Math.max(x1, x2)) && (y1 >= Math.max(x1, x2)))){
            System.out.println("Пересекается");
        } else System.out.println("Не пересекается");
    }
}
