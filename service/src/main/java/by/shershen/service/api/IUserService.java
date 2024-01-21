package by.shershen.service.api;

import by.shershen.service.dto.PageDTO;
import by.shershen.service.dto.UserDTO;
import org.springframework.data.domain.Page;

public interface IUserService {

    Page<UserDTO> findAll(PageDTO pageDTO);

    void save(UserDTO userDTO);
}
