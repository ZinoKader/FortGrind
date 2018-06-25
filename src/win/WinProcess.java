package win;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WinProcess {

    private static final String TASKLIST = "tasklist";

    public static boolean isProcessRunning(String serviceName) {
        try {
            Process p = Runtime.getRuntime().exec(TASKLIST);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(serviceName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }

}
