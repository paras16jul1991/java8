package com.hackerrank;
class TestArithmeticUtils
{
    public static void main(String s[])
    {
        ArithmeticUtils utils = new ArithmeticUtils();
        int x = utils.add(2, 8);    // LINE M
        double y = utils.add(3.4, 6.6);    // LINE N
        int z = utils.add(x, y, 20); // LINE O

        System.out.println("z = " + z);
    }
}

class ArithmeticUtils
{
    int add(int i, int j) // LINE A
    {
        return i + j;
    }

    double add(double i, double j) // LINE B
    {
        return i + j;
    }

    double add(int i, double j, int k)
    {
        return i + j + k;
    }

    double add(int i, double j, int k, double l) // LINE C
    {
        return i + j + k + l;
    }
}