
class aBST {
    //public - private
    private Integer[] tree;
    //public - private
    private int depth;

    //Убрал инициализацию переменных в конструктор
    //public - default
    aBST(int initdepth) {
        this.depth = initdepth;
        this.tree = new Integer[settreeSize()];
    }

    //Убрал определение размера дерева в отдельный метод
    public int settreeSize() {
        int size = 1;
        for (int i = 1; i <= depth + 1; i++) {
            size = size * 2;
        }
        return size - 1;
    }

    public Integer findKeyIndex(int key) {

        int teknode = 0;
        if (tree[0] == null) {
            return 0;
        }
        while (tree[teknode] != null && 2 * teknode + 1 < tree.length) {
            if (tree[teknode] == key) {
                break;
            }
            if (key < tree[teknode] && tree[2 * teknode + 1] == null) {
                teknode = 2 * teknode + 1;
                break;
            }
            if (key < tree[teknode] && tree[2 * teknode + 1] != null) {
                teknode = 2 * teknode + 1;
                continue;
            }
            if (key < tree[teknode] && tree[2 * teknode + 1] != 0 && key < tree[2 * teknode + 1]) {
                teknode = tree[2 * teknode + 1];
            }
            if (key > tree[teknode] && tree[2 * teknode + 2] == null) {
                teknode = 2 * teknode + 2;
                break;
            }
            if (key > tree[teknode] && tree[2 * teknode + 2] != null) {
                teknode = 2 * teknode + 2;
                continue;
            }
            if (key > tree[teknode] && tree[2 * teknode + 2] != 0 && key > tree[2 * teknode + 2]) {
                tree[2 * teknode + 2] = key;
            }
        }
        if (tree[teknode] == null) {
            return -teknode;
        }
        if (tree[teknode] != null && tree[teknode] != key) {
            return null;
        }
        return teknode;
    }

    public int addKey(int key) {
        Integer predfind = findKeyIndex(key);

        if (predfind == null) {
            return -1;
        }
        if (predfind == 0 && tree[0] == null) {
            tree[0] = key;
            return 0;
        }
        if (predfind < 0) {
            tree[predfind * (-1)] = key;
            return predfind * (-1);
        }
        if (tree[predfind] != null && tree[predfind] != key) {
            return -1;
        }
        if (tree[predfind] != null && tree[predfind] == key) {
            return predfind;
        }
        tree[predfind] = key;
        return predfind;
    }

    public Integer[] getTree() {
        return tree;
    }

    public void setTree(Integer[] tr) {
        tree = tr;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int d) {
        this.depth = d;
    }
}
