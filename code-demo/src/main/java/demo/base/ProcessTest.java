package demo.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessTest {
  public static void main(String[] args) throws IOException, InterruptedException {
    Runnable runnable = () -> run();
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    executorService.submit(runnable);
    executorService.submit(runnable);
    executorService.submit(runnable);
    executorService.submit(runnable);
    Thread.sleep(100000);
  }

  public static void run() {
    try {
      int outnum = 0;
      int errnum = 0;
      int s = 0;
      while (true) {
        s++;
        Process process = bashRun("python3 /Users/qihaiming/code/sensors-code/gitub/test1.py", new HashMap<>());
        StringBuilder stdoutStringBuilder = new StringBuilder();
        StringBuilder stderrStringBuilder = new StringBuilder();
        while (true) {
          // 尝试读stdout，没有就返回
          dumpInputStream(process.getInputStream(), stdoutStringBuilder);
          // 尝试读stderr，没有就返回
          dumpInputStream(process.getErrorStream(), stderrStringBuilder);

          if (!process.isAlive()) {
            // 尝试读stdout，没有就返回
            dumpInputStream(process.getInputStream(), stdoutStringBuilder);
            // 尝试读stderr，没有就返回
            dumpInputStream(process.getErrorStream(), stderrStringBuilder);
            if (stdoutStringBuilder.length() == 0) {
              outnum++;
            }
            if (stderrStringBuilder.length() == 0) {
              errnum++;
            }
            break;

          }
        }
        Thread.sleep(100);
        if (outnum>0 || errnum > 0) {
          System.out.println(
              "end................................................run" + s + " ..out:" + outnum + "  err:" + errnum);
          break;
        }
      }
    } catch (Exception e) {
      //...
    }

  }

  public static Process bashRun(String cmd, Map<String, String> envs) throws IOException {
    ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-l", "-c", cmd);
    if (null != envs) {
      Map<String, String> processEnvs = processBuilder.environment();
      for (Map.Entry<String, String> entry : envs.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
        processEnvs.put(key, value);
      }
    }
    return processBuilder.start();
  }

  public static String dumpInputStream(InputStream inputStream, StringBuilder stringBuilder) {
    byte[] buffer = new byte[4096];
    int readBytes = 0;
    try {
      while (true) {
        readBytes = inputStream.available();
        if (readBytes == 0) {
          break;
        }
        readBytes = Math.min(readBytes, buffer.length);
        inputStream.read(buffer, 0, readBytes);
        stringBuilder.append(new String(buffer, 0, readBytes));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return stringBuilder.toString();
  }
}
