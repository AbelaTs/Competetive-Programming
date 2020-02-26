#https://leetcode.com/problems/powx-n/
class Solution(object):
    def myPow(self, x, n):
        
        if n >=0:
            if n == 0:
                return 1
            elif n % 2 == 0:
                y = self.myPow(x, n/2)
                return y**2
            else:
                return x * self.myPow(x, n-1)
        else:
            if n == 0:
                return 1
            elif n % 2 == 0:
                y = self.myPow(x, n/2)
                return y**2
            else:
                return (1/x) * self.myPow(x, n+1)