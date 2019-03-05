package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class becaServiceTest extends BaseTest {

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
    }

}
