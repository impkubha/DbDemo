package com.example.dbdemo;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editId,edtName,edtAddress;
    Button btnInsert,btnSelect,btnUpdate,btnDelete;
    TextView txtData;
    MyDbHelper myDbHelper;
    ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //creating object for database
        myDbHelper=new MyDbHelper(this);

        editId=findViewById(R.id.edtId);
        edtName=findViewById(R.id.edtName);
        edtAddress=findViewById(R.id.edtAddress);
        btnInsert=findViewById(R.id.btnInsert);
        btnSelect=findViewById(R.id.btnSelect);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        //txtData=findViewById(R.id.txtData);
        listView=findViewById(R.id.mylist);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(editId.getText().toString());
                String name=edtName.getText().toString();
                String address=edtAddress.getText().toString();

                //calling insert function
                myDbHelper.insertData(id,name,address);
                Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //retreiving data
                ArrayList<Integer> id=new ArrayList<>();
                ArrayList<String> name=new ArrayList<>();
                ArrayList<String> address=new ArrayList<>();

                //calling select function
                Cursor cursor=myDbHelper.selectData();
                while (cursor.moveToNext()){
                    id.add(cursor.getInt(0));
                    name.add(cursor.getString(1));
                    address.add(cursor.getString(2));
                }
                ListAdaptor adaptor=new ListAdaptor(MainActivity.this,id,name,address);
                listView.setAdapter(adaptor);
            }
        });
    }
}