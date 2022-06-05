import java.util.*;

class aBST {
    public Integer Tree[];
    static int depth;
    int tree_size;

    //Убрал инициализацию переменных в конструктор
    public aBST(int depth) {
        this.depth = depth;
        this.tree_size = setTreeSize();
        this.Tree = new Integer[tree_size];
    }

    //Убрал определение размера дерева в отдельный метод
    public int setTreeSize() {
        int size = 1;
        for (int i = 1; i <= depth + 1; i++) {
            size = size * 2;
        }
        return size - 1;
    }

    public Integer FindKeyIndex(int key) {

        int teknode = 0;
        if (Tree[0] == null) {
            return 0;
        }
        while (Tree[teknode] != null && 2 * teknode + 1 < Tree.length) {
            if (Tree[teknode] == key) {
                break;
            }
            if (key < Tree[teknode] && Tree[2 * teknode + 1] == null) {
                teknode = 2 * teknode + 1;
                break;
            }
            if (key < Tree[teknode] && Tree[2 * teknode + 1] != null) {
                teknode = 2 * teknode + 1;
                continue;
            }
            if (key < Tree[teknode] && Tree[2 * teknode + 1] != 0 && key < Tree[2 * teknode + 1]) {
                teknode = Tree[2 * teknode + 1];
            }
            if (key > Tree[teknode] && Tree[2 * teknode + 2] == null) {
                teknode = 2 * teknode + 2;
                break;
            }
            if (key > Tree[teknode] && Tree[2 * teknode + 2] != null) {
                teknode = 2 * teknode + 2;
                continue;
            }
            if (key > Tree[teknode] && Tree[2 * teknode + 2] != 0 && key > Tree[2 * teknode + 2]) {
                Tree[2 * teknode + 2] = key;
            }
        }
        if (Tree[teknode] == null) {
            return -teknode;
        }
        if (Tree[teknode] != null && Tree[teknode] != key) {
            return null;
        }
        return teknode;
    }

    public int AddKey(int key) {
        Integer predfind = FindKeyIndex(key);

        if (predfind == null) {
            return -1;
        }
        if (predfind == 0 && Tree[0] == null) {
            Tree[0] = key;
            return 0;
        }
        if (predfind < 0) {
            Tree[predfind * (-1)] = key;
            return predfind * (-1);
        }
        if (Tree[predfind] != null && Tree[predfind] != key) {
            return -1;
        }
        if (Tree[predfind] != null && Tree[predfind] == key) {
            return predfind;
        }
        Tree[predfind] = key;
        return predfind;
    }
}
