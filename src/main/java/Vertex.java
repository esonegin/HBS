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
        Vertex newVertex = new Vertex(value);
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == null) {
                vertex[i] = newVertex;
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
        //6.1, 6.3
        int[][] matrixWithDeletedVertex = new int[max_vertex][max_vertex];
        for (int i = 0; i < max_vertex; ++i) {
            System.arraycopy(m_adjacency[i], 0, matrixWithDeletedVertex[i], 0, max_vertex);
        }
        m_adjacency = matrixWithDeletedVertex;
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
                if (getUnHitNeighbor(neighbors) != null) {
                    tekushaya = getUnHitNeighbor(neighbors);
                    continue;
                }
                if (getUnHitNeighbor(neighbors) == null) {
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

    //unHitNeighbor - getUnHitNeighbor
    public Vertex getUnHitNeighbor(ArrayList<Vertex> neighbors) {
        for (Vertex neighbor : neighbors) {
            if (!neighbor.Hit) {
                return neighbor;
            }
        }
        return null;
    }

    public ArrayList<Vertex> findAdjacentVertexs(Vertex ver) {
        //6.1, 6.3
        ArrayList<Vertex> listOfNeighbors = new ArrayList<>();
        for (int i = 0; i < m_adjacency[ver.Value].length; i++) {
            if (m_adjacency[ver.Value][i] == 1) {
                listOfNeighbors.add(vertex[i]);
            }
        }
        return listOfNeighbors;
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
        //6.2
        Deque<Vertex> dequeueVertex = new LinkedList<>();
        ArrayList<Vertex> currentPath = new ArrayList<>();
        Vertex currentVertex = vertex[VFrom];
        currentVertex.Hit = true;
        currentPath.add(currentVertex);
        for (Vertex v : findAdjacentVertexs(currentVertex)) {
            if (v == vertex[VTo]) {
                currentPath.add(v);
                return currentPath;
            }
            dequeueVertex.addLast(v);
            v.Hit = true;
        }

        if (currentVertex == vertex[VTo]) {
            currentPath.add(currentVertex);
            return currentPath;
        }

        while (dequeueVertex.size() != 0) {
            if (findAdjacentVertexs(currentVertex).contains(vertex[VTo])) {
                return currentPath;
            }
            currentVertex = dequeueVertex.poll();
            if (unHitNeighbor(findAdjacentVertexs(currentVertex)) != null) {
                currentPath.add(currentVertex);
            }
            if (findAdjacentVertexs(currentVertex).contains(vertex[VTo])) {
                currentPath.add(vertex[VTo]);
                return currentPath;
            }
            for (Vertex v : findAdjacentVertexs(currentVertex)) {
                if (!v.Hit) {
                    dequeueVertex.addLast(v);
                }
                v.Hit = true;
            }

        }
        if (checkUnHitVertex()) {
            currentPath.clear();
            return currentPath;
        }
        if (!currentPath.contains(vertex[VTo])) {
            currentPath.add(vertex[VTo]);
        }
        return currentPath;
    }

    public ArrayList<Vertex> WeakVertices() {
        ArrayList<Vertex> result = new ArrayList<>();
        for (Vertex v : vertex) {
            if (findAdjacentVertexs(v).size() == 0 || !checkNeighborsConnection(v)) {
                result.add(v);
            }
        }
        return result;
    }

    public boolean checkNeighborsConnection(Vertex parrent) {
        //6.3
        ArrayList<Vertex> neighborVertices = findAdjacentVertexs(parrent);
        for (Vertex firstNeighbor : neighborVertices) {
            for (Vertex secondNeighbor : neighborVertices) {
                if (IsEdge(firstNeighbor.Value, secondNeighbor.Value) && firstNeighbor.Value != secondNeighbor.Value) {
                    return true;
                }
            }
        }
        return false;
    }
}
