package com.sendy.FloodFillExample;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.sendy.FloodFillView.FloodFillView;

import org.xdty.preference.colorpicker.ColorPickerDialog;
import org.xdty.preference.colorpicker.ColorPickerSwatch;


public class MainActivity extends AppCompatActivity {

    private FloodFillView mIvImage;
    private Button mBtnSelectColor;
    private Button mBtnRedo;
    private Bitmap originalBitmap;
    private Bitmap currentBitmap;
    private Bitmap oldBitmap;
    private int currentX, currentY;
    private int mSelectedColor = Color.BLUE;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mIvImage.setMaxZoom(15);
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inScaled = false;
        originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.animal10, o);
        mIvImage.setImageBitmap(originalBitmap);
        currentBitmap = originalBitmap.copy(originalBitmap.getConfig(), true);
        oldBitmap = originalBitmap;

        mIvImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        currentX = (int) event.getX();
                        currentY = (int) event.getY();

                        float devVsImgRatio = mIvImage.drawableWidthForDeviceRelated / originalBitmap.getWidth();
                        PointF point = mIvImage.transformCoordTouchToBitmap(event.getX(), event.getY(), true);
                        currentX = (int) (point.x / devVsImgRatio);
                        currentY = (int) (point.y / devVsImgRatio);
                        Bitmap bitmap = currentBitmap;
                        //floodFill(bitmap, currentX, currentY, mSelectedColor, Color.BLACK, 50);
                        mIvImage.FloodFill(bitmap, currentX, currentY, mSelectedColor, Color.BLACK, 0);
                        mIvImage.setImageBitmap(bitmap);
                        break;
                }
                return true;
            }
        });

    }

    private void initView() {
        mIvImage = (FloodFillView) findViewById(R.id.ivImage);
        mBtnSelectColor = (Button) findViewById(R.id.btn_select_color);
        mBtnRedo = (Button) findViewById(R.id.btn_redo);

        mBtnSelectColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectedColor = ContextCompat.getColor(MainActivity.this, R.color.flamingo);
                int[] mColors = getResources().getIntArray(R.array.default_rainbow);

                ColorPickerDialog dialog = ColorPickerDialog.newInstance(R.string.color_picker_default_title,
                        mColors,
                        mSelectedColor,
                        5,
                        ColorPickerDialog.SIZE_SMALL);

                dialog.setOnColorSelectedListener(new ColorPickerSwatch.OnColorSelectedListener() {

                    @Override
                    public void onColorSelected(int color) {
                        mSelectedColor = color;
                    }

                });

                dialog.show(getFragmentManager(), "color_dialog_test");
            }
        });

        mBtnRedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmapo = currentBitmap;
                mIvImage.Redu(bitmapo, Color.WHITE, Color.BLACK, 0);
                mIvImage.setImageBitmap(bitmapo);

            }
        });
    }
}
