public class reductionofFraction {
    public static int gcd(int m,int n)//辗转相除法求最大公约数
    {   if(n == 0){
        return m;
    }
        int r = m%n;
        return gcd(n,r);
    }
    public static String main(int a, int b) {// 分数约分，用于计算结果
        int i = gcd(a,b);
        int x = a / i;// 分子
        int y = b / i;// 分母
        if (x == 0) {
            return "0";
        }
        //if(y==0) return "y=0";曾用于测试哪里使程序报错
        if(y==1) return x+"";
        else  return change.main(x,y);

    }
}
