package mx.com.axity.services.service;

import mx.com.axity.model.UserDO;

import java.util.List;
import java.util.Optional;

public interface IbecaService {
    int sum(int num1, int num2);
    int rest(int num1, int num2);
    int multiplication(int num);
    int division(int numToDiv);

    List<UserDO> getAllUsers();
    UserDO getUsersIdBS(Long id);
    void saveUser(UserDO userDO);
    void deleteUser(Long id);
    void updateUser(UserDO userDO);
}
