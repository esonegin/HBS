import java.util.*;

public class BastShoe {
    //v17
    //default - private
    private static StringHistory str;
    static final int ADD = 1;
    static final int BACK = 2;
    static final int DELETE = 3;
    static final int BACKTO = 4;
    static final int FORWARDTO = 5;

    //Убрал объяление строки в конструктор
    public BastShoe() {
        this.str = new StringHistory();
    }

    //Вынес магические числа в константы, код стал нагляднее


    public static String commandExecuter(String command) {
        int com;
        String value = "";
        String result = "";
        if (command.contains(" ")) {
            com = Integer.parseInt(command.split(" ")[0]);
            value = command.substring(2);
        } else {
            com = Integer.parseInt(command);
        }

        if (com == ADD) {
            addToString(value);
        } else if (com == BACK) {
            goBackStepHistory(value);
        } else if (com == BACKTO) {
            backOneStep();
        } else if (com == FORWARDTO) {
            aheadOnStep();
        }

        if (com == ADD || com == BACK) {
            if (str.getNumberTekusheyStroki() == 0) {
                result = str.getValue(str.getHistoryValue(str.history.size() - 1));
            } else {
                result = str.getValue(str.getHistoryValue(str.getNumberTekusheyStroki()));
            }


        } else if (com == BACKTO) {
            if (str.history.size() == 1) {
                result = str.getValue("");
            } else if (str.getUndoCount() >= str.history.size() && str.history.size()
                    == 2 && str.getNumberTekusheyStroki() < 0 && str.getPredOperation() == 4) {
                result = str.getValue(str.getHistoryValue(0));
            } else if (str.getUndoCount() >= str.history.size() && str.history.size()
                    == 2 && str.getNumberTekusheyStroki() < 0) {
                result = str.getValue("");
            } else if (str.getNumberTekusheyStroki() <= 0 && str.history.size() == 2) {
                result = str.getValue(str.getHistoryValue(0));
            } else if (str.getNumberTekusheyStroki() < 0 && str.history.size() == 2
                    && str.getUndoCount() >= str.history.size()) {
                result = str.getValue("");
            } else if (str.getNumberTekusheyStroki() < 0 && str.history.size() > 2) {
                result = str.getValue(str.getHistoryValue(0));
            } else if (str.getNumberTekusheyStroki() >= str.history.size() - 1 && str.history.size() > 0) {
                result = str.getValue(str.getHistoryValue(str.history.size() - 1 - str.getUndoCount()));
                str.setNumberTekusheyStroki(str.history.size() - 1 - str.getUndoCount());

            } else if (str.getNumberTekusheyStroki() >= str.history.size() - 1 && str.history.size() == 0) {
                result = str.getValue("");

            } else {
                result = str.getValue(str.getHistoryValue(str.getNumberTekusheyStroki()));
            }

        } else if (com == FORWARDTO) {
            if (str.getNumberTekusheyStroki() < 0) {
                result = str.getValue("");
            } else if (str.getNumberTekusheyStroki() + 1 >= str.history.size()) {
                result = str.getValue(str.getHistoryValue(str.history.size() - 1));
            } else {
                result = str.getValue(str.getHistoryValue(str.getNumberTekusheyStroki()));
            }

        } else if (com == DELETE) {
            result = deleteValue(value);
        }

        System.out.println(result);
        return result;
    }

    //command1 - addToString
    public static void addToString(String value) {
        if (str.getPredOperation() == BACKTO) {
            str.clearHistory();
        }
        if (str.getPredOperation() == FORWARDTO && str.getNumberTekusheyStroki() < str.history.size() - 1
                && str.getNumberTekusheyStroki() > -1) {
            str.clearHistoryRedo();
        }
        if (str.history.size() == 0) {
            str.setHistoryValue(value);
        } else if (str.getNumberTekusheyStroki() > -1 && str.getNumberTekusheyStroki() <= str.history.size() - 1) {
            str.setHistoryValue(str.getHistoryValue(str.getNumberTekusheyStroki()) + value);
        } else if (str.getNumberTekusheyStroki() > str.history.size() - 1) {
            str.setHistoryValue(str.getHistoryValue(str.getNumberTekusheyStroki() - 1) + value);
        }
        str.setNumberTekusheyStroki(str.history.size() - 1);
        str.setPredOperation(1);
    }

