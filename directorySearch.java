import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

public class directorySearch {
    public static String path;
    public static String xmlString = "";
    public static void main(String[] args) {
        path = args[0];
        findPath(path);
        findPath2(path);
//        System.out.println(xmlString);
    }
    public static void findPath(String path){
        String[] listpath = path.split("/");
        String lastpath = listpath[listpath.length-1];
        xmlString += "<folder name=" + '"' + lastpath + '"' + ">";
        File f = new File(path);
        File[] files =  f. listFiles();
//        System.out.println(path);
        for ( int i = 0 ; i < files.length ; i++ ){
            File file = files[i];
//            System.out.println(file);
            String filename = file.getName();
//            System.out.println(filename);
            if ( file.isDirectory() ){
                String nextpath = files[i].toString();
//                System.out.println(nextpath);
                findPath(nextpath);
            }
            else {
                xmlString += "<file>" + filename + "</file>";
            }
        }
        xmlString += "</folder>";
    }

    public static void findPath2(String path){
        String[] listpath = path.split("/");
        String lastpath = listpath[listpath.length-1];
        xmlString += "<folder name=" + '"' + lastpath + '"' + ">";
        File f = new File(path);
        File[] files =  f. listFiles();
        System.out.println(lastpath);
        for ( int i = 0 ; i < files.length ; i++ ){
            File file = files[i];
//            System.out.println(file);
            String filename = file.getName();
//            System.out.println(filename);
            if ( file.isDirectory() ){
                String nextpath = files[i].toString();
//                System.out.println(nextpath);
                System.out.print("\t|_________");
                findPath2(nextpath);
            }
            else {
                System.out.println("\t\t"+filename);
                xmlString += "<file>" + filename + "</file>";
            }
        }
        xmlString += "</folder>";
    }
}
