import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class myStack {
        int size, top;

        int[] arr;

        public myStack() {
            this.size = 0;
            this.top = -1;
            this.arr = new int[10000];
        }

        public void push(int x) {
            arr[++top] = x;
            size++;

        }

        public int pop() {
            if (top == -1) {
                return -1;
            }
            size--;
            return arr[top--];
        }

        public int size() {
            return size;
        }

        public int empty() {
            if (size == 0) {
                return 1;
            }
            return 0;

        }

        public int top() {
            if (size == 0) {
                return -1;
            }
            return arr[top];
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        myStack stack = new myStack();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
            }


        }
        System.out.print(sb);


    }
}
