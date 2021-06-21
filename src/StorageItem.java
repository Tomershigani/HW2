import java.util.Random;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;




public abstract class StorageItem {

 private String name;
 private double size;
 private final long date;

public StorageItem(String name){
    this.name = name;
    this.size = size;
    this.date = date;
}

public abstract int getSize();

public abstract String getName();

public void printTree(SortingField field){

}

}
