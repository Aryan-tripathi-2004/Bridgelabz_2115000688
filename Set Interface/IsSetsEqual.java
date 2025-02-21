import java.util.*;

public class IsSetsEqual{
    private static boolean isEqual(Set<Integer> s1,Set<Integer>s2){
        for(int num : s1){
            if(!s2.contains(num)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<>(List.of(1,2,4,8,6,3));
        HashSet<Integer> s2 = new HashSet<>(List.of(1,2,4,5,6,3));

        if(isEqual(s1,s2)) System.out.println("Sets are Equal");   
        else System.out.println("Sets are different");  
    }
}