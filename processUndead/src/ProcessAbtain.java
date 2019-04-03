import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

class ProcessAbtain {
    static boolean showProcess(String name) {
        ProcessBuilder pb = new ProcessBuilder("tasklist");
        Process p;
        try {
            p = pb.start(); //创建任务管理进程
            BufferedReader out = new BufferedReader(new InputStreamReader(new BufferedInputStream(p.getInputStream()), Charset.forName("GB2312")));
            String ostr;
            while ((ostr = out.readLine()) != null) //逐行读取进程列表
                if (ostr.contains(name))    //查找目标进程
                    return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
