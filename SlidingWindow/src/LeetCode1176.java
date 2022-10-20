public class LeetCode1176 {
    //1176. Diet Plan Performance
    //https://leetcode.ca/2019-02-18-1176-Diet-Plan-Performance/

    static int pointsOfDietPlan(int[] calories,int k,int lower,int upper){
        int points=0;
        int sum=0;
        for (int i = 0; i < k ; i++) {
            sum+=calories[i];
        }
        if(sum>upper)
            points+=1;
        else if(sum<lower)
            points-=1;

        int n= calories.length;

        for (int i = k; i < n; i++) {
            sum+=calories[i];
            sum-= calories[i-k];

            if(sum>upper)
                points+=1;
            else if(sum<lower)
                points-=1;
        }
        return points;
    }

    public static void main(String[] args) {
        int[] calories = {1,2,3,4,5};
        int k = 1, lower = 3, upper = 3;

        System.out.println(pointsOfDietPlan(calories,k,lower,upper));
    }

}
