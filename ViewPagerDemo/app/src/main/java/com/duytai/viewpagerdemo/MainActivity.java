package com.duytai.viewpagerdemo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<IntroSlide> introSlides = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ViewPager2 viewPager = findViewById(R.id.viewPager);

        introSlides.add(new IntroSlide(R.drawable.z4929651213995_b465ff77ab36113f6dd097c6a1ee8503, "Chào mừng!", "Đây là ứng dụng giới thiệu sản phẩm tuyệt vời của chúng tôi."));
        introSlides.add(new IntroSlide(R.drawable.z4929651213995_b465ff77ab36113f6dd097c6a1ee8503, "Tính năng nổi bật", "Ứng dụng cung cấp nhiều tính năng hữu ích giúp bạn..."));
        introSlides.add(new IntroSlide(R.drawable.z4929651213995_b465ff77ab36113f6dd097c6a1ee8503, "Dễ sử dụng", "Giao diện thân thiện, dễ sử dụng cho mọi người."));

        viewPager.setAdapter(new IntroSlideAdapter(introSlides));
    }
}