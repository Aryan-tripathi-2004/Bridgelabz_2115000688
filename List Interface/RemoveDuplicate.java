import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicate{
    private static <T> void removeDuplicate(List<T>list){
        HashSet<T> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            if(set.contains(list.get(i))){
                list.remove(i);
                i--;
            }else{
                set.add(list.get(i));
            }
        }
    }
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 2, 3, 4));
        removeDuplicate(list);
        System.out.println(list);
        
    }
}