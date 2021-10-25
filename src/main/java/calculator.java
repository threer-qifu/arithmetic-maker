public class calculator {
    public static int[] main(int a, int b,int c,int d,int x) {
        int numerator=0,denominator = 0;
        int answer[]=new int[6];
        if(b!=0&&d!=0) {//判定分母是否有0
        }
        else{//若有零则将分母置1
            b=1;d=1;
        }
        switch (x) {
            case 0: {//加
                numerator = a * d + b * c;
                denominator = b * d;
                break;
            }
            case 1: {//减
                if ((a * d - b * c) < 0) {//若出现负数则减数与被减数互换
                   int xx=a;
                   a=c;
                   c=xx;
                   xx=b;
                   b=d;
                   d=xx;
                }
                numerator = a * d - b * c;
                denominator = b * d;
                break;
            }
            case 2: {//乘
                numerator = a * c;
                denominator = b * d;
                break;
            }
            case 3: {//除
                numerator = a * d;
                denominator = b * c;//c有概率为0，导致报错
                break;
            }

        }
        answer[0]=a;
        answer[1]=b;
        answer[2]=c;
        answer[3]=d;
        answer[4]=numerator;
        if (denominator!=0) {//判定答案的除数是不是0，若是，则返回-1，此次报废
            answer[5] = denominator;
        }
        else{
            answer[5] = -1;
        }
        return answer;
    }
}
