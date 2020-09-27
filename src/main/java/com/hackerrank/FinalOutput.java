package com.hackerrank;
public class FinalOutput
{
    int printA = 20;

    public static void main(String[] args)
    {
        PrintB c = new PrintB();

        System.out.println("printA = " + c.printA);
        System.out.println("printB = " + c.printB);
    }
}

/* final */ class PrintA
{
    int printA = 5;
}

final class PrintB extends PrintA
{
    int printA = 10;
    int printB = 5;
}