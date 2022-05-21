# Hash

function

1. `hashCode` is using to calc the hash index of map list.
2. `equals` is using to compare when hash conflict with same hash code element.

```java
key1.equals(key2)
```

## Comparing with TreeMap

TreeMap requires element's key must can be compared.

HashMap no requires for element's key.
HashMap will using equals function to judge if same element.

## Enlarger Size with 2 times

1. index wont change
2. index = index + old table size

##  TODO

- Add Test Case.