class Solution(object):
    def checkPerfectNumber(self, num):
        divisors = []
        if num > 1:
            #Going just half way through
            for number in range(1,int(math.floor(math.sqrt(num))) +1 ):
                if num%number == 0:
                    divisors.append(number)
            sum = 0
            div_list = divisors[:]
            for divisor in divisors:
                div_list.append(num/divisor)
            print(div_list)
            for divisor in div_list:
                if not divisor == num:
                    sum += divisor
            if sum == num:
                return True
            return False
        return False
        