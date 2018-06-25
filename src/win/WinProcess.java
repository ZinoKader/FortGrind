package win;

import constants.WinConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class WinProcess {

    private static final String TASKLIST = "tasklist";

    public static boolean isProcessRunning(String serviceName) {
        return ProcessHandle.allProcesses().anyMatch(processHandle -> {
            if (processHandle.info().command().isPresent()) {
                return processHandle.info().command().get().contains(serviceName);
            }
            return false;
        });
    }

    public static long getProcessId(String processName, String negativeKeyWord) {
        return ProcessHandle.allProcesses()
                .filter(processHandle -> {
                    if (processHandle.info().command().isPresent()) {
                        String testedProcessName = processHandle.info().command().get();
                        return testedProcessName.contains(processName) && !testedProcessName.contains(negativeKeyWord);
                    }
                    return false;
                })
                .findAny().get().pid();
    }

}
