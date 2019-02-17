package com.example.frescodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button yuanj;
    private Button yuanx;
    private Button bil;
    private Button jianj;
    private Button cip;
    private Button dongh;
    private Button jiant;
    private Button peiz;
    private SimpleDraweeView img;
    private Uri parse;
    private GenericDraweeHierarchyBuilder builder;
    private RoundingParams mparams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //资源ID
        initView();
        parse=Uri.parse("http://p5.so.qhimgs1.com/bdr/200_200_/t01fadcf3cc106e7afb.jpg");
        builder = new GenericDraweeHierarchyBuilder(getResources());

    }

    //资源ID
    private void initView() {
        yuanj = (Button) findViewById(R.id.yuanj);
        yuanx = (Button) findViewById(R.id.yuanx);
        bil = (Button) findViewById(R.id.bil);
        jianj = (Button) findViewById(R.id.jianj);
        cip = (Button) findViewById(R.id.cip);
        dongh = (Button) findViewById(R.id.dongh);
        jiant = (Button) findViewById(R.id.jiant);
        peiz = (Button) findViewById(R.id.peiz);
        img = (SimpleDraweeView) findViewById(R.id.img);

        yuanj.setOnClickListener(this);
        yuanx.setOnClickListener(this);
        bil.setOnClickListener(this);
        jianj.setOnClickListener(this);
        jiant.setOnClickListener(this);
        cip.setOnClickListener(this);
        dongh.setOnClickListener(this);
        peiz.setOnClickListener(this);
    }

    //根据相应的点击事件跳转至相应的功能页面
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //圆角
            case R.id.yuanj:
                //设置弧度
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(50f);
                GenericDraweeHierarchy build = builder.setRoundingParams(roundingParams).build();
                //加载图片控件
                img.setHierarchy(build);
                img.setImageURI(parse);
                break;
                //圆形
            case R.id.yuanx:
                mparams = RoundingParams.asCircle();
                GenericDraweeHierarchy buildyx = builder.setRoundingParams(mparams).build();
                img.setHierarchy(buildyx);
                img.setImageURI(parse);
                break;
                //比例
            case R.id.bil:
                break;
                //渐进
            case R.id.jianj:
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(parse)
                        //设置打开渐进模式
                        .setProgressiveRenderingEnabled(true)
                        .build();

                AbstractDraweeController draweeController = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setTapToRetryEnabled(true)
                        .setOldController(img.getController())
                        .build();
                img.setController(draweeController);
                break;
                //监听
            case R.id.jiant:
                break;
                //磁盘缓存
            case R.id.cip:
                break;
                //动画
            case R.id.dongh:



                break;
                //配置
            case R.id.peiz:
                break;
        }
    }

}
