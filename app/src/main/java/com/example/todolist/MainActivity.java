package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView mylist=findViewById(R.id.ToDoListView);
        final ArrayAdapter<String>listAdapter=new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1);

        mylist.setAdapter(listAdapter);

        Button AddButton=findViewById(R.id.addButton);

        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText myItem = findViewById(R.id.InputText);
                String value = myItem.getText().toString().trim(); // Remove leading and trailing whitespace

                if (!value.isEmpty()) { // Check if the value is not empty
                    listAdapter.add(value);
                    myItem.getText().clear();
                } else {
                    // Handle empty item case (e.g., show an error message, display a toast, etc.)
                    // For example, you can display a toast message:
                    Toast.makeText(getApplicationContext(), "Please enter a valid item", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position, long id) {
                Toast.makeText(getApplicationContext(),((TextView)arg1).getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        Button ClearButton=findViewById(R.id.ClearButton);
        ClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listAdapter.clear();

            }
        });








        mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String item=(String)parent.getItemAtPosition(position);
                listAdapter.remove(item);
                return true;
            }
        });
    }
}