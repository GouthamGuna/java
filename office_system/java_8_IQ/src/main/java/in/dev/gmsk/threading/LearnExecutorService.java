package in.dev.gmsk.threading;

import in.dev.gmsk.jdbc.JDBCConnection;
import in.dev.gmsk.model.StudentModel;

import java.util.OptionalInt;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LearnExecutorService {

    private static final String url = "jdbc:mysql://localhost:3306/dev_gmsk_db";         // krithvik";
    private static final String user = "root";
    private static final String password = "root";
    private static final JDBCConnection jdbcConnection;
    private static final int nThread = Runtime.getRuntime().availableProcessors();
    private static final int asize = 10; // initial size of array is 10
    private String[][] tab;

    static {
        jdbcConnection = new JDBCConnection(url, user, password);
    }

    public static void main(String[] args) {

        if (args.length > 0 && validateTheNumber(args[0])) {

            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                // demoNewFixedThreadPool(i);
                demoThread(i);
            }
        } else {
            System.out.println("No command line arguments were provided...");
            System.exit(0);
        }
    }

    private static void demoThread(int i) {

        Thread thread = new Thread(() -> {
            /*Stream<StudentModel> allStudentList =
                    StudentPlayingThreadClass.getAllStudentList(jdbcConnection);*/

            String s = StudentPlayingThreadClass.saveEmployee(jdbcConnection);

            // System.err.println("allStudentList = " + i + " " + Thread.currentThread().getName() + " " + allStudentList.collect(Collectors.toList()));
            System.err.println("allStudentList = " + i + " " + Thread.currentThread().getName() + " " + s);
        });
        thread.start();
    }

    private static void demoNewFixedThreadPool(int i) {

        ExecutorService executor = Executors.newFixedThreadPool(nThread);
        executor.execute(() -> {

            /*Stream<StudentModel> allStudentList =
                    StudentPlayingThreadClass.getAllStudentList(jdbcConnection);
            System.err.println("allStudentList = " + i + " " + Thread.currentThread().getName() + " " + allStudentList.collect(Collectors.toList()));*/


            String s = StudentPlayingThreadClass.saveEmployee(jdbcConnection);
            System.out.println("allStudentList = " + i + " " + Thread.currentThread().getName() + " " + s);
        });
        executor.shutdown();
    }

    private static boolean validateTheNumber(String val) {
        boolean returnFlag = false;
        try {
            Integer.parseInt(val);
            returnFlag = true;
        } catch (NumberFormatException e) {
            System.err.print(e.getMessage());
        }
        return returnFlag;
    }

    public OptionalInt findInt(String k) {
        try {

            String s = findValue(k);

            if (s == null) {
                return OptionalInt.empty();
            }

            return OptionalInt.of(Integer.parseInt(s));

        } catch (Throwable e) {
            return OptionalInt.empty();
        }
    }

    private String findValue(String key) {
        return findValue(key, null);
    }

    private String findValue(String k, String Default) {
        if (k == null)
            return Default;
        k = k.toLowerCase();
        for (int i = 0; i < asize; ++i) {
            if (tab[i][0] == null) {
                return Default;
            } else if (k.equals(tab[i][0])) {
                return tab[i][1];
            }
        }
        return Default;
    }
}
