import java.util.*;

public class RotateElement {
    public static <T> void reverseList(List<T> list,int left,int right) {
        
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            
            left++;
            right--;
        }
    }

    private static <T> void rotate(List<T> list,int k){
        reverseList(list, 0, list.size()-1);
        reverseList(list,0,k);
        reverseList(list, k+1, list.size()-1);
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(10,20,30,40,50));
        int k = 2;
        rotate(list,k);
        System.out.println(list);
    }
}
