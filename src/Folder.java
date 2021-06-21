import java.util.ArrayList;

public class Folder {
    String folderName;
    ArrayList <StorageItem> list;

    public Folder(String name){
        this.folderName = name;
        this.list = new ArrayList<>();
    }


}

