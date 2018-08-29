import java.util.*;

public class Help {
    public static void main(String[] args){
        Help tester = new Help();
        System.out.println(tester.kth(40));
    }

    public int kth(int k) {
        // Write your solution here
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2){
                if(c1.value == c2.value){
                    return 0;
                }
                return c1.value < c2.value ? -1:1;
            }
        });


        int rows = 40;
        int cols = 40;

        minHeap.offer(new Cell(0,0));
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0]= true;
        k--;
        while(k > 0 ){
            Cell cur = minHeap.poll();
            if(cur.x + 1 < rows && ! visited[cur.x+1][cur.y]){
                minHeap.offer(new Cell(cur.x+1, cur.y));
                visited[cur.x+1][cur.y] = true;
            }
            if(cur.y + 1 < cols && ! visited[cur.x][cur.y+1]){
                minHeap.offer(new Cell(cur.x, cur.y+1));
                visited[cur.x][cur.y+1] = true;
            }
            k--;
        }
        return minHeap.peek().value;
    }

    private int deFactor(int k, int a){
        int count = 1;
        while(k / 2 != 0){
            k = k/2;
            count++;
        }
        return count;
    }

    static class Cell{
        int x;
        int y;
        int value;
        public Cell(int x, int y){
            this.x = x;
            this.y = y;
            this.value = (int)((int)Math.pow(2, x) * Math.pow(3, y));
        }
    }
}