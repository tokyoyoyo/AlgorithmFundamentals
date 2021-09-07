package java.str;

public class LRString {
    public int balancedStringSplit(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        int ans = 0;
        for ( char c : str){
            count = c == 'L' ? --count : ++count;
            if (count == 0){
                ans++;
            }
        }
        return ans;
    }
}
