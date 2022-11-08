package com.example.project_a;

import android.content.AttributionSource;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CommentItemView extends LinearLayout {
    TextView userId;
    TextView commentTime;
    TextView comment;

    public CommentItemView (Context context) {
        super(context);

        init(context); //초기화
    }

    public CommentItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view, this, true);

        userId = (TextView) findViewById(R.id.user_id);
        commentTime = (TextView) findViewById(R.id.comment_time);
        comment = (TextView) findViewById(R.id.comment);
    }

    public void setUserId(String userId) {
        this.userId.setText(userId);
    }

    public void setCommentTime(String commentTime) {
        this.commentTime.setText(commentTime);
    }

    public void setComment(String comment) {
        this.comment.setText(comment);
    }
}
