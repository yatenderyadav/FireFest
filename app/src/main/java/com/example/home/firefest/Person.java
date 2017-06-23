package com.example.home.firefest;

/**
 * Created by shashank on 20-03-2017.
 */

public class Person {

    private String ques;
    private String ques2;
    private String ques3;
    private String var1;
    private String var2;
    private int Ans1;
    private int Ans2;


    public Person() {
    }
    //Getters and setters
    public String getques() {
        return ques;
    }

    public void setques(String ques) {
        this.ques = ques;
    }

    public String getques2() {
        return ques2;
    }

    public void setques2(String ques2) {
        this.ques2 = ques2;
    }

    public String getques3() {return ques3;}
    public void setques3(String ques3) {
        this.ques3 = ques3;
    }

    public String getvar1() {return var1;}
    public void setvar1(String var1) {
        this.var1 = var1;
    }

    public String getvar2() {return var2;}
    public void setvar2(String var2) {
        this.var2 = var2;
    }

    public int getAns1(){ return Ans1;}
    public void setAns1(int Ans1){this.Ans1=Ans1+1;}

    public int getAns2(){ return Ans2;}
    public void setAns2(int Ans2){this.Ans2=Ans2+1;}

}