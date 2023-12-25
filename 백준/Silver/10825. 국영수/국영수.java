import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Student {
        String name;
        int kor,eng,math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, kor, eng, math);
        }

        Arrays.sort(students,(a,b) -> {
            if(a.kor != b.kor) {
                return b.kor-a.kor;
            }
            if(a.eng != b.eng) {
                return a.eng-b.eng;
            }

            if(a.math != b.math) {
                return b.math - a.math;
            }
            return a.name.compareTo(b.name);
        });
        Arrays.stream(students).forEach(std -> {
            sb.append(std.name).append("\n");
        });
        System.out.print(sb);
        br.close();
    }
}
