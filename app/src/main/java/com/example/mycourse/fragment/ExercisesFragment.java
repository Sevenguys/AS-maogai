package com.example.mycourse.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.example.mycourse.R;
import com.example.mycourse.adapter.ExercisesListItemAdapter;
import com.example.mycourse.bean.ExercisesBean;

import java.util.ArrayList;
import java.util.List;

public class ExercisesFragment extends Fragment {

    private ListView vlist;//传给fragment_exercises
    private ExercisesListItemAdapter adapter; //适配器
    private List<ExercisesBean> beanlist; //列表集合

    @Override
    //创建该fragment对应的视图
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exercises, null);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        vlist = view.findViewById(R.id.lv_list);
        adapter = new ExercisesListItemAdapter(getActivity());//获取适配器
        adapter.setData(beanlist);//数据传输
        vlist.setAdapter(adapter);
    }

    //章节习题信息
    private void initData(){
        beanlist = new ArrayList<ExercisesBean>();
        for (int i=0;i<10;i++){
            ExercisesBean bean = new ExercisesBean();
            bean.id=(i+1);
            switch (i){
                case 0:
                    bean.title="第1章 毛泽东思想及其历史地位";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_1);
                    break;
                case 1:
                    bean.title="第2章 新民主主义革命理论";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_2);
                    break;
                case 2:
                    bean.title="第3章 社会主义改造理论";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_3);
                    break;
                case 3:
                    bean.title="第4章 社会主义建设道路初步探索的理论成果";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_4);
                    break;
                case 4:
                    bean.title="第5章 邓小平理论";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_1);
                    break;
                case 5:
                    bean.title="第6章 三个代表”重要思想”";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_2);
                    break;
                case 6:
                    bean.title="第7章 科学发展观";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_3);
                    break;
                case 7:
                    bean.title="第8章 习近平新时代中国特色社会主义思想";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_4);
                    break;
                case 8:
                    bean.title="第9章 中国特色社会主义总任务";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_1);
                    break;
                case 9:
                    bean.title="第10章 全面深化改革";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_2);
                    break;
                default:
                    break;
            }
            beanlist.add(bean);
        }
    }
}
