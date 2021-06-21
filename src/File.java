

public class File extends StorageItem {
    private final String name;
    private final String ext;
    private String content;

    public File(String name, String ext) {
        //Constructor
        super(name);
        this.name = name;
        this.ext = ext;
        this.content = "";

    }

    public String getName() { // return the full name of a file
        String official_name = this.name + "." + this.ext;
        return official_name;
    }

    public int getSize() {
        return this.content.length();
    }

    public void addContent (String contentToAdd){
        this.content = this.content + contentToAdd;
    }

    public void printContent(){ // printing the file content
        System.out.println(getName() + " Size: " + getSize() + "MB Created: " + super.date);
        System.out.println(this.content);
    }

}
