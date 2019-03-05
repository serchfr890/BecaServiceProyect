package mx.com.axity.services.facade;

import mx.com.axity.commons.to.UserTO;

import java.util.List;
import java.util.Optional;

public interface IbecaFacade {

    int operation(int num1, int num2);
    List<UserTO> getAllUsers();

    UserTO readUserByIdF(Long id);

    void saveUser(UserTO userTO);

    void deleteUser(Long id);

    void updateUser(UserTO userTO);
}
