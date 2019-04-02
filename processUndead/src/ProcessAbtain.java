import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

class ProcessAbtain {
    boolean showProcess(String name) {
        ProcessBuilder pb = new ProcessBuilder("tasklist");
        Process p;
        try {
            p = pb.start();
            BufferedReader out = new BufferedReader(new InputStreamReader(new BufferedInputStream(p.getInputStream()), Charset.forName("GB2312")));
            String ostr;
            while ((ostr = out.readLine()) != null)
                if (ostr.contains(name))
                    return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
