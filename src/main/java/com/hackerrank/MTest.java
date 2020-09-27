package com.hackerrank;
class MTest
{
    public static void main(String[] args)
    {
        M m = new M();
        N n = new N();
        m = n;          // LINE A
        O o = new O();
        m = o;          // LINE B
        O o2 = (O) m;   // LINE C
        N n2 = (N) m;   // LINE D
    }
}

class M { }
class N extends M { }
class O extends M { }