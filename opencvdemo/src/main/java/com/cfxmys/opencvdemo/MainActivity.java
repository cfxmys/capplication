package com.cfxmys.opencvdemo;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.BindView;
import demos.cfxmys.com.baselibrary.BaseActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.pic_process)
    Button mProcess;
    @BindView(R.id.image)
    ImageView mTestImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initOpenCV();
        mProcess = findViewById(R.id.pic_process);
        mTestImage = findViewById(R.id.image);
        mProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 获取资源文件对应的图像文件
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
                // 传给灰度转换方法
                convertGray(bitmap);
                mTestImage.setImageBitmap(bitmap);

            }
        });
    }

    @Override
    protected int initViewLayout() {
        return R.layout.main_activity;
    }

    private void initOpenCV() {
        boolean success = OpenCVLoader.initDebug();

    }

    private void convertGray(Bitmap bitmap) {
        Mat src = new Mat();
        Mat dst = new Mat();
        Utils.bitmapToMat(bitmap, src);
        Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
        Utils.matToBitmap(dst, bitmap);
        src.release();
        dst.release();
    }

}
