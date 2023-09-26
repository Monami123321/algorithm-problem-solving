import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int m = Integer.parseInt(br.readLine());

		int set = 0;

		for (int i = 0; i < m; i++) {
			String[] cmd = br.readLine().split(" ");
			int num = 0;
			switch (cmd[0]) {
			case "add":
				num = Integer.parseInt(cmd[1]);
				set = set | (1 << (num - 1));
				break;
			case "remove":
				num = Integer.parseInt(cmd[1]);

				set = set & ~(1 << (num - 1));

				break;

			case "check":
				num = Integer.parseInt(cmd[1]);
				if ((set & (1 << (num - 1))) == 0) {
					sb.append(0).append("\n");

				} else {
					sb.append(1).append("\n");
				}
				break;
			case "toggle":
				num = Integer.parseInt(cmd[1]);
				set = set ^ (1 << (num - 1));

				break;
			case "all":
				set = (1 << 21) - 1;

				break;
			case "empty":
				set = 0;

				break;

			default:
				break;
			}

		}
		System.out.println(sb);

		br.close();
	}

}
