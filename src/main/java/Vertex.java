import java.util.*;
import java.util.Deque;
import java.util.LinkedList;

class Vertex {
    public int Value;
    public boolean Hit;

    public Vertex(int val) {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value) {
        Vertex newvertex = new Vertex(value);
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == null) {
                vertex[i] = newvertex;
                break;
            }
        }
    }

    public void RemoveVertex(int v) {
        if (v > max_vertex) {
            return;
        } else {
            while (v < max_vertex - 1) {
                for (int i = 0; i < max_vertex; ++i) {
                    m_adjacency[i][v] = m_adjacency[i][v + 1];
                }
                if (max_vertex >= 0) {
                    System.arraycopy(m_adjacency[v + 1], 0, m_adjacency[v], 0, max_vertex);
                }
                v++;
            }
            max_vertex--;
        }
        int[][] result = new int[max_vertex][max_vertex];
        for (int i = 0; i < max_vertex; ++i) {
            System.arraycopy(m_adjacency[i], 0, result[i], 0, max_vertex);
        }
        m_adjacency = result;
    }


    public boolean IsEdge(int v1, int v2) {
        if (v1 >= max_vertex || v2 > max_vertex) {
            return false;
        }
        return m_adjacency[v1][v2] == 1;
    }

    public void AddEdge(int v1, int v2) {
        if (v1 >= max_vertex || v2 > max_vertex) {
            return;
        }
        m_adjacency[v1][v2] = 1;
        m_adjacency[v2][v1] = 1;
    }

    public void RemoveEdge(int v1, int v2) {
        if (v1 >= max_vertex || v2 > max_vertex) {
            return;
        }
        m_adjacency[v1][v2] = 0;
        m_adjacency[v2][v1] = 0;
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        Stack<Vertex> stack = new Stack<>();
        for (Vertex v : vertex) {
            v.Hit = false;
        }
        Vertex tekushaya = vertex[VFrom];
        while (checkUnHitVertex()) {
            tekushaya.Hit = true;
            stack.push(tekushaya);
            ArrayList<Vertex> neighbors = findAdjacentVertexs(tekushaya);
            if (checkTargetVertex(neighbors, VTo) != null) {
                stack.push(checkTargetVertex(neighbors, VTo));
                return stackToReverseArray(stack);
            } else if (checkTargetVertex(neighbors, VTo) == null) {
                if (unHitNeighbor(neighbors) != null) {
                    tekushaya = unHitNeighbor(neighbors);
                    continue;
                }
                if (unHitNeighbor(neighbors) == null) {
                    stack.pop();
                    if (stack.size() == 0) {
                        return stackToReverseArray(stack);
                    } else {
                        stack.peek().Hit = true;
                        tekushaya = stack.pop();
                    }
                }
            }
        }
        return stackToReverseArray(stack);
    }

    public Vertex unHitNeighbor(ArrayList<Vertex> neighbors) {
        for (Vertex neighbor : neighbors) {
            if (!neighbor.Hit) {
                return neighbor;
            }
        }
        return null;
    }

    public ArrayList<Vertex> findAdjacentVertexs(Vertex ver) {
        ArrayList<Vertex> result = new ArrayList<>();
        for (int i = 0; i < m_adjacency[ver.Value].length; i++) {
            if (m_adjacency[ver.Value][i] == 1) {
                result.add(vertex[i]);
            }
        }
        return result;
    }

    public Vertex checkTargetVertex(ArrayList<Vertex> arr, int target) {
        for (Vertex v : arr) {
            if (v.Value == target) {
                return v;
            }
        }
        return null;
    }

    public boolean checkUnHitVertex() {
        for (Vertex v : vertex) {
            if (!v.Hit) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Vertex> stackToReverseArray(Stack<Vertex> stack) {
        ArrayList<Vertex> result = new ArrayList<>();
        while (stack.size() != 0) {
            result.add(stack.pop());
        }
        Collections.reverse(result);
        return result;
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
        Deque<Vertex> queue = new LinkedList<>();
        ArrayList<Vertex> path = new ArrayList<>();
        Vertex tekushaya = vertex[VFrom];
        tekushaya.Hit = true;
        for (Vertex v : findAdjacentVertexs(tekushaya)) {
            if (!v.Hit) {
                queue.addLast(v);
            }
        }
        tekushaya = queue.peekFirst();
        path.add(tekushaya);

        while (queue.size() != 0) {

            ArrayList<Vertex> neighbors = findAdjacentVertexs(tekushaya);
            for (Vertex v : neighbors) {
                if (!v.Hit && !queue.contains(v)) {
                    queue.addLast(v);
                    path.add(v);
                    v.Hit = true;
                }
                if (v.Value == VTo) {
                    return glueQueue(path, VFrom, VTo);
                }
            }
            tekushaya = queue.pollFirst();
            tekushaya.Hit = true;
            //path.add(tekushaya);
        }

        return glueQueue(path, VFrom, VTo);
    }


    public ArrayList<Vertex> glueQueue(ArrayList<Vertex> path, int from, int to) {
        ArrayList<Vertex> result = new ArrayList<>();
        result.add(vertex[from]);
        result.addAll(path);
        result.add(vertex[to]);
        return result;
    }
}




