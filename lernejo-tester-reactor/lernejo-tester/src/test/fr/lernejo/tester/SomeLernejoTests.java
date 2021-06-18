package test.fr.lernejo.tester;

import main.fr.lernejo.tester.api.TestMethod;
import java.lang.IllegalStateException;

public class SomeLernejoTests {
    @TestMethod
    public void ok()
    {
    }
    @TestMethod
    public void ko()
    {
        throw new java.lang.IllegalStateException();
    }
    public void none()
    {
    }
}
