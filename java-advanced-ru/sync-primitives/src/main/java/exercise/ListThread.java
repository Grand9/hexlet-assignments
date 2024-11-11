package exercise;

// BEGIN
import java.util.Random;

public class ListThread implements Runnable {

    private final SafetyList list;

    public ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int num = random.nextInt(1000);

            list.add(num);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// END
