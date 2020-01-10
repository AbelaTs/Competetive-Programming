class Solution(object):
    def trailingZeroes(self, n):
        zero_num = 0;
        counter = 1;
        if n >= 5:
            while(n >= 5**counter):
                zero_num += n/(5**counter)
                counter+=1
            return zero_num
        return zero_num