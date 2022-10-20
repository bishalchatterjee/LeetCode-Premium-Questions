import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode248 {
        //248. Strobogrammatic Number III

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

        static List<String> countStrobogrammaticNumbers(String low, String high){
            List<String> ans=new ArrayList<>();
            int l=Integer.parseInt(low);
            int h=Integer.parseInt(high);
            for(int i=l;i<=h;i++){
                if(isStrobogrammaticNumber(Integer.toString(i)))
                    ans.add(Integer.toString(i));
            }
            return ans;
        }

        public static void main(String[] args) {

            String low="50";
            String high="100";
            System.out.println(countStrobogrammaticNumbers(low,high));
        }
    }

