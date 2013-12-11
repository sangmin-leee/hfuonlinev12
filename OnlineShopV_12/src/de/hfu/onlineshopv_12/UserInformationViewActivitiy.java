package de.hfu.onlineshopv_12;

import java.io.File;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserInformationViewActivitiy extends Activity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information_view);
        this.addListenerOnButten();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_information_view_activitiy, menu);
        return true;
    }
    
    
    public void addListenerOnButten()
    {
    	Button submitB;
    	Button resetB;
    	OnClickListener cListener;
    	
        /****************Init*****************/
        submitB = (Button)findViewById(R.id.submitButton);
        resetB = (Button)findViewById(R.id.resetButton);
        /*************************************/
        
        
        
        /***********Click Listener**************/
        cListener = new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				String name = new String();
				String password = new String();
				String phonenumber = new String();
				String email = new String();
				String address = new String();
				
				EditText textField;
				
				switch(v.getId())
				{
				case R.id.submitButton:			
					textField = (EditText)findViewById(R.id.nameField);
					name = textField.getText().toString();
					
					textField = (EditText)findViewById(R.id.passwordField);
					password = textField.getText().toString();
					
					textField = (EditText)findViewById(R.id.phoneField);
					phonenumber = textField.getText().toString();
					
					textField = (EditText)findViewById(R.id.emailField);
					email = textField.getText().toString();
					
					textField = (EditText)findViewById(R.id.addressField);
					address = textField.getText().toString();
					
					File f = new File("c:/"+name+".xml");
					
					break;
					//if submit button is clicked
					
					
				case R.id.resetButton:
					
					textField = (EditText)findViewById(R.id.nameField);
					textField.setText("");
					
					textField = (EditText)findViewById(R.id.passwordField);
					textField.setText("");
					
					textField = (EditText)findViewById(R.id.emailField);
					textField.setText("");
					
					textField = (EditText)findViewById(R.id.phoneField);
					textField.setText("");
					
					
					textField = (EditText)findViewById(R.id.addressField);
					textField.setText("");
					
					break;
					//if reset button is clicked
				default:
					break;
				}
				
			}
        	
        };
        /********************************/
        
        
        /*********add***************/
        submitB.setOnClickListener(cListener);
        resetB.setOnClickListener(cListener);
        /*************************/
    }
    
    
}
