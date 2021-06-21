
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
        long date1 = Math.abs(new Random.nextLong());
        date1 = (date1 %(Math.abs(time1 - time2)))+ Math.min(time1,time2);
        this.name = name;
        this.size = size;
        this.date = date1;
    }

    public abstract int getSize();

    public long getDate() {
        return date;
    }
    public abstract String getName();

    public void byName(ArrayList<StorageItem>list){
        list.sort(Comparator.comparing(StorageItem::getName));
    }

    public void bySize(ArrayList<StorageItem>list){
        list.sort(Comparator.comparing(StorageItem::getSize).thenComparing(Comparator.comparing(StorageItem::getName)));
    }

    public void byDate(ArrayList<StorageItem>list){
        list.sort(Comparator.comparing(StorageItem::getDate).thenComparing(Comparator.comparing(StorageItem::getName)));
    }

    public void print_folder (SortingField field, StorageItem item, int counter){
        System.out.println("\n");
        for (int i = 0; i < counter; i++) {
            System.out.print("| ");
        }
        if (item instanceof File) {
            System.out.print(item.getName());
            return;
        }
        if (item instanceof Folder){
            System.out.println(item.getName());
            ArrayList <StorageItem> temp = ((Folder)item).list;
            if (field == SortingField.NAME)
            {
                byName(temp);
            }
            if (field == SortingField.SIZE)
            {
                bySize(temp);
            }
            if (field == SortingField.DATE)
            {
                byDate(temp);
            }
            for (StorageItem s : temp) {
                print_folder(field, s, counter++);
                counter--;
            }
        }

        return;
    }
    public void printTree(SortingField field){
        if (this instanceof File) {
            System.out.println(this.getName());
            return;
        }
        System.out.println(this.getName());
        ArrayList <StorageItem> tree = (Folder)this.list;
        if (field == SortingField.NAME)
        {
            byName(tree);
        }
        if (field == SortingField.SIZE)
        {
            bySize(tree);
        }
        if (field == SortingField.DATE)
        {
            byDate(tree);
        }
        int counter = 1 ;
        for (StorageItem i : tree){
            print_folder(field, i, counter);
        }
    }

}
