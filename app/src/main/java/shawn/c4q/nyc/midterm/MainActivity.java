package shawn.c4q.nyc.midterm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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

public class Adapter extends RecyclerView.Adapter {
    private List<Record> records;
    private LayoutInflater inflater;

    public Adapter(List<Record> records) {
        this.records = records;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.fullscreen_item, parent, false);
        return new VineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Record record = records.get(position);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_Layout);
//        linearLayout.setBackgroundColor(Color.parseColor(record.getProfileBackground()));

        /**
         *
         *  CODE ABOVE SHOULD WORK BUT DOES NOT!
         *
         */

        ((VineViewHolder) holder).bind(record);
    }

    @Override
    public int getItemCount() {
        return records.size();
    }
}

    public class VineViewHolder extends RecyclerView.ViewHolder {
        TextView usernameTV;
        TextView likedTV;
        LinearLayout linearLayout;


        public void bind(Record record){
            usernameTV.setText(record.getUsername());
            likedTV.setText(String.valueOf(record.getLiked()));
//            ContextCompat.getColor(this, R.color.white);
        }

        public VineViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_Layout);
            usernameTV = (TextView) itemView.findViewById(R.id.name_TV);
            likedTV = (TextView) itemView.findViewById(R.id.liked_TV);
            /**
             * set background to
             * profile background from JSON.
             */
        }
    }



    void makeApiCall (){
        initializeRV();
        service = URLbuilder.makeService();
        Call<Example> dataCall = service.getDataInfo();
        dataCall.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example = response.body();
                Data data = example.getData();
                List<Record> records = data.getRecords();
                rv.setAdapter(new Adapter(records));

                Log.d(TAG, String.valueOf(records.size()));
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d(TAG, "failure");
            }
        });
    }

    public void initializeRV(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv = (RecyclerView) findViewById(R.id.recycler_view);
        rv.setLayoutManager(layoutManager);
    }
}
