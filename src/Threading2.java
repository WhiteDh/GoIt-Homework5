import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Threading2 {
    private int n;
    private int currentValue = 1;

    //usage concurrency
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();


    public Threading2(int n) {
        this.n = n;
    }


    public void fizz() {
        while (currentValue <= n) {
            synchronized (this) {
                if (currentValue > n) break;
                if (currentValue % 3 == 0 && currentValue % 5 != 0) {
                    queue.add("Fizz");
                    currentValue++;
                    notifyAll();
                }
            }
        }
    }

    public void buzz() {
        while (currentValue <= n) {
            synchronized (this) {
                if (currentValue > n) break;
                if (currentValue % 3 != 0 && currentValue % 5 == 0) {
                    queue.add("Buzz");
                    currentValue++;
                    notifyAll();
                }
            }
        }
    }
    public void fizzBuzz() {
        while (currentValue <= n) {
            synchronized (this) {
                if (currentValue > n) break;
                if (currentValue % 3 == 0 && currentValue % 5 == 0) {
                    queue.add("FizzBuzz");
                    currentValue++;
                    notifyAll();
                }
            }
        }
    }

    public void number() {
        while (currentValue <= n||queue.isEmpty()) {
            synchronized (this) {
                if(queue.isEmpty() && currentValue <= n && currentValue%3 !=0 && currentValue%5!=0)
                {
                    queue.add(Integer.toString(currentValue));
                    currentValue++;
                    notifyAll();
                }
                else {
                    while (!queue.isEmpty()) {
                        System.out.println(queue.poll());
                    }
                }
            }
        }
    }

}
