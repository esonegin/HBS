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
        // ваш код добавления новой вершины
        // с значением value
        // в незанятую позицию vertex
        Vertex newvertex = new Vertex(value);
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == null) {
                vertex[i] = newvertex;
                break;
            }
        }

    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке  vertex
    public void RemoveVertex(int v) {
        // ваш код удаления вершины со всеми её рёбрами
        for (Vertex vertex : vertex) {
            if (vertex.Value == v) {
                vertex.Value = -1;
            }
        }
        int[][] result = new int[m_adjacency.length - 1][v - 1];


    }

    public boolean IsEdge(int v1, int v2) {
        // true если есть ребро между вершинами v1 и v2
        if (m_adjacency[v1 - 1][v2 - 1] == 1) {
            return true;
        }
        return false;
    }

    public void AddEdge(int v1, int v2) {
        // добавление ребра между вершинами v1 и v2
        m_adjacency[v1 - 1][v2 - 1] = 1;
        m_adjacency[v2 - 1][v1 - 1] = 1;
    }

    public void RemoveEdge(int v1, int v2) {
        // удаление ребра между вершинами v1 и v2
        m_adjacency[v1 - 1][v2 - 1] = 0;
        m_adjacency[v2 - 1][v1 - 1] = 0;
    }
}