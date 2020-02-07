import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
     int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> root_list = new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        getElements(root1,root_list);
        getElements(root2,root_list);
        res.addAll(root_list);
        Collections.sort(res);
        return res;
        
        
    }
    public void getElements(TreeNode root,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left != null){
            getElements(root.left,list);
        }
        if(root.right != null){
            getElements(root.right,list);
        }
        
    }
//     public static void countSort(ArrayList<Integer> list){
        
//         //finding the largest number
//         int largest = list.get(0);
//         for(int i=0; i<list.size(); i++){
//             if(list.get(i) > largest){
//                 largest = list.get(i);
//             }
//         }
        
//         //Setting the counting array
//         ArrayList<Integer> count_sort = new ArrayList<Integer>();
//         for (int x=0; x < largest+1; x++){
//             count_sort.add(0);
//         }
//         //Counting occurance of each member
//         for(int y=0; y<list.size(); y++){
//             count_sort.set(list.get(y),count_sort.get(list.get(y))+1);
//             System.out.println(y + " : " +list.get(y)+" : "+count_sort.get(list.get(y)));
            
//         }
//         list.clear();
//         //resorting the array
//         for(int j=0; j<count_sort.size(); j++){
//             int counter = count_sort.get(j);
//             while(counter > 0){
//                 list.add(j);
//                 counter--;
//                 count_sort.set(j,count_sort.get(j)-1);
//             }
//         }
        
//     }
}