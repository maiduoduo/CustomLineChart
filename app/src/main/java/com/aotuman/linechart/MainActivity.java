package com.aotuman.linechart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LineChartView mLineChartView;
    //X轴
    String[] xItem = {"04/01 07:50","04/02 07:50","04/03 07:50","04/04 07:50","04/05 07:50"
            ,"04/06 07:50","04/07 07:50","04/08 07:50","04/09 07:50","04/10 07:50"};
//        String[] xItem = {"04/01 07:50","04/02 07:50","04/03 07:50","04/04 07:50"};

    //Y轴
    int[] yItem = {18,35,22,38,22,30,22,30,10,25};

    //X轴
    String[] xItem2 = {"04/01 07:50","04/02 07:50","04/03 07:50","04/04 07:50","04/05 07:50"
            ,"04/06 07:50","04/07 07:50","04/08 07:50","04/09 07:50","04/10 07:50"
            ,"04/06 07:50","04/07 07:50","04/08 07:50","04/09 07:50","04/10 07:50"
            ,"04/06 07:50"};
    int[] yItem2 = {1000,800,500,250,500,250,500,250,500,250,500,250,500,250,500,250};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLineChartView = (LineChartView) findViewById(R.id.lineChart);
        setLineData(xItem,yItem);

    }

    private void setLineData(String[] xItem,int[] yItem) {
        ArrayList xItemArray = new ArrayList();
        for (int i = 0; i < xItem.length; i++) {
            xItemArray.add(xItem[i]);
        }
        ArrayList<Integer> yItemArray = new ArrayList<>();
        for (int i = 0; i < yItem.length; i++) {
            yItemArray.add(yItem[i]);
        }
        int yMax = findMax(yItem);
        mLineChartView.setXItem(xItemArray);
        mLineChartView.setYItem(yItemArray);
        mLineChartView.setMaxYValue(yMax);
    }

    // 获得数组中最大值
    private int findMax(int[] array){
        int max = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i]>max) max=array[i];
        }
        return max;
    }

    private int updateIndex = 0;
    public void updateToggle(View view) {
        if (0 == updateIndex) {
            setLineData(xItem2, yItem2);
            updateIndex = 1;
        }else if (1 == updateIndex) {
            setLineData(xItem, yItem);
            updateIndex = 0;
        }
    }
}
