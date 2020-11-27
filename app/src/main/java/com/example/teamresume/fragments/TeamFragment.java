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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class TeamFragment extends Fragment {

    private ListView lv_contianer;
    private String[][] personlist;
    private int[] imgaddress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv_contianer = view.findViewById(R.id.lv_contianer);

        //two data array
        imgaddress = new int[]{R.drawable.avatar01, R.drawable.avatar02, R.drawable.avatar03, R.drawable.avatar04, R.drawable.avatar05};
        personlist = new String[][]{
                {"yyh", "20", "male", "首席干饭师", "web-developer"},
                {"yyj", "20", "male", "首席打工人", "backend-developer"},
                {"sjy", "20", "male", "短裤战神", "java-developer"},
                {"qsw", "20", "male", "伟哥就是伟大", "management-developer"},
                {"yyc", "20", "male", "fivefire", "sql-developer"},
        };

        //data sent to MyAdapter
        final ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
        for (int i = 0; i < personlist.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemName", personlist[i][0]);
            map.put("ItemAge", personlist[i][1]);
            map.put("ItemGender", personlist[i][2]);
            map.put("ItemRemark", personlist[i][3]);
            map.put("ItemSkill", personlist[i][4]);
            map.put("ItemImage", imgaddress[i]);
            listItem.add(map);
        }
        MyAdapter adapter = new MyAdapter(this.getContext(), listItem);
        lv_contianer.setAdapter(adapter);//为ListView绑定适配器

        //OnclickEvent
        lv_contianer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Intent intent = new Intent(getActivity(), ResumeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("ItemName", personlist[arg2][0]);
                bundle.putString("ItemAge", personlist[arg2][1]);
                bundle.putString("ItemGender", personlist[arg2][2]);
                bundle.putString("ItemRemark", personlist[arg2][3]);
                bundle.putString("ItemSkill", personlist[arg2][4]);
                bundle.putInt("ItemImage", imgaddress[arg2]);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}