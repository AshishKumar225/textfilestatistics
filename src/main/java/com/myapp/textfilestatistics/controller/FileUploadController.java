package com.myapp.textfilestatistics.controller;

import com.myapp.textfilestatistics.mapper.TextFileStatisticsMapper;
import com.myapp.textfilestatistics.model.TextFileStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FileUploadController {
    @Autowired
    private TextFileStatisticsMapper textFileStatisticsMapper;

    private static final String FILE_UPLOAD_URI = "/upload";
    private static final String TEXT_FILE = "textFile";
    private static final String NO_FILE_ERROR = "No file uploaded";
    private static final String FILE_PROCESSING_ERRROR="Error processing file";

    @PostMapping(FILE_UPLOAD_URI)
    public ResponseEntity<?> handleFileUpload(@RequestParam(TEXT_FILE) MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(NO_FILE_ERROR);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String text = reader.lines().collect(Collectors.joining("\n"));

            TextFileStatistics stats = textFileStatisticsMapper.mapToStatistics(text);

            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(FILE_PROCESSING_ERRROR);
        }
    }
}
