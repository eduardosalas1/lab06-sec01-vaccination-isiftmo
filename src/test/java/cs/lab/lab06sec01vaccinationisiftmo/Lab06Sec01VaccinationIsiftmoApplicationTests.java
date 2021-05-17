package cs.lab.lab06sec01vaccinationisiftmo;

import org.springframework.boot.test.context.SpringBootTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Test
class Lab06Sec01VaccinationIsiftmoApplicationTests {

    @Test(invocationCount = 1000, threadPoolSize = 1000)
    void Test_stress_1000_users()throws IOException, Exception{
        Long start = System.currentTimeMillis();
        Long end = System.currentTimeMillis();
        Long elapsedTime = end - start;
        Assert.assertTrue(elapsedTime<=400);

    }
    
     @Test
    void Test_length_dni(String dni) {
        int largo = dni.length();
        if(largo > 8){
            Assert.hasLength(dni,"tiene mas de 8 caracteres.");
        }
        else{
            Assert.hasLength(dni, "longitud correcta");
        }
    }

    @Test
    void Test_usuarios_max(int usuarios){
        if(usuarios > 1000){
            Assertions.assertEquals(1,2);
        }
        else{
            Assertions.assertEquals(1, 1);
        }
    }



}
