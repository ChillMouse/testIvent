package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author ChillMouse
 * На входе функция получает параметр n - натуральное число. +
 * Необходимо сгенерировать n-массивов, заполнить их случайными числами, каждый массив имеет случайный размер. +
 * Размеры массивов не должны совпадать. +
 * Далее необходимо отсортировать массивы. +
 * Массивы с четным порядковым номером отсортировать по возрастанию, с нечетным порядковым номером - по убыванию. +
 * На выходе функция должна вернуть массив с отсортированными массивами. + */

public class Main {

    public static Integer[] lengthArrays = {};

    public static void main(String[] args) {
        Integer[][] myArray = getArrayOfIntegersArray(2);
        String myResult = Arrays.deepToString(myArray);
        System.out.println(myResult);
    }

    public static Integer[] getIntegersArray() {
        Integer[] workArray = {};

        Random random = new Random(); // Случайное целое число
        int k = 1 + random.nextInt(9999); // Случайная длина массива от 1 до n.

        boolean isSetInArray = false; // Флаг, есть ли элемент в массиве.

        boolean isOdd = false; // Нет, массив по порядковому номеру нечётный.
        if (lengthArrays.length % 2 == 0){
            isOdd = true; // Да, массив по порядковому номеру чётный.
        }

        for (int lengthArray : lengthArrays) {
            if (lengthArray == k) {
                isSetInArray = true; // Проверка существования элемента в массиве. true, если есть, иначе false.
                break;
            }
        }

        if (!isSetInArray){ // Если нет повтора, то тут же вернёт массив этой длины.
            for (int i = 0; i < k; i++) { // Создать массив длины k.
                workArray = Arrays.copyOf(workArray, workArray.length + 1);// Увеличение массива по супер цене!
                workArray[i] = random.nextInt(1000000); // Случайное число
            }

            if (isOdd)
                Arrays.sort(workArray);
            else
                Arrays.sort(workArray, Collections.reverseOrder());

            return workArray;
        }
        return getIntegersArray(); // Иначе, если есть массив, заново начнёт функцию.


    }

    /** @param n Любое натуральное число */
    public static Integer[][] getArrayOfIntegersArray(int n){
        Integer[][] workArray = {};

        for (int i = 0; i < n; i++){

            workArray = Arrays.copyOf(workArray, workArray.length + 1); // Увеличение массива по супер цене!

            Integer[] rndArray = getIntegersArray();

            workArray[i] = rndArray;

            lengthArrays = Arrays.copyOf(lengthArrays, lengthArrays.length + 1); // Копирование пустого массива и увеличение его длины.
            lengthArrays[lengthArrays.length - 1] = rndArray.length; // Запись длины в последний элемент массива.

        }

        Arrays.sort(lengthArrays);
        System.out.println("Все длины массивов: " + Arrays.toString(lengthArrays));
        return workArray;
    }
    /*
         Профессиональный анекдот: приходит студент сдавать лабораторную работу по программированию,
         сделал всё как положено, всё работает,
         препод спросил: "Угу... Угу... Здесь ясно, скажите, а зачем вы код обфусцировали?".
         Студент отвечает: "Так вы листок вверх ногами держите".
         xD xD xD xD xD xD
    */
}
