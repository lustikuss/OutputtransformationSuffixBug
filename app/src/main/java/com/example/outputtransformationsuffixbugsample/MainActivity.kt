package com.example.outputtransformationsuffixbugsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.foundation.text.input.insert
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ComposeView>(R.id.compose_view).apply {
            setContent {
                MaterialTheme {
                    Column(modifier = Modifier.padding(16.dp)) {
                        BasicTextField(
                            modifier = Modifier
                                .height(56.dp)
                                .border(width = 1.dp, Color.Red, shape = RoundedCornerShape(4.dp))
                                .padding(16.dp),
                            state = rememberTextFieldState(),
                            textStyle = MaterialTheme.typography.bodyMedium.copy(color = Color.Red),
                            outputTransformation = CurrencyOutputTransformation,
                            cursorBrush = SolidColor(Color.Red)
                        )
                        HorizontalDivider(Modifier.padding(16.dp))
                        BasicTextField(
                            modifier = Modifier
                                .height(56.dp)
                                .border(width = 1.dp, Color.Red, shape = RoundedCornerShape(4.dp))
                                .padding(16.dp),
                            state = rememberTextFieldState("100"),
                            textStyle = MaterialTheme.typography.bodyMedium.copy(color = Color.Red),
                            outputTransformation = CurrencyOutputTransformation,
                            cursorBrush = SolidColor(Color.Red)
                        )
                    }
                }
            }
        }
    }
}

object CurrencyOutputTransformation : OutputTransformation {
    override fun TextFieldBuffer.transformOutput() {
        if (asCharSequence().isNotBlank()) insert(length, " €")
    }
}