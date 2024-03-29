package by.shershen.service.services;

import by.shershen.database.entity.User;
import by.shershen.database.repository.UserRepository;
import by.shershen.service.api.IUserService;
import by.shershen.service.dto.PageDTO;
import by.shershen.service.dto.UserDTO;
import by.shershen.service.exceptions.InternalServerErrorException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<UserDTO> findAll(PageDTO pageDTO) {
        try {
        Page<User> users =
                this.userRepository.
                        findAll(PageRequest.of(pageDTO.getPage(), pageDTO.getSize(), Sort.by("email")));
        return users.map(UserService::apply);
        } catch (DataAccessException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public void save(UserDTO userDTO) {
        User entity = new User();
        entity.setId(UUID.randomUUID());
        entity.setSurname(userDTO.getSurname());
        entity.setName(userDTO.getName());
        entity.setPatronymic(userDTO.getPatronymic());
        entity.setEmail(userDTO.getEmail());
        entity.setRole(userDTO.getRole());
        try {
        this.userRepository.saveAndFlush(entity);
        } catch (DataAccessException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    private static UserDTO apply(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setSurname(user.getSurname());
        userDTO.setName(user.getName());
        userDTO.setPatronymic(user.getPatronymic());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
