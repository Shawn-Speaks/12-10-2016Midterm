package shawn.c4q.nyc.midterm.POJOS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shawnspeaks on 12/10/16.
 */

public class User {

    @SerializedName("username")
    @Expose
    private String username;

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

}
