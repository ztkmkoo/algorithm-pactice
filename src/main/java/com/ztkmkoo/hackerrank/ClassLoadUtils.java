package com.ztkmkoo.hackerrank;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

public class ClassLoadUtils {

    private ClassLoadUtils() {}

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static Class[] getClasses(final String packageName)
            throws ClassNotFoundException, IOException {
        final List<Class> classes = getClassList(packageName);
        return classes.toArray(new Class[classes.size()]);
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes as list
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static List<Class> getClassList(final String packageName) throws IOException, ClassNotFoundException {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        final String path = packageName.replace('.', '/');
        final Enumeration<URL> resources = classLoader.getResources(path);
        final List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        final ArrayList<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }

        return classes;
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     * And satisfy the class(only class, abstract will be filtered) is inherited from the given class type.
     * @param packageName The base package
     * @param implementsClassType Filter the classes who is inherited
     * @param <T> The implementsClassType class
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> List<Class> getClassListImplements(final String packageName, final Class<T> implementsClassType) throws IOException, ClassNotFoundException {
        final List<Class> classes = getClassList(packageName);
        return classes
                .stream()
                .filter(c -> implementsClassType.isAssignableFrom(c))
                .filter(c -> !c.isInterface())
                .filter(c -> !Modifier.isAbstract(c.getModifiers()))
                .collect(Collectors.toList());
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
