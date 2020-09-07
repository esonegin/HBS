


class Unmanned {

    public static void main(String[] args) {
        int dlinnadorogi = 10;
        int kolvosvetoforov = 2;
        int[][] opisanie = {{3,2,2},{6,1,3}};
        System.out.print(Unmanned(dlinnadorogi, kolvosvetoforov, opisanie));

    }

    public static int Unmanned(int L, int N, int[][] track) {
        int time = 0;
        Svetofors[] svetofors = arraySvetofors(track);
        //Если светофорров нет, то время = расстоянию
        if (track.length == 0) {
            time = L;
        } else if (track.length != 0) {

            for (int rasstoyanie = 0, nomer = 0; rasstoyanie < L; ) {
                if (rasstoyanie == svetofors[nomer].mesto
                        && svetofors[nomer].TimeStep(time, svetofors[nomer].redtime, svetofors[nomer].greentime).equals("red")) {
                    time++;
                    continue;
                } else if (rasstoyanie == svetofors[nomer].mesto
                        && svetofors[nomer].TimeStep(time, svetofors[nomer].redtime, svetofors[nomer].greentime).equals("green")) {
                    time++;
                    rasstoyanie++;
                    if (nomer + 1 < svetofors.length) {
                        nomer++;
                    }
                    //continue;

                } else if (rasstoyanie != svetofors[nomer].mesto) {
                    time++;
                    rasstoyanie++;
                    continue;
                }
            }
        }
        return time;
    }


    public static class Svetofors {
        int mesto;
        int redtime;
        int greentime;

        public Svetofors(int mesto, int red, int green) {
            this.mesto = mesto;
            this.redtime = red;
            this.greentime = green;
        }

        //Цвет светофора в момент времени
        public String TimeStep(int time, int red, int green) {
            String result = null;
            int res = 0;
            //Дефолтный красный
            if (time <= red - 1) {
                result = "red";
            }
            //Дефолтный зеленый
            else if (time >= red && time < red + green) {
                result = "green";
            }
            //Прибавляем к 0 диапазоны, пока не получим фактическое время
            else {
                while (res <= time) {
                    res += red;
                    if (res < time) {
                        res += green;
                        continue;
                    } else if (res >= time) {
                        break;
                    }
                }

                //Если циклов четное количество, то светофор горит зеленым
                if (res % 2 == 0 && res < time) {
                    result = "green";
                }
                if (res % 2 == 0 && res == time + 1 && mesto % 2 == 0) {
                    result = "red";
                }
                else if (res % 2 == 0 && res > time && mesto % 2 != 0) {
                    result = "green";
                }
                else if (res % 2 == 0 && res > time && mesto % 2 == 0) {
                    result = "green";
                }
                else if (res % 2 == 0 && res == time) {
                    result = "green";
                }
                //Если циклов нечетное количество, то светофор горит красным

                else if (res % 2 != 0 && res < time) {
                    result = "red";
                }
                else if (res % 2 != 0 && res > time) {
                    result = "red";
                }
                else if (res % 2 != 0 && res == time) {
                    result = "green";
                }

            }
            return result;
        }

    }

    //Создаем массив объектов светофоров
    public static Svetofors[] arraySvetofors(int[][] opisanie) {
        Svetofors[] svetofors = new Svetofors[opisanie.length];
        for (int i = 0; i < opisanie.length; i++) {
            svetofors[i] = new Svetofors(opisanie[i][0], opisanie[i][1], opisanie[i][2]);
        }
        return svetofors;
    }
}
