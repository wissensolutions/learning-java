## Introduction to Trees

Tree data structure consists of Nodes. Below are some of the aspects of nodes, 
- Each tree has a root node.
- Root node has zero or more child nodes.
- Each child node has zero or more child nodes and so on.  

A tree cannot contain cycles. The nodes may or may not be in a particular order. They could have any data value stored in them. They may or may not have links to there parent nodes, but each parent node will have links to the child nodes.  
NOTE : Tree is actually a type of Graph

**Trees vs. Binary Trees**  
A binary tree is a tree in which each node has atmost 2 childrens. Not all trees are binary trees. Ex, below tree is not a binary tree, we call it a ternary tree. 

![ternary_tree](https://cloud.githubusercontent.com/assets/3439029/19421752/c5ca281e-93bc-11e6-9a64-56ef41710140.png)

There are ocassions when we may have to deal with non-binary trees. Ex. If we want a tree to represent bunch of phone numbers, we may use a 10-ary tree with each node having upto 10 nodes(one for each digit). Node is called a "leaf" if it has no childrens. 

**Binary Trees vs. Binary Search Trees**  
Every node in Binary Search Tree(BST) satisfies a property i.e _All left Nodes <= Root Node < All Right Nodes_ whereas Binary Trees does not hold any such property, they just make sure that each node except leaf nodes have atmost 2 childrens.  

**Balanced vs. UnBalanced**  
While many trees are balanced but not all. Two most common balanced trees are AVL Trees and Red Black Trees. Some definitions to check at this point of time are, 
 - _Complete Binary Tree_ : In this tree every level of the tree is fully filled, except the last level. If last level is filled, then it is filled from left to right.
 - _Full Binary Tree_ : A tree is considered as full Binary Tree if each node has either Zero or Two childs i.e none of the node should have 1 child.
 - _Perfect Binary Tree_ : A tree is considered as Perfect Binary Tree if it is both complete and full.
 
**Binary Tree Traversal**
There are three types of traversal in general that can be applied to a binary tree, 
i.e InOrder, PreOrder and PostOrder
 - _InOrder Traversal_ : Left > Current > Right i.e Visit the left sub tree first, then current node and then right sub tree.
 - _PreOrder Traversal_ : Current > Left > Right i.e Visit the current node first then its child nodes (That's why it's called Pre-Order)
 - _PostOrder Traversal_ : Left > Right > Current i.e Visit the child nodes first and then current node (That's why it's called Post Order)
 
**Common Operation on Tree**
- _Insertion_: Nodes can be inserted into binary trees in between two other nodes or added after a leaf node. In binary trees, a node that is inserted is specified as to which child it is.
- _Leaf Nodes_: To add a new node after leaf node A, A assigns the new node as one of its children and the new node assigns node A as its parent.
- _Internal Nodes_: Insertion on internal nodes is slightly more complex than on leaf nodes. Say that the internal node is node A and that node B is the child of A. (If the insertion is to insert a right child, then B is the right child of A, and similarly with a left child insertion.) A assigns its child to the new node and the new node assigns its parent to A. Then the new node assigns its child to B and B assigns its parent as the new node.
- _Deletion_:Deletion is the process whereby a node is removed from the tree. Only certain nodes in a binary tree can be removed unambiguously.
    - _Node to be deleted is leaf: Simply remove from the tree.
    - _Node to be deleted has only one child: Copy the child to the node and delete the child
    - _Node to be deleted has two children: Find inorder successor of the node. Copy contents of the inorder successor to the node and delete the inorder successor. Note that inorder predecessor can also be used.
        
*Note*: The important thing to note is, inorder successor is needed only when right child is not empty. In this particular case, inorder successor can be obtained by finding the minimum value in right child of the node.
        
- Traversal: As Tree doesn't contains cycles, we dont remember visited nodes
    - _Breadth First_:Contrasting with depth-first order is breadth-first order, which always attempts to visit the node closest to the root that it has not already visited
    - _Depth First_: In depth-first order, we always attempt to visit the node farthest from the root node that we can
    
    
**AVL Tree**  
This is a self balancing BST. In an AVL tree, height of two subtrees of a given node differ by at most one. If at any time they differ by more then one, re balancing is done to restore this property.  
Lookup, insertion and deletion all of them takes O(log n) time in both average and worst cases, where n is the number of nodes in the tree prior to operation.   

AVL trees are often compared with Red-Black trees because both the them supports same set of operations and takes same amount of time.
Because AVL trees are more rigidly balanced, they are faster than red-black trees for lookup intensive applications. However, red-black trees are faster for insertion and removal.
Term used in AVL trees is balance factor, which is derived as
	BalanceFactor = height(left subtree) - height(right subtree)
At any given node, if this balance factor becomes > 1, then re balancing happens. If for some reason re balancing fails, then this tree is not considered as AVL tree.


Rotations :
To make itself balanced this tree performs 4 different kind of operations, 
	- Left Rotation
	- Right Rotation
	- Left-Right Rotation
	- Right-Left Rotation
	
Left Rotation : If a tree becomes unbalanced when a node is inserted in right sub tree, then left rotation is done.
Right Rotation : AVL tree may become unbalanced when a node is inserted in left sub tree, this will result in right rotation.
Left Right Rotation : Double rotations are slightly complex. This is left rotation followed by right rotation. 
Right Left Rotation : This is right rotation followed by left rotation.

	