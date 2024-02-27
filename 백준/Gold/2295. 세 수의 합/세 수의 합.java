import java.io.*;
import java.util.Arrays;

public class Main {

    public static int[] sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        sum = new int[n*(n+1)/2];

        for(int i = 0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int idx = 0;
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                sum[idx++] = arr[i]+arr[j];
            }
        }

        Arrays.sort(sum);

        for(int i = n-1; i>=0; i--){
            for(int j = i; j>=0; j--){
                if(bs(arr[i]-arr[j]))
                    continue;
                bw.write(String.valueOf(arr[i]));
                br.close();
                bw.close();
                return;
            }
        }

    }

    public static boolean bs(int num){
        int l = 0;
        int r = sum.length-1;

        while(l <= r){
            int mid = (l+r) >>> 1;
            if(sum[mid]>num)
                r = mid-1;
            else if(sum[mid]<num)
                l = mid+1;
            else
                return false;
        }
        return true;
    }
}