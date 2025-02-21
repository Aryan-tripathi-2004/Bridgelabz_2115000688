import java.util.HashMap;

public class FindFreqOfElements {
    public static void main(String[] args) {
        String arr[] = {"apple", "banana", "apple", "orange"};
        HashMap<String,Integer> map = new HashMap<>();

        for(String s : arr){
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }

        System.out.println(map);
    }
}
