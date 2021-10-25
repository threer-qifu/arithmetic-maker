import java.io.*;
import java.util.*;

public class homework {
    private static Random random = new Random();
    public static int range;
    public static void main(String[] args) {
        // 依次转化为字符串,设置题目
        System.out.println("请输入“ -r 数字”或“-r 数字 -n 数字”");
        if(args[0]!="-r") {
            System.out.println("请输入“ -r 数字”或“-r 数字 -n 数字”");
        }
        else {
            range = Integer.parseInt (args[1]);
        }
        int num;
        if((args.length==4)&&(args[2]=="-n")) {
            num = Integer.parseInt (args[3]);
        }
        else {
            num = 10000;
        }
        //int num=10,range=10;

        for(int j=0;j<num;j++) {
            int a[] = new int[6];
            for (int i = 0; i < 6; i++) {
                a[i] = random.nextInt(range);
            }//创建随机数
            int b[] = new int[2];//创建随机运算符
            b[0] = random.nextInt(4);
            b[1] = random.nextInt(5);//可能不存在第二个运算符
            b[1] = 4;//技术有限先不考虑第二个运算符

            int c[] = new int[6];//计算
            if (b[1] == 4) {
                c = calculator.main(a[1], a[2], a[3], a[4], b[0]);
            }

            if(c[5]!=-1) {//若答案的除数非0才会进入
                String exercises[] = new String[1];//构建题目
                exercises[0] = reductionofFraction.main(c[0], c[1]);
                switch (b[0]) {
                    case 0: {
                        exercises[0] += " + ";
                        break;
                    }
                    case 1: {
                        exercises[0] += " - ";
                        break;
                    }
                    case 2: {
                        exercises[0] += " × ";
                        break;
                    }
                    case 3: {
                        exercises[0] += " ÷ ";
                        break;
                    }
                }
                exercises[0] += reductionofFraction.main(c[2], c[3]);
                exercises[0] += " =";

                String answer[] = new String[1];//计算答案
                answer[0] = reductionofFraction.main(c[4], c[5]);


                FileWriter fExercises = null;
                try {
                    File f = new File("Exercises.txt");//题目写入
                    fExercises = new FileWriter(f, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (exercises[0] != null) {
                    PrintWriter pExercises = new PrintWriter(fExercises);
                    pExercises.println(j + 1 + "." + exercises[0]);
                    pExercises.flush();
                    try {
                        fExercises.flush();
                        pExercises.close();
                        fExercises.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                FileWriter fAnswer = null;
                try {
                    File f = new File("Answer.txt");//答案写入
                    fAnswer = new FileWriter(f, true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (exercises != null) {
                    PrintWriter pAnswer = new PrintWriter(fAnswer);
                    pAnswer.println(j + 1 + "." + answer[0]);
                    pAnswer.flush();
                    try {
                        fAnswer.flush();
                        pAnswer.close();
                        fAnswer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else j--;//否则此次随机过程作废
        }
        // 退出程序
        System.exit(0);
    }
}