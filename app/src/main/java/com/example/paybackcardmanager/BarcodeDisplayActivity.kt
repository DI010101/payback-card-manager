package com.example.paybackcardmanager

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix

class BarcodeDisplayActivity : AppCompatActivity() {
    
    private lateinit var barcodeImage: ImageView
    private lateinit var cardNameText: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barcode_display)
        
        // View Binding manuell
        barcodeImage = findViewById(R.id.barcode_image)
        cardNameText = findViewById(R.id.card_name)
        
        // Vollbildmodus
        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_FULLSCREEN or
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        )
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        
        // Test-Barcode anzeigen
        cardNameText.text = "Test Karte"
        displayBarcode("1234567890123", "CODE_128")
        
        findViewById<View>(R.id.root).setOnClickListener {
            finish()
        }
    }
    
    private fun displayBarcode(data: String, barcodeType: String) {
        try {
            val format = when (barcodeType) {
                "QR_CODE" -> BarcodeFormat.QR_CODE
                else -> BarcodeFormat.CODE_128
            }
            
            val bitmap = encodeAsBitmap(data, format)
            barcodeImage.setImageBitmap(bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Fehler beim Generieren des Barcodes", Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun encodeAsBitmap(content: String, format: BarcodeFormat): Bitmap {
        val width = 800
        val height = if (format == BarcodeFormat.QR_CODE) 800 else 400
        
        val writer = MultiFormatWriter()
        val bitMatrix: BitMatrix = writer.encode(content, format, width, height)
        
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (bitMatrix[x, y]) 0xFF000000.toInt() else 0xFFFFFFFF.toInt())
            }
        }
        
        return bitmap
    }
}
