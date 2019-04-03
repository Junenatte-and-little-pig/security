import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessUndead {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("calc"); //创建计算器进程
            System.out.println("创建计算器进程，开始时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
            while (true) {
                Thread.sleep(1000);
                if (!ProcessAbtain.showProcess("Calculator.exe")) {   //判断进程列表中是否有计算器进程正在运行
                    Runtime.getRuntime().exec("calc");  //没有就再打开
                    System.out.println("重新创建计算器进程，开始时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
