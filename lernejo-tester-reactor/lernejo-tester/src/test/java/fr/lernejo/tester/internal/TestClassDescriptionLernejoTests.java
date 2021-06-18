package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestClassDescriptionLernejoTests {
    @TestMethod
    public void listing_test_returns_only_annotated_ones()
    {
        TestClassDescription description = new TestClassDescription(SomeLernejoTests.class);
        List<Method> methods = description.listTestMethods();
        Set<String> methodsNames = methods.stream().map(m -> m.getName()).collect(Collectors.toSet());

        if (!methodsNames.equals(Set.of("ok","ko")))
        {
            throw new IllegalStateException("You should have listed ko and ok methods");
        }

    }
    public static void main(String[]args)
    {
        new TestClassDescriptionLernejoTests().listing_test_returns_only_annotated_ones();
    }

}
