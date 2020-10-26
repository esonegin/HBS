import java.util.ArrayList;

public class MatrixTurn {
    //v1
    static MatrixObj matrix = new MatrixObj();
    static String[] Matrix;

    static void MatrixTurn(String Matrix[], int M, int N, int T) {
        matrix.setVhodarray(Matrix);
        matrix.setVisota(M);
        matrix.setShrina(N);
        matrix.setKolvoLevels();
        matrix.setVhodmatrix(matrix.getVhodarray());
        matrix.setKolvoLevels();
        ArrayList<String> strokivsehlevels = new ArrayList<String>();
        String[][] ishodnaya = matrix.getVhodmatrix();

        //Помещаем перевернутую строку первого уровня в список
        strokivsehlevels.add(PerestanovkaSimvolovVstroke(strokaIzMatrici(ishodnaya, T), T));

        //Помещаем перевернутые строки остальных уровней в список
        for (int i = 2; i <= matrix.getKolvoLevels(); i++) {
            strokivsehlevels.add(PerestanovkaSimvolovVstroke(strokaIzMatrici(PoluchenieMatrixPoLevel(i), T), T));
        }

        for (int j = 0; j < strokivsehlevels.size(); j++) {
            System.out.println(strokivsehlevels.get(j));
        }

        for (int k = 1; k <= matrix.getKolvoLevels(); k++) {
            PoluchenieFinMatrix(strokivsehlevels, k);
        }

        //Вывод финальной матрицы
        for (int i = 0; i < M; i++) {  //идём по строкам
            for (int j = 0; j < N; j++) {//идём по столбцам
                System.out.print(" " + matrix.getFinmatrix()[i][j] + " "); //вывод элемента
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }
        System.out.println("*****");

        for (int i = 0; i < M; i++) {  //идём по строкам
            for (int j = 0; j < N; j++) {//идём по столбцам
                Matrix[i] = "";
            }
        }

        for (int i = 0; i < M; i++) {  //идём по строкам
            for (int j = 0; j < N; j++) {//идём по столбцам
                Matrix[i] = Matrix[i] + matrix.getFinmatrix()[i][j];
            }
        }

        for (int i = 0; i < Matrix.length; i++) {
            System.out.println(Matrix[i]);
        }

        MatrixTurn.Matrix = Matrix;
    }

    public static String[][] PoluchenieFinMatrix(ArrayList<String> strokivsehlevels, int level) {
        int M = matrix.getVisota();
        int N = matrix.getShirina();
        String[][] finish = new String[M][N];


        //Наполняем финальную матрицу
        for (int i = 0; i < M; i++) {  //идём по строкам
            for (int j = 0; j < N; j++) {//идём по столбцам
                if (level == 1) {
                    //Верхняя горизонталь
                    if (i == 0) {
                        finish[i][j] = strokivsehlevels.get(0).substring(j, j + 1);
                    }
                    //Левая вертикаль
                    if (i > 0 && i < M - 1 && j == 0) {
                        finish[i][j] = strokivsehlevels.get(0).substring(strokivsehlevels.get(0).length() - i, strokivsehlevels.get(0).length() - i + 1);
                    }
                    //Правая вертикаль
                    if (i > 0 && i < M - 1 && j == N - 1) {
                        finish[i][j] = strokivsehlevels.get(0).substring(N + i - 1, N + i);
                    }
                    //Нижняя горизонталь
                    if (i == M - 1) {
                        finish[i][j] = strokivsehlevels.get(0).substring((N + M) - 3 + N - j, (N + M) - 3 + N - j + 1);
                    }
                    matrix.setFinmatrix(finish);
                }
                if (level == 2) {
                    //Уровень 2 верхняя горизонталь
                    if (i > 0 && i < M - 1 && j > 0 && j < N - 1) {
                        matrix.getFinmatrix()[i][j] = strokivsehlevels.get(level - 1).substring(j - 1, j);
                    }
                    //Уровень 2 нижняя горизонталь
                    if (i == M - level && j > 0 && j < N - 1) {
                        matrix.getFinmatrix()[i][j] = strokivsehlevels.get(level - 1).substring(strokivsehlevels.get(level - 1).length() - j, strokivsehlevels.get(level - 1).length() - j + 1);
                    }
                }
            }
        }

        return matrix.getFinmatrix();
    }


    public static String[][] PoluchenieIznachalnoyMatrix(String[] array) {
        String[][] matrix = new String[MatrixObj.getVisota()][MatrixObj.getShirina()];
        for (int i = 0; i < MatrixObj.getVisota(); i++) {
            for (int j = 0; j < MatrixObj.getShirina(); j++) {
                matrix[i][j] = (array[i].split("")[j]);
            }
        }
        return matrix;
    }

    public static String[][] PoluchenieMatrixPoLevel(int level) {
        String[][] iznmatrix = matrix.getVhodmatrix();
        String[][] resultmatrix = new String[matrix.getVisota() - level][matrix.getShirina() - level];
        for (int i = 0; i < resultmatrix.length; i++) {
            for (int j = 0; j < resultmatrix[0].length; j++) {
                resultmatrix[i][j] = iznmatrix[i + 1][j + 1];
            }
        }
        return resultmatrix;
    }

    public static String strokaIzMatrici(String[][] matrix, int T) {
        String gorizverh = "";
        String gorizniz = "";
        String vertikalleft = "";
        String vertikalright = "";
        String result = "";

        if (matrix.length == 1 && T % 2 == 0) {
            for (int i = 0; i < 1; i++) {  //идём по строкам
                for (int j = 0; j < matrix[0].length; j++) {
                    result = result + matrix[i][j];
                }
                StringBuffer res = new StringBuffer(result);
                res.reverse();
                result = String.valueOf(res);
            }
        }
        else if (matrix.length == 1 && T % 2 != 0) {
            for (int i = 0; i < 1; i++) {  //идём по строкам
                for (int j = 0; j < matrix[0].length; j++) {
                    result = result + matrix[i][j];
                }
            }
        }else {
            for (int i = 0; i < matrix.length; i++) {  //идём по строкам
                for (int j = 0; j < matrix[0].length; j++) {//идём по столбцам
                    if (i == 0) {
                        gorizverh = gorizverh + matrix[i][j];
                    }
                    else if (i > 0 && i < matrix.length - 1 && j == 0) {
                        vertikalleft = vertikalleft + matrix[i][0];
                    }
                    else if (i > 0 && i < matrix.length - 1 && j == matrix[0].length - 1) {
                        System.out.println("d");
                        vertikalright = vertikalright + matrix[i][matrix[0].length - 1];
                    }
                    else if (i == matrix.length - 1) {
                        gorizniz = gorizniz + matrix[i][j];
                    }
                }
            }

            StringBuffer buffergor = new StringBuffer(gorizniz);
            buffergor.reverse();
            StringBuffer buffervert = new StringBuffer(vertikalleft);
            buffervert.reverse();
            result = gorizverh + vertikalright + buffergor + buffervert;
        }
        return result;
    }

    public static String PerestanovkaSimvolovVstroke(String stroka, int T) {
        String result = "";

        //Если длина строки == шагу, то возвращаем строку
        if (T - stroka.length() == 0) {
            result = stroka;
        //Если длина строки больше шага
        } else if (stroka.length() > T) {
            String perenos = stroka.substring(stroka.length() - T);
            result = perenos + stroka.substring(0, stroka.length() - T);

        //Если шаг больше длины строки
        }else if (stroka.length() < T) {
            String perenos = stroka.substring(stroka.length() - (T - (stroka.length() * (T / stroka.length()))));
            result = perenos + stroka.substring(0, stroka.length() - (T - stroka.length() * (T / stroka.length())));
        }
        return result;
    }

    public static class MatrixObj {
        static int visota;
        static int shirina;
        String[] vhodarray;
        int tekushiyshag = 0;
        String[][] vhodmatrix;
        String strokaIzMatrici;
        String strokaLevel1;
        static int kolvolevels;
        String[][] finmatrix;


        public String[][] getFinmatrix() {
            return finmatrix;
        }

        public static int getKolvoLevels() {
            return kolvolevels;
        }

        public static int getVisota() {
            return visota;
        }

        public static int getShirina() {
            return shirina;
        }

        public String[] getVhodarray() {
            return vhodarray;
        }

        public int getTekushiyshag() {
            return tekushiyshag;
        }

        public String[][] getVhodmatrix() {
            return vhodmatrix;
        }

        public String getStrokaIzMatrici() {
            return strokaIzMatrici;
        }

        public String getStrokaLevel1() {
            return strokaLevel1;
        }

        public void setFinmatrix(String[][] finmatrix) {
            this.finmatrix = finmatrix;
        }

        public void setVisota(int visota) {
            this.visota = visota;
        }

        public void setShrina(int shrina) {
            this.shirina = shrina;
        }

        public void setTekushiyshag(int tekushiyshag) {
            this.tekushiyshag = tekushiyshag;
        }

        public void setVhodarray(String[] vhodarray) {
            this.vhodarray = vhodarray;
        }

        public void setVhodmatrix(String[] vhodmatrix) {
            this.vhodmatrix = PoluchenieIznachalnoyMatrix(vhodmatrix);
        }

        public void setStrokaIzMatrici(String strokaIzMatrici) {
            this.strokaIzMatrici = strokaIzMatrici;
        }

        public void setStrokaLevel1(String strokaLevel1) {
            this.strokaLevel1 = strokaLevel1;
        }

        public void setKolvoLevels() {
            if (visota == shirina && visota == 2) {
                this.kolvolevels = 1;
            }
            if (visota == shirina && visota > 2) {
                this.kolvolevels = visota - 2;
            }
            if (visota != shirina) {
                this.kolvolevels = (Math.min(visota, shirina) - 1);
            }

        }

    }
}
