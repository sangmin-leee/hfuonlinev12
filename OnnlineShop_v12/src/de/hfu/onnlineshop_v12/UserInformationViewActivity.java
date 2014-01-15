package de.hfu.onnlineshop_v12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.xmlpull.v1.XmlSerializer;

import android.os.Bundle;
import android.app.Activity;
import android.util.Xml;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class UserInformationViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_information_view);
		this.addListenerOnButton();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_information_view, menu);
		return true;
	}

	public void addListenerOnButton()
	{
		Button submitB;
		Button resetB;
		OnClickListener cListener;
		
		
		submitB = (Button)findViewById(R.id.submitButton);
		resetB = (Button)findViewById(R.id.resetButton);
		
		
		
		submitB.setOnClickListener(new OnClickListener()
		{

			String name = new String();
			String password = new String();
			String phonenumber = new String();
			String email = new String();
			String address = new String();
			
			EditText textField;
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textField = (EditText)findViewById(R.id.nameField);
				name = textField.getText().toString();
				
				textField = (EditText)findViewById(R.id.passwordField);
				password = textField.getText().toString();

				textField = (EditText)findViewById(R.id.phoneField);
				phonenumber = textField.getText().toString();
				
				textField = (EditText)findViewById(R.id.addressField);
				address = textField.getText().toString();
				
				File newxmlFile = new File("/storage/sdcard0/" + name + ".xml");
				try {
					newxmlFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				FileOutputStream fos = null;
				
				try {
					fos = new FileOutputStream(newxmlFile);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				XmlSerializer xmls = Xml.newSerializer();
				
				try {
					xmls.setOutput(fos,"UTF-8");
					

					// Start xml document
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
				
				}
			
		});
		
		resetB.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				EditText textField;
				
				textField = (EditText)findViewById(R.id.nameField);
				textField.setText("");
				
				textField = (EditText)findViewById(R.id.passwordField);
				textField.setText("");
				
				textField = (EditText)findViewById(R.id.phoneField);
				textField.setText("");
				
				textField = (EditText)findViewById(R.id.emailField);
				textField.setText("");
				
				textField = (EditText)findViewById(R.id.addressField);
				textField.setText("");
			}
			
		});
		
		/*
		cListener = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) {
				String name = new String();
				String password = new String();
				String phonenumber = new String();
				String email = new String();
				String address = new String();
				
				EditText textField;
				
				switch(arg0.getId())
				{
				case R.id.submitButton:
					textField = (EditText)findViewById(R.id.nameField);
					name = textField.getText().toString();
					
					textField = (EditText)findViewById(R.id.passwordField);
					password = textField.getText().toString();

					textField = (EditText)findViewById(R.id.phoneField);
					phonenumber = textField.getText().toString();
					
					textField = (EditText)findViewById(R.id.addressField);
					address = textField.getText().toString();
					
					break;
					
				case R.id.resetButton:
					textField = (EditText)findViewById(R.id.nameField);
					textField.setText("");
					
					textField = (EditText)findViewById(R.id.passwordField);
					textField.setText("");
					
					textField = (EditText)findViewById(R.id.phoneField);
					textField.setText("");
					
					textField = (EditText)findViewById(R.id.email);
					textField.setText("");
					
					textField = (EditText)findViewById(R.id.addressField);
					textField.setText("");
					
					break;
					
				
				default:
					break;	
				}
			}
		};
		*/
	}

}
