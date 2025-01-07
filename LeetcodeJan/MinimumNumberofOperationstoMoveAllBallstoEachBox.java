package LeetcodeJan;

public class MinimumNumberofOperationstoMoveAllBallstoEachBox {
    public static void main(String[] args) {
        String boxes = "110";
        System.out.println(minOperations(boxes));
    }

    public static int[] minOperations(String boxes) {
        int res[] = new int[boxes.length()];
        int forward[] = new int[res.length];
        int backward[] = new int[res.length];
        int factor = boxes.charAt(0) == '1' ? 1 : 0;
        for(int i=1;i<boxes.length();i++){
            forward[i] = forward[i-1] + factor;
            if(boxes.charAt(i) == '1'){
                factor+=1;
            }
        }
        factor = boxes.charAt(boxes.length()-1) == '1' ? 1 : 0;
        for(int i=boxes.length()-2;i>=0;i--){
            backward[i] = backward[i+1] + factor;
            if(boxes.charAt(i) == '1'){
                factor+=1;
            }
        }
        for(int i=0;i<boxes.length();i++) res[i] = forward[i] + backward[i];
        return res;
    }
}