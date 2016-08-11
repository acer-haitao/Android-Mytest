package com.baidu;

import java.util.List;

import com.baidu.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class First_Activity extends Activity {

	private CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5;
	private TextView tv;
	private AlertDialog.Builder builder;
	private Button btn;
	private EditText edit1, edit2;
	private SharedPreferences sp;
	private Editor edit;
	private boolean flag;
	private String account;
	private String passwd;
	private SensorManager sm;
	private Button btn1;
	private Button listview;

	;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_layout);
		// ��ȡ�༭��(editΪ����ý��)
		sp = getSharedPreferences("init", MODE_PRIVATE);
		edit = sp.edit();
		account = sp.getString("accunt", null);
		passwd = sp.getString("passwd", null);
		flag = sp.getBoolean("flag", false);
		// �����Ұ�ť����
		findbutton();
		// ��ס����
		passwd();
		// ��ȡ�������б�
		getsenor();
		// ���õ�������¼�����Ӧ�¼�
		onclicklistener();

	}

	public void passwd() {
		if (flag) {
			edit1.setText(account);
			edit2.setText(passwd);
			checkbox5.setChecked(true);
		}
	}

	@Override
	// �����˳�����
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (checkbox5.isChecked()) {
			edit.putString("accunt", edit1.getText().toString());
			edit.putString("passwd", edit2.getText().toString());
			edit.putBoolean("flag", true);
			edit.commit();
		} else {
			edit.clear();
			edit.commit();
		}
	}

	public void findbutton() {
		/* ��ѡ��ť��� */
		checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
		checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
		checkbox3 = (CheckBox) findViewById(R.id.checkbox3);
		checkbox4 = (CheckBox) findViewById(R.id.checkbox4);
		tv = (TextView) findViewById(R.id.tv);
		// ��ʾ�Ի���
		btn = (Button) findViewById(R.id.buton);
		// ��ס����
		edit1 = (EditText) findViewById(R.id.edit1);
		edit2 = (EditText) findViewById(R.id.edit2);
		checkbox5 = (CheckBox) findViewById(R.id.checkbox5);
		//��ת��sensorinfoҳ��
		btn1 = (Button) findViewById(R.id.sensor1);
		listview = (Button) findViewById(R.id.listview);
	}

	// ��ȡ�������б�
	public void getsenor() {
		SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		// ��ȡ�������б�
		List<Sensor> list = sm.getSensorList(Sensor.TYPE_ALL);
		TextView tv = (TextView) findViewById(R.id.sensor);

		for (Sensor s : list)// ��ǿ��forѭ������
		{
			tv.append("\n���������֣�" + s.getName());// �Ѵ�������ʾ
		}

	}

	public void onclicklistener() {
		// ѡ��ѡ���ı���ʾλ���е�bug��
		checkbox1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					tv.append(checkbox1.getText() + " ");
				} else {
					CharSequence text = tv.getText();
					String string = text.toString();
					String replace = string.replace(checkbox1.getText() + " ",
							" ");
					tv.setText(replace);
				}
			}
		});
		checkbox2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					tv.append(checkbox2.getText() + " ");
				} else {
					CharSequence text = tv.getText();
					String string = text.toString();
					String replace = string.replace(checkbox2.getText() + " ",
							" ");
					tv.setText(replace);
				}
			}
		});
		checkbox3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					tv.append(checkbox3.getText() + " ");
				} else {
					CharSequence text = tv.getText();
					String string = text.toString();
					String replace = string.replace(checkbox3.getText() + " ",
							" ");
					tv.setText(replace);
				}
			}
		});
		checkbox4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					tv.append(checkbox4.getText() + " ");
				} else {
					CharSequence text = tv.getText();
					String string = text.toString();
					String replace = string.replace(checkbox4.getText() + " ",
							" ");
					tv.setText(replace);
				}
			}
		});

		// ��ʾ�Ի���
		builder = new Builder(First_Activity.this);
		builder.setTitle("��ֵ");
		builder.setMessage("�ף�ȷ�ϳ�ֵ100Ԫ������");
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(First_Activity.this, "��ֵʧ��", 1).show();
			}
		});

		builder.setPositiveButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(First_Activity.this, "��ֵ�ɹ�", 1).show();
			}
		});
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(First_Activity.this, "����ѡ�����ĳ�ֵ����", 1).show();
				builder.create().show();
			}
		});
		//��ת���ڶ���ҳ����Ϣ����
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(First_Activity.this, Sensor_Info.class);
				startActivity(i);
			}
		});
		//��ת��listview
		listview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent i = new Intent(First_Activity.this,ListView_list.class);	
			startActivity(i);
			}
		});
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		menu.add(Menu.NONE, 0, 1, "����");
		menu.add(Menu.NONE, 0, 1, "ͼ��");
		menu.add(Menu.NONE, 0, 1, "�ļ�");
		menu.add(Menu.NONE, 0, 1, "ͼƬ");
		menu.add(Menu.NONE, 0, 1, "΢��");
		menu.add(Menu.NONE, 0, 1, "QQ");
		menu.add(Menu.NONE, 0, 1, "�ʼ�");
		return true;
	}

}
