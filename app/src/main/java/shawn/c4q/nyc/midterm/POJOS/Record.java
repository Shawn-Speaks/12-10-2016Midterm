package shawn.c4q.nyc.midterm.POJOS;

/**
 * Created by shawnspeaks on 12/10/16.
 */

public class Record {


    private Integer liked;
    private String profileBackground;
    private Repost repost;

    public Repost getRepost() {
        return repost;
    }

    public void setRepost(Repost repost) {
        this.repost = repost;
    }

    /**
     *
     * @return
     * The liked
     */
    public Integer getLiked() {
        return liked;
    }

    /**
     *
     * @param liked
     * The liked
     */
    public void setLiked(Integer liked) {
        this.liked = liked;
    }

    /**
     *
     * @return
     * The profileBackground
     */
    public String getProfileBackground() {
        return profileBackground;
    }

    /**
     *
     * @param profileBackground
     * The profileBackground
     */
    public void setProfileBackground(String profileBackground) {
        this.profileBackground = profileBackground;
    }

    /**
     *
     * @return
     * The user
     */

}

