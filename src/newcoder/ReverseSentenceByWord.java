package newcoder;

/**
 * 题目描述
 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符


 接口说明

 /**
 * 反转句子
 *
 * @param sentence 原句子
 * @return 反转后的句子
public String reverse(String sentence);

        输入描述:
        将一个英文语句以单词为单位逆序排放。

        输出描述:
        得到逆序的句子

        示例1
        输入
        I am a boy
        输出
        boy a am I
 */
import java.util.Scanner;
public class ReverseSentenceByWord {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();
        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();
        reversed.append(words[words.length-1]);
        for(int i = words.length-2; i >= 0; i --){
            reversed.append(" " + words[i]);
        }
        System.out.println(reversed.toString());
    }
}
