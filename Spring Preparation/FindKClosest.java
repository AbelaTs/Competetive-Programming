class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> queue = new LinkedList<>();
        if (arr.length <= k) {
            for (int num: arr) queue.add(num);
            return queue;
        }
        
        int idx = 0;
        while (idx < k) queue.offerLast(arr[idx++]);
        while (idx < arr.length) {
            int a = Math.abs(x - queue.peekFirst());
            int b = Math.abs(arr[idx] - x);
            if (a > b) {
                queue.pollFirst();
                queue.offerLast(arr[idx]);
            }
            
            ++idx;
        }
        
        return queue;
    }
}
