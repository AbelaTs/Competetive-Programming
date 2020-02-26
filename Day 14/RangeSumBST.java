//https://leetcode.com/problems/range-sum-of-bst/
// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
 
class RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
       if(root != null){

            if(root != null){

                if(L <= root.val && root.val <= R){ 
                       sum += root.val;
                 }
                //right search
                sum += rangeSumBST(root.left,L,R);
                //left search
                sum += rangeSumBST(root.right,L,R);
            }



            return sum;
    }
        return sum;
    }
}