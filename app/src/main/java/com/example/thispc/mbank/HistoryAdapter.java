package com.example.thispc.mbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryAdapter extends BaseAdapter {
    Context context;
    ArrayList<TransactionInfo> list;

    public HistoryAdapter(Context context, ArrayList<TransactionInfo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(R.layout.activity_custom_adapter1,viewGroup,false);
        TextView accAmouV=view.findViewById(R.id.accAmouV);
        TextView accNumV=view.findViewById(R.id.accNumV);
        TextView accTypV=view.findViewById(R.id.accTypV);
        TextView accDateV=view.findViewById(R.id.accDateV);

        accNumV.setText(list.get(i).getTo());
        accTypV.setText(list.get(i).getType());
        accAmouV.setText(list.get(i).getAmount());
        accDateV.setText(list.get(i).getDate());
        return view;
    }
}
