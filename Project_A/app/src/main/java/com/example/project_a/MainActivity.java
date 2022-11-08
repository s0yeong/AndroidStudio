package com.example.project_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button likeButton; Button dislikeButton;
    TextView likeCountView; TextView dislikeCountView;
    ListView listView;
    CommentAdapter adapter;
    int likeCount = 15; int dislikeCount = 1;
    boolean likeState = false; boolean dislikeState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton = (Button) findViewById(R.id.button);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (likeState) {
                    decrLikeCount();
                } else if (dislikeState) {
                    decrDisLikeCount();
                    dislikeState = false;
                    incrLikeCount();
                } else {
                    incrLikeCount();
                }
                likeState = !likeState;
            }
        });

        dislikeButton = (Button) findViewById(R.id.button2);
        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dislikeState) {
                    decrDisLikeCount();
                } else if (likeState) {
                    decrLikeCount();
                    likeState = false;
                    incrDisLikeCount();
                } else {
                    incrDisLikeCount();
                }
                dislikeState = !dislikeState;
            }
        });

        likeCountView = (TextView) findViewById(R.id.likeCountView);
        dislikeCountView = (TextView) findViewById(R.id.dislikeCountView);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new CommentAdapter();

        adapter.items.add(new CommentItem("kym71****", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", "10분 전", 5));
        adapter.items.add(new CommentItem("kym71****", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", "10분 전", 5));
        listView.setAdapter(adapter);


        Button write_comment_btn = (Button) findViewById(R.id.button3);
        write_comment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast write_comment_toast = Toast.makeText(getApplicationContext(), "한줄평 작성하기 버튼이 눌렸습니다.", Toast.LENGTH_LONG);
                write_comment_toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200);
                write_comment_toast.show();
            }
        });

        Button view_all_btn = (Button) findViewById(R.id.button4);
        view_all_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast view_all_toast = Toast.makeText(getApplicationContext(), "모두 보기 버튼이 눌렸습니다.", Toast.LENGTH_LONG);
                view_all_toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200);
                view_all_toast.show();
            }
        });

    }

    class CommentAdapter extends BaseAdapter {
        //데이터 관리
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void additem(CommentItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            CommentItemView cView = null;
            if (view == null) {
                cView = new CommentItemView(getApplicationContext());
            } else {
                cView = (CommentItemView) view;
            }

            CommentItem item = items.get(i);
            cView.setUserId(item.getUserId());
            cView.setCommentTime(item.getCommentTime());
            cView.setComment(item.getComment());

            return cView;
        }



    }

    public void incrLikeCount() {
        likeCount += 1;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrLikeCount() {
        likeCount -= 1;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.thumb_up);
    }

    public void incrDisLikeCount() {
        dislikeCount += 1;
        dislikeCountView.setText(String.valueOf(dislikeCount));
        dislikeButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);
    }

    public void decrDisLikeCount() {
        dislikeCount -= 1;
        dislikeCountView.setText(String.valueOf(dislikeCount));
        dislikeButton.setBackgroundResource(R.drawable.thumb_down);
    }
}