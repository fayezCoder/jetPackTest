package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                MyText(my_text.value)
                MyTextField()
                MyOutLineTextField()
                MyButton()
            }
        }
    }
}
@Composable
fun MyText(text:String){
    Text(text = text,
        color = Color.Black,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 25.sp,
        textDecoration = TextDecoration.None,
        letterSpacing = 3.sp
    )// TextView
}
@Composable
fun MyTextField (){


    val textValue = remember {
        mutableStateOf("")
    }
    TextField(
        value = textValue.value,
        onValueChange = { text ->
            textValue.value = text
        },
        label = {
            Text(text = stringResource(id = R.string.text_field))
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = colorResource(id = R.color.purple_700),
            focusedBorderColor = colorResource(id = R.color.purple_200)

        )

    )

}
@Composable
fun MyOutLineTextField(){

    val textValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = textValue.value,
        onValueChange = { text ->
            textValue.value = text
        },
        label = {
            Text(text = stringResource(id = R.string.out_lin_text_field))
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = colorResource(id = R.color.purple_700),
            focusedBorderColor = colorResource(id = R.color.purple_200)
        )

    )
}

val my_text = mutableStateOf("")

@Composable
fun MyButton (){

    Button(onClick = {
        my_text.value = "This Is my text"
    },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.teal_700)),
        border = BorderStroke(
            4.dp,
            color = colorResource(id = R.color.purple_200)
        )

    ) {
        Text(
            text = stringResource(id = R.string.my_button),
            color = Color.Black
        )

    }
}
