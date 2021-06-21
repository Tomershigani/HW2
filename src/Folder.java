import java.util.ArrayList;

public class Folder {
    String folderName;
    ArrayList <StorageItem> list;

    public Folder(String name){
        this.folderName = name;
        this.list = new ArrayList<>();
    }
    public int getSize() {
        int sum = 0;
        int range = this.list.size();
        for (int i = 0; i < range; i++) {
            sum = sum + (this.list.get(i)).getSize();
        }
    }

}

