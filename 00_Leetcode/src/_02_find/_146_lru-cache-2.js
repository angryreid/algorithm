class Node {
  constructor(key, value) {
    this.key = key;
    this.value = value;
    this.prev = this.next = null;
  }
}

/**
 * @param {number} capacity
 */
var LRUCache = function (capacity) {
  this.capacity = capacity;
  this.map = new Map();
  this.head = new Node();
  this.head.next = this.head;
  this.head.prev = this.head;

  this.removeNode = function (node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  };

  this.moveToHead = function (node) {
    node.prev = this.head;
    node.next = this.head.next;
    node.prev.next = node;
    node.next.prev = node;
  };

  this.getNode = function (key) {
    const node = this.map.get(key);
    if (!node) return null;
    this.removeNode(node);
    this.moveToHead(node);
    return node;
  };
};

/**
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function (key) {
  return this.getNode(key)?.value ?? -1;
};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function (key, value) {
  const node = this.getNode(key);
  if (node) {
    node.value = value;
  } else {
    if (this.map.size === this.capacity) {
      const lastNode = this.head.prev;
      this.removeNode(lastNode);
      this.map.delete(lastNode.key);
    }
    const newNode = new Node(key, value);
    this.moveToHead(newNode);
    this.map.set(key, newNode);
  }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

var cache = new LRUCache(2 /* capacity */);
cache.put(1, 1);
cache.put(2, 2);
console.log(cache.get(1)); // returns 1
cache.put(3, 3); // evicts key 2
console.log(cache.get(2)); // returns -1 (not found)
cache.put(4, 4); // evicts key 1
console.log(cache.get(1)); // returns -1 (not found)
