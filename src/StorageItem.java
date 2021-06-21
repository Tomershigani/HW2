import java.util.Random;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;




public abstract class StorageItem {

 private String name;
 private double size;
 private final long date;

public StorageItem(String name,double size, long date){
    this.name = name;
    this.size = size;
    this.date = date;
}

public abstract int getSize();

public void printTree(SortingField field){

}

}
