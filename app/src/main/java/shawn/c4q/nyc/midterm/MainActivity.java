package shawn.c4q.nyc.midterm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shawn.c4q.nyc.midterm.POJOS.Data;
import shawn.c4q.nyc.midterm.POJOS.Example;
import shawn.c4q.nyc.midterm.POJOS.Record;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    ApiService service;
    private String TAG = "DEBUGGER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeApiCall();
    }




    void makeApiCall (){
        service = URLbuilder.makeService();
        Call<Example> dataCall = service.getDataInfo();
        dataCall.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example = response.body();
                Data data = example.getData();
                List<Record> records = data.getRecords();
                
                Log.d(TAG, String.valueOf(records.size()));
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d(TAG, "failure");
            }
        });
    }
}
