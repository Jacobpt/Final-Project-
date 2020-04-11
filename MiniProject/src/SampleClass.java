

public class SampleClass {
    int SCint;
    String SCstring;

    SampleClass(String scstring, int scint)
    {
        this.SCint = scint;
        this.SCstring = scstring;
    }
    SampleClass()
    {
        this.SCint = 0;
        this.SCstring = "";
    }

    public int getSCint() {
        return SCint;
    }

    public void setSCint(int SCint) {
        this.SCint = SCint;
    }

    public String getSCstring() {
        return SCstring;
    }

    public void setSCstring(String SCstring) {
        this.SCstring = SCstring;
    }

    public void AddOne()
    {
        SCint++;
    }
    public void Addnumber(int n)
    {
        SCint+= n;
    }
    public void SetString(String s)
    {
        SCstring = s;
    }
    public void SetInt(int i)
    {
        SCint = i;
    }

    public void SetStringToInt()
    {
        SCstring = Integer.toString(SCint);
    }
}
