package org.jsonschema2pojo;

import com.wltt.jsonschemapojo.jsonschemapojo.annotator.JAXBAnnotator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Factory object for creating {@link Annotator}s for all the supported
 * annotation styles.
 */
public class AnnotatorFactory {
    private final GenerationConfig generationConfig;

    public AnnotatorFactory(GenerationConfig generationConfig) {
        this.generationConfig = generationConfig;
    }

    public Annotator getAnnotator(AnnotationStyle style) {
        switch(style) {
            case JACKSON:
            case JACKSON2:
                return new Jackson2Annotator(this.generationConfig);
            case JACKSON1:
                return new Jackson1Annotator(this.generationConfig);
            case GSON:
                return new GsonAnnotator(this.generationConfig);
            case MOSHI1:
                return new Moshi1Annotator(this.generationConfig);
            case NONE:
                return new NoopAnnotator();
            case JAXB:
                return new JAXBAnnotator(this.generationConfig);
            default:
                throw new IllegalArgumentException("Unrecognised annotation style: " + style);
        }
    }

    public Annotator getAnnotator(Class<? extends Annotator> clazz) {
        if (!Annotator.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("The class name given as a custom annotator (" + clazz.getName() + ") does not refer to a class that implements " + Annotator.class.getName());
        } else {
            try {
                try {
                    Constructor<? extends Annotator> constructor = clazz.getConstructor(GenerationConfig.class);
                    return (Annotator)constructor.newInstance(this.generationConfig);
                } catch (NoSuchMethodException var3) {
                    return (Annotator)clazz.newInstance();
                }
            } catch (InstantiationException | InvocationTargetException var4) {
                throw new IllegalArgumentException("Failed to create a custom annotator from the given class. An exception was thrown on trying to create a new instance.", var4.getCause());
            } catch (IllegalAccessException var5) {
                throw new IllegalArgumentException("Failed to create a custom annotator from the given class. It appears that we do not have access to this class - is both the class and its no-arg constructor marked public?", var5);
            }
        }
    }

    public CompositeAnnotator getAnnotator(Annotator... annotators) {
        return new CompositeAnnotator(annotators);
    }
}
