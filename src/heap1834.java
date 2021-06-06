import java.util.*;

public class heap1834 {

    public class Task {
        public int enqueue;
        public int process;
        public int index;
        public Task(int enqueue,int process,int index) {
            this.enqueue = enqueue;
            this.process = process;
            this.index = index;
        }
    }
    public int[] getOrder(int[][] tasks) {
        if(tasks == null || tasks.length == 0) return new int[]{};
        ArrayList<Task> list = new ArrayList<>();
        for(int i = 0;i<tasks.length;i++){
            Task t = new Task(tasks[i][0],tasks[i][1],i);
            list.add(t);
        }
        Collections.sort(list, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.enqueue - o2.enqueue;
            }
        });
        PriorityQueue<Task> heap = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.process == o2.process) {
                    return o1.index - o2.index;
                }else{
                    return o1.process - o2.process;
                }
            }
        });
        int[] ret = new int[tasks.length];
        long now = 0;
        int index = 0;
        int i = 0;
        while (i < tasks.length) {
            //heap offer tasks (enqueue time <= now)
            while (i < tasks.length && list.get(i).enqueue <= now) {
                heap.offer(list.get(i));
                i++;
            }
            //empty heap
            if(heap.isEmpty()) {
                now = list.get(i).enqueue;
                while (i < tasks.length && list.get(i).enqueue <= now) {
                    heap.offer(list.get(i));
                    i++;
                }
            }

            if(!heap.isEmpty()) {
                Task poll = heap.poll();
                now+=poll.process;
                ret[index] = poll.index;
                index++;
            }
        }
        while (!heap.isEmpty()) {
            Task poll = heap.poll();
            ret[index] = poll.index;
            index++;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[][] tasks = {
                {7,10},
                {7,12},
                {7,5},
                {7,4},
                {7,2}
        };
        heap1834 obj = new heap1834();
        int[] order = obj.getOrder(tasks);
        System.out.println(Arrays.toString(order));
    }
}
