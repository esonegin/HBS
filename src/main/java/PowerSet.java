public class PowerSet {
    public int size;
    public String[] slots;
    public int prevslot;

    public PowerSet() {
        size = 20000;
        slots = new String[size];
        prevslot = -1;
    }

    public int size() {
        int result = 0;
        for (int i = 0; i < size; i++) {
            if (slots[i] != null) {
                result++;
            }
        }
        return result;
    }

    public void put(String value) {
        boolean doublecheck = doubleCheck(value);
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null && doublecheck) {
                slots[i] = value;
                break;
            } else if (slots[slots.length - 1] != null && doublecheck && prevslot == -1) {
                slots[i] = value;
                prevslot = i;
                break;
            } else if (slots[slots.length - 1] != null && doublecheck && prevslot != -1 && prevslot < slots.length - 1) {
                slots[prevslot + 1] = value;
                prevslot++;
                break;
            } else if (slots[slots.length - 1] != null && doublecheck && prevslot != -1 && prevslot >= slots.length - 1) {
                prevslot = 0;
                slots[prevslot] = value;
                break;
            }
        }
    }

    public boolean doubleCheck(String value) {
        for (String val : slots) {
            if (val == value) {
                return false;
            }
        }
        return true;
    }

    public boolean get(String value) {
        boolean result = false;
        for (String val : slots) {
            if (val != null && val.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean remove(String value) {
        boolean result = false;
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] != null && slots[i].equals(value)) {
                slots[i] = null;
                result = true;
                break;
            }
        }
        return result;
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet result = new PowerSet();
        if (set2.size >= slots.length) {
            for (String val : slots) {
                for (int j = 0; j < set2.size; j++) {
                    if (val != null && val.equals(set2.slots[j])) {
                        result.put(val);
                    }
                }
            }
        } else if (set2.size < slots.length) {
            for (int i = 0; i < set2.size; i++) {
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
        for (int i = 0; i < set2.size; i++) {
            if (set2.slots[i] != null) {
                result.put(set2.slots[i]);
            }
        }
        for (String val : slots) {
            if (val != null) {
                result.put(val);
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
        for (int i = 0; i < set2.size; i++) {
            if (set2.get(slots[i])) {
                j++;
            }
        }
        if (j == set2.size()) {
            return true;
        }
        return false;
    }
}