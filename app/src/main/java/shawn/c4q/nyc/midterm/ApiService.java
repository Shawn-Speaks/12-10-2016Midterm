package shawn.c4q.nyc.midterm;

import retrofit2.Call;
import retrofit2.http.GET;
import shawn.c4q.nyc.midterm.POJOS.Example;

/**
 * Created by shawnspeaks on 12/10/16.
 */
public interface ApiService {

    @GET("api/timelines/users/918753190470619136")
    Call<Example> getDataInfo();
}
