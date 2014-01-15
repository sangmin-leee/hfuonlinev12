package de.hfu.onlineshopv_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.xmlpull.v1.XmlSerializer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.util.Xml;
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
        //this.addListenerOnButten();

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
					
					
					/*
					File newxmlfile = new File("/storage/sdcard0/external_sd/" + name +".xml");
					try {
					    newxmlfile.createNewFile();
					} catch (IOException e) {
					     Log.e("IOException", "Exception in create new File(");
					}
					
					FileOutputStream fos = null;
					try{
						fos = new FileOutputStream(newxmlfile);

					} catch(FileNotFoundException e) {
					Log.e("FileNotFoundException",e.toString());
					}
					
					//getApplicationContext().openFileOutput(newxmlfile);
					
					XmlSerializer xmls = Xml.newSerializer();
					//StringWriter sw = new StringWriter();
					
					try {
						xmls.setOutput(fos,"UTF-8");
						xmls.startDocument("UTF-8", true);
						xmls.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
						  
						// Open tag
						xmls.startTag(null, "user-data");
						// Values
						xmls.startTag("", "name");
						xmls.text(name);
						xmls.endTag("", "name");
						xmls.startTag("", "password");
						xmls.text(password);
						xmls.endTag("", "password");
						xmls.startTag("", "phonenumber");
						xmls.text(phonenumber);
						xmls.endTag("", "phonenumber");
						xmls.startTag("", "email");
						xmls.text(email);
						xmls.endTag("", "email");
						xmls.startTag("", "address");
						xmls.text(address);
						xmls.endTag("", "address");
						// End tag
						xmls.endTag(null, "user-data");
						xmls.endDocument();
						xmls.flush();
						fos.close();
						
						
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					// Start xml document
					;
					//if submit button is clicked
					 * 
					 */
					
					break;
					
					
					
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
