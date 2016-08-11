package com.baidu;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Sensor_Info extends Activity implements SensorEventListener {
	private SensorManager sm;
	private Sensor Orientation;
	private Sensor light;
	private Sensor accelerometer;
	private TextView etori;
	private TextView etacc;
	private TextView etlight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sensorinfo);
		
		sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		Orientation = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
		accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

		sm.registerListener(this, Orientation, SensorManager.SENSOR_DELAY_GAME);
		sm.registerListener(this, light, SensorManager.SENSOR_DELAY_GAME);
		sm.registerListener(this, accelerometer,
				SensorManager.SENSOR_DELAY_GAME);
		findbutton();

	}

	public void findbutton() {

		etori = (TextView) findViewById(R.id.etori);
		etacc = (TextView) findViewById(R.id.etacc);
		etlight = (TextView) findViewById(R.id.etlight);

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		float[] values = event.values;// (�Ѽ�������ֵ���浽values����)

		switch (event.sensor.getType()) {// �жϴ����������Ͱ���Ӧ��������ʾ���ı���ȥ
		case Sensor.TYPE_ORIENTATION:
			etori.setText("��Z��ת���ĽǶȣ�" + values[0] + "\n��X��ת���ĽǶȣ�" + values[1]
					+ "\n��Y��ת���ĽǶȣ�" + values[2]);
			break;
		case Sensor.TYPE_ACCELEROMETER:
			etacc.setText("X�᷽���ϵļ��ٶȣ�" + values[0] + "\nY�᷽���ϵļ��ٶȣ�" + values[1]
					+ "\nZ�᷽���ϵļ��ٶȣ�" + values[2]);
			break;
		case Sensor.TYPE_LIGHT:
			etlight.setText("��ǰ����ǿ��Ϊ��" + values[0]);
			break;
		default:
			break;
		}
}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}
}
