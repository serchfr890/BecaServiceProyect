package mx.com.axity.services.service.impl;

import mx.com.axity.model.UserDO;
import mx.com.axity.persistence.UserDAO;
import mx.com.axity.services.service.IbecaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class becaServiceImpl implements IbecaService {

    static final Logger LOG = LogManager.getLogger(becaServiceImpl.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int rest(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiplication(int num) {
        return num * 4;
    }

    @Override
    public int division(int numToDiv) {
        return numToDiv / 4;
    }

    @Override
    public List<UserDO> getAllUsers() {
        return (List<UserDO>) this.userDAO.findAll();
    }

    @Override
    public UserDO getUsersIdBS(Long id) {
        UserDO optionalUserDO = this.userDAO.findById(id).get();
        return optionalUserDO;
    }


    @Override
    public void saveUser(UserDO userDO) {
        this.userDAO.save(userDO);
    }

    @Override
    public void deleteUser(Long id) {
        this.userDAO.deleteById(id);
    }

    @Override
    public void updateUser(UserDO userDO) {
        this.userDAO.save(userDO);
    }
}
