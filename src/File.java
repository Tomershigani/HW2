

public class File extends StorageItem {
    private final String name;
    private final String ext;
    private String content;

    public File(String name, String ext) {
        this.name = name;
        this.ext = ext;
        this.content = "";

    }

    public String getName() {
        String official_name = this.name + "." + this.ext;
        return official_name;
    }

    public int getSize() {
        return this.content.length();
    }

    public void addContent (String contentToAdd){
        this.content = this.content + contentToAdd;
    }

    public void printContent(){
        System.out.println(getName(), "Size: ", getSize(), "MB Created: ",super.date);
        System.out.println(this.content);
    }

}
