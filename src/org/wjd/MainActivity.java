package org.wjd;

import org.wjd.business.audio.AudioActivity;
import org.wjd.business.normal.NormalActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends BaseActivity
{

	private ListView listDemos;

	private Class<?>[] activitys = new Class[] { NormalActivity.class,
			AudioActivity.class };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listDemos = (ListView) findViewById(R.id.list_demos);
		listDemos.setAdapter(new ArrayAdapter<String>(getBaseContext(),
				android.R.layout.simple_list_item_1, android.R.id.text1,
				getResources().getStringArray(R.array.demos)));
		listDemos.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				startActivity(new Intent(getBaseContext(), activitys[position]));
			}
		});
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		getApp().exitApp();
	}
}
