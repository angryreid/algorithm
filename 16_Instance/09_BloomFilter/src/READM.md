
# Bloom Filter

1. Judge element existing status.
2. Elements size is extra large, hope to use less space.
3. Allow error rate

## Advantage

It's a large Binary bit and hash functions (3), every element will be calculated by hash function and product an index

Space usage and finding time is less than most of Algorithm.

## Disadvantage

Error rate, hard to delete saved data.

## Instances

Web black list, Spam email, spider web site reduplicated judgement, back-end cache penetrating.

## Complexity

### Time

O(k) k -> number of hash functions

### Space

O(m) m -> Binary bit size