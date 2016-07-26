package com.monster.titlebar;

import com.monster.titlebar.view.TitleBar;
import com.monster.titlebar.view.TitleBar.TitleBarClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends Activity {
    private TitleBar titleBar;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleBar = (TitleBar) findViewById(R.id.titleBar);
        titleBar.setTitleBarClickListener(new TitleBarClickListener() {
			
			@Override
			public void rightClick() {
				Toast.makeText(MainActivity.this, "·ÖÏí", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void leftClick() {
				Toast.makeText(MainActivity.this, "·µ»Ø", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
