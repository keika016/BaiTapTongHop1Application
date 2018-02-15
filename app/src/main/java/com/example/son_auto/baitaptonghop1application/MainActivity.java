package com.example.son_auto.baitaptonghop1application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnShow, btnPopUp, btnContext, btnCustomDialog, btnAlertDialog;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button) findViewById(R.id.buttonShow);
        btnPopUp = (Button) findViewById(R.id.popup1);
        btnContext = (Button) findViewById(R.id.context1);
        btnCustomDialog = (Button) findViewById(R.id.customdialog_activity1);
        btnAlertDialog = (Button) findViewById(R.id.alertdialog1);
        spinner1 = (Spinner) findViewById(R.id.spinner1);

        btnShow.setOnClickListener(new ButtonClickEvent(MainActivity.this));
        btnPopUp.setOnClickListener(new ButtonClickEvent(MainActivity.this));
        btnCustomDialog.setOnClickListener(new ButtonClickEvent(MainActivity.this));
        btnAlertDialog.setOnClickListener(new ButtonClickEvent(MainActivity.this));
        registerForContextMenu(btnContext);

        ArrayList<String> listString = new ArrayList<>();
        listString.add("Phần tử 1");
        listString.add("Phần tử 2");
        listString.add("Phần tử 3");
        listString.add("Phần tử 4");
        listString.add("Phần tử 5");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listString);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, spinner1.getSelectedItem() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Hiển thị context menu");
        menu.setHeaderIcon(R.drawable.pic1);
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }
}
