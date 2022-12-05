# Graph

`G = (V, E)`
V -> Vertex
E -> Edge

## Type

### Directed Graph

#### Directed Acyclic Graph

DAG: Any vertex can not get back itself with any edge

#### Strongly Connected Graph

Vertex `x` can reach to `y` with edges.

Any two vertexes is connected.

### Undirected Graph

#### Connected Component

### Mixed Graph

### Multiple Graph

### Undirected Completed Graph

Any two vertexes have edge.

If vertexes number is `n`, then all edges are `n * (n - 1) / 2`

### Directed Completed Graph

Any two vertices have two diff direction edge.

If vertexes number is `n`, then all edges are `n * (n - 1)`

### Weighted Graph

Edge has weight.

### Connected Graph

Vertex `x` can reach to `y` with edges.

Any two vertexes is connected.

## Implementation

### Adjacency Matrix

- One level List saves the vertexes
- Two level List saves the edges

### Adjacency List

- Linked list saves each path

## AOV

Activity on Vertex Network -> Directed Acyclic Graph

1962 Kahn Algorithm

Topo Sort

1. Find the entry, no dependency. In edges are 0
2. Removed the setp 1 vertex and remove related edges
3. Until no In edges vertex.


## Spanning Tree

### Minimum Spanning Tree

#### Cut Theory

Crossing Edge: if there is one edge with two vertex belongs to diff Cut area, this edge is Crossing Edge.

Cut Theory: The minimum weight edge in any Cut area must be the part of MST

#### Prim Algorithm

#### Kruskal Algorithm