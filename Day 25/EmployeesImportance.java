import java.util.ArrayList;
import java.util.List;

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

class EmployeesImportance {
    public int getImportance(List<Employee> employees, int id) {
       int total_imp = 0;
       Employee main_emp = employees.get(0);
       if(main_emp != null){
           for(Employee employee : employees){
               if(employee.id == id){
                   main_emp = employee;
               }
           }
            //Initialize the stack of dfs algorithm
           CStack stack = new CStack();
           ArrayList<Integer> seen = new ArrayList<Integer>();
            //Push the main employee
           stack.push(id);


           while(!stack.isEmpty()){
               int curr = stack.pop();
               Employee curr_emp = employees.get(0);
               //find the employee
               for(Employee employee : employees){
                   if(employee.id == curr){
                       curr_emp = employee;
                   }
                }
               //check if the employee has been seen before
               if(!seen.contains(curr)){
                   seen.add(curr);
                   total_imp += curr_emp.importance;
               }

               for(int i = 0; i < curr_emp.subordinates.size(); i++){
                   stack.push(curr_emp.subordinates.get(i));
               }

           }
       }
       return total_imp;
        
    }
    
    
}

//Custom stack
class CStack{
    ArrayList<Integer> stack;
    public CStack(){
        stack = new ArrayList<Integer>();
    }
    public int pop(){
        int emp = (int) stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return emp;
    }
    public void push(int c){
        stack.add(c);
    }
    public int peek(){
        int emp = (int) stack.get(stack.size() - 1);
        return emp;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    
}