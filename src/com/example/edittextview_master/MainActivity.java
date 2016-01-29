package com.example.edittextview_master;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.edittextview_master.view.CircleImageDrawable;

public class MainActivity extends Activity implements OnClickListener{
	ImageView vc_image;
	private ImageView head;
	EditText v_code;
	Button bt_sure;
	String getCode=null;
	String code;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		vc_image=(ImageView)findViewById(R.id.vc_image);
		vc_image.setImageBitmap(Code.getInstance().getBitmap());
		bt_sure=(Button)findViewById(R.id.bt_sure);
		v_code=(EditText)findViewById(R.id.v_code);
		getCode=Code.getInstance().getCode();
		head=(ImageView)findViewById(R.id.head);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),  
                R.drawable.head);
		head.setImageDrawable(new CircleImageDrawable(bitmap));
		
		bt_sure.setOnClickListener(this);
		vc_image.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.vc_image:
			vc_image.setImageBitmap(Code.getInstance().getBitmap());
			getCode=Code.getInstance().getCode();
			break;
		case R.id.bt_sure:
			code=v_code.getText().toString();
			if(code==null||code.equals("")){
				Toast.makeText(MainActivity.this, "请填写验证码", 2).show();
			}else if(!code.equals(getCode)){
				Toast.makeText(MainActivity.this, "验证码错误", 2).show();
			}else Toast.makeText(MainActivity.this, "验证成功", 2).show();
			break;

		default:
			break;
		}
	}

}
