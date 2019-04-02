import java.io.IOException;

public class ProcessUndead {
    public static void main(String[] args) {
        ProcessAbtain pa = new ProcessAbtain();
        try {
            Runtime.getRuntime().exec("calc");
            while (true) {
                Thread.sleep(1000);
                if (!pa.showProcess("Calculator.exe"))
                    Runtime.getRuntime().exec("calc");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

}
