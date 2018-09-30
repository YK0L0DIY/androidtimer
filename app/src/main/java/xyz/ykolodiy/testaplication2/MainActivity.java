package xyz.ykolodiy.testaplication2;

import android.drm.DrmStore;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int seconds=0;
    int minutes=0;
    int houers=0;
    String sthours="00";
    String stminutes="00";
    String stsecond="00";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView timer= (TextView) findViewById(R.id.timer);
        timer.setText("00:00:00");

        final Button startTimer= findViewById(R.id.startTimer);
        startTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Handler handler=new Handler();

                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        if(seconds==60){
                            seconds=0;
                            minutes++;
                            if(minutes==60){
                                minutes=0;
                                houers++;
                                if(houers<10){
                                    sthours="0"+houers;
                                }else {
                                    sthours=String.format("%s",houers);
                                }

                                timer.setText(String.format("%s:%s:%s",sthours,minutes,seconds));
                            }
                            if(minutes<10){
                                stminutes="0"+minutes;
                            }else {
                                sthours=String.format("%s",minutes);
                            }
                            timer.setText(String.format("%s:%s:%s",sthours,stminutes,stsecond));

                        }
                        if(seconds<10){
                            stsecond="0"+seconds;
                        }else {
                            stsecond=String.format("%s",seconds);
                        }
                        timer.setText(String.format("%s:%s:%s",sthours,stminutes,stsecond));
                        seconds++;
                        handler.postDelayed(this, 1000);
                    }
                };
                handler.postDelayed(runnable,1);
            }
        });

    }
}
