
public class TimerClass {
    private int second =1;

    public TimerClass(){

        //for the second task to complete its work
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        printEverySecond.start();
        printEveryFiveSecond.start();

    }

    Thread printEverySecond = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true) {
                try {
                    System.out.println(second);
                    second++;
                    Thread.sleep(1000);


                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    });

    Thread printEveryFiveSecond = new Thread(new Runnable() {
        @Override
        public void run() {

            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Пройшло 5 секунд");

                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }


            }
        }
    });
}
