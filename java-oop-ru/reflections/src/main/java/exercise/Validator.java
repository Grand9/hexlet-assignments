package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// BEGIN
class Validator {

    public static List<String> validate(Address address) throws IllegalAccessException {
        List<String> notValidFields = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                if (field.get(address) == null) {
                    notValidFields.add(field.getName());
                }
            }
        }

        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) throws IllegalAccessException {
        Map<String, List<String>> validationErrors = new HashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();

        for (Field field : fields) {
            List<String> errors = new ArrayList<>();
            field.setAccessible(true);

            // Проверка @NotNull
            if (field.isAnnotationPresent(NotNull.class)) {
                if (field.get(address) == null) {
                    errors.add("can not be null");
                }
            }

            // Проверка @MinLength
            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
                int minLength = minLengthAnnotation.minLength();
                String value = (String) field.get(address);
                if (value != null && value.length() < minLength) {
                    errors.add("length less than " + minLength);
                }
            }

            if (!errors.isEmpty()) {
                validationErrors.put(field.getName(), errors);
            }
        }

        return validationErrors;
    }
}
// END
