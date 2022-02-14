package com.wanghu.spring.Test;

/**
 * @author wanghu
 * @date 2021/12/20 22:14
 */
import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str = scanner.next();

        test2 test=new test2();
//        test.utitl(str);
        test.utitl2(str);


    }

    public void utitl(String str){
        String a="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars1 = a.toCharArray();
        char[] chars = str.toCharArray();

        for (int i = 0,b=isalpha(chars[i]); i <chars.length ; i++) {
            for (int j=0;j<chars1.length;j++){
                if (chars1[j]==chars[i] && b==1 ){
                    chars[i]=chars1[j+1];
                    break;
                }
            }
        }
        System.out.println(chars);

    }

    public void utitl2(String str){
        String a="abcdefghijklmnopqrstuvwxyz";
        char[] chars1 = a.toCharArray();
        char[] chars = str.toCharArray();


        for (int i = 0; i < chars.length; i++) {
            for (int j=0;j<chars1.length;j++){
                if (chars[i]==chars1[j]){
                    chars[i]=tolower(chars1[j]);
                    break;
                }
            }
        }

        System.out.println(chars);
    }


    public int isalpha(char c){
        int a=1;
        char[] chars={0,1,2,3,4,5,6,7,8,9,};
        for (int i = 0; i < chars.length; i++) {
            if (c==chars[i]){
                a=0;
            }
        }
        return a;
    }


    public char tolower(char c){
        c=(char) (c^32);
        return c;
    }
}

