package com.example.mchho.networkasync;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private TextView name;
    private List<Profile> profileList = new ArrayList<>();

    private ProfileAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        name = (TextView) findViewById(R.id.name_text);




        getData();

//        HashMap<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("username", "maulana");
//        paramMap.put("password", "firdaus");
//        RequestParams params = new RequestParams(paramMap);


    }

    private void getData() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://firdaus91.web.id/test/profiles.php", new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                name.setText("fail");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                /*try {
                    JSONArray profile = new JSONObject(responseString).getJSONArray("profile");

                    for(int i=0;i<profile.length();++i){
                        JSONObject prof = profile.getJSONObject(i);

                        nameVal = prof.getString("name");
                        phoneVal = prof.getString("phone");
                        adrsVal = prof.getString("address");
                        photoVal = prof.getString("photo");
                    Profile aProf = new Profile(nameVal,phoneVal,adrsVal,photoVal);
                    profileList.add(aProf);}
                    mAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

                Profiles profiles = new Gson().fromJson(responseString, Profiles.class);
                Log.i("info", profiles.toString());
                mAdapter = new ProfileAdapter(MainActivity.this, profiles.getProfile());
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);
            }

        });
    }
}
