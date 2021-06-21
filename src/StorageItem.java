import java.util.Random;
import java.sql.Timestamp;
import java.lang.Math;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;




public abstract class StorageItem {

 private String name;
 private double size;
 private final long date;

public StorageItem(String name){
    Timestamp times1 = new Timestamp(2017,1,1,0,0,0,0);
    Timestamp times2 = new Timestamp(2021,1,1,0,0,0,0);
    long time1 = times1.getTime();
    long time2 = times2.getTime();
    Random rnd=Main.rnd;
    long date1 = Math.abs(rnd.nextLong());
    date1 = (date1 %(Math.abs(time1 - time2)))+ Math.min(time1,time2);
    this.name = name;
    this.size = size;
    this.date = date1;
}

public abstract int getSize();

public abstract String getName();

public void printTree(SortingField field){

}

}
