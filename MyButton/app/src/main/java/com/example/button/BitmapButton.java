package com.example.button;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class BitmapButton extends AppCompatButton {

    public BitmapButton(@NonNull Context context) {
        super(context);

        init(context);
    }

    public BitmapButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        // 배경 이미지를 지정하겠다는 상태가 된다.
        setBackgroundResource(R.drawable.title_bitmap_button_normal);

        float textSize = getResources().getDimension(R.dimen.text_size);
        // 글자 크기 지정(dp 단위)
        setTextSize(textSize);

        setTextColor(Color.WHITE);  //글자의 색이 하얀색으로 나오는 것을 볼 수 있음.
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {    //버튼을 손가락으로 터치했을 때 호출되는 메소드
        int action = event.getAction(); //action 값을 통해 손가락을 누르거나 손가락을 눌러서 움직일 때를 구분해준다.

        switch(action) {
            case MotionEvent.ACTION_DOWN:   //손가락을 눌렀을 때
                setBackgroundResource(R.drawable.title_bitmap_button_clicked);

                break;
            case MotionEvent.ACTION_UP:
                setBackgroundResource(R.drawable.title_bitmap_button_normal);
                break;
        }
        invalidate(); //이미지가 바뀌었을 때 다시 그려달라고 요청을 한다.

        return true;
    }

}
