package com.example.edittextview_master.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class DrawableEditText extends RelativeLayout {

	private Context mContext;
	private EditTextDel mEditText;
	private ImageView mImage;
	
	// �ı���Ϊ�� ͼƬ��Դ
	private int imgRes;
	// �ı���Ϊ�� ͼƬ��Դ
	private int nullImgRes;
	//ɾ����ťͼƬ��Դ
	private int delImgRes;

	public DrawableEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		
		delImgRes = attrs.getAttributeResourceValue(null, "delImgRes", 0);
		imgRes = attrs.getAttributeResourceValue(null, "imgRes", 0);
		nullImgRes = attrs.getAttributeResourceValue(null, "nullImgRes", 0);
		
		init();

		// �õ�ͼƬ��Դ
		if (nullImgRes != 0) {
			setDrawable();
		}

		// �������ִ�С
		int textSize = attrs.getAttributeResourceValue(null, "textSize", 0);
		if (textSize != 0) {
			mEditText.setTextSize(textSize);
		}

		// ����edittext��hint��ʾ
		int hint = attrs.getAttributeResourceValue(null, "hint", 0);
		if (hint != 0) {
			mEditText.setHint(hint);
		}

		// �����ı���ɫ
		int textColor = attrs.getAttributeResourceValue(null, "textColor", 0);
		if (textColor != 0) {
			mEditText.setTextColor(textColor);
		}
	}

	// ��ʼ�����ֺͿؼ�
	public void init() {
		LinearLayout layout = new LinearLayout(mContext);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		mEditText=new EditTextDel(mContext,delImgRes);
		mEditText.setBackgroundResource(0);
		mImage=new ImageView(mContext);
		layout.addView(mImage);
		layout.addView(mEditText);
		mImage.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
		mEditText.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,1));
		this.addView(layout);
		
	}

	// �����ı����Ƿ�Ϊ�����ò�ͬ��ͼƬ
	private void setDrawable() {
		if (mEditText.getText().toString().equals("")) {
			mImage.setImageResource(nullImgRes);
		} else {
			mImage.setImageResource(imgRes);
		}
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		// �ı����text�ı����
		mEditText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				setDrawable();
			}
		});
		
	}

	/**
	 * @description ������Ƿ�������
	 * @return
	 */
	public boolean isEmpty() {
		return getText() == null || getText().length() == 0 ? true : false;
	}

	/**
	 * @description ��ȡ������ڵ�����
	 * @return
	 */
	public String getText() {
		return mEditText.getText().toString();
	}

	/**
	 * @description ����������ڵ�����
	 * @return
	 */
	public void setText(String s) {
		mEditText.setText(s);
	}
}
