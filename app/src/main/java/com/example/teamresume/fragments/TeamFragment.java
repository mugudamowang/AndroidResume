package com.example.teamresume.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamresume.MyAdapter;
import com.example.teamresume.R;
import com.example.teamresume.ResumeActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;


public class TeamFragment extends Fragment {

    private ListView lv_contianer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv_contianer = view.findViewById(R.id.lv_contianer);
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
        for (int i = 0; i < 15; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.mipmap.ic_launcher);//加入图片
            map.put("ItemTitle", "第" + i + "行");
            map.put("ItemRemark", "这是第" + i + "行");
            listItem.add(map);
        }

        MyAdapter adapter = new MyAdapter(this.getContext(), listItem);
        lv_contianer.setAdapter(adapter);//为ListView绑定适配器


        lv_contianer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    Toast.makeText(getActivity(),"Fxxk!"+arg2, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), ResumeActivity.class);
                    intent.putExtra("id",arg2);
                    startActivity(intent);
            }
        });
    }
}