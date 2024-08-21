class Solution {
    int dp[][];
    public int strangePrinter(String s) {
        char arr[] = s.toCharArray();
        int n = s.length();
        dp = new int[n][n];
        return f(0,s.length()-1, arr);
    }
    int f(int i, int j, char []arr){
        if(i>j) return 0; 
        if(i==j) return 1;
        if(dp[i][j]!=0) return dp[i][j];
        int val = 1 + f(i+1,j,arr);
        for(int x=i+1; x<=j; x++){
            if(arr[x]==arr[i]){
                int v = f(i,x-1,arr)+f(x+1,j,arr);
                val = Math.min(val,v);
            }
        }
        return dp[i][j] = val;
    }

}
