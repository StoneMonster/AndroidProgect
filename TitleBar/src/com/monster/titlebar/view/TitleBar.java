package com.monster.titlebar.view;

import com.monster.titlebar.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class TitleBar extends RelativeLayout {

	private TitleBarClickListener listener;
	private Button leftButton;
	private Button rightButton; 
	
	public TitleBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public TitleBar(Context context) {
		this(context, null, 0);
	}

	public TitleBar(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
		
		String leftText = typedArray.getString(R.styleable.TitleBar_leftText);
		float leftTextSize = typedArray.getDimension(R.styleable.TitleBar_leftTextSize, 0);
		int leftTextColor = typedArray.getColor(R.styleable.TitleBar_leftTextColor, 0);
		Drawable leftBackground = typedArray.getDrawable(R.styleable.TitleBar_leftBackground);
		leftButton = new Button(context);
		leftButton.setText(leftText);
		leftButton.setTextSize(leftTextSize);
		leftButton.setTextColor(leftTextColor);
		leftButton.setBackgroundColor(Color.TRANSPARENT);
		if(leftBackground != null){
			leftBackground.setBounds(0, 0, 58, 58);
			leftButton.setCompoundDrawables(null, leftBackground, null, null);
		}
		LayoutParams leftParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
		this.addView(leftButton, leftParams);
		
		String rightText = typedArray.getString(R.styleable.TitleBar_rightText);
		float rightTextSize = typedArray.getDimension(R.styleable.TitleBar_rightTextSize, 0);
		int rightTextColor = typedArray.getColor(R.styleable.TitleBar_rightTextColor, 0);
		Drawable rightBackground = typedArray.getDrawable(R.styleable.TitleBar_rightBackground);
		rightButton = new Button(context);
		rightButton.setText(rightText);
		rightButton.setTextSize(rightTextSize);
		rightButton.setTextColor(rightTextColor);
		rightButton.setBackgroundColor(Color.TRANSPARENT);
		if(rightBackground != null){
			rightBackground.setBounds(0, 0, 58, 58);
			rightButton.setCompoundDrawables(null, rightBackground, null, null);
		}
		LayoutParams rightParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
		this.addView(rightButton, rightParams);
		
		String centerText = typedArray.getString(R.styleable.TitleBar_centerText);
		float centerTextSize = typedArray.getDimension(R.styleable.TitleBar_centerTextSize, 0);
		int centerTextColor = typedArray.getColor(R.styleable.TitleBar_centerTextColor, 0);
		Drawable centerBackground = typedArray.getDrawable(R.styleable.TitleBar_centerBackground);
		Button centerButton = new Button(context);
		centerButton.setText(centerText);
		centerButton.setTextSize(centerTextSize);
		centerButton.setTextColor(centerTextColor);
		centerButton.setBackgroundColor(Color.TRANSPARENT);
		if(centerBackground != null){
			centerBackground.setBounds(0, 0, 374, 60);
			centerButton.setCompoundDrawables(null, centerBackground, null, null);
		}
		LayoutParams centerParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		centerParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		this.addView(centerButton, centerParams);
		
		int titleBarBackgroundColor = typedArray.getColor(R.styleable.TitleBar_titleBarBackgroundColor, 0);
		setBackgroundColor(titleBarBackgroundColor);
		
		typedArray.recycle();
		
		leftButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.leftClick();
			}
		});
		rightButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.rightClick();
			}
		});
	}

	public interface TitleBarClickListener{
		public void leftClick();
		public void rightClick();
	}
	public void setTitleBarClickListener(TitleBarClickListener listener){
		this.listener = listener;
	}
	
	public void setLeftVisible(boolean flag) {
		if (flag) {
			this.leftButton.setVisibility(View.VISIBLE);
		} else {
			this.leftButton.setVisibility(View.GONE);
		}
	}
	public void setRightVisible(boolean flag) {
		if (flag) {
			this.rightButton.setVisibility(View.VISIBLE);
		} else {
			this.rightButton.setVisibility(View.GONE);
		}
	}
	
}
