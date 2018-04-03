package io.openbdt.support;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.stereotype.Component;

/**
 * OpenBDT traditional test support 
 * @author splait
 *
 */
@Component
public class Utilities {

	private static Logger LOG = Logger.getLogger(Utilities.class);

	public <C, A extends Annotation> Set<A> getAnnotationsFromAllMethods(Class<C> clazz, Class<A> annotation) {
		LOG.debug(String.format("looking for @%s above method declarations in %s", annotation.getSimpleName(),
				clazz.getSimpleName()));
		Set<A> annotations = new LinkedHashSet<>();
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.isAnnotationPresent(annotation)) {
				LOG.debug(String.format("@%s found upon %s.%s()", annotation.getName(), clazz.getName(), method.getName()));
				annotations.add(method.getAnnotation(annotation));
			}
		}
		LOG.debug(String.format("annotations found: [%s]", annotation));
		return annotations;
	}

	public Set<Class<?>> getClassesFromPackage(String packageName) {
		LOG.debug(String.format("looking for all classes contained inside the package %s", packageName));
		List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
		classLoadersList.add(ClasspathHelper.contextClassLoader());
		classLoadersList.add(ClasspathHelper.staticClassLoader());
		Reflections reflections = new Reflections(new ConfigurationBuilder()
				.setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
				.setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
				.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(packageName))));
				//.filterInputsBy(new FilterBuilder().include(packageName)));
		Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
		LOG.debug(String.format("classes found: [%s]", classes));
		return classes;
	}

	public Class<?> loadClass(String classLocation) throws ClassNotFoundException {
		return Utilities.class.getClassLoader().loadClass(classLocation);
	}
}
