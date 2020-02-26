#https://leetcode.com/problems/count-primes/
class Solution(object):
    def countPrimes(self, n):
        boundary = int(Math.floor(Math.sqrt(n)))
        counter = 0
        isPrime = []
        for num in range(n):
            isPrime.append(True)
        isPrime[0] = False
        isPrime[1] = False
        for num in range(2,boundary):
            for i in range(len(isPrime)):
                isprime[num*i] = False
        for count in isPrime:
            if(count):
                counter += 1
        return counter