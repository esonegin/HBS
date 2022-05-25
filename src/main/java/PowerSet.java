public class PowerSet {
    //Вынес максимальный размер set в константу
    final int MAXSETSIZE = 20000;
    public String[] slots;
    public int prevslot;

    public PowerSet() {
        slots = new String[MAXSETSIZE];
        prevslot = -1;
    }

    public int size() {
        int result = 0;
        for (int i = 0; i < MAXSETSIZE; i++) {
            if (slots[i] != null) {
                result++;
            }
        }
        return result;
    }

    public void put(String value) {
        //7.1 - doublecheck - isDuplicate
        boolean isDuplicate = duplicateCheck(value);
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null && isDuplicate) {
                slots[i] = value;
                break;
            } else if (slots[slots.length - 1] != null && isDuplicate && prevslot == -1) {
                slots[i] = value;
                prevslot = i;
                break;
            } else if (slots[slots.length - 1] != null && isDuplicate && prevslot != -1 && prevslot < slots.length - 1) {
                slots[prevslot + 1] = value;
                prevslot++;
                break;
            } else if (slots[slots.length - 1] != null && isDuplicate && prevslot != -1 && prevslot >= slots.length - 1) {
                prevslot = 0;
                slots[prevslot] = value;
                break;
            }
        }
    }

    public boolean duplicateCheck(String value) {
        for (String val : slots) {
            if (val != null && val.equals(value)) {
                return false;
            }
        }
        return true;
    }

    public boolean get(String value) {
        //7.1 - result - valueInSlots
        boolean valueInSlots = false;
        //7.3 - val - i
        for (String i : slots) {
            if (i != null && i.equals(value)) {
                valueInSlots = true;
                break;
            }
        }
        return valueInSlots;
    }

    public boolean remove(String value) {
        //7.1 - result - isValueRemoved
        boolean isValueRemoved = false;
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] != null && slots[i].equals(value)) {
                slots[i] = null;
                isValueRemoved = true;
                break;
            }
        }
        return isValueRemoved;
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet result = new PowerSet();
        if (set2.MAXSETSIZE >= slots.length) {
            for (String val : slots) {
                for (int j = 0; j < MAXSETSIZE; j++) {
                    if (val != null && val.equals(set2.slots[j])) {
                        result.put(val);
                    }
                }
            }
        } else {
            for (int i = 0; i < MAXSETSIZE; i++) {
                for (String val : slots) {
                    if (set2.slots[i] != null && set2.slots[i].equals(val)) {
                        result.put(set2.slots[i]);
                    }
                }
            }
        }
        return result;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet result = new PowerSet();
        for (String val : slots) {
            if (val != null) {
                result.put(val);
            }
        }
        for (int i = 0; i < MAXSETSIZE; i++) {
            if (set2.slots[i] != null) {
                result.put(set2.slots[i]);
            }
        }

        return result;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet result = new PowerSet();
        for (String val : slots) {
            if (val != null && !set2.get(val)) {
                result.put(val);
            }
        }
        return result;
    }

    public boolean isSubset(PowerSet set2) {
        int j = 0;
        for (int i = 0; i < set2.MAXSETSIZE; i++) {
            if (set2.get(slots[i])) {
                j++;
            }
        }
        return j == set2.size();
    }
}