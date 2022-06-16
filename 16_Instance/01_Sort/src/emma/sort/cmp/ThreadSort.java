package emma.sort.cmp;

public class ThreadSort extends Thread{
    private int value;

    public ThreadSort(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(value * 1000);
            System.out.println(value);;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
