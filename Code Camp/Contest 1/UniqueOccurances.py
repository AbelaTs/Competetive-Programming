#https://leetcode.com/problems/unique-number-of-occurrences/
class Solution(object):
    def uniqueOccurrences(self, arr):
        occ = []
        uniques = []
        for m in arr:
            if not m in uniques:
                uniques.append(m)
        
        for uni in uniques:
            occ.append(arr.count(uni))
            
        for index in range(len(occ)):
            if occ.count(occ[index]) > 1:
                return False
        return True