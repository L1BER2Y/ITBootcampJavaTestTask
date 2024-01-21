package by.shershen.service.dto;

import by.shershen.database.entity.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String surname;

    private String name;

    private String patronymic;

    private String email;

    private Role role;


}
