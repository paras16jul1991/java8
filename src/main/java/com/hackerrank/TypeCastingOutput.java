package com.hackerrank;
class TypeCastingOutput
{
    public static void main(String s[])
    {
        A a = new A();
        a.i = 21;
        B b = new B();
        b.i = 43;
        b.j = 25;

        A a2 = b;

        B b2 = a2; // LINE X

        System.out.println("i = " + b2.i); // LINE Y
    }

}

class A
{
    int i;
}

class B extends A
{
    int j;
}
