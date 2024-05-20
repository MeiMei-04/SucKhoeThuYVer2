/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uliti;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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

    public static boolean openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean openWebpage(URL url) {
        try {
            return openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }
}
