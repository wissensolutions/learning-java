An entry in a WeakHashMap will automatically be removed when its key is no longer in ordinary use. 
More precisely, An entry will be discarded if garbage collection process run 


- Not Thread safe
- if we want to make this map as thread safe, need to use Collections.synchronisedHashMap
- Only weak reference object can be used as keys. 
- String is constant and has its own pool. So it is not weak reference. weak map functionality will not work with String