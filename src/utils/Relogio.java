package utils;

public class Relogio implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(java.time.LocalTime.now().toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
