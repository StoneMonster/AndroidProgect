package com.moster.titletextview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.monster.titletextview.R;

public class TitleTextView extends LinearLayout {

	private View mLeftLine, mRightLine;
	private TextView mTitleText;
	private int mLineColor;
	private int mTitleTextColor;
	private float mTitleTextDim;

	public TitleTextView(Context context) {
		super(context);
		initView(context);
	}

	public TitleTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
		initDate(context, attrs);
	}

	private void initView(Context context) {
		View view = View.inflate(context, R.layout.titletext_view, this);
		mLeftLine = view.findViewById(R.id.left_line);
		mRightLine = view.findViewById(R.id.right_line);
		mTitleText = (TextView) view.findViewById(R.id.title_text);
	}

	private void initDate(Context context, AttributeSet attrs) {
		//��ȡdeclare-styleable����
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleText);
		//�Ӽ�����ȡ�����Ӧ��ֵ
		String mText = typedArray.getString(R.styleable.TitleText_titletext);
		if(!isInEditMode()){
			//�ڶ���ֵ��û�����ø�������ʹ�õ�Ĭ��ֵ
			mLineColor = typedArray.getColor(R.styleable.TitleText_linecolors, Color.BLACK);
			mTitleTextColor = typedArray.getColor(R.styleable.TitleText_titletextcolor, Color.BLACK);
			mTitleTextDim = typedArray.getDimension(R.styleable.TitleText_titletextsize, getResources().getDimension(R.dimen.adefault_textsize));
			//��������
			mTitleText.setText(mText);
			mTitleText.setTextColor(mTitleTextColor);
			mTitleText.setTextSize(mTitleTextDim);
			mLeftLine.setBackgroundColor(mLineColor);
			mRightLine.setBackgroundColor(mLineColor);
		}
		//�ر���Դ
		typedArray.recycle();
	}
}