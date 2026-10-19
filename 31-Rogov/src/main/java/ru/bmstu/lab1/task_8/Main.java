package ru.bmstu.lab1.task_8;

import java.io.IOException;
import ru.bmstu.lab1.ConsoleInput;

/** Задача 8. Разделить положительные и отрицательные элементы, исключив нули. */
public final class Main {
    private Main() {
    }

    /** Решает задачу для массива по ограничениям условия, не изменяя его. */
    public static int[][] solve(int[] values) {
        int positiveCount = 0;
        int negativeCount = 0;
        for (int value : values) {
            if (value > 0) {
                positiveCount++;
            } else if (value < 0) {
                negativeCount++;
            }
        }
        int[] positive = new int[positiveCount];
        int[] negative = new int[negativeCount];
        int positiveIndex = 0;
        int negativeIndex = 0;
        for (int value : values) {
            if (value > 0) {
                positive[positiveIndex++] = value;
            } else if (value < 0) {
                negative[negativeIndex++] = value;
            }
        }
        return new int[][] {positive, negative};
    }

    /** Читает n, массив и при необходимости дополнительное число; печатает ответ. */
    public static void main(String[] args) throws IOException {
        ConsoleInput input = new ConsoleInput();
        int[] values = input.readArray();
        int[][] result = solve(values);
        System.out.println(ConsoleInput.format(result[0]));
        System.out.println(ConsoleInput.format(result[1]));
    }
}
