#Streams
- Use stream operations to express sophisticated data processing queries.
    If we have large date sets, It would be difficult to process data. 
    For ex : 
     -  Finding a transaction with highest value group by operations 
     -  group all transactions related to grocery shopping
    Before Streams: 
    ```
        List<Transaction> groceryTransactions = new Arraylist<>();
        for(Transaction t: transactions){
          if(t.getType() == Transaction.GROCERY){
            groceryTransactions.add(t);
          }
        }
        Collections.sort(groceryTransactions, new Comparator(){
          public int compare(Transaction t1, Transaction t2){
            return t2.getValue().compareTo(t1.getValue());
          }
        });
        List<Integer> transactionIds = new ArrayList<>();
        for(Transaction t: groceryTransactions){
          transactionsIds.add(t.getId());
        }
    ```
    With Streams: 
    ```
    List<Integer> transactionsIds = 
        transactions.stream()
                    .filter(t -> t.getType() == Transaction.GROCERY)
                    .sorted(comparing(Transaction::getValue).reversed())
                    .map(Transaction::getId)
                    .collect(toList());
     ```               
- Parallel processing (parallelStream)
    ```
        List<Integer> transactionsIds = 
            transactions.parallelStream()
                        .filter(t -> t.getType() == Transaction.GROCERY)
                        .sorted(comparing(Transaction::getValue).reversed())
                        .map(Transaction::getId)
                        .collect(toList());
                        
    ```                    
- Aggregate operations : Streams support SQL-like operations and common operations from functional programing languages, such as filter, map, reduce, find, match, sorted, and so on. 
    ```
         List<Integer> transactionsIds = 
                transactions.parallelStream()
                            .filter(t -> t.getType() == Transaction.GROCERY)
                            .sorted(comparing(Transaction::getValue).reversed())
                            .map(Transaction::getId)
                            .collect(toList());

    ```
- Higher efficiency with lazyness ( Intermediate opertations): Stream operations that can be connected are called intermediate operations. 
They can be connected together because their return type is a Stream. Operations that close a stream pipeline are called terminal operations. They produce a result from a pipeline such as a List, an Integer, or even void (any non-Stream type).
     Intermediate operations do not perform any processing until a terminal operation is invoked on the stream pipeline; they are “lazy.” This is because intermediate operations can usually be “merged” and processed into a single pass by the terminal operation.
    ```
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> twoEvenSquares = 
            numbers.stream()
                   .filter(n -> {
                            System.out.println("filtering " + n); 
                            return n % 2 == 0;
                          })
                   .map(n -> {
                            System.out.println("mapping " + n);
                            return n * n;
                          })
                   .limit(2)
                   .collect(toList());
    ```
- Numeric operations : Java SE 8 introduces three primitive specialized stream interfaces to tackle this issue—IntStream, DoubleStream, and LongStream—that respectively specialize the elements of a stream to be int, double, and long.
  ```
   int statementSum = 
       transactions.stream()
                   .mapToInt(Transaction::getValue)
                   .sum(); // works!
   ```    
               
               