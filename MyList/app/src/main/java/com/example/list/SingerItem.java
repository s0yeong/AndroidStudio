package com.example.list;

public class SingerItem {
    //MainActivity파일에서 사용할 각 SingerItem의 정보들을 담은 파일이다.

    // 데이터를 편리하게 담아둘 수 있는 메서드 또는 이 안에서 사용할 수 있는 메서드를 생성한다.
    String name;
    String mobile;
    int resId;

    public SingerItem(String name, String mobile, int resId) {
        this.name = name;
        this.mobile = mobile;
        this.resId = resId;
    }

    // 변수에 직접 접근하는 것을 권장하지 않으므로 get과 set 메서드를 이용하여 접근한다.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    // 객체 안에 있는 데이터를 확인하고 싶을 경우 다음과 같이 toString 메서드를 호출하여 문자열로 출력한다.
    @Override
    public String toString() {
        return "SingerItem{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
