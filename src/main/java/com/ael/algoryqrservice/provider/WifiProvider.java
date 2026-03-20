package com.ael.algoryqrservice.provider;

import com.ael.algoryqrservice.model.Type;
import com.ael.algoryqrservice.model.dto.QrRequest;
import com.ael.algoryqrservice.model.dto.QrResponse;
import com.ael.algoryqrservice.model.dto.WifiRequest;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class WifiProvider implements QrProvider<QrRequest> {

    @Override
    public Type getType() {
        return Type.WIFI;
    }

    @Override
    public Class<QrRequest> requestType() {
        return QrRequest.class;
    }

    @Override
    public QrResponse createQr(QrRequest req) {
    try{
        String content = buildVCard(req.getDetails());
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter
                .encode(content, BarcodeFormat.QR_CODE, 1, 2);


        String projectPath = System.getProperty("user.dir");
        Path dir = Paths.get(projectPath);

        String fileName = "qrcode.png";
        Path filePath = dir.resolve(fileName);


        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",filePath);
        return null;
    }catch (Exception e){
        System.out.println(e);
    }

      return null;
    }

    public String buildVCard(Map<String, Object> details) {
        String firstName = value(details.get("firstName"));
        String lastName = value(details.get("lastName"));
        String phone = value(details.get("phone"));
        String email = value(details.get("email"));
        String company = value(details.get("company"));
        String title = value(details.get("title"));

        return "BEGIN:VCARD\n" +
                "VERSION:3.0\n" +
                "N:" + lastName + ";" + firstName + "\n" +
                "FN:" + firstName + " " + lastName + "\n" +
                "TEL:" + phone + "\n" +
                "EMAIL:" + email + "\n" +
                "ORG:" + company + "\n" +
                "TITLE:" + title + "\n" +
                "END:VCARD";
    }

    private String value(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}
