
// Definition for a binary tree node.
  public class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class MinimumDistanceBST {
    static int min;
    public static int minDiffInBST(TreeNode root) {
       if(root != null){
           ArrayList<Integer> values = new ArrayList<Integer>();
            findMin(root,values);
            int min = values.get(0);
            //Check the distance between each node
            for(int i =0; i < values.size(); i++){
                for(int j = 0; j < values.size(); j++){
                    if(values.get(i) != values.get(j)){
                        if(Math.abs(values.get(i) - values.get(j)) < min){
                            min = Math.abs(values.get(i) - values.get(j));
                        }
                    }
                }
            }


            return min;
       }else{
           return 0;
       }
        
    }
    //Recurseive function to get the difference between each different node
    public static TreeNode findMin(TreeNode root,ArrayList<Integer> list){
        if(root != null){
            list.add(root.val);
            TreeNode left = findMin(root.left,list);
            TreeNode right = findMin(root.right,list);
            return left;
        }else{
            return root;
        }
    
    }
}