package app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int[] arrayNums;


    public static void main(String[] args) {
        int loopIndex;
        int findNumber;
        int findNumberPosition;
        //Створення масиву, ініціалізація Random
        arrayNums = new int[15];
        Random rnd = new Random();

        //Присвоєння випадкових чисел і зміна знаку випадковим способом
        for (loopIndex = 0; loopIndex < arrayNums.length; loopIndex++)
            arrayNums[loopIndex] = rnd.nextInt(100) + 1;

        System.out.println("Початковий масив:    " + Arrays.toString(arrayNums));

        SortArray(arrayNums);

        System.out.println("Відсортований масив: " + Arrays.toString(arrayNums));

        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть ціле число для пошуку: ");
        findNumber = sc.nextInt();
        sc.close();

        findNumberPosition = FindNumberInArray(findNumber,arrayNums);

       if (findNumberPosition==-1)
         System.out.printf("Число %s незнайдено",findNumber);
        else
         System.out.printf("Індекс числа %s у відсортованому масиві: %s",findNumber,findNumberPosition);
    }

    public static void SortArray(int[] arrayToSort) {
        //Сортування методом вставки
        int loopIndex;
        int TempInt;
        boolean changes;
        for (int i = 1; i < arrayToSort.length; i++) {
            // Ключ - як основа для порівняння
            int key = arrayToSort[i];
            // Пошук розпочнеться з попереднього індексу
            // до індексу ключа
            int j = i - 1;
            // Пошук буде продовжуватися доти, доки не буде
            // знайдено елемент менший, ніж ключ
            while (j >= 0 && key < arrayToSort[j]) {
                arrayToSort[j + 1] = arrayToSort[j];
                j--;
            }
            // Після знаходження елемента меншого аніж ключ,
            // ключ до наступного індексу
            arrayToSort[j + 1] = key;
        }
    }
    public static int FindNumberInArray(int NumToFind, int[] arrayToFind) {

        int low = 0;
        int high = arrayToFind.length - 1;
        // За замовчуванням вважаємо, що значення відсутнє,
        // тобто індекс зазначаємо -1
        int idx = -1;

        // Алгоритм запускає цикл while,
        // порівнюючи key зі значенням mid.
        while (low <= high) {
            // Середній індекс масиву
            int mid = (low + high) / 2;

            if (arrayToFind[mid] == NumToFind) {
                // Зазначаємо певний індекс,
                // якщо значення знайдено
                idx = mid;
                break;
            } else if (arrayToFind[mid] > NumToFind) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
       return idx;
    }
}