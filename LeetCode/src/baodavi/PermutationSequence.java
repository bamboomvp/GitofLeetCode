package baodavi;

import java.util.Arrays;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for(int i = 1; i <= n; i++){
        	arr[i - 1] = i;
        }
        k--;
        while(k != 0){
        	// 1.
        	int boundary = arr.length - 1;
        	while(true){
        		if(boundary == 0)	return null;
        		else if(arr[boundary] > arr[boundary - 1])	break;
        		else	boundary--;
        	}
        	int swapInd = boundary;
        	while(swapInd < arr.length && arr[swapInd] > arr[boundary - 1]){
        		swapInd++;
        	}
        	// 2.
        	swap(arr, boundary - 1, swapInd - 1);
        	// 3.
        	sort(arr, boundary);
        	
        	k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < arr.length; j++){
        	sb.append(Integer.toString(arr[j]));
        }
        return sb.toString();
    }
    
    private void swap(int[] arr, int ind1, int ind2){
    	int tmp = arr[ind1];
    	arr[ind1] = arr[ind2];
    	arr[ind2] = tmp;
    }
    
    private void sort(int[] arr, int boundary){
    	Arrays.sort(arr, boundary, arr.length);
    }
}
