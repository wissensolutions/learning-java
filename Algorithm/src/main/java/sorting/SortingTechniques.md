Sorting techniques will be two different types 
    -  Integer Algorithm 
    -  Comparision algorithm
    
Comparision algorithms : 
1. Insertion Sort: Insertion sort is a comparison-based algorithm that builds a final sorted array one element at a time. It iterates through an input array and removes one element per iteration, finds the place the element belongs in the array, and then inserts it there.
     1. It is very simple.
     2. It is very efficient for small data sets.
     3. It is stable; i.e., it does not change the relative order of elements with equal keys.
     4. In-place; i.e., only requires a constant amount O(1) of additional memory space.
   - [Implementation](./InsertionSort.java)
   
   ![insertion-sort](https://user-images.githubusercontent.com/24597513/46922264-36cc6900-cfbb-11e8-9a7c-be40bec3631f.png)

  See more at: http://www.java2novice.com/java-sorting-algorithms/insertion-sort/#sthash.chHgGH9U.dpuf
  
2. Bubble Sort: Bubble sort is a comparison​-based algorithm that compares each pair of elements in an array and swaps them if they are out of order until the entire array is sorted. For each element in the list, the algorithm compares every pair of elements.   
    *Advantages:*
    1. Easy to understand.
    2. Easy to implement.
    3. In-place, no external memory is needed.
    4. Performs greatly when the array is almost sorted.
    
    *<p>Disadvantages</p>*
    1. Very expensive, O(n2)in worst case and average case.
    2. It does more element assignments than its counterpart, insertion sort.
   - [Implementation](./BubbleSort.java)
  
    
3.  Merge Sort: Mergesort is a comparison-based algorithm that focuses on how to merge together two pre-sorted arrays such that the resulting array is also sorted.
    
    *Time Complexity*
    * Whenever there are inner loops associated, complexity is n^2. In this case, 
    * Best - O(n log(n))
    * Average - O(n log(n))
    * Worst - O(n log(n))
   - [Implementation](./MergeSort.java)

4. Quick Sort: Quicksort is a divide and conquer algorithm. It first divides a large list into two smaller sub-lists and then recursively sort the two sub-lists.
    
    The basic step of sorting an array are as follows:
     * Select a pivot, normally the middle one
     * From both ends, swap elements and make left elements < pivot and all right > pivot
     * Recursively sort left part and right part
    - [Implementation](./QuickSort.java)
     
5. Heap Sort:TBA

6. Selection Sort: The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. 
    * During each pass, the unsorted element with the smallest (or largest) value is moved to its proper position in the array.
    * The number of times the sort passes through the array is one less than the number of items in the array.
    * In the selection sort, the inner loop finds the next smallest (or largest) value and
    * the outer loop places that value into its proper location.
  
  ![selectionsort](https://user-images.githubusercontent.com/24597513/46922239-ee14b000-cfba-11e8-8339-0de212447d08.jpg)
  
     - See more at: http://www.java2novice.com/java-sorting-algorithms/selection-sort/#sthash.z3AacPw6.dpuf
     
    - [Implementation](./SelectionSort.java)
7. Counting Sort: Counting sort is a sorting technique based on keys between a specific range. It works by counting the number of objects having distinct key values (kind of hashing). Then doing some arithmetic to calculate the position of each object in the output sequence.

      Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input.
      
      Auxiliary Space: O(n+k)
      
      Points to be noted:
      1. Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted. Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.
      2. It is not a comparison based sorting. It running time complexity is O(n) with space proportional to the range of data.
      3. It is often used as a sub-routine to another sorting algorithm like radix sort.
      4. Counting sort uses a partial hashing to count the occurrence of the data object in O(1).
      5. Counting sort can be extended to work for negative inputs also.
      
    - [Implementation](./CountingSort.java)
     
![alt text](resources/SortingComparision.png "Sorting Comparision")

**Recommendation**
* Small sets of Data : Bubble sort
* Larger sets of Data : Quick Sort
