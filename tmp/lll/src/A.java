

public class A {


    public int getX () {
        return 0;
    }

    public int getXx () {
        getX();
        return 0;
    }

    public int getXxx () {
        return 0;
    }

    public int getXxxx () {
        return 0;
    }

    public int getXxxxx () {
        getXx();
        return 0;
    }

}
