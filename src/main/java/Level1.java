public class Level1 {
    //v3
    static tree derevo = new Level1.tree();

    static String[] TreeOfLife(int H, int W, int N, String[] tree) {
        //Кладем параметры в объект
        derevo.setVisota(H);
        derevo.setShirina(W);
        derevo.setLet(N);
        derevo.setTekusheeSostoyanie(tree);
        derevo.setTekushiyGod(0);
        //Заменяем символы на цифры
        zamenaSimvolovNaCifry();

        //Меняем текущее состояние пока не дойдем до заданного возраста
        while (derevo.getTekushiyGod() <= N) {
            if (derevo.getTekushiyGod() == 0) {
                derevo.getTekusheeSostoyanie();
                //Если год "нечетный"
            } else if (derevo.getTekushiyGod() % 2 == 0) {
                //Прибавляем возраст веткам
                derevo.setTekusheeSostoyanie(VozrastVetokPlus(derevo.getTekusheeSostoyanie()));
                //Удаляем старые ветки
                derevo.setTekusheeSostoyanie(GibelVetok(PoluchenieMatrix(derevo.getTekusheeSostoyanie())));

            } else if (derevo.getTekushiyGod() % 2 != 0) {
                derevo.setTekusheeSostoyanie(VozrastVetokPlus(derevo.getTekusheeSostoyanie()));
            }

            //Выводим текущий год
            System.out.println(derevo.getTekushiyGod());
            //Выводим финальную матрицу из цифр
            for (int i = 0; i < tree.length; i++) {
                System.out.println(derevo.tekusheeSostoyanie[i]);
            }
            derevo.setTekushiyGod(derevo.getTekushiyGod() + 1);
        }

        return ZamenaCifrNaPlus(derevo.tekusheeSostoyanie);
    }

    //
    public static void zamenaSimvolovNaCifry() {
        //Заменяем + на 1
        for (int i = 0; i < tree.getTekusheeSostoyanie().length; i++) {
            tree.getTekusheeSostoyanie()[i] = tree.getTekusheeSostoyanie()[i].replace("+", "1");
        }
        //Заменяем . на 0
        for (int i = 0; i < tree.getTekusheeSostoyanie().length; i++) {
            tree.getTekusheeSostoyanie()[i] = tree.getTekusheeSostoyanie()[i].replace(".", "0");
        }
    }

    //Увеличиваем возраст веток
    public static String[] VozrastVetokPlus(String[] tr) {
        for (int i = 0; i < tr.length; i++) {
            if (tr[i].contains("3")) {
                tr[i] = tr[i].replace("3", "4");
            }
            if (tr[i].contains("2")) {
                tr[i] = tr[i].replace("2", "3");
            }
            if (tr[i].contains("1")) {
                tr[i] = tr[i].replace("1", "2");
            }
            if (tr[i].contains("0")) {
                tr[i] = tr[i].replace("0", "1");
            }

        }

        return tr;
    }

    //Получаем матрицу дерева
    public static int[][] PoluchenieMatrix(String[] derevo) {
        String[] result = new String[0];
        int[][] matrix = new int[tree.getVisota()][tree.getShirina()];
        for (int i = 0; i < tree.getVisota(); i++) {
            for (int j = 0; j < tree.getShirina(); j++) {
                matrix[i][j] = Integer.parseInt(derevo[i].split("")[j]);
            }
        }

        return matrix;
    }

    //Заменям клетки с 3 и четыре вокруг на 0
    public static String[] GibelVetok(int[][] matrix) {
        String[] result = new String[tree.getVisota()];
        for (int i = 0; i < tree.getVisota(); i++) {  //идём по строкам
            for (int j = 0; j < tree.getShirina(); j++) {//идём по столбцам
                //Если это нулевая строка и нулевой столбец - меняем три значения
                if ((matrix[i][j] == 3 || matrix[i][j] == 4) && i == 0 && j == 0) {
                    matrix[i][j] = 0;
                    if(matrix[i][j + 1] == 1 || matrix[i][j + 1] == 2) { matrix[i][j + 1] = 0; }
                    if(matrix[i + 1][j] == 1 || matrix[i + 1][j] == 2) { matrix[i + 1][j] = 0; }
                }
                //Если это нулевая строка, не первый столбец, не последний столбец - меняем четыре значения
                if ((matrix[i][j] == 3 || matrix[i][j] == 4) && i == 0 && j > 0 && j < tree.getVisota()) {
                    matrix[i][j] = 0;
                    matrix[i][j - 1] = 0;
                    if(matrix[i][j + 1] == 1 || matrix[i][j + 1] == 2) { matrix[i][j + 1] = 0; }
                    if(matrix[i + 1][j] == 1 || matrix[i + 1][j] == 2) { matrix[i + 1][j] = 0; }
                }
                //Если это нулевая строка, последний столбец - меняем три значения
                if ((matrix[i][j] == 3 || matrix[i][j] == 4) && i == 0 && j > 0 && j == tree.getShirina() - 1) {
                    matrix[i][j] = 0;
                    matrix[i][j - 1] = 0;
                    if(matrix[i + 1][j] == 1 || matrix[i + 1][j] == 2) { matrix[i + 1][j] = 0; }
                }
                //Если это не нулевая строка, не последняя строка, нулевой столбец - меняем четыре значения
                if ((matrix[i][j] == 3 || matrix[i][j] == 4) && i > 0 && i < tree.getVisota() - 1 && j == 0) {
                    matrix[i][j] = 0;
                    matrix[i - 1][j] = 0;
                    if(matrix[i][j + 1] == 1 || matrix[i][j + 1] == 2) { matrix[i][j + 1] = 0; }
                    if(matrix[i + 1][j] == 1 || matrix[i + 1][j] == 2) { matrix[i + 1][j] = 0; }
                }
                //Если это не нулева строка, не последняя строка, не нулевой столбец, не последний столбец - меняем пять значений
                if ((matrix[i][j] == 3 || matrix[i][j] == 4) && i > 0 && i < tree.getVisota() - 1 && j > 0 && j < tree.getShirina() - 1) {
                    matrix[i][j] = 0;
                    matrix[i - 1][j] = 0;
                    if(matrix[i][j + 1] == 1 || matrix[i][j + 1] == 2) { matrix[i][j + 1] = 0; }
                    if(matrix[i + 1][j] == 1 || matrix[i + 1][j] == 2) { matrix[i + 1][j] = 0; }
                    matrix[i][j - 1] = 0;
                }
                //Если это ненулевая строка, последния столбец - меняем три значения
                if ((matrix[i][j] == 3 || matrix[i][j] == 4) && i > 0 && i < tree.getVisota() && j == tree.getShirina() - 1) {
                    matrix[i][j] = 0;
                    matrix[i - 1][j] = 0;
                    matrix[i][j - 1] = 0;
                }
                //Если это последняя строка, нулевой столбец - меняем три значения
                if ((matrix[i][j] == 3 || matrix[i][j] == 4) && i == tree.getVisota() - 1 && j == 0) {
                    matrix[i][j] = 0;
                    matrix[i - 1][j] = 0;
                    if(matrix[i][j + 1] == 1 || matrix[i][j + 1] == 2) { matrix[i][j + 1] = 0; }

                }
                //Если это последняя строка, не нулевой столбец - меняем четыре значения
                if ((matrix[i][j] == 3 || matrix[i][j] == 4) && i == tree.getVisota() - 1 && j > 0 && j < tree.getShirina()) {
                    matrix[i][j] = 0;
                    matrix[i - 1][j] = 0;
                    if(matrix[i][j + 1] == 1 || matrix[i][j + 1] == 2) { matrix[i][j + 1] = 0; }
                    matrix[i][j - 1] = 0;
                }
                //Если это последняя строка и последний столбец - меняем три значения
                if ((matrix[i][j] == 3 || matrix[i][j] == 4) && i == tree.getVisota() - 1 && j == tree.getShirina() - 1) {
                    matrix[i][j] = 0;
                    matrix[i - 1][j] = 0;
                    matrix[i][j - 1] = 0;
                }
            }
        }

        for (int i = 0; i < derevo.getVisota(); ) {  //идём по строкам
            for (int j = 0; j < derevo.getShirina(); j++) {//идём по столбцам
                if (result[i] == null) {
                    result[i] = String.valueOf(matrix[i][j]);
                } else {
                    result[i] = result[i] + matrix[i][j];
                }
            }
            i++;
        }
        return result;
    }

    //Заменяем цифры на плюсы и точки для итогового вывода
    public static String[] ZamenaCifrNaPlus(String[] cifry) {
        for (int i = 0; i < cifry.length; i++) {
            if (cifry[i].contains("0")) {
                cifry[i] = cifry[i].replace("0", ".");
            }
            if (cifry[i].contains("1")) {
                cifry[i] = cifry[i].replace("1", "+");
            }
            if (cifry[i].contains("2")) {
                cifry[i] = cifry[i].replace("2", "+");
            }
            if (cifry[i].contains("3")) {
                cifry[i] = cifry[i].replace("3", "+");
            }
            if (cifry[i].contains("3")) {
                cifry[i] = cifry[i].replace("3", "+");
            }
        }
        return cifry;
    }

    public static class tree {

        static int visota;
        static int shirina;
        int let;
        static int tekushiyGod;
        static String[] tekusheeSostoyanie;
        static int[][] matrix;

        public static int getVisota() {
            return visota;
        }

        public static int getShirina() {
            return shirina;
        }

        public int getLet() {
            return let;
        }

        public static String[] getTekusheeSostoyanie() {
            return tekusheeSostoyanie;
        }

        public static int getTekushiyGod() {
            return tekushiyGod;
        }

        public int[][] getMatrix() {
            return matrix;
        }

        public void setVisota(int visota) {
            this.visota = visota;
        }

        public void setShirina(int shirina) {
            this.shirina = shirina;
        }

        public void setLet(int let) {
            this.let = let;
        }

        public void setTekusheeSostoyanie(String[] tekusheeSostoyanie) {
            this.tekusheeSostoyanie = tekusheeSostoyanie;
        }

        public static void setTekushiyGod(int tekushiyGod) {
            tree.tekushiyGod = tekushiyGod;
        }

        public void setMatrix(int[][] matrix) {
            this.matrix = matrix;
        }
    }
}