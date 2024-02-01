import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class User {
        int level;
        String id;

        public User(int level, String id) {
            this.level = level;
            this.id = id;
        }
    }

    static class Room {
        int t;
        int level;
        boolean isStarted;
        List<User> users;

        public Room(int t, int level) {
            this.t = t;
            this.level = level;
            this.users = new ArrayList<>();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        List<Room> list = new ArrayList<>();


        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        outer:
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String id = st.nextToken();
            User user = new User(level, id);
            for (Room r : list) {
                if (r.level - 10 <= level && r.level + 10 >= level) {
                    if (!r.isStarted) {
                        r.users.add(user);
                        if (r.users.size() == m) {
                            r.isStarted = true;
                        }
                        continue outer;
                    }
                }
            }
            Room room = new Room(i, level);
            room.users.add(user);
            if (m == 1) {
                room.isStarted = true;
            }
            list.add(room);

        }
        list.forEach(e -> {
            if (e.isStarted) {
                sb.append("Started!").append("\n");
                Collections.sort(e.users, (a, b) -> a.id.compareTo(b.id));
                e.users.forEach(u -> {
                    sb.append(u.level).append(" ").append(u.id).append("\n");
                });
            } else {
                sb.append("Waiting!").append("\n");
                e.users.stream().sorted((a, b) -> a.id.compareTo(b.id)).forEach(u -> {
                    sb.append(u.level).append(" ").append(u.id).append("\n");
                });
            }
        });
        System.out.print(sb);


        br.close();
    }
}

