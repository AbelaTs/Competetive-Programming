/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LongestUniValuePath {
    public int longestUnivaluePath(TreeNode root) {
        int largest_counter = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        addMembers(root, result);
        int first = result.get(0);
        int counter = 0;
        int index = 0;
        for(int i = 1; i < result.size(); i++){
            if(result.get(i) == first){
                    counter++;
                    if(counter>largest_counter){
                        largest_counter = counter;
                    }
                  //If the next element is different from the current
                    if(i < result.size()-1){
                        if(result.get(i) != result.get(i+1)){
                            counter = 0;
                        }
                    }
             }else if(result.get(i) == result.get(i-1)){
                    counter++;
                    if(counter>largest_counter){
                        largest_counter = counter;
                    }
                    //If the next element is different from the current
                     if(i < result.size()-1){
                        if(result.get(i) != result.get(i+1)){
                            counter = 0;
                        }
                    }
                
            }else{
                counter = 0;
            }
        }
       
        
        return largest_counter;
    }
    public static TreeNode addMembers(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return root;
        }
        list.add(root.val);
        
        TreeNode left = addMembers(root.left,list);
        TreeNode right = addMembers(root.right,list);
       
        return left;
    }
}