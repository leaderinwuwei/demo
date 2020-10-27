package com.captain.demo.interview.i1_javabase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Captain Wang
 * @time 2020/8/20
 */
public class Test implements Serializable {
    private Integer a;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    private static final long serialVersionUID = 5920505614954010153L;

    public static void main(String[] args) {
        Test e = new Test();
        e.setA(111);
        try {

            FileOutputStream fileOut =
                    new FileOutputStream("/Users/captainwang/Desktop/workSpace/javaspace/jdk11/demo/src/main/java/com/captain/demo/interview/i1_javabase/Test.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
