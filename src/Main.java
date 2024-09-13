//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {





        Threading2 threading2 = new Threading2(100);

        Thread thradA = new Thread(threading2::fizz);
        Thread thradB = new Thread(threading2::buzz);
        Thread thradC = new Thread(threading2::fizzBuzz);
        Thread thradD = new Thread(threading2::number);


        thradA.start();
        thradB.start();
        thradC.start();
        thradD.start();


        new TimerClass();
    }
}