class SquareOfSored {
    public int[] sortedSquares(int[] A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        for(int i = 0; i < A.length; i++){
            maxHeap.add((A[i] * A[i]));
        }
        int[] res = new int[A.length];
        Iterator iterator = maxHeap.iterator();
        int counter = 0;
        while(iterator.hasNext()){
            res[counter] = maxHeap.poll();
            counter++;
        }
        return res;
    }
}