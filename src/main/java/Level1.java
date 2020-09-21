

import java.util.*;

public class Level1 {
    //v12
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
            if (stroka.getNumberTekusheyStroki() == 0) {
                result = stroka.getValue(stroka.getHistoryValue(stroka.history.size() - 1));
            } else {
                result = stroka.getValue(stroka.getHistoryValue(stroka.getNumberTekusheyStroki()));
            }


        } else if (com == 4) {
            if (stroka.history.size() == 1) {
                result = stroka.getValue("");
            }
           /* else if (stroka.getNumberTekusheyStroki() < 0 && stroka.history.size() == 2) {
                result = stroka.getValue(stroka.getHistoryValue(0));
            } else if (stroka.getNumberTekusheyStroki() < 0 && stroka.history.size() < 2) {
                result = stroka.getValue("");
            } */

            else if (stroka.getNumberTekusheyStroki() < 0 && stroka.history.size() == 2 && stroka.getUndoCount() < stroka.history.size()) {
                result = stroka.getValue(stroka.getHistoryValue(0));
            }
            else if (stroka.getNumberTekusheyStroki() < 0 && stroka.history.size() == 2 && stroka.getUndoCount() >= stroka.history.size()) {
                result = stroka.getValue("");
            }
            else if (stroka.getNumberTekusheyStroki() < 0 && stroka.history.size() > 2) {
                result = stroka.getValue("");
            }
            else if (stroka.getNumberTekusheyStroki() >= stroka.history.size() - 1 && stroka.history.size() > 0) {
                result = stroka.getValue(stroka.getHistoryValue(stroka.history.size() - 1 - stroka.getUndoCount()));
                stroka.setNumberTekusheyStroki(stroka.history.size() - 1 - stroka.getUndoCount());

            }else if (stroka.getNumberTekusheyStroki() >= stroka.history.size() - 1 && stroka.history.size()  == 0) {
                result = stroka.getValue("");

            } else {
                result = stroka.getValue(stroka.getHistoryValue(stroka.getNumberTekusheyStroki()));
            }

        } else if (com == 5) {
            if (stroka.getNumberTekusheyStroki() < 0) {
                result = stroka.getValue("");
            } else if (stroka.getNumberTekusheyStroki() + 1 >= stroka.history.size()) {
                result = stroka.getValue(stroka.getHistoryValue(stroka.history.size() - 1));
            } else {
                result = stroka.getValue(stroka.getHistoryValue(stroka.getNumberTekusheyStroki()));
            }

        } else if (com == 3) {
            result = command3(value);
        }

        System.out.println(result);
        return result;
    }

    public static void command1(String value) {

        if (stroka.getPredOperation() == 4) {
            stroka.clearHistory();
        }

        if (stroka.history.size() == 0) {
            stroka.setHistoryValue(value);
        } else if (stroka.getNumberTekusheyStroki() > - 1 && stroka.getNumberTekusheyStroki() <= stroka.history.size() - 1){
            stroka.setHistoryValue(stroka.getHistoryValue(stroka.getNumberTekusheyStroki()) + value);
        }
        else if (stroka.getNumberTekusheyStroki() > stroka.history.size() - 1){
            stroka.setHistoryValue(stroka.getHistoryValue(stroka.getNumberTekusheyStroki() - 1) + value);
        }

        stroka.setNumberTekusheyStroki(stroka.history.size() - 1);
        stroka.setPredOperation(1);
    }

    public static void command2(String value) {
        if (stroka.getPredOperation() == 4) {
            stroka.clearHistory();
        }

        if (stroka.getNumberTekusheyStroki() < 0) {
            stroka.setHistoryValue("");
        } else if (stroka.history.size() > 1) {
            stroka.setHistoryValue(stroka.getHistoryValue(stroka.getNumberTekusheyStroki() - 1).
                    substring(0, stroka.getHistoryValue(stroka.getNumberTekusheyStroki()).length() - Integer.parseInt(value)));
        } else if (stroka.history.size() == 1) {
            stroka.setHistoryValue(stroka.getHistoryValue(stroka.getNumberTekusheyStroki()).
                    substring(0, stroka.getHistoryValue(stroka.getNumberTekusheyStroki()).length() - Integer.parseInt(value)));
        }
        stroka.setNumberTekusheyStroki(stroka.history.size() - 1);
        stroka.setPredOperation(2);
    }

    public static String command3(String value) {
        String result = "";
        int key = 0;
        if (stroka.getNumberTekusheyStroki() >= 0) {
            key = stroka.getNumberTekusheyStroki();
        }

        if (Integer.parseInt(value) > stroka.getHistoryValue(key).length()
                || Integer.parseInt(value) < 0) {
            result = "";
        } else {
            result = stroka.getHistoryValue(key).substring(Integer.parseInt(value), Integer.parseInt(value) + 1);
        }

        stroka.setPredOperation(3);
        return result;
    }

    public static void command4() {
        if (stroka.getUndoCount() == 0 && stroka.history.size() > 1) {
            stroka.setNumberTekusheyStroki(stroka.getNumberTekusheyStroki() - 1);

        } else if (stroka.getUndoCount() == 0 && stroka.history.size() == 1) {
            stroka.setNumberTekusheyStroki(stroka.getNumberTekusheyStroki() - 1);
        }
        if (stroka.getUndoCount() > 0) {
            stroka.setNumberTekusheyStroki(stroka.getNumberTekusheyStroki() - 1 - stroka.getRedoCount());
        }
        stroka.setUndoCount(stroka.getUndoCount() + 1);
        stroka.setPredOperation(4);
        stroka.setRedoCount(0);

    }

    public static void command5() {

        stroka.setNumberTekusheyStroki(stroka.getNumberTekusheyStroki() + 1);
        stroka.setRedoCount(stroka.getRedoCount() + 1);
        stroka.setPredOperation(5);
        stroka.setUndoCount(0);
    }

    public static class Stroka {
        private String value;
        private int numberTekusheyStroki = 0;
        private int predOperation;
        ArrayList<String> history = new ArrayList<String>();
        private int undoCount;
        private int redoCount;

        public String getValue(String value) {
            return value;
        }

        public String getHistoryValue(int key) {
            return history.get(key);
        }

        public int getNumberTekusheyStroki() {
            return numberTekusheyStroki;
        }

        public int getPredOperation() {
            return predOperation;
        }


        public int getUndoCount() {
            return undoCount;
        }

        public int getRedoCount() {
            return redoCount;
        }


        public void setHistoryValue(String value) {
            history.add(value);
        }

        public void setPredOperation(int predOperation) {
            this.predOperation = predOperation;
        }

        public void setUndoCount(int undoCount) {
            this.undoCount = undoCount;
        }

        public void setRedoCount(int redoCount) {
            this.redoCount = redoCount;
        }

        public void setNumberTekusheyStroki(int numberTekusheyStroki) {
            this.numberTekusheyStroki = numberTekusheyStroki;
        }

        public void clearHistory() {

            if (stroka.history.size() == 0) {

            } else if (stroka.getNumberTekusheyStroki() > - 1 && stroka.getNumberTekusheyStroki() < stroka.history.size()) {
                String value = stroka.getHistoryValue(stroka.getNumberTekusheyStroki());
                stroka.history.clear();
                stroka.setHistoryValue(value);
                setNumberTekusheyStroki(0);
            }else{
                stroka.history.clear();
                setNumberTekusheyStroki(0);
            }
            stroka.setUndoCount(0);

        }

    }

}
