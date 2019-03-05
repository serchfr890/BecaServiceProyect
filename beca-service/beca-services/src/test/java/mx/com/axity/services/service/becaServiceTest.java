package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;
import java.util.List;
import java.util.NoSuchElementException;

public class becaServiceTest extends BaseTest {
    /*
    @Test //cuando se pone test se dice que es una prueba unitaria
    public void shouldReturnTheSumOfTwoNumbers(){
        //Definir las variables de entrada
        int num1 = 5;
        int num2 = 10;

        int resul = this.becaService.sum(num1, num2);
        //Argumentos Valor esperado con el valor de prueba
        Assert.assertEquals(15, resul);
    }
    @Test
    public void shouldReturnTheRestOfTwoNumbers(){
        int num1 = 15;
        int num2 = 5;

        int result = this.becaService.rest(num1, num2);
        Assert.assertEquals(10, result);
    }

    @Test
    public void shouldReturnTheMultOfTwoNumbers(){
        int num1 = 10;

        int resul = this.becaService.multiplication(num1);

        Assert.assertEquals(40, resul);
    }

    @Test
    public void shouldReturnTheDivOfTwoNumbers(){
        int num1 = 40;
        int resul = this.becaService.division(num1);

        Assert.assertEquals(10, resul);
    }*/

    java.io.PrintStream o = System.out;

    @Autowired protected IbecaService becaService;

    @Test
    public void updateExisteRegistro(){
        //Exito --> Registro existe y se actualiza
        UserDO userDO = becaService.getUsersIdBS(7L);
        Assert.assertTrue(userDO!=null);
        Assert.assertTrue(new Long(7).equals(userDO.getId()));
        Assert.assertTrue("Ln".equals(userDO.getLastName()));
    }

    @Test
    public void updateNoExisteRegistro(){
        try{
            UserDO userDO = becaService.getUsersIdBS(75678L);
            Assert.assertTrue(false);

        }catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }
}
