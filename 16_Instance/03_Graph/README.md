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

Any two vertexes have two diff direction edge.

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
