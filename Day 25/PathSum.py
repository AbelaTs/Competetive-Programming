# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        node_sum = 0
        if root == None:
            return False
        return self.findSum(root,sum,node_sum)
        
    def findSum(self,root,given_sum,n_sum):
        n_sum += root.val
        final_res = False
        
        if root.left == None and root.right == None:
            if n_sum == given_sum:
                print(n_sum)
                return True
            return False
        
        if root.left != None:
            l_res = self.findSum(root.left,given_sum,n_sum)
            if l_res:
                final_res = l_res
        if root.right != None:
            r_res = self.findSum(root.right,given_sum,n_sum)
            if r_res:
                final_res = r_res
        
        return final_res