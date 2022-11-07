package com.example.mysummary2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class CommentItemView extends LinearLayout {

    public CommentItemView(Context context) {
        super(context);

        init(context);  //초기화
    }

    public CommentItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) { //파라미터를 받아서 comment_item_view.xml 파일과 이 자바 소스 파일을 인플레이션을 통해서 연결해준다.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view, this, true);
    }

}
