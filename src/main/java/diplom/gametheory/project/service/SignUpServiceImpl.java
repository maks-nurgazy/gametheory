package diplom.gametheory.project.service;

import diplom.gametheory.project.entity.User;
import diplom.gametheory.project.forms.UserForm;
import diplom.gametheory.project.model.Role;
import diplom.gametheory.project.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .role(Role.TEACHER)
                .build();

        usersRepository.save(user);
    }
}