package listeners.annotation_transformer;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Listener Class {@link AnnotationTransformerServer}.
 * <p>
 * Listener Class AnnotationTransformerServer is for logging annotations were used in each test methods. Destination resource: console.
 * <i>This Class is a member of the {@link listeners.annotation_transformer}
 * package.</i>
 */
public class AnnotationTransformerServer implements IAnnotationTransformer {
    private static final String LIST_OF_ANNOTATIONS = "List of annotations for";
    private static final String TAB = "\t-";

    /**
     * Listener method transform.
     * <p>
     * Method logs info in console about annotations were used in each test methods.
     *
     * @param iTestAnnotation object of {@link ITestAnnotation} type
     * @param aClass          object of {@link Class} type
     * @param constructor     object of {@link Constructor} type
     * @param method          object of {@link Method} type
     */
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        Annotation[] annotation = method.getAnnotations();
        System.out.printf("%s %s:\n\r", LIST_OF_ANNOTATIONS, method.getName());
        for (Annotation anno : annotation) {
            System.out.printf("%s %s\n\r", TAB, anno.annotationType().getSimpleName());
        }
    }
}

