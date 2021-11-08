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
    public static int count = 0;
    public static void main(String[] args) {
        path = args[0];
        findPath(path,count);
//        System.out.println(xmlString);
    }

    public static void findPath(String path,int count){
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

            if ( count > 0 ){
                for (int j = 0 ; j < count ; j++){
                    if ( count > 1 ){
                        for (int k = 0 ; k < count ; k++){
                            System.out.print("  ");
                        }
                    }
                    System.out.println("\t"+"|_________"+filename);
                }
            }

            if (files[i].isDirectory()){
//                System.out.println("\t"+"|_________"+files[i]);
                count += 1;
                path = files[i].toString();
//                println("Directory: " + path);
                findPath(path,count);
                count = 0;
            }
//            if ( file.isDirectory() ){
//                String nextpath = files[i].toString();
////                System.out.println(nextpath);
//                count++;
//                System.out.print("\t|_________");
//                findPath(nextpath);
//            }
//            else {
//                for( int j = 0 ; j < count ; j++) {
//                    if( count > 1){
//                        for (int k = 0; k < count ; k++){
//                            System.out.print(" ");
//                        }
//                    }
//                }
//                System.out.println("\t"+"|_________"+filename);
//                xmlString += "<file>" + filename + "</file>";
//            }
        }
        xmlString += "</folder>";
    }
}
