## Choosing the right Data Structure

Data structure is the way how data is stored in the computer. We should choose data structure very wisely else system will not perform well. Below are the bunch of DS and reasons when to use which one.

**1. Array** - It used to store similar kind of elements in contiguous memory. Can be used in below cases, 
- When fast element access is needed (Can be done using the index)  
- When number of elements i.e size of array is known before hand  
- When iterating through all the elements in sequence is needed  
- When less memory has to be used. (Arrays take less memory as compared to LinkedList)  

**2. Singly Linked List** - It is used to store data in nodes, which are connected to each other and points in one direction. Can be used in below cases,
- When constant time of insertion and deletion is needed (On head)
- When data dynamically grows
- When random elements are not needed to be accessed
- When insertion is needed at any point in the list

**3. Doubly Linked List** - Same as singly linked list but pointers in both the directions. Can be used in below cases,
- It's easier to delete the node from doubly linked list
- Can be iterated in reverse order without recursion
- Insertion or removal from doubly linked list is faster.

**4. Circular Linked List** - Same as singly linked list except the last node, which again points to first node. Can be used in below cases,
- Develop the buffer memory
- Represent a deck of cards in a game
- Browser cache which allows to hit the back button
- MRU list (Most recently used list)
- Undo functionality in photoshop or word

**5. Stack** - It is used to store data in LIFO form i.e LAST IN FIRST OUT. Think of a stack of plates. Can be used in below cases,
- Expression evaluation and syntax parsing
- Finding the correct path in maze using back tracking
- Runtime memory management
- Recursion function

**6. Queue** - It is used to store data in FIFO form i.e FIRST IN FIRST OUT. Think of a queue outside movie theatre. Can be used in below cases,
- When order is needed
- When processing is needed in FIFO order
- If we want to add or remove, queue can be used or double ended queue in case if operations needed both sides.

**7. Binary Tree** - Data Structure where each node has atmost 2 childs. Can be used in below cases, 
- Find name in the phone book
- Sorted traversal of the tree
- Find the next closest element
- Find all elements less then or greater then certain value

**8. Binary Search Tree (BST)** - This is similar to binary tree, except of the fact that root node is equal to or greater then the root node of left subtree and less then or equal to root node of right sub tree.
- They are memory efficient
- To be used when data needs to be sorted
- Search can be done on range of values
- Height balancing helps in reducing the run time

**9. B Tree** - This keeps data sorted and allows searches, sequential access, insertions, and deletions in logarithmic time. We can use B-Tree in the following use cases.
- File systems
- Database operations

**10. Red Black Tree** - This is again a kind of binary tree with an extra bit of data per node i.e its color, which can be either red or black. We can use Red-Black Tree in the following use cases.
- Java Tree Map and C++ map implemented using Red Black Tree.
- Computational Geometry Data structures.
- Scheduler applications.

**11. Splay Tree** - It is a self-adjusting binary search tree with the additional property that recently accessed elements are quick to access again. We can use Splay Tree in the following use cases,
- When we want to access the recent data easily.
- Allow duplicate items.
- Simple implementation and take less memory.
- When the application deals with a lot of data, use the splay tree.

**12. AVL Tree** - Shape of this tree is constrained at all times such that the tree remains balanced. The height of the tree never exceeds O(log n). We can use AVL Tree in the following use cases.
- When we want to control the tree height outside -1 to 1 range.
- Fast looking element.

**13. Minimum Spanning Tree** - A spanning tree of that graph is a subgraph that is a tree and connects all the vertices together. A minimum spanning tree (MST) or minimum weight spanning tree is then a spanning tree with weight less than or equal to the weight of every other spanning tree. We can use Minimum Spanning Tree in the following use cases.
- Describe financial markets.
- Handwriting recognition of mathematical expressions.
- Image registration and segmentation.
- Constructing trees for broadcasting in computer networks.

**14. Trie** - A Trie (digital tree and sometimes radix tree or prefix tree), is an ordered tree data structure that is used to store a dynamic set or associative array where the keys are usually strings. We can use Trie in the following use cases.
- Fixed dictionary and want to look up quickly.
- Require less storage for a large dictionary.
- Matching sentences during string matching.
- Predictable O(k) lookup time where k is the size of the key.
- Lookup can take less than k time if it’s not there.
- Supports ordered traversal.
- No need for a hash function.
- Deletion is straightforward.

**15. Heap** - It is a specialized tree-based abstract data type that satisfies the heap property. We can use Heap in the following use cases.
- Implement Priority Queue.
- Whenever we want quick access to the largest (or smallest) item.
- Good for selection algorithms (finding the min or max).
- Operations tend to be faster than for a binary tree.
- Heap sort sorting methods being in-place and with no quadratic worst-case scenarios.
- Graph algorithms are using heaps as internal traversal data structures, run time will be reduced by polynomial order.

**16. Hashing** - It is used to implement an associative array, a structure that can map keys to values. We can use Hash table in the following use cases.
- Constant time operation.
- Inserts are generally slow, reads are faster than trees.
- Hashing is used so that searching a database can be done more efficiently.
- Internet routers use hash tables to route the data from one computer to another.
- Internet search engine uses hash function effectively.

**17. Graph** - It is an abstract data type that is meant to implement the graph and directed graph concepts from mathematics. We can use Graph in the following use cases.
- Networks have many uses in the practical side of graph theory.
- Finding the shortest path between the cities.
- Solve maze game.
- Find the optimized route between the cities.

**18. Matrix** - It is used to store the data using rows and columns. We can use Matrix in the following use cases.
- Matrix arithmetic in graphic processing algorithms.
- Represent the graph.
- Represent quadratic forms and linear algebra solution.
