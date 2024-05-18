/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uliti;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Hieu
 */
public class webService {
    public static void openWeb() {
        String filePath = "web/index.html";
        File htmlFile = new File(filePath);
        if (htmlFile.exists() && htmlFile.isFile()) {
            try {
                Desktop.getDesktop().open(htmlFile);
            } catch (IOException e) {
                System.out.println("Không thể mở tệp HTML: " + e.getMessage());
            }
        } else {
            System.out.println("Tệp HTML không tồn tại hoặc không hợp lệ.");
        }
    }
}
