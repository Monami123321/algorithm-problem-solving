import java.util.*;
class Solution {
    static class Task {
        String name;
        int time, req;
        
        Task(String name, int time, int req) {
            this.name = name;
            this.time = time;
            this.req = req;
            
        }
        
    }
    public String[] solution(String[][] plans) {
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> 
            a.time-b.time
        );
        for(String[] tmp : plans) {
            String name = tmp[0];
            int start = stoi(tmp[1]);
            int req = Integer.parseInt(tmp[2]);
            pq.add(new Task(name,start,req));
        }
        Stack<Task> stack = new Stack<>();
        String[] ans = new String[plans.length];
        int index = 0;
        
        int prev = 0;
        while (!pq.isEmpty()) {
            Task now = pq.poll();
            
            if(stack.isEmpty()) {
                prev = now.time;
                stack.push(now);
            } else {
                while(prev < now.time && !stack.isEmpty()) {
                    Task prevTask = stack.pop();
                    if(prevTask.req <= now.time - prev) {
                        ans[index++] = prevTask.name;
                        prev +=prevTask.req;
                    } else {
                        prevTask.req -= now.time-prev;
                        stack.push(prevTask);
                        prev = now.time;
                    }
                    
                }
                stack.push(now);
                prev = now.time;
            }
        }
        while(!stack.isEmpty()) {
            ans[index++] = stack.pop().name;
        }
        
        return ans;
    }
    static int stoi(String time) {
        return Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3,5));
    }
}