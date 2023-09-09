public class ArrayChecker {
    public static void checkArray(int[][] array) {
        int numRows = array.length;
        int numCols = array[0].length;
        boolean[] matchingRows = new boolean[numRows];
        boolean[] matchingCols = new boolean[numCols];

        // Проверяем строки
        for (int i = 0; i < numRows; i++) {
            for (int j = i + 1; j < numRows; j++) {
                if (array[i].length != array[j].length) {
                    System.out.println("Длина строки " + i + " не совпадает с длиной строки " + j);
                    matchingRows[i] = false;
                    matchingRows[j] = false;
                } else {
                    matchingRows[i] = true;
                    matchingRows[j] = true;
                }
            }
        }

        // Проверяем столбцы
        for (int i = 0; i < numCols; i++) {
            for (int j = i + 1; j < numCols; j++) {
                boolean colMatch = true;
                for (int k = 0; k < numRows; k++) {
                    if (array[k][i] != array[k][j]) {
                        colMatch = false;
                        break;
                    }
                }
                if (colMatch) {
                    System.out.println("Столбец " + i + " совпадает со столбцом " + j);
                    matchingCols[i] = true;
                    matchingCols[j] = true;
                }
            }
        }

        // Вывод информации о строках и столбцах
        for (int i = 0; i < numRows; i++) {
            if (!matchingRows[i]) {
                System.out.println("Строка " + i + " не совпадает с другими строками");
            }
        }

        for (int i = 0; i < numCols; i++) {
            if (!matchingCols[i]) {
                System.out.println("Столбец " + i + " не совпадает с другими столбцами");
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        checkArray(array);
    }
}
