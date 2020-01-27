class Solution(object):
    def fractionAddition(self, expression):
        operators = []
        for num in range(1,len(expression)):
            if expression[num] == '+' or expression[num] == '-':
                operators.append(expression[num])
        #get each character      
        members = []
        for cr in expression:
            members.append(cr)
        #handle when negativ comes first 
        if expression[0] == '-':
            del members[0]
            members[0] = '-' + members[0]        
            
        numerators = [] # stores list of numerators
        denominators = [] # stores list of denominators
        
        for num in range(len(members)):
            if members[num] == '/':
                #check for double digit number
                if num-2 >= 0:
                    if members[num-2] != '+' and members[num-2] != '-' and members[num-2] != '/' :
                        numerators.append(members[num-2] + members[num-1])
                    else:
                        numerators.append(members[num-1])
                else:
                    numerators.append(members[num-1])
                if num+2 < len(members):
                    if members[num+2] != '+' and members[num+2] != '-' and members[num+2] != '/' :
                        denominators.append(members[num+1] + members[num+2])
                    else:
                        denominators.append(members[num+1])
                else:
                    denominators.append(members[num+1])
        #Inititalize our result with the first element as a start
        res = [numerators[0],denominators[0]]
        counter = 0
        for num in range(1,len(numerators)):
            res = self.addFractions(int(res[0]),int(numerators[num]),int(res[1]),int(denominators[num]),operators[counter])
            #print(res)
            
            counter+=1
         
        return str(res[0])+"/"+str(res[1])     
            
    #add two fractions
    def addFractions(self,num1,num2,denom1,denom2,operator):
        res = []
        
        
        final_denom = self.findLCM(int(denom1),int(denom2))
        
        if operator == '+':
            res.append(((final_denom/int(denom1)) * int(num1)) + ((final_denom/int(denom2)) * int(num2)))
        elif operator == '-':
            res.append(((final_denom/int(denom1)) * int(num1)) - ((final_denom/int(denom2)) * int(num2)))
        
        res.append(final_denom)
        res = self.reduceFraction(res[0],res[1])
        
        
        return res
        
    #LCM funtion
    def findLCM(self,a,b):
        return (a*b)/self.findGCD(a,b)
    
    #GCD function
    def findGCD(self,a,b):
        if b == 0:
            return a
        return self.findGCD(b,a%b)
    
    #reduce fraction
    def reduceFraction(self,a,b):
        gcd = self.findGCD(a,b)
        a = a/gcd
        b = b/gcd
        return a,b