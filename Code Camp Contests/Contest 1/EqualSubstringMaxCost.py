class Solution(object):
    def equalSubstring(self, s, t, maxCost):
        costs = []
        maximum_len = 0
        for index in range(len(s)):
            costs.append(abs(ord(s[index]) - ord(t[index])))
        summation = 0
        sum_list = [0]
        for cost in costs:
            summation += cost
            sum_list.append(summation)
        main_pointer = 0
        counter = 0;
        while counter < len(sum_list):
            if sum_list[counter] - sum_list[main_pointer] <= maxCost:
                if counter-main_pointer > maximum_len:
                    maximum_len = counter-main_pointer
                counter += 1
            else:
                main_pointer+=1
        return maximum_len
                
            
        
        