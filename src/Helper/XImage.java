/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author dell
 */
public class XImage {
    public static Image getAppIcon(){
        URL url=XImage.class.getResource("D:\\Code_Du_An_1\\Du-An-1\\src\\Image\\man-icon-1 (1).png");
        return new ImageIcon(url).getImage();
    }
    
    public static void save(File src){
        File dts=new File("logos",src.getName());
        if(!dts.getParentFile().exists()){
            dts.getParentFile().mkdirs();
        }        
        try {
            Path from=Paths.get(src.getAbsolutePath());
            Path to=Paths.get(dts.getAbsolutePath());
            Files.copy(from,to,StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static ImageIcon read(String fileName){
        File path=new File("logos",fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
