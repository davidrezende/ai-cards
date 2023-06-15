package com.aicards.entrypoint.http;

import com.aicards.dataprovider.client.ReplicateAIClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;

@RestController
@RequestMapping("/v1/test")
public class TestController {

    @Autowired
    private ReplicateAIClient clientAIImage;


    @GetMapping("/image/{prompt}")
    public String testImage(@PathVariable String prompt) throws JsonProcessingException {
        return clientAIImage.callReplicateAI(prompt, null);
    }

    @GetMapping("/{replicateId}")
    public ResponseEntity<String> testGetImage(@PathVariable String replicateId) {
        return clientAIImage.getPrediction(replicateId);
    }

    @GetMapping("/url")
    public String testeConvertToBase64() throws IOException {
        URL url = new URL("");
        BufferedImage image = ImageIO.read(url);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", bos );
        byte [] data = bos.toByteArray();
        image.flush();
        bos.close();
        //byte [] fileContent = FileUtils.readFileToByteArray(file);
        return Base64.getEncoder().encodeToString(data);
    }
}
