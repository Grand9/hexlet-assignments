package exercise.dto;

import org.openapitools.jackson.nullable.JsonNullable;

import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class CarUpdateDTO {
    private JsonNullable<String> model = JsonNullable.undefined();
    private JsonNullable<String> manufacturer = JsonNullable.undefined();
    private JsonNullable<Integer> enginePower = JsonNullable.undefined();
}
// END
