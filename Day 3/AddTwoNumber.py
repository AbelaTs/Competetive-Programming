class Add(object):
    def addTwoNumbers(self, l1, l2):
        result_head = result = ListNode(None)
        hold = 0
        while l1 or l2 : 
            summation = hold
            if l1 != None:
                summation += l1.val
                l1 = l1.next
            if l2 != None:
                summation += l2.val
                l2 = l2.next
            hold = summation // 10
            result.next = ListNode(summation % 10)
            result = result.next

        if hold == 1:
            result.next = ListNode(hold)

        return result_head.next
        