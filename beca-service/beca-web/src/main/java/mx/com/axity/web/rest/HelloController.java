package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.IbecaFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("beca")
@Api(value="beca", description="Operaciones con beca")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IbecaFacade IbecaFacade;

    //****************************************Ejercicios Prueba********************************************************
    @RequestMapping(value = "/operation", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity operation() {
        LOG.info("Se invoca /operation");
        int result = this.IbecaFacade.operation(5,10);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity test() {
        LOG.info("Se invoca /test");
        return new ResponseEntity<>("Prueba Ok", HttpStatus.OK);
    }
    /*
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUserShow(@RequestBody UserTO userTO) {
        LOG.info("User");
        LOG.info(userTO.getName());
        LOG.info(userTO.getAge());
        LOG.info(userTO.getId());
        LOG.info(userTO.getLastName());
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    //Get All Users
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        LOG.info("Se invoca /users");
        List<UserTO> users = this.IbecaFacade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Create a User
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUser(@RequestBody UserTO userTO) {
        this.IbecaFacade.saveUser(userTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Delete user
    @RequestMapping(value = "/user", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity userDelete(@RequestParam(value = "id") Long id) {
        LOG.info("Delete User By Id");
        LOG.info(id);
        this.IbecaFacade.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Read User
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUserById(@RequestParam(value = "id") Long id) {
        LOG.info("Read User By Id");
        LOG.info(id);
        UserTO userTO = this.IbecaFacade.readUserByIdF(id);
        return new ResponseEntity<>(userTO, HttpStatus.OK);
    }

    //Update User
    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateUser(@RequestBody UserTO userTO) {
        LOG.info("Update User");
        this.IbecaFacade.updateUser(userTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
