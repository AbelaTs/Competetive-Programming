class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> q = new PriorityQueue<double[]>((a,b)->(Double.compare((b[0]+1)/(b[1]+1)-b[0]/b[1], (a[0]+1)/(a[1]+1)-a[0]/a[1])));
        for(int[] c : classes)
            q.offer(new double[]{c[0], c[1]});
        while(extraStudents>0){
            double[] sml = q.poll();
            sml[0]++;
            sml[1]++;
            q.offer(sml);
            extraStudents--;
        }
        double total = 0;
        while(!q.isEmpty()){
            double[] cur = q.poll();
            total+=cur[0]/cur[1];
        }
        return total/classes.length;
    }
}
