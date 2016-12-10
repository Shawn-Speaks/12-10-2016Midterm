package shawn.c4q.nyc.midterm.POJOS;

import java.util.List;

/**
 * Created by shawnspeaks on 12/10/16.
 */

public class Data {
    private Integer count;
    private String anchorStr;
    private List<Record> records = null;

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The anchorStr
     */
    public String getAnchorStr() {
        return anchorStr;
    }

    /**
     *
     * @param anchorStr
     * The anchorStr
     */
    public void setAnchorStr(String anchorStr) {
        this.anchorStr = anchorStr;
    }

    /**
     *
     * @return
     * The records
     */
    public List<Record> getRecords() {
        return records;
    }

    /**
     *
     * @param records
     * The records
     */
    public void setRecords(List<Record> records) {
        this.records = records;
    }


}
