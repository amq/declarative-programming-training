package at.technikum.wien.mse.swe;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    int start();
    int length();
    String padding();
}
