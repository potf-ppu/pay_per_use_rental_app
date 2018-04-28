package com.example.akm.potf_ppu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Office extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office);

        String [] list={"1","2","3","4"};
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list);
        MaterialBetterSpinner spinner=(MaterialBetterSpinner)findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);

    }
}
