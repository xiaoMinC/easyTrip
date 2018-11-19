package com.example.chen.easygo.utils.photo;


import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.chen.easygo.R;


@SuppressLint("InlinedApi")
public class PhotoPopupWindow extends PopupWindow {
    private Context mcontext;
    private OnClickListener onclick;
    
	public PhotoPopupWindow(Context mcontext, OnClickListener onclick) {
		super();
		this.mcontext = mcontext;
		this.onclick = onclick;
		init();
	}
	public void init(){
		 //填充管理服务
	      LayoutInflater inflater=(LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	      final View menuview=inflater.inflate(R.layout.photo_popup_window, null);
	      
	      TextView tv_camera=(TextView) menuview.findViewById(R.id.id_system_camera);
	      TextView tv_photo=(TextView) menuview.findViewById(R.id.id_system_photo);
	      TextView tp_cancel=(TextView) menuview.findViewById(R.id.id_take_cancel);
	      tv_camera.setOnClickListener(onclick);
	      tv_photo.setOnClickListener(onclick);
	      tp_cancel.setOnClickListener(onclick);
	      this.setContentView(menuview);
	      this.setWidth(LayoutParams.MATCH_PARENT);
	      this.setHeight(LayoutParams.MATCH_PARENT);
	      this.setFocusable(true);
	      menuview.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int h=menuview.findViewById(R.id.id_ll_get_photo).getTop();
				if(event.getAction()==MotionEvent.ACTION_UP){
				   if(event.getY()<h){
					   dismiss();
				   }
				}
				return true;
			}
		});
	}
    
}
