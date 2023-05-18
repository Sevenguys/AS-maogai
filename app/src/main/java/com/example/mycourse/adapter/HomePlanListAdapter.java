package com.example.mycourse.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.example.mycourse.R;
import com.example.mycourse.adapter.ExercisesListItemAdapter;
import com.example.mycourse.bean.CourseBean;
import com.example.mycourse.bean.ExercisesBean;
import com.example.mycourse.utils.AnalysisUtils;

import java.util.ArrayList;
import java.util.List;

public class HomePlanListAdapter extends BaseAdapter {

    private List<CourseBean> objects = new ArrayList<CourseBean>();
    private Context context;
    private LayoutInflater layoutInflater;

    public HomePlanListAdapter(Context context) {
        this.context=context;
        this.layoutInflater=LayoutInflater.from(context);
    }

    public void setData(List<CourseBean> objects){
        this.objects = objects;
        notifyDataSetChanged();
    }

    public void updateView(List<CourseBean> objects){
        this.objects = objects;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return objects == null ? 0 : objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.course_list_item2, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((CourseBean) getItem(position), (ViewHolder) convertView.getTag(),
                position, convertView);
        return convertView;
    }

    private void initializeViews(CourseBean object, ViewHolder holder,
                                 int position, View convertView) {
        final CourseBean bean = (CourseBean) getItem(position);
        holder.tvCTitle.setText(bean.title);
        holder.tvDate.setText(bean.date);
        /* 这里设置一下，把已经学完的课程显示已学
        Log.i("readExercises", AnalysisUtils.readExerciseStatus(context,position+1)+"");
        if (AnalysisUtils.readExerciseStatus(context,position+1)){
            holder.tvContent.setText("已完成");
        }else{
            holder.tvContent.setText(bean.content);
        }
        */

        }

    protected class ViewHolder {
        private TextView tvCTitle;
        private TextView tvDate;

        public ViewHolder(View view) {
            tvCTitle = (TextView) view.findViewById(R.id.tv_ctitle);
            tvDate = (TextView) view.findViewById(R.id.tv_date);
        }
    }
}
