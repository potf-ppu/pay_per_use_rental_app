package com.example.akm.potf_ppu;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class sms extends AppCompatActivity {

    private HttpURLConnection getConnection(String url) throws MalformedURLException, IOException {
        URL endpoint = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) endpoint.openConnection();
        conn.setRequestMethod("GET");
        return conn;
    }

    private boolean checkCode(String code) {
        try {
            HttpURLConnection conn = getConnection(pass.rooturl + "verify/" + pass.userid + "/" + pass.doorid + "/" + code + "/");
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                // open door successfully
                return  true;
            }
            else {

                return false;
                // failed
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        final EditText sms=(EditText)findViewById(R.id.edsms);
        Button btn=(Button)findViewById(R.id.btnsms);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        String code = sms.getText().toString();
                        if (checkCode(code)) {
                            sms.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Door open", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        else {
                            sms.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Door not open", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }
                });

            }
        });
    }
}
