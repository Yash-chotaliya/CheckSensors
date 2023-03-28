package com.example.checksensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.checksensor.databinding.ActivityProximityBinding

class ProximityAct : AppCompatActivity(),SensorEventListener {

    private lateinit var binding: ActivityProximityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProximityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        if(sensor!=null){
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
        }
        else{
            Toast.makeText(this,"Sensor is not available",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event!=null){
            val x = "Value : " + event.values[0]
            binding.`val`.text = x
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}