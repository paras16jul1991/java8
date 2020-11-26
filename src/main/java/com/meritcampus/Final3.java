package com.meritcampus;
public class Final3
{
    final int assign;
    
    Final3(int assign){
    	this.assign = assign;
    }

    public static void main(String[] args)
    {
        final int result = 20;

        Final3 f = new Final3(result);
    //    f.assign = process(result);
        System.out.println(f.assign);
    }
    
    final static int process(int a)
    {
        return a + 5;
    }
}