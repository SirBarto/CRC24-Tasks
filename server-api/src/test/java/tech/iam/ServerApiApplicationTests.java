package tech.iam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ServerApiApplicationTests {

    @Test
    void main() {
    }

    @Test
    public void assertTrue() {
        var frodo = "Frodo";
        assertThat(frodo).isEqualTo("Frodo");
    }


}