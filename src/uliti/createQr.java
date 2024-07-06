/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uliti;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 *
 * @author HieuCute
 */
public class createQr {

    private static final String QR_CODE_IMAGE_PATH = "src/qr/";

    public static void generateQRCodeImage(String text, String name)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);

        Path path = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH+name);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

//    public static void main(String[] args) {
//        try {
//            generateQRCodeImage("https://www.example.com", 350, 350, QR_CODE_IMAGE_PATH);
//            System.out.println("QR Code image created successfully!");
//        } catch (WriterException e) {
//            System.err.println("Could not generate QR Code, WriterException :: " + e.getMessage());
//        } catch (IOException e) {
//            System.err.println("Could not generate QR Code, IOException :: " + e.getMessage());
//        }
//    }

}
