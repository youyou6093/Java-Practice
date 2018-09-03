## Purpose  

This repository is for me to study java, some interview questions are also included.

## String && StringBuilder

### String
```java
String x = "hello";
x.charAt(index);
x.equals("hello");
Integer.parseInt(string); //change string to integer
Integer.toString(num);
x.length();
char[] array = str.toCharArray();   //change string to char array
str = new String(array); //char array to string
```

### StringBuilder
```java
StringBuilder sol = new StringBuilder();
sol.append(chr);
sol.toString();
sol.deleteCharAt(sol.length() - 1);
```

## Queue & Stack

### Queue 
```java
Deque<E> queue = new LinkedList<>();
queue.offerLast(var);
queue.pollFirst();
queue.peekFirst();
queue.isEmpty();
queue.size();
//or use queue interface
Queue<E> queue = new LinkedList<>();
queue.poll();
queue.peek();
queue.offer();

```

### Stack
```java
Deque<E> stack = new LInkedList<>();
stack.offerFirst(var);
stack.pollFirst();
stack.peekFirst();
```


## ArrayList

```java
List<E> myList = new ArrayList<>();
List<E> newList = new ArrayList<>(myList); //create a deep copy
myList.add(e);
myList.get(index);
myList.indexOf(e); //first occurrence or -1
myList.add(index, e);
myList.isEmpty();
myList.size();
myList.remove(index);
myList.set(index, e);
myList.subList(index1, index2); //[index1, index2]
myList.toArray();
List<List<Integer>> list = new ArrayList<>();
for (Integer a : myList)   // iterate a list
```

## Array

```java
int[] array = new int[];
Arrays.toString(x)
char[] array;
//convert array to string/list
String a  = new String(array);
ArrayList<Integer> a = Arrays.asList(array);
```

## Heap

```java

class myComparator implements Comparator<Cell>{
    @Override
    public int compare(Cell t1, Cell t2) {
        if (t1.val == t2.val) {
            return 0;
        } else {
            return t1.val < t2.val ? -1 : 1;
        }
    }
}

PriorityQueue<point> pQueue = new PriorityQueue<>(k, new myComparator()); //k need to be positive
PriorityQueue<point> pQueue = new PriorityQueue<>(k, Collections.reverseOrder());
pQueue.offer(e);
pQueue.poll();
pQueue.peek();
```



## Tips

1. 二分查找一要考虑会不会死循环，二要考虑会不会错过解
2. LinkedList先搞个dummy head再说
3. 递归不能忘记初始条件
 