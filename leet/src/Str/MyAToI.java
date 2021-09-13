package Str;

public class MyAToI {

    public static void main(String[] args) {
        System.out.println(myatoi("words and 987"));
    }

    public static int myatoi(String s) {
        char[] chs = s.toCharArray();
        int length = chs.length;
        int index = 0;

        while(index < length && chs[index] == ' '){
            index++;
        }

        if (index >= length){
            return 0;
        }

        int sign = 1;
        if(chs[index] == '-' || chs[index] == '+'){
            if(chs[index] == '-'){
                sign = -1;
            }
            index++;
        }

        int tmp = 0;
        int res = 0;
        while(index <length){
            int num = chs[index]-'0';
            if(num < 0 || num > 9){
                break;
            }
            tmp = res;
            res = tmp*10 + num;
            if(res/10 != tmp){
                if(sign == 1){
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.MIN_VALUE;
                }
            }
            index++;
        }
        return res*sign;

    }
}
