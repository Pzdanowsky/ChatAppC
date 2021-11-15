package Services;

import Objects.FileObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class FileCreatorService {
   // private static FileObject fileObject;
    private static File file;

    public static FileObject preparationFileObject(File file){
        FileObject fileObject = null;
        FileInputStream fileInputStream = null;
        byte[] bFile = new byte[(int)file.length()];

        try{
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();

            fileObject = new FileObject(file.getName(),bFile);

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return fileObject;
    }


    public static File preparationFile(FileObject fileObject){
        File file = null;
        String path = "src/fileRepository/recive/";
        String pathFile = path+fileObject.getFilename();

        try {

           //file = new File(pathFile);
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            fileOutputStream.write(fileObject.getContentFile());
            file = new File(pathFile);

        }catch(IOException ex){
            ex.printStackTrace();

        }
        return file;
    }

}
