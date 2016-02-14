package baodavi;

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if(A == null)
            return -1;

        int oldLen = A.length;
        for (int i = 0; i < oldLen; i++) {
            if(A[i] == elem){
                A[i--] = A[oldLen - 1];
                oldLen--;
            }
        }
        
        return oldLen;
    }
}
