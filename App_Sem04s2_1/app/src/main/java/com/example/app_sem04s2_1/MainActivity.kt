package com.example.app_sem04s2_1

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

val CAMERA_REQUEST_CODE = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCamara = findViewById<Button>(R.id.btCamara)

        btCamara.setOnClickListener {
            checkCameraPermission()
        }
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED){
            //permiso rechazado
            requestCameraPermission()
        }
        else{
            Toast.makeText(this, "Ya se tiene el permiso de la camara", Toast.LENGTH_LONG).show()
        }
    }

    private fun requestCameraPermission() {
        //solicitamos el permiso
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CAMERA)){
            Toast.makeText(this, "Rechazó el permiso antes. Habilítelo!!", Toast.LENGTH_LONG).show()
        }
        else{
            //el usuario nunca pidio ni nego el permiso
            Toast.makeText(this, "Debe aceptar el permiso", Toast.LENGTH_LONG).show()
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode){
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Se aceptó el permiso de la CAMARA", Toast.LENGTH_LONG).show()
                    //Aqui se pondría toda la funcionalidad
                }
                else{
                    Toast.makeText(this, "Permiso negado", Toast.LENGTH_LONG).show()
                }
                return
            }
        }
    }
}