    //command2 - goBackStepHistory
    public static void goBackStepHistory(String step) {
        if (str.getPredOperation() == BACKTO) {
            str.clearHistory();
        }
        if (str.getNumberTekusheyStroki() < 0) {
            str.setHistoryValue("");
        } else if (str.history.size() > 1) {
            str.setHistoryValue(str.getHistoryValue(str.getNumberTekusheyStroki() - 1).substring
                    (0, str.getHistoryValue(str.getNumberTekusheyStroki()).length() - Integer.parseInt(step)));
        } else if (str.history.size() == 1) {
            str.setHistoryValue(str.getHistoryValue(str.getNumberTekusheyStroki()).substring(0, str.getHistoryValue(str.getNumberTekusheyStroki()).length() - Integer.parseInt(step)));
        }
        str.setNumberTekusheyStroki(str.history.size() - 1);
        str.setPredOperation(2);
    }

    public static String deleteValue(String value) {
        String result;
        int key = Math.max(str.getNumberTekusheyStroki(), 0);
        if (Integer.parseInt(value) >= str.getHistoryValue(key).length() || Integer.parseInt(value) < 0) {
            result = "";
        } else {
            result = str.getHistoryValue(key).substring(Integer.parseInt(value), Integer.parseInt(value) + 1);
        }

        str.setPredOperation(DELETE);
        return result;
    }

    //command4 - backOneStep
    public static void backOneStep() {
        if (str.getUndoCount() == 0 && str.history.size() > 1) {
            str.setNumberTekusheyStroki(str.getNumberTekusheyStroki() - 1);

        } else if (str.getUndoCount() == 0 && str.history.size() == 1) {
            str.setNumberTekusheyStroki(str.getNumberTekusheyStroki() - 1);
        } else if (str.getUndoCount() > 0) {
            str.setNumberTekusheyStroki(str.getNumberTekusheyStroki() - 1 - str.getRedoCount());
        } else if (str.getNumberTekusheyStroki() == 0) {
            str.setNumberTekusheyStroki(str.getNumberTekusheyStroki());
        }
        str.setUndoCount(str.getUndoCount() + 1);
        str.setPredOperation(BACKTO);
        str.setRedoCount(0);

    }

    //command5 - aheadOnStep
    public static void aheadOnStep() {

        str.setNumberTekusheyStroki(str.getNumberTekusheyStroki() + 1);
        str.setRedoCount(str.getRedoCount() + 1);
        str.setPredOperation(FORWARDTO);
        str.setUndoCount(0);
    }

    //stroka - StringHistory
    public static class StringHistory {
        private int numberTekusheyStroki = 0;
        private int predOperation;
        final ArrayList<String> history = new ArrayList<>();
        private int undoCount;
        private int redoCount;

        static String getValue(String value) {
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

            if (str.history.size() == 0 || str.getNumberTekusheyStroki() < 0) {
                str.history.clear();
                str.setHistoryValue("");
                setNumberTekusheyStroki(0);
            } else if (str.getNumberTekusheyStroki() > -1 && str.getNumberTekusheyStroki() < str.history.size()) {
                String value = str.getHistoryValue(str.getNumberTekusheyStroki());
                str.history.clear();
                str.setHistoryValue(value);
                setNumberTekusheyStroki(0);
            } else {
                str.history.clear();
                setNumberTekusheyStroki(0);
            }
            str.setUndoCount(0);

        }

        public void clearHistoryRedo() {
            for (int i = str.getNumberTekusheyStroki() + 1; i < str.history.size(); i++) {
                str.history.remove(i);
            }
            str.history.size();
        }

    }

}
