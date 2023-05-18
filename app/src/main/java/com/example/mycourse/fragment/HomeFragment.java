package com.example.mycourse.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import com.example.mycourse.R;
import com.example.mycourse.adapter.ExercisesListItemAdapter;
import com.example.mycourse.adapter.HomePlanListAdapter;
import com.example.mycourse.bean.CourseBean;
import com.example.mycourse.bean.ExercisesBean;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ListView vlist;
    private HomePlanListAdapter adapter;
    private List<CourseBean> courseBeanlist;

    @Override
    //创建该fragment对应的视图
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        vlist = view.findViewById(R.id.lv_home_list);
        adapter = new HomePlanListAdapter(getActivity());//获取适配器
        adapter.setData(courseBeanlist);//数据传输
        vlist.setAdapter(adapter);
    }

    private void initData() {
        courseBeanlist=new ArrayList<CourseBean>();
        for (int i=0;i<15;i++){
            CourseBean bean = new CourseBean();
            bean.id=(i+1);
            switch (i){
                case 0:
                    bean.title="毛泽东思想及其历史地位";
                    bean.date="第1周";
                    break;
                case 1:
                    bean.title="新民主主义革命理论";
                    bean.date="第2周";
                    break;
                case 2:
                    bean.title="社会主义改造理论";
                    bean.date="第3周";
                    break;
                case 3:
                    bean.title="社会主义建设道路初步探索的理论成果";
                    bean.date="第4周";
                    break;
                case 4:
                    bean.title="邓小平理论";
                    bean.date="第5周";
                    break;
                case 5:
                    bean.title="三个代表”重要思想”";
                    bean.date="第6周";
                    break;
                case 6:
                    bean.title="科学发展观";
                    bean.date="第7周";
                    break;
                case 7:
                    bean.title="习近平新时代中国特色社会主义思想";
                    bean.date="第8周";
                    break;
                case 8:
                    bean.title="中国特色社会主义总任务";
                    bean.date="第9周";
                    break;
                case 9:
                    bean.title="全面深化改革";
                    bean.date="第10周";
                    break;
                case 10:
                    bean.title="“五位一体”总体布局";
                    bean.date="第11周";
                    break;
                case 11:
                    bean.title="全面推进国防和军队现代化";
                    bean.date="第12周";
                    break;
                case 12:
                    bean.title="“一国两制”与祖国统一";
                    bean.date="第13周";
                    break;
                case 13:
                    bean.title="中国特色大国外交";
                    bean.date="第14周";
                    break;
                case 14:
                    bean.title="全面从严治党";
                    bean.date="第15周";
                    break;
                default:
                    break;
            }
            courseBeanlist.add(bean);
        }
    }
}