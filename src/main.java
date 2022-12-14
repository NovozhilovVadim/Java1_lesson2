import java.util.Random;

public class main {
    /*
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
   С помощью цикла и условия заменить 0 на 1, 1 на 0;
2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов)
   заполнить его диагональные элементы единицами;
5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
   если в массиве есть место, в котором сумма левой и правой части массива равны.
   Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
   граница показана символами ||, эти символы в массив не входят.
7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
   при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
   Для усложнения задачи нельзя пользоваться вспомогательными массивами.
   Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
   При каком n в какую сторону сдвиг можете выбирать сами.
   Если выполнение задач вызывает трудности, можете обратиться к последней странице методического пособия.
   Для задач со * не нужно искать решение в интернете, иначе вы теряете весь смысл их выполнения.
     */



    public static void main(String[] args) {
        System.out.println("Task 1: ");
        task1();
        System.out.println(" \n" + "Task 2: ");
        task2(8);
        System.out.println(" \n" + "Task 3: ");
        task3();
        System.out.println(" \n" + "Task 4: ");
        task4();
        System.out.println(" \n" + "Task 5: ");
        task5(6);
        System.out.println(" \n" + "Task 6: ");
        task6(arrayRandom(6));
        System.out.println(" \n" + "Task 7: ");
        task7(arrayRandom(10), -1);
    }
    public static void printArr(int[] arr){ // Вывод массива в консоль
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] arrayRandom(int size){ // Создание массива заданной длинны и заполнение его случайными значениям
        int[] arr = new int[size]; // Создаём и инициализируем массив c размером size
        for (int i = 0; i < arr.length; i++){ // Заполняем его случайными числами в диапозоне от "-100" - "100"
            Random random = new Random();
            arr[i] = random.nextInt(301) - 100;
        }
        return arr; // Возвращаем массив
    }

    public static void task1 (){
        int[] arr = new int[10]; // Создаём и инициализируем массив
        for (int i = 0; i < arr.length; i++){ // Проходим по массиву в цикле и заполняем его случайным образом "1" и "0"
            Random random  = new Random();
            arr[i] = random.nextInt(2);
        }
        printArr(arr);
        System.out.println(); // перевод строки
        for (int i = 0; i < arr.length - 1; i++){ // проходим по массиву в цикле и меняем "1" на "0" и "0" на "1"
            if(arr[i] == 0){
                arr[i] = 1;
            }else arr[i] = 0;
        }
        printArr(arr);
    }

    public static void task2 (int leght){ //получаем размер массива
        int arr[] = new int[leght]; // создаём и инициализируем массив
        arr[0] = 0; // заполняем самыый первый элемент массива "0"
        for (int i = 1; i < arr.length; i++ ){ // при каждой итерации увеливаем значение предыдущей я чейки на 3 и записываем в массив
            arr[i] = arr[i-1] +3;
        }
        printArr(arr);
    }

    public static void task3 (){
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArr(arr);
        for (int i = 0; i < arr.length; i++){ // читаем массив в цикле и числа менбше "6" умножаем на "2"
            if (arr[i] < 6){
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println();
        printArr(arr);
    }

    public static void task4 (){
        int[][] arr = new int[7][7]; // Создаём и инициализируем квадартный двумерный массив
        for (int i = 0; i < arr.length; i++){ // Заполняем массив "0"
            for (int j = 0; j < arr.length; j++){
                arr[i][j] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++){ // заполняем массив по диагоналям "1"
            for (int j = 0; j < arr.length; j++){
                arr[i][i] = 1; // Диагональ с лева на право
            }
            arr [i][(arr.length - 1) - i] = 1; //диагональ с права налево ( "(arr.length - 1)" - индексы в массиве начинаются с 0)
        }
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void task5 (int length){
        int[] arr = arrayRandom(length); // Создаём и инициализируем массив заданной длинны
//        int[] arr = {1, 1, 1, 2, 1};
        printArr(arr);
        // Создаём переменные для минимального и максимального значений
        int max;
        int min = Integer.MAX_VALUE; // изначально присваиваем переменной min максимально допустимое значение для int
        for (int i = 0; i < arr.length; i++){ // проходим циклом по массиву, при первой итерации сравниваем значение из ячейки "0"
            // с максимально возможным значением и если оно меньше - меняем переменную min на значение из ячейки,
            // дальше сравниваем каждую последующую ячейку с предыдущей через переменную
            if (arr[i] < min ){
                min = arr[i];
            }
        }
        max = min; // задаем переменной max самое минимальное значение из массива
        for (int i = 0; i < arr.length; i++){ // сравниваем значения из массива с минимальным значением и присваем большее.
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("\n" + "Min: " + min + "\n" + "Max: " + max);
    }

    public static boolean task6 (int[] arr){
        printArr(arr);
        System.out.println();
        int summLeft = 0; // сумма левой части
        int summRight; // сумма правой части
        for (int i = 0; i < arr.length; i++) { // подсчет суммы в левой части
            summRight = 0; // в начале каждого цикла обнуляем значение в правой части
            summLeft = summLeft + arr[i];
            for (int j = i+1; j < arr.length ; j++) { // считаем значение в правой части
                summRight = summRight + arr[j];
            }
            System.out.println("iteration - " + i );
            System.out.println("summLeft: " + summLeft + " " + "summRight: " + summRight);
            if (summLeft == summRight){ // при каждом цикле сравниваем суммы
                System.out.println("Result = true");
                return true; // если суммы совпал - возвращаем true и выходим из цикла
            }
        }
        System.out.println("Result  = false");
        return false; // если совпадений нет - возвращаем false
    }

    public static void task7 (int[] arr, int n){
        printArr(arr);
        System.out.println();
        if (n > 0){ // если число сдвига положительное - двигаем вправо
            System.out.println("n > 0: >>>>>");
            for (int i = 0; i < n; i++) { // число итераций на одну меньше числа сдвига
                int val = arr[0]; // читем начальную ячейку массива в переменную
                arr[0] = arr[arr.length - 1]; // записываем в начальную ячейку значение последнеё
                for (int j = 0; j < arr.length - 1; j++) { // дальше в цикле передвигаем по одной ячейке
                    int val1 = arr[j+1];
                    arr[j+1] =val;
                    val = val1;
                }
            }
        }else {
            System.out.println("n < 0: <<<<<"); // если число сдвига отрицательное - то же самое но влево
            n = n* (-1); // приводим число сдвига к положительному значению
            for (int i = 0; i < n ; i++) {
                int val = arr[arr.length - 1]; // читаем последнюю ячейку в переменную
                arr[arr.length - 1] = arr[0]; // пишем в последнюю ячейку значение начальной
                for (int j = arr.length - 1; j > 0 ; j--) { // двигаем все остальное
                    int val1 = arr[j-1];
                    arr[j-1] =val;
                    val = val1;
                }
            }
        }
        printArr(arr);
    }
}
