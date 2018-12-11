package at.technikum.wien.mse.swe;

import at.technikum.wien.mse.swe.exception.SecurityAccountOverviewReadException;
import at.technikum.wien.mse.swe.model.RiskCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.apache.commons.lang.StringUtils.stripStart;

public class MyParser {

    public static void myParser(Object object, String content) {
        MyAnnotation annotation;
        String value;

        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                field.setAccessible(true);
                annotation = field.getAnnotation(MyAnnotation.class);
                value = stripStart(extract(content, annotation.start(), annotation.length()).trim(), annotation.padding());

                try {
                    if (field.getType() == BigDecimal.class) {
                        field.set(object, new BigDecimal(value));
                    } else if (field.getType() == String.class) {
                        field.set(object, new String(value));
                    } else if (field.getType() == RiskCategory.class) {
                        field.set(object, RiskCategory.fromCode(value).orElseThrow(IllegalStateException::new));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                field.setAccessible(false);
            }
        }
    }

    public static String readFileContent(Path file) {
        String content;
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            content = reader.readLine();
        } catch (IOException e) {
            throw new SecurityAccountOverviewReadException(e);
        }
        return content;
    }

    private static String extract(String content, int startIndex, int length) {
        return content.substring(startIndex, startIndex + length);
    }
}
