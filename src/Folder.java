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
        if (!isExist(item.getName())){
            this.list.add(item);
            return true;
        }
        return false;
    }

    public boolean isExist(String item1){
        for (StorageItem item2 : this.list){
            if ((item2.getName()).equals(item1)){
                return true;
            }
        }
        return false;
    }

    public StorageItem getFile(String name) {
        for (StorageItem item2 : this.list) {
            if (item2.getName().equals(name)) {
                return item2;
            }
        }
        return null;
    }
    public File findFile(String path) {
        StorageItem file;  //אם לא רץ לבדוק פה
        String temp_name = path.substring((path.indexOf("/") - 1));
        path = path.replaceAll(temp_name, "");
        if (path.length() == 0) {
            if (isExist(temp_name)) {
                return (File)getFile(temp_name);
            }
            return null;
        }
        if (isExist(temp_name)) {
            file = ((Folder)getFile(temp_name)).findFile(path);
            return (File)file;
        }
       return null;
    }




    }







