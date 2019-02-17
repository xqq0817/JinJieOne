package com.example.daytwozuoye;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button yuanx;
    private Button yaunj;
    private Button kg;
    private Button donghua;
    private SimpleDraweeView img;
    private Button zhujie;
    private Button fanshe;
    private Uri parse;
    private Uri uris;
    private GenericDraweeHierarchyBuilder builder;
    private RoundingParams mparams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //资源ID
        initView();
        parse=Uri.parse("http://www.zhaoapi.cn/images/quarter/ad1.png");
        uris=Uri.parse("http://www.zhaoapi.cn/images/girl.gif");
        builder = new GenericDraweeHierarchyBuilder(getResources());


    }
    //资源ID
    private void initView() {
        yuanx = (Button) findViewById(R.id.yuanx);
        yaunj = (Button) findViewById(R.id.yaunj);
        kg = (Button) findViewById(R.id.kg);
        donghua = (Button) findViewById(R.id.donghua);
        img = (SimpleDraweeView) findViewById(R.id.img);
        zhujie = (Button) findViewById(R.id.zhujie);
        fanshe = (Button) findViewById(R.id.fanshe);
        yuanx.setOnClickListener(this);
        yaunj.setOnClickListener(this);
        kg.setOnClickListener(this);
        donghua.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //圆形
            case R.id.yuanx:
                mparams = RoundingParams.asCircle();
                GenericDraweeHierarchy buildyx = builder.setRoundingParams(mparams).build();
                img.setHierarchy(buildyx);
                img.setImageURI(parse);
                break;
                //圆角
            case R.id.yaunj:
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(50f);
                GenericDraweeHierarchy build = builder.setRoundingParams(roundingParams).build();
                img.setHierarchy(build);
                img.setImageURI(parse);
                break;
            case R.id.kg:
                img.setAspectRatio(2.71f);
                break;
            case R.id.donghua:
                AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(uris)
                        .setAutoPlayAnimations(true)
                        .setOldController(img.getController())
                        .build();
                img.setController(controller);
                break;
        }
    }
}
