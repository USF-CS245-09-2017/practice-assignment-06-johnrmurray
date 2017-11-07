package p06;

public class BinaryHeap {
	
	protected int[] arr;
	protected int size;
	
	public BinaryHeap() {
		arr = new int[10];
		size = 0;
	}
	
	void add(int priority) {
		if (arr.length == size) {
			grow_heap();
		}
		arr[size++] = priority;
		
		int index = size - 1;
		while (index > 0 && arr[index] < arr[parent(index)]) {
			swap(arr, index, parent(index));
			index = parent(index);
		}
	}
	
	int remove() {
		int removed = arr[0];
		arr[0] = arr[--size];
		int index = 0;
		int child = left_child(index);
		if (child >= size) {
			return removed;
		} else if (right_child(index) < size && arr[right_child(index)] < arr[child]) {
			child = right_child(index); 	
		}
		while (child < size && arr[child] < arr[index]) {
			swap(arr, index, child);
			index = child;
			child = left_child(index);
			if (right_child(index) < size && arr[right_child(index)] < arr[child]) {
				child = right_child(index);
			}
		}
		return removed;
	}
	
	int parent(int index) {
		return (index-1)/2;
	}
	
	int left_child(int index) {
		return ((index * 2) + 1); 
	}
	
	int right_child(int index) {
		return ((index * 2) + 2);
	}
	
	void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private void grow_heap() {
		int[] new_arr = new int[arr.length*2];
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		arr = new_arr;
	}

}
