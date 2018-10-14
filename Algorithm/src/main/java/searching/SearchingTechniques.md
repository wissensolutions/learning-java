1. Binary Search
     * Few points to note here,
        1. Binary search works only on sorted collection
        2. Ex. Looking up a name in Telephone directory
        3. Each time we make a comparison, we eliminate half of the list </p>
     
     **Algorithm** :
      1. Find the mid index in the list and compare it with the search term
      2. If search term is smaller then the element at mid index, eliminate upper half, else eliminate lower half
      3. If it is equal, break the loop as we have found our element.
      4. Keep running the loop until high >= low.
      5. return index of matching item, or -1 if not found
    
     **Complexity** :
      1. Best Case : What is the fewer number of iterations to find the item?
     	    * Best case is when search term is at the first try
      	    * Number of comparisons in this case is 1
     
      2. Worst Case : What is the most number of comparisons needed to find the item?
            * Worst case is when search term is not at all in the array
            * If our array is of size N, we need log(2)N comparisons for worst case
     
      3. Average Case : On an Average, how many comparisons are needed to find the element in the array?
            * On an average, search term is anywhere in the list
            
            
2. Linear Search: Linear search sequentially checks each element of the list until it finds an element that matches the target value. If the algorithm reaches the end of the list, the search terminates unsuccessfully.
    
    Linear Search is also called Sequential Search
  
 **Few point**
   * It can be really slow with large number of elemets in the collection
        * ex. If we have 100000 items in the list, on an average it will take 500000 number of comparisons
   * To be used when we are not sure about the sort order of the list. </p>
     
 **Algorithm**
   * Loop through each item in the list
   * Compare search term to the current item in the list
   * If matches, save index of the matching item and break
   * return index of matching item, or -1 if not found
 
 **Complexity**
  1. Best Case : What is the fewer number of iterations to find the item?
        * Best case is when search term is at the first slot of the array
        * Number of comparisons in this case is 1
  2. Worst Case : What is the most number of comparisons needed to find the item?
        *   Worst case is when search term is at the last slot of the array or not at all in the array
        * If our array is of size N, we need N comparisons for worst case
  3. Average Case : On an Average, how many comparisons are needed to find the element in the array?
        * On an average, search term will be in the middle of the array
        * For an array of size N, number of comparisons will be N/2

    