package com.example.crud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CrudApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void Testing_API_createBlco() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/findAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());

	}

}
