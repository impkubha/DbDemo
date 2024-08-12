package com.example.dbdemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListAdaptor extends ArrayAdapter {
    Activity context;
    ArrayList<Integer> id;
    ArrayList<String> name;
    ArrayList<String> address;


    public ListAdaptor(@NonNull Context context, ArrayList<Integer> id,ArrayList<String> name, ArrayList<String> address) {

        super(context, R.layout.list_items,name);
        this.context= (Activity) context;
        this.id=id;
        this.name=name;
        this.address=address;

    }
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_items,null,true);

        TextView txtId=(TextView) rowView.findViewById(R.id.txtId);
        TextView txtName=(TextView) rowView.findViewById(R.id.txtName);
        TextView txtAddress=(TextView) rowView.findViewById(R.id.txtAddress);

        txtId.setText(id.get(position).toString());
        txtName.setText(name.get(position).toString());
        txtAddress.setText(address.get(position).toString());


      return rowView;
    }
}
