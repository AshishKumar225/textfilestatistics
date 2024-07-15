package com.myapp.textfilestatistics.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.textfilestatistics.mapper.TextFileStatisticsMapper;
import com.myapp.textfilestatistics.model.TextFileStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FileUploadController.class)
class FileUploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TextFileStatisticsMapper textFileStatisticsMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private FileUploadController fileUploadController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(fileUploadController).build();
    }

    @Test
    void testHandleFileUpload() throws Exception {
        String text = "Hello world!.";
        MockMultipartFile file = new MockMultipartFile("textFile", "test.txt", "text/plain", text.getBytes());

        TextFileStatistics stats = new TextFileStatistics();
        stats.setWordCount(4);
        stats.setLetterCount(17);
        Map<Character, Integer> symbols = new HashMap<>();
        symbols.put('!', 1);
        symbols.put('.', 1);
        stats.setSymbolCount(symbols.size());
        stats.setSymbols(symbols);
        stats.setTopWords(List.of("hello", "world"));
        stats.setTopLetters(List.of('h', 'e', 'l'));

        when(textFileStatisticsMapper.mapToStatistics(text)).thenReturn(stats);

        mockMvc.perform(multipart("/api/upload")
                        .file(file)
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(stats)));
    }
    @Test
    void testHandleEmptyFileUpload() throws Exception {
        MockMultipartFile emptyFile = new MockMultipartFile("textFile", "empty.txt", "text/plain", new byte[0]);

        mockMvc.perform(multipart("/api/upload")
                        .file(emptyFile)
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("No file uploaded"));
    }
}