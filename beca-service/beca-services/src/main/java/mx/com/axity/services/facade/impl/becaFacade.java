package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.facade.IbecaFacade;
import mx.com.axity.services.service.IbecaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Component
public class becaFacade implements IbecaFacade {

    @Autowired //Lo saca de la pila de dependencias para ya no hacer IbecaService beca = new becaServiceImple
    private IbecaService becaService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public int operation(int a, int b) {
        int c = becaService.sum(a,b);
        b = becaService.rest(c,a);
        int d = becaService.multiplication(b);
        return becaService.division(d);
    }

    @Override
    public List<UserTO> getAllUsers() {
        List<UserDO> userDOList = this.becaService.getAllUsers();
        //List<UserTO> resul = new ArrayList<>();
        Type userTOType = new TypeToken<List<UserTO>>() {}.getType();
        List<UserTO> resul = this.modelMapper.map(userDOList, userTOType);
        return resul;
    }

    @Override
    public UserTO readUserByIdF(Long id) {
        UserDO userDO = this.becaService.getUsersIdBS(id);
        UserTO resul = this.modelMapper.map(userDO, UserTO.class);
        return resul;
    }


    @Override
    public void saveUser(UserTO userTO) {
        UserDO toSave = this.modelMapper.map(userTO,UserDO.class);
        this.becaService.saveUser(toSave);
    }

    @Override
    public void deleteUser(Long id) {
        this.becaService.deleteUser(id);
    }

    @Override
    public void updateUser(UserTO userTO) {
        UserDO userDO = this.modelMapper.map(userTO,UserDO.class);
        this.becaService.updateUser(userDO);
    }


}
