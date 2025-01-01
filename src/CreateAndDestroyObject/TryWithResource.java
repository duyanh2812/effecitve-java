package CreateAndDestroyObject;

import java.io.*;
/*
Always use try-with-resources in preference to try-finally when working with resources that must be closed. The resulting code
is shorter and clearer, and the exceptions that it generates are more useful. The
try-with-resources statement makes it easy to write correct code using
resources that must be closed, which was practically impossible using try-finally.
 */
public class TryWithResource {
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        }
    }

    // try-with-resources on multiple resources - short and sweet
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[10];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }
}
