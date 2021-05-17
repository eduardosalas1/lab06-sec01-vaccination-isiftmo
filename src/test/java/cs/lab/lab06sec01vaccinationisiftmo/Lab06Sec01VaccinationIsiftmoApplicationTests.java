package cs.lab.lab06sec01vaccinationisiftmo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lab06Sec01VaccinationIsiftmoApplicationTests {

    @Test
    void contextLoads() {
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
