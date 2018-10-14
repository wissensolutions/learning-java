/**
 * searching
 * <p>
 */
package searching;

/**

 */
public class LinearSearch extends Search{
    @Override
    int doSearch(int[] inputArr, int searchElement) {
        int searchIndex = -1;
        for (int i=0;i<inputArr.length;i++){
            if(inputArr[i] == searchElement){
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }
}
