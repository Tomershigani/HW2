
import java.util.Random;
import java.sql.Timestamp;
import java.lang.Math;
import java.util.*;




public abstract class StorageItem {

    private final String name;
    final Timestamp date;


    public StorageItem(String name){
        /*
        Constructor
        :param link_param: Link obj of the method in which we calculate distance between clusters, before merging
        :param samples: list of Samples to apply the algorithm on
        */
        Random rnd = Main.rnd;
        long time1 = Timestamp.valueOf("2017-01-01 00:00:00").getTime();
        long time2= Timestamp.valueOf("2021-12-31 23:59:59").getTime();
        long date1 = Math.abs(rnd.nextLong());
        date1 = (date1 %(Math.abs(time1 - time2)))+ Math.min(time1,time2);
        this.name = name;
        this.date = new Timestamp(date1);
    }

    public abstract int getSize();

    public Timestamp getDate() {
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
        System.out.println("");
        for (int i = 0; i < counter; i++) {
            System.out.print("|    ");
        }
        if (item instanceof File) {
            System.out.print(item.getName());
            return;
        }
        if (item instanceof Folder){
            System.out.print(item.getName());
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
                counter = counter + 1;
                print_folder(field, s, counter);
                counter = counter - 1;
            }
        }

        return;
    }
    public void printTree(SortingField field){
        if (this instanceof File) {
            System.out.print(this.getName());
            return;
        }
        System.out.print(this.getName());
        ArrayList <StorageItem> tree = ((Folder)this).list;
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
        System.out.println("");
    }

}
