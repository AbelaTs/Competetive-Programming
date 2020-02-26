//https://leetcode.com/problems/kth-largest-element-in-a-stream/
import java.util.ArrayList;

class KthLargest {
    ArrayList<Integer> heap;
    int kth_largest;
    public KthLargest(int k, int[] nums) {
        heap = new ArrayList<Integer>();
        kth_largest = k;
        for(int i = 0; i < nums.length; i++){
                if(i < kth_largest){
                    insert(nums[i]);
                }else{
                    if(nums[i] > heap.get(0)){
                        heap.set(0,heap.get(heap.size()-1));
                        heap.remove(heap.size()-1);
                        heapifyDown();
                        insert(nums[i]);
                    }
                }
        }
        
    }
    
    public int add(int val) {
        if(heap.size() == kth_largest){
            if(val > heap.get(0)){
                heap.set(0,heap.get(heap.size()-1));
                heap.remove(heap.size()-1);
                heapifyDown();
                insert(val);
            }
        }else{
            insert(val);
        }
        
        return getMin();
        
    }
    public void insert(int num){
        heap.add(num);
        heapifyUp();
    }
    public int getMin(){
        int min = heap.get(0);
        return min;
    }

    public void heapifyUp(){
        int last_index = heap.size()-1;
        while(last_index > 0){
            int parent = (last_index - 1)/2;
            if(parent >= 0){
                if(heap.get(last_index) < heap.get(parent)){
                    swap(parent, last_index);
                    last_index = parent;
                }else{
                    break;
                }
            }
        }
    }
    public void heapifyDown(){
        int curr_index = 0;
        while(curr_index < heap.size()){
            int left_child = 2*curr_index + 1;
            int right_child = 2*curr_index + 2;
            if(left_child < heap.size() && right_child < heap.size()){
                if(heap.get(left_child) <= heap.get(right_child)){
                    if(heap.get(curr_index) > heap.get(left_child)){
                        swap(curr_index, left_child);
                        curr_index = left_child;
                    }else{
                        break;
                    }
                }else{
                    if(heap.get(curr_index) > heap.get(right_child)){
                        swap(curr_index, right_child);
                        curr_index = right_child;
                    }else{
                        break;
                    }
                }
            }else if(left_child < heap.size()){
                if(heap.get(curr_index) > heap.get(left_child)){
                    swap(curr_index, left_child);
                    curr_index = left_child;
                }else{
                    break;
                }
            }else if(right_child < heap.size()){
                if(heap.get(curr_index) < heap.get(right_child)){
                    swap(curr_index, right_child);
                    curr_index = right_child;
                }else{
                    break;
                }
            }else{
                break;
            }

        }

    }
    public void swap(int index1,int index2){
        int temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2,temp);

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */