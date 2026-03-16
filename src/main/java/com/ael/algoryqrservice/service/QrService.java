package com.ael.algoryqrservice.service;

import com.ael.algoryqrservice.model.dto.QrRequest;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class QrService {
    public void createQR(QrRequest req) {
        //TEXT , WİDTH , HEIGHT
        try{
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter
                    .encode(req.getText(), BarcodeFormat.QR_CODE, req.getWidth(), req.getHeight());


            String projectPath = System.getProperty("user.dir");
            Path dir = Paths.get(projectPath);

            String fileName = "qrcode.png";
            Path filePath = dir.resolve(fileName);


            MatrixToImageWriter .writeToPath(bitMatrix,"PNG",filePath);


        }catch (Exception e){
            System.out.println(e);
        }

    }
}
