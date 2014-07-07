package com.danielme.tipsandroid.intents;

import java.util.Date;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

/**
 * 
 * @author danielme.com
 * 
 */
public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void search(View view)
	{
		Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
		intent.putExtra(SearchManager.QUERY, "android");
		startActivity(intent);
	}

	public void share(View view)
	{
		Intent intent = new Intent(android.content.Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "asunto");
		intent.putExtra(Intent.EXTRA_TEXT, "contenido del mensaje");
		startActivity(Intent.createChooser(intent, "Compartir usando"));
	}

	public void youtube(View view)
	{
		Intent intent = new Intent(Intent.ACTION_SEARCH);
		intent.setPackage("com.google.android.youtube");
		// la cadena a buscar
		intent.putExtra("query", "zz top i need you tonight");
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		try
		{
			startActivity(intent);
		}
		catch (ActivityNotFoundException e)
		{
			Toast.makeText(this, R.string.not_available, Toast.LENGTH_SHORT).show();
		}
	}

	public void contact(View view)
	{
		Intent contactIntent = new Intent(Intent.ACTION_INSERT);

		contactIntent.setType(ContactsContract.Contacts.CONTENT_TYPE);
		contactIntent.putExtra(ContactsContract.Intents.Insert.NAME, "Richard Parker");
		contactIntent.putExtra(ContactsContract.Intents.Insert.EMAIL, "mail@mail.com");
		contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, "666-777");

		startActivity(contactIntent);
	}

	public void events(View view)
	{
		Intent intent = new Intent(Intent.ACTION_EDIT);
		intent.setType("vnd.android.cursor.item/event");
		intent.putExtra("beginTime", new Date());
		intent.putExtra("allDay", false);
		intent.putExtra("endTime", new Date());
		intent.putExtra("title", "Cita médica");
		intent.putExtra("description", "Acudir a la cita médica con el resultado de las pruebas");
		startActivity(Intent.createChooser(intent, "Seleccione una aplicación"));
	}

	public void play(View view)
	{
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("market://details?id=com.danielme.muspyforandroid"));
		startActivity(intent);
	}

	public void media(View view)
	{
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.parse("http://freedownloads.last.fm/download/552080591/Aurora.mp3"), "audio/mpeg");
		startActivity(intent);
	}

	public void email(View view)
	{
		Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:mail@gmail.com"));
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
		emailIntent.putExtra(Intent.EXTRA_TEXT, "body");
		startActivity(Intent.createChooser(emailIntent, "Seleccione una aplicación"));
	}
}