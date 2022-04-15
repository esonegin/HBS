import java.util.*;

class Vertex {
    public int Value;

    public Vertex(int val) {
        Value = val;
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
}
