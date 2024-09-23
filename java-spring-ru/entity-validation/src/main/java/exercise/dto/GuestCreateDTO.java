package exercise.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// BEGIN
@Getter
@Setter
public class GuestCreateDTO {

    @NotEmpty(message = "Имя пользователя не может быть пустым")
    private String name;

    @Email(message = "Некорректный адрес электронной почты")
    private String email;

    @Pattern(regexp = "^\\+\\d{11,13}$", message = "Номер телефона должен начинаться с + и содержать от 11 до 13 цифр")
    private String phoneNumber;

    @Pattern(regexp = "^\\d{4}$", message = "Номер клубной карты должен состоять ровно из четырех цифр")
    private String clubCard;

    @Future(message = "Срок действия клубной карты должен быть еще не истекшим")
    private LocalDate cardValidUntil;

}
// END
