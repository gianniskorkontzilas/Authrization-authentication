package gr.aueb.cf.springauthsession5.mapper;

import gr.aueb.cf.springauthsession5.dto.RegisterTeacherDTO;
import gr.aueb.cf.springauthsession5.model.Teacher;
import gr.aueb.cf.springauthsession5.model.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private Mapper() {}

    public static Teacher extractTeacherFromRegisterTeacherDTO(RegisterTeacherDTO dto) {
        return new Teacher(dto.getFirstname(), dto.getLastname(), true);
    }

    public static User extractUserFromRegisterTeacherDTO(RegisterTeacherDTO dto) {
        User user = User.getNewUserWithTeacherRole(dto.getUsername(), dto.getPassword());
        user.setIsActive(true);
        return user;
    }
}