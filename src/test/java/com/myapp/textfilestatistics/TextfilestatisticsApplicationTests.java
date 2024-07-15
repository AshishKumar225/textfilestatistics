package com.myapp.textfilestatistics;

import com.myapp.textfilestatistics.controller.FileUploadController;
import com.myapp.textfilestatistics.service.TextStatisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class TextfilestatisticsApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private FileUploadController fileUploadController;

	@Autowired
	private TextStatisticsService textStatisticsService;

    @Test
	void contextLoads() {
		assertThat(applicationContext).isNotNull();
	}

	@Test
	void fileUploadControllerLoads() {
		assertThat(fileUploadController).isNotNull();
	}

	@Test
	void textStatisticsServiceLoads() {
		assertThat(textStatisticsService).isNotNull();
	}

	@Test
	void testEndpointAvailability() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(fileUploadController).build();
		mockMvc.perform(get("/api/upload"))
				.andExpect(status().isMethodNotAllowed());
	}
}
