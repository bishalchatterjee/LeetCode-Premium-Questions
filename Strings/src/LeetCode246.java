import java.util.HashMap;
import java.util.Map;

public class LeetCode246 {
    //246. Strobogrammatic Number

    static boolean isStrobogrammaticNumber(String n){//strobogrammatic number --> same when rotated 180 degree
        Map<Character, Character> map=new HashMap<>();
        map.put('6','9');
        map.put('9','6');
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');

        int start=0;
        int end=n.length()-1;

        while(start<=end){
            if(!map.containsKey(n.charAt(start)) ||map.get(n.charAt(start)) != n.charAt(end))
                return false;

                start++;
                end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String n="69"; //strobogrammatic number --> same when rotated 180 degree
        System.out.println(isStrobogrammaticNumber(n));
    }
}
