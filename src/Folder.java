import java.util.ArrayList;

public class Folder extends StorageItem {
    String folderName;
    ArrayList <StorageItem> list;

    public Folder(String name){
        super(name);
        this.folderName = name;
        this.list = new ArrayList<>();
    }
    public int getSize() {
        int sum = 0;
        int range = this.list.size();
        for (int i = 0; i < range; i++) {
            sum = sum + (this.list.get(i)).getSize();
        }
        return sum;
    }

    @Override
    public String getName() {
        return this.folderName;
    }

    public boolean addItem(StorageItem item){
        if (!isExist(item)){
            this.list.add(item);
            return true;
        }
        return false;
    }

    public boolean isExist(StorageItem item1){
        for (StorageItem item2 : this.list){
            if (item2.getName().equals(item1.getName())){
                return true;
            }
        }
        return false;
    }

    public File findFile(String path){
        if (path.length()==0)
            return null;
        String temp_name = "";
        

    }
}

