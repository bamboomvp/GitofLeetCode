package baodavi;

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int overlapTotal = computeRecArea(A, B, C, D) + computeRecArea(E, F, G, H);
    	
        if(B >= H || D <= F || A >= G || C <= E){
        	return overlapTotal;
        }else{
        	int x1 = (A < E) ? E : A;
        	int y1 = (B < F) ? F : B;
        	int x2 = (C < G) ? C : G;
        	int y2 = (D < H) ? D : H;
        	return overlapTotal - computeRecArea(x1, y1, x2, y2);
        }
    }
    
    private int computeRecArea(int x1, int y1, int x2, int y2){
    	return (x2 - x1) * (y2 - y1);
    }
}
