import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;
    public MinHeap(){
        heap = new ArrayList<Integer>();
    }
    public void insert(int num){
        heap.add(num);
        heapifyUp();
    }

    public int getMin(int num){
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
                    }
                }else{
                    if(heap.get(curr_index) > heap.get(right_child)){
                        swap(curr_index, right_child);
                        curr_index = right_child;
                    }
                }
            }else if(left_child < heap.size()){
                if(heap.get(curr_index) > heap.get(left_child)){
                    swap(curr_index, left_child);
                    curr_index = left_child;
                }
            }else if(right_child < heap.size()){
                if(heap.get(curr_index) < heap.get(right_child)){
                    swap(curr_index, right_child);
                    curr_index = right_child;
                }
            }

        }

    }
    public void swap(int index1,int index2){
        int temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2,temp);

    }
}