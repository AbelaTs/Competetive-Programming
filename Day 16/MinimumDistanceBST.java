
// Definition for a binary tree node.
  public class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class MinimumDistanceBST {
    static int min;
    public static int minDiffInBST(TreeNode root) {
        if(root != null){
            ArrayList<Integer> values = new ArrayList<Integer>();
             findMin(root,values);// get node values
             
             int[] result = new int[values.size()]; // convert the array list to normal array
             for(int i = 0; i < values.size(); i++){
                 result[i] = (int) values.get(i);
             }
             result = mergeSort(result);// sort the given array with merge sort
             int min = result[1] - result[0];
 
             for(int i=0; i<result.length-1; i++){// Iterate through the sorted list with comparision of their difference
                 if(result[i+1] - result[i] < min){
                     min = result[i+1] - result[i];
                 }
             }
 
 
             return min;
        }else{
            return 0;
        }
         
        
    }

    //Merge Sort
    public static int[] merge(int[] left_list,int[] right_list){
        int merge_list_length = left_list.length + right_list.length;
        int[] merge_list = new int[merge_list_length];
        int left_pointer = 0;
        int right_pointer = 0;
        
        int merged_list_pointer = 0;

        while(merged_list_pointer < merge_list_length){
           if(left_pointer < left_list.length && right_pointer < right_list.length){
                if(left_list[left_pointer] <= right_list[right_pointer]){
                    merge_list[merged_list_pointer] = left_list[left_pointer];
                    left_pointer++;
                }else{
                merge_list[merged_list_pointer] = right_list[right_pointer];
                right_pointer++;
                }
                merged_list_pointer++;


           }else{
               if(left_pointer >= left_list.length){
                   for(int i = right_pointer; i< right_list.length; i++){
                       merge_list[merged_list_pointer] = right_list[right_pointer];
                       right_pointer++;
                       merged_list_pointer++;
                   }
               }else if(right_pointer >= right_list.length){
                    for(int i = left_pointer; i< left_list.length; i++){
                        merge_list[merged_list_pointer] = left_list[left_pointer];
                        left_pointer++;
                        merged_list_pointer++;
                }
               }
           }
           
        }

        return merge_list;
    }

    // sorts a gien list in an increasing order
    public static int[] mergeSort(int[] list){
        int[] left_list = Arrays.copyOfRange(list,0,list.length/2);
        int[] right_list = Arrays.copyOfRange(list,list.length/2,list.length);

        if(list.length == 1){
            return list;
        }else{
            left_list = mergeSort(left_list);
            right_list = mergeSort(right_list);
        }
        return merge(left_list,right_list);


    }

    //Recurseive function to get the value of each different node
    public static TreeNode findMin(TreeNode root,ArrayList<Integer> list){
        if(root != null){
            list.add(root.val);
            TreeNode left = findMin(root.left,list);
            TreeNode right = findMin(root.right,list);
            return left;
        }else{
            return root;
        }
    
    }
}