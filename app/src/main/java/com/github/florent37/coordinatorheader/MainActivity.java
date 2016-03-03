package com.github.florent37.coordinatorheader;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("Toolbar");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((Holder) holder).bind(position);
            }

            @Override
            public int getItemCount() {
                return 40;
            }

            class Holder extends RecyclerView.ViewHolder {

                TextView textView;

                public Holder(View itemView) {
                    super(itemView);
                    textView = (TextView) itemView.findViewById(R.id.text);
                }

                public void bind(int position) {
                    textView.setText("row " + position);
                }
            }

        });
    }

}
