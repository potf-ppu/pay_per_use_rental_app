package com.example.akm.potf_ppu;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOError;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class pass extends AppCompatActivity {

    public static final String userid = "user123";
    public static final String doorid = "door123";
    public static final String rooturl = "http://13.229.123.98:5002/";

    private HttpURLConnection getConnection(String url) throws MalformedURLException, IOException {
        URL endpoint = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) endpoint.openConnection();
        conn.setRequestMethod("GET");
        return conn;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);

        Button open=(Button)findViewById(R.id.btnOpen);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            HttpURLConnection conn = getConnection(rooturl + "request/" + userid + "/" + doorid + "/");
                            int responseCode = conn.getResponseCode();
                            if (responseCode == 200) {
                                Intent i=new Intent(v.getContext(),sms.class);
                                startActivity(i);
                            }
                            else {
                                // failed
                                pass.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Failed to send sms", Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });

        Button close=(Button)findViewById(R.id.btnClose);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
