package msPersonne;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void retournePremierEmploye() throws Exception {
        mockMvc.perform(get("/employes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Amine"))
                .andExpect(jsonPath("$.age").value(28));
    }

    @Test
    void retourneDeuxiemeEmploye() throws Exception {
        mockMvc.perform(get("/employes/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("Salma"));
    }

    @Test
    void retourne404SiEmployeAbsent() throws Exception {
        mockMvc.perform(get("/employes/9999"))
                .andExpect(status().isNotFound());
    }
}