"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution(object):
    curr_row = -1 
    def maxDepth(self, root):
        total_length = 0
        counter = 1
        if root == None:
            return 0
        return self.getDepth(root,1)
    #depth calculator for a node
    def getDepth(self,root,counter):
        if len(root.children) == 0:
            return counter
        maximum = -1
        for nde in root.children:
            depth = self.getDepth(nde,counter+1)
            if depth > maximum:
                maximum = depth
        return maximum
        