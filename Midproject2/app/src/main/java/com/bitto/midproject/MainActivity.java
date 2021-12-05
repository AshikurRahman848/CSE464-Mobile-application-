package com.bitto.midproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button save,update,refresh;
    EditText name;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DBhelper helper = new DBhelper(this);
        final ArrayList arrayList = helper.getAllCotacts();
        name = findViewById(R.id.name);
        listView = findViewById(R.id.listView);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.clear();
                arrayList.addAll(helper.getAllCotacts());
                arrayAdapter.notifyDataSetChanged();
                listView.invalidateViews();
                listView.refreshDrawableState();
            }
        });
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty()){
                    if (helper.insert(name.getText().toString())){
                        Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    name.setError("Enter Name");
                }
            }
        });
        final String[] prevText = new String[1];
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String a = listView.getItemAtPosition(i).toString();
                prevText[0] = a;
            }
        });
        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editText = name.getText().toString();
                if(!name.getText().toString().isEmpty()){
                    if(helper.update(editText, prevText[0])){
                        Toast.makeText(MainActivity.this, "Item Updated", Toast.LENGTH_LONG ).show();
                        name.setText("");
                        arrayList.clear();
                        arrayList.addAll(helper.getAllCotacts());
                        listView.invalidateViews();
                        listView.refreshDrawableState();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Item not updated", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    name.setError("Enter text");
                }

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String some = arrayList.get(position).toString();


                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Are you sure ?")
                        .setMessage("Do you want to delete this item")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                helper.delete(some);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });
    }
}