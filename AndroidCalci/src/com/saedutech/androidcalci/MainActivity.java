package com.saedutech.androidcalci;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	int stash=0,display=0;
	char operator=' ';
	
	TextView display_view,stash_view,operator_view; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);      
        // Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        
        // collect all required UI elements
        display_view = (TextView) findViewById(R.id.dynamic_display);
    	stash_view = (TextView) findViewById(R.id.calc_stash_display);
    	operator_view = (TextView) findViewById(R.id.operator_display);
    	
    	
    	RelativeLayout btnContainer = (RelativeLayout) findViewById(R.id.button_container);
        // Set listeners to all number buttons
        BtnClickListener btnClickListener = new BtnClickListener();
        
        for(int i=0;i<btnContainer.getChildCount();i++){
        	Button number_button = (Button) btnContainer.getChildAt(i);
        	number_button.setOnClickListener(btnClickListener);
        }
        
        LinearLayout opBtnContainer = (LinearLayout) findViewById(R.id.operations_btn_container);
        // Set listener for all operation buttons
        OpBtnClickListener opBtnClickListener = new OpBtnClickListener();
        for(int i=0;i<opBtnContainer.getChildCount();i++){
        	Button operator_button = (Button) opBtnContainer.getChildAt(i);
        	operator_button.setOnClickListener(opBtnClickListener);
        }
        
        //set listener for clear button
        ((Button) findViewById(R.id.btn_clear)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        //set listener for equal to button
        ((Button) findViewById(R.id.btn_equal)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    // update display function
 	public void updateDisplay(){
 		Log.d("update_fun",display + " " +stash + " " + operator);
 		display_view.setText(String.valueOf(display));
 		stash_view.setText(String.valueOf(stash));
 		operator_view.setText(String.valueOf(operator));
 	}
    
	// define button_click listener
	class BtnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try{
				Button pressed_btn = (Button) v;
				char pressed_digit = pressed_btn.getText().charAt(0);
				if (display==0){
					display = Integer.parseInt(String.valueOf(pressed_digit));
				}else{
					display = Integer.parseInt((String.valueOf(display) + String.valueOf(pressed_digit))); 
				}
				updateDisplay();
						
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	// define operation_btn_click listener
	class OpBtnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try{
				Button pressed_btn = (Button) v;
				char pressed_op = pressed_btn.getText().charAt(0);
				operator = pressed_op;
				stash = display;
				display = 0;
				
				updateDisplay();
						
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}

}
