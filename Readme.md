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
String[] rets = list.toArray(new String[0]); //list of strings to string array
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
ArrayList<Integer> a = new ArrayList<>(Arrays.asList(array));
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

## HashMap and Set

### HashMap

```java
HashMap<T1, T2> map = new HashMap<>();
map.put(key, value);
map.get(key);
map.containsKey(key);
map.remove(key);
```
### HashSet

```java
HashSet<T> set = new HashSet<>();
set.add(key);
set.contains(key);
set.remove(key);
```

## Tips

1. 二分查找一要考虑会不会死循环，二要考虑会不会错过解
2. LinkedList先搞个dummy head再说, 不要丧失头结点，确定cur.next, cur.key不会报错
3. 递归不能忘记初始条件
4. DFS别忘记加层数加一
5. 谁小移谁的问题别忘记移！！！
6. Java声明变量别忘记右边
7. 所有问题先想为空的情况
8. BFS:
    part1: push first node into queue, add it to visited
    part2: keep popping nodes from the queue (expand) 
           push its neighbors to the queue, add them to visited list (generate)
    part3: repeat until the queue is empty or get results that we want
9. DFS:
    part1: set nodes as visited, check termination condition
    part2: for neighbors that has not been visited, DFS recursively 
10. 内外循环千万别搞混了,i , j;
11. c++ BST删除node需要删除吗？
12. unsigned int 来接受 vec.size()
    