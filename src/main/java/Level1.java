import java.util.*;

public class Level1 {
    //v9
    static Stroka stroka = new Stroka();

    public static String BastShoe(String command) {
        int com;
        String value = "";
        String result = "";
        if (command.contains(" ")) {
            com = Integer.parseInt(command.split(" ")[0]);
            value = command.substring(2);
        } else {
            com = Integer.parseInt(command);
        }
        if (com == 1) {
            command1(value);
        } else if (com == 2) {
            command2(value);
        } else if (com == 4) {
            command4();
        } else if (com == 5) {
            command5();
        }


        if (com == 1 || com == 2) {
            result = stroka.getValue(stroka.getHistoryValue(stroka.getNumberTekusheyStroki()));


        } else if (com == 4) {
            if (stroka.getNumberTekusheyStroki() < 0) {
                result = stroka.getValue("");
            }

            else if (stroka.getNumberTekusheyStroki() == 0 && stroka.history.size() != stroka.getUndoCount()) {
                result = stroka.getValue("");

            }

            else if (stroka.getNumberTekusheyStroki() > 0) {
                result = stroka.getValue(stroka.getHistoryValue(stroka.getNumberTekusheyStroki()));
            }

        } else if (com == 5) {

            if (stroka.getNumberTekusheyStroki() < 1) {
                result = stroka.getValue("");

            } else if (stroka.getNumberTekusheyStroki() >= 1) {
                result = stroka.getValue(stroka.getHistoryValue(stroka.getNumberTekusheyStroki()));
            }

        } else if (com == 3) {
            result = command3(value);
        }
        System.out.println(result);
        return result;
    }

    public static void command1(String value) {
        stroka.setUndoCount(0);
        if (stroka.getPredOperation() == 4 && stroka.history.size() > 0) {
            stroka.clearHistory();
            stroka.setNumberTekusheyStroki(0);
        }
        if (stroka.getPredOperation() == 4 && stroka.history.size() == 0) {
            stroka.setNumberTekusheyStroki(0);
        }

        stroka.setNumberTekusheyStroki(stroka.getNumberTekusheyStroki() + 1);

        if (stroka.getNumberTekusheyStroki() == 1) {
            stroka.setHistoryValue(stroka.getNumberTekusheyStroki(), value);

        } else if (stroka.getNumberTekusheyStroki() > 1) {
            stroka.setHistoryValue(stroka.getNumberTekusheyStroki(), stroka.getHistoryValue(stroka.getNumberTekusheyStroki() - 1) + value);

        }
        stroka.setPredOperation(1);

    }

    public static void command2(String value) {
        stroka.setUndoCount(0);
        if (stroka.getPredOperation() == 4) {
            stroka.clearHistory();
        }
        stroka.setNumberTekusheyStroki(stroka.getNumberTekusheyStroki() + 1);

        if (stroka.getNumberTekusheyStroki() < 1) {
            stroka.setHistoryValue(stroka.getNumberTekusheyStroki(), "");
        } else if (Integer.parseInt(value) > stroka.getHistoryValue(stroka.getNumberTekusheyStroki() - 1).length()) {
            stroka.setHistoryValue(stroka.getNumberTekusheyStroki(), "");
        } else {
            stroka.setHistoryValue(stroka.getNumberTekusheyStroki(),
                    stroka.getHistoryValue(stroka.getNumberTekusheyStroki() - 1).substring(0, stroka.getHistoryValue(stroka.getNumberTekusheyStroki() - 1).length() - Integer.parseInt(value)));
        }

        stroka.setPredOperation(2);

    }

    public static String command3(String value) {
        String result = "";
        if (stroka.getNumberTekusheyStroki() > 1) {
            if (Integer.parseInt(value) < stroka.getValue(stroka.getHistoryValue(stroka.getNumberTekusheyStroki())).length()) {
                result = (stroka.getValue(stroka.getHistoryValue(stroka.getNumberTekusheyStroki())).substring(Integer.parseInt(value), Integer.parseInt(value) + 1));
            } else {
                result = "";
            }
        } else if (stroka.getNumberTekusheyStroki() < 1) {
            if (Integer.parseInt(value) < stroka.getHistoryValue(1).length()) {
                result = (stroka.getHistoryValue(1).substring(Integer.parseInt(value), Integer.parseInt(value) + 1));
            } else {
                result = "";
            }
        }
        stroka.setPredOperation(3);
        return result;
    }

    public static void command4() {
        stroka.setUndoCount(stroka.getUndoCount() + 1);


        stroka.setNumberTekusheyStroki(stroka.getNumberTekusheyStroki() - 1);


        stroka.setPredOperation(4);

    }

    public static void command5() {
        stroka.setUndoCount(0);
        stroka.setRedoCount(stroka.getRedoCount() + 1);


        if (stroka.getNumberTekusheyStroki() + 1 < stroka.history.size()) {
            stroka.setNumberTekusheyStroki(stroka.getNumberTekusheyStroki() + 1);

        } else if (stroka.getNumberTekusheyStroki() + 1 >= stroka.history.size()) {
            stroka.setNumberTekusheyStroki(stroka.history.size());
        }

        stroka.setPredOperation(5);
    }

    public static class Stroka {
        private String value;
        private int numberTekusheyStroki;
        private int predOperation;
        HashMap<Integer, String> history = new HashMap<>();
        private int undoCount;
        private int redoCount;

        public String getValue(String value) {
            return value;
        }

        public int getNumberTekusheyStroki() {
            return numberTekusheyStroki;
        }

        public int getPredOperation() {
            return predOperation;
        }

        public String getHistoryValue(int key) {
            return history.get(key);
        }

        public int getUndoCount() {
            return undoCount;
        }

        public int getRedoCount() {
            return redoCount;
        }

        public void setHistoryValue(int key, String value) {
            history.put(key, value);
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setPredOperation(int predOperation) {
            this.predOperation = predOperation;
        }

        public void setNumberTekusheyStroki(int numberTekusheyStroki) {
            this.numberTekusheyStroki = numberTekusheyStroki;
        }

        public void setUndoCount(int undoCount) {
            this.undoCount = undoCount;
        }

        public void setRedoCount(int redoCount) {
            this.redoCount = redoCount;
        }

        public void clearHistory() {
            String value = history.get(stroka.getNumberTekusheyStroki());
            history.clear();
            history.put(1, value);
        }

    }
}