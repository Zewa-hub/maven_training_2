package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClassDescription {
    private final Class<?> clas;
    public TestClassDescription(Class<?> O)
    {
        clas=O;
    }
    public List<Method> listTestMethods()
    {
        /*
        return Arrays.stream(clas.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .filter(m -> m.getReturnType().equals(void.class))
            .filter(m -> m.getParameterCount() == 0)
            .filter(m -> m.isAnnotationPresent(TestMethod.class))
            .toList();

         */
        List<Method>result = new ArrayList<Method>();
        Method all_methods[]=clas.getDeclaredMethods();
        for (int i =0;i<all_methods.length;i++)
        {
            if ((Modifier.isPublic(all_methods[i].getModifiers())) && (all_methods[i].isAnnotationPresent(TestMethod.class)) && (all_methods[i].getParameterCount() == 0) && (all_methods[i].getReturnType().equals(Void.TYPE)))
            {
                result.add(all_methods[i]);
            }
        }
        return result;
    }
}
