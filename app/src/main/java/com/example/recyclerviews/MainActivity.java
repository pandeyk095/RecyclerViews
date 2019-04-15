package com.example.recyclerviews;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = new ArrayList<User>();
        userList.add(new User("Sailesh Prajapati", "Kalimati", "9860680462"));
        userList.add(new User("Aashish Maharjan", "Thaiba", "9860263483"));
        userList.add(new User("Koshal Pandey", "Balaju", "9843672328"));
        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        MyAdapter adapter = new MyAdapter(userList);
        recyclerView.setAdapter(adapter);



    }

    public static class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        private ArrayList<User> mUserList;

        public MyAdapter(ArrayList<User> userList){

            mUserList = userList;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

            User user = mUserList.get(i);
            myViewHolder.nameTv.setText(user.getUserName());
            myViewHolder.addTv.setText(user.getAddress());
            myViewHolder.contactTv.setText(user.getContactNo());
        }

        @Override
        public int getItemCount() {
            return mUserList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView nameTv, addTv, contactTv;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                nameTv =  itemView.findViewById(R.id.name_tv);
                addTv = itemView.findViewById(R.id.add_tv);
                contactTv = itemView.findViewById(R.id.contact_tv);
            }
        }

    }


}
