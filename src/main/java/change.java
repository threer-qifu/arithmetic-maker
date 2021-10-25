public class change {
    public static String main(int a, int b) {//判断假分数，并化假分数为带分数
        if(a>=b) {
            int c;
            c=a/b;
            int d;
            d=a%b;
            {
                if(d==0) {
                    return c+"";//若两数可以整除
                }
                return c+"'"+d+"/"+b;//分子大于分母可以转化为带分数
            }
        }return a+"/"+b;//分子小于分母不能转化为带分数
    }
}
