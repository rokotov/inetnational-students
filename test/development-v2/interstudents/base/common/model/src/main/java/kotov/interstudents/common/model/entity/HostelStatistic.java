package kotov.interstudents.common.model.entity;

/**
 * Created by vkotov on 29.05.2015.
 */
public class HostelStatistic {
    private Hostel hostel;
    private int count = 0;

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addCount(){
        count++;
    }
}
