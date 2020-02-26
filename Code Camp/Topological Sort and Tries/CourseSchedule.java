//https://leetcode.com/problems/course-schedule/
import java.util.ArrayList;
import java.util.HashMap;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        HashMap<Integer,ArrayList<Integer>> mapper = new HashMap<Integer,ArrayList<Integer>>();
        ArrayList<Integer> heads = new ArrayList<Integer>();
        int[] course_tracker = new int[numCourses];
        //building ajecency list
        for(int i = 0; i < prerequisites.length; i++){
           
            course_tracker[prerequisites[i][0]]++;
            if(!mapper.containsKey(prerequisites[i][1])){
                mapper.put(prerequisites[i][1],new ArrayList<Integer>());
                mapper.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }else{
                mapper.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
        }
        //getting courses which has no prerequisites
        for(int i = 0; i < course_tracker.length; i++){
            if(course_tracker[i] == 0){
                heads.add(i);
            }
        }
        MyQueue que = new MyQueue();
        //push courses that has no incoming ages
        for(int i = 0; i < heads.size(); i++){
            que.push(heads.get(i));
        }
        ArrayList<Integer> courses_taken = new ArrayList<Integer>();
        while(!que.empty()){
            int course = que.pop();
            courses_taken.add(course);
            if(mapper.get(course) != null){
                for(int i : mapper.get(course)){
                    course_tracker[i]--;
                    if(course_tracker[i] == 0){
                        que.push(i);
                    }
                }
            }
            
        }
         
        return courses_taken.size() == numCourses;
        
        
    
        
    }
}
class MyQueue {

    ArrayList<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new ArrayList<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.add(x);   
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int num = stack.get(0);
        stack.remove(0);
        return num;
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.get(0);
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack.size() != 0){
            return false;
        }
        return true;
    }
}