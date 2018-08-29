## Purpose  

This repository is for me to study java, some interview questions are also included.

## String

```java
String x = "hello";
x.charAt(index);
x.equals("hello");
Integer.parseInt(string); //change string to integer
Integer.toString(num);
```

## queue & stack

```java
Deque<E> queue = new LinkedList<>();
Deque<E> stack = new LInkedList<>();
queue.offerLast(var);
queue.pollFirst();
queue.peekFirst();
queue.isEmpty();
queue.size();
stack.offerFirst(var);
stack.pollFirst();
```

## ArrayList

```java
List<E> myList = new ArrayList<>();
myList.add(e);
myList.get(index);
myList.indexOf(e); //first occurrence or -1
mylist.clone(); 
myList.clear();
myList.add(index, e);
myList.isEmpty();
myList.size();
myList.remove(index);
myList.set(index, e);
myList.subList(index1, index2); //[index1, index2]
myList.toArray();
List<List<Integer>> list = new ArrayList<>();
for (Integer a : myList) 
```
## Array

```java
int[] array = new int[];
Arrays.toString(x)
```

## Heap

```java
Comparator<point> myComparator = new Comparator<point>() {
    @Override
    public int compare(point t1, point t2) {
        if (t1.val == t2.val) {
            return 0;
        } else {
            return t1.val < t2.val ? -1 : 1;
        }
    }
};

PriorityQueue<point> pQueue = new PriorityQueue<>(k, myComparator);
pQueue.offer(e);
pQueue.poll();
pQueue.peek();
```

## Tips

1. 二分查找一要考虑会不会死循环，二要考虑会不会错过解
2. LinkedList先搞个dummy head再说
3. 递归不能忘记初始条件
 