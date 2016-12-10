package shawn.c4q.nyc.midterm;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shawnspeaks on 12/10/16.
 */

public class URLbuilder {

    private static final String vineAPIURL = "https://vine.co/";
    private static Retrofit retrofit;
    private static Retrofit.Builder builder;

    public static ApiService makeService(){
        builder = new Retrofit.Builder()
                .baseUrl(vineAPIURL)
                .addConverterFactory(GsonConverterFactory.create());

                retrofit = builder.build();

        return retrofit.create(ApiService.class);
    }


//    public static String getJSONstring(){
//        retrofit = new Retrofit.Builder().baseUrl(vineAPIURL).build();
//        ApiService example = retrofit.create(ApiService.class);
//        try {
//            Response response = example.getDataInfo().execute();
//            response.body().str
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




}
