# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumEvenGrandparent(self, root):
        res = []
        queue = []
        seen = []
        final_sum = 0
        if root != None:
            queue.append(root)
        while len(queue) != 0:
            node = queue[0]
            queue.remove(queue[0])
            if node.left != None:
                #add it to the queue
                queue.append(node.left)
                if node.val % 2 == 0:
                        #If the node value is even, check for its grand kids
                    if node.left.left != None:
                        final_sum += node.left.left.val
                    if node.left.right != None:
                        final_sum += node.left.right.val
            if node.right != None:
                    #add it to the queue
                queue.append(node.right)
                if node.val % 2 == 0:
                         #If the node value is even, check for its grand kids
                    if node.right.left != None:
                        final_sum += node.right.left.val
                    if node.right.right != None:
                        final_sum += node.right.right.val
    
        return final_sum
            
            
            