package com.example.mygrid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SingerAdapter adapter;

    EditText editText;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridVIew);

        //리스트 뷰에 어댑터 객체를 만든 후 설정을 해준다.
        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("소녀시대", "010-0000-0000", R.drawable.icon01));
        adapter.addItem(new SingerItem("에스파", "010-1111-1111", R.drawable.icon02));
        adapter.addItem(new SingerItem("아이들", "010-2222-2222", R.drawable.icon03));
        adapter.addItem(new SingerItem("아이브", "010-3333-3333", R.drawable.icon04));
        adapter.addItem(new SingerItem("블랙핑크", "010-4444-4444", R.drawable.icon05));

        gridView.setAdapter(adapter);

        //리스트뷰의 한 아이템을 클릭했을 때 발생할 이벤트 처리하는 리스너 추가
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SingerItem item = (SingerItem) adapter.getItem(i);  //name, mobile 데이터가 들어있음.
                Toast.makeText(getApplicationContext(), "선택 : " + item.getName(), Toast.LENGTH_LONG).show();

            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                String mobile = editText2.getText().toString();

                adapter.addItem(new SingerItem(name, mobile, R.drawable.icon01));
                adapter.notifyDataSetChanged();
            }
        });

    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();  //여러 문자열이 들어가는 아이템을 관리한다.
        // ArrayList<String> items = new ArrayList<String>(); //글자 하나가 들어가는 아이템을 관리한다.

        @Override
        public int getCount() {
            return items.size();    //item의 사이즈를 알려주는 메서드
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);    //인덱스 i에 해당하는 item 값을 반환
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            // new로 계속 뷰객체를 만들면 메모리 소모량이 심할 수 있으므로 재사용할 수 있게 convertView 사용
            SingerItemView view = null;
            if (convertView == null) {  //null인 경우에만 새로 할당
                view = new SingerItemView(getApplicationContext());
            } else {
                view = (SingerItemView) convertView;
            }

            SingerItem item = items.get(i);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());

            return view;
        }
    }
}