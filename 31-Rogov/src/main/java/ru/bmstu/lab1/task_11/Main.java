package ru.bmstu.lab1.task_11;

import java.io.IOException;
import ru.bmstu.lab1.ConsoleInput;

/** Задача 11. Найти ближайший к среднему элемент; при равенстве выбрать первый. */
public final class Main {
    private Main() {
    }

    /** Решает задачу для массива по ограничениям условия, не изменяя его. */
    public static int solve(int[] values) {
        long sum = 0;
        for (int value : values) {
            sum += value;
        }
        int closest = values[0];
        long bestDistance = Math.abs((long) closest * values.length - sum);
        for (int value : values) {
            // Умножаем расстояние на n: сравниваем точно, без ошибок double.
            long distance = Math.abs((long) value * values.length - sum);
            if (distance < bestDistance) {
                bestDistance = distance;
                closest = value;
            }
        }
        return closest;
    }

    /** Читает n, массив и при необходимости дополнительное число; печатает ответ. */
    public static void main(String[] args) throws IOException {
        ConsoleInput input = new ConsoleInput();
        int[] values = input.readArray();
        System.out.println(solve(values));
    }
}
