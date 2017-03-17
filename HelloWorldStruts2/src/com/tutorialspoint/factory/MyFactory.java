package com.tutorialspoint.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyFactory {

    public static Object getInstance(final Class<?> clazzInterface) {

        Object result = null;

        if (!clazzInterface.isInterface()) {
            throw new IllegalArgumentException();
        }

        String interfaceName = clazzInterface.getSimpleName();

        String className = clazzInterface.getPackage().getName() + "." + interfaceName.substring(1);

        Class<?> clazzToInstance = null;

        try {
            clazzToInstance = Class.forName(className);
        } catch (ClassNotFoundException e1) {
            throw new IllegalArgumentException("Aucune implémentation trouvé pour cette interface!");
        }

        try {
            Method methodToCall = clazzToInstance.getMethod("getInstance", new Class[0]);

            result = methodToCall.invoke(null, new Object[0]);

        } catch (SecurityException e) {
            e.printStackTrace();
            throw new RuntimeException("Problème de sérité");
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("La classe d'impléntation ne respecte pas le pattern singleton (getInstance)!");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Accés aux invocation interdit!");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Problème d'invocation!");
        }

        return result;

    }

}