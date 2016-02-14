package baodavi;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int low, high;
        int currIndex = 0;
        boolean lastChnFlag = false;
        low = 0;
        high = A.length - 1;
        while( low <= high ){
            currIndex = (low + high) / 2;
            if(A[currIndex] == target){
                return currIndex;
            }else if(A[currIndex] < target){
                low = currIndex + 1;
                lastChnFlag = true;
            }else{
                high = currIndex - 1;
                lastChnFlag = false;
            }
        }
        if(lastChnFlag)
            return currIndex + 1;
        else
            return currIndex;
    }
}
