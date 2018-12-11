package at.technikum.wien.mse.swe;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    int start();
    int length();
    String padding();
}
