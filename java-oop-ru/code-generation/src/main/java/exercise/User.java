package exercise;

import lombok.Value;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
// BEGIN
@Getter
@Setter
@AllArgsConstructor
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
