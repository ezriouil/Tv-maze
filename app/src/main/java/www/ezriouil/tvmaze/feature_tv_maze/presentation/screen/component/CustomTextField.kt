package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import www.ezriouil.tvmaze.ui.theme.Bg_TF
import www.ezriouil.tvmaze.ui.theme.Kaiseiopti

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    backgroundColor: Color = Bg_TF,
    textFieldColors: Color = Color.Black,
    hintStyle: TextStyle = MaterialTheme.typography.subtitle2,
    type: TextFieldType,
    maxLiens: Int = 1,
    singleLine: Boolean = true,
) {
    var passwordInvisible by remember { mutableStateOf(true) }
    OutlinedTextField(
        value = value,
        maxLines = maxLiens,
        singleLine = singleLine,
        textStyle = TextStyle(
            fontFamily = Kaiseiopti,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            color = textFieldColors
        ),
        label = { Text(text = label, style = hintStyle, color = textFieldColors) },
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(66.dp)
            .padding(horizontal = 8.dp)
            .shadow(elevation = 0.dp),
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = textFieldColors,
            unfocusedIndicatorColor = textFieldColors,
            focusedLabelColor = textFieldColors,
            disabledIndicatorColor = textFieldColors,
            focusedIndicatorColor = textFieldColors,
            backgroundColor = backgroundColor
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = when (type) {
                TextFieldType.PASSWORD -> KeyboardType.Password
                TextFieldType.TEXT -> KeyboardType.Text
                TextFieldType.EMAIL -> KeyboardType.Email
            }
        ),
        leadingIcon = {
            when (type) {
                TextFieldType.PASSWORD -> {
                    Icon(
                        imageVector = Icons.Default.Password,
                        contentDescription = null,
                        tint = textFieldColors
                    )
                }
                TextFieldType.TEXT -> {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = textFieldColors
                    )
                }
                TextFieldType.EMAIL -> {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null,
                        tint = textFieldColors
                    )

                }
            }
        },
        visualTransformation =
        when (type) {
            TextFieldType.PASSWORD -> {
                if (!passwordInvisible) VisualTransformation.None
                else PasswordVisualTransformation()
            }
            else -> VisualTransformation.None
        },
        trailingIcon = {
            when (type) {
                TextFieldType.PASSWORD -> {
                    Icon(
                        modifier = modifier.clickable { passwordInvisible = !passwordInvisible },
                        imageVector = if (passwordInvisible) Icons.Default.CodeOff else Icons.Default.Code,
                        contentDescription = null,
                        tint = textFieldColors
                    )
                }
                else -> null
            }
        }
    )
}

enum class TextFieldType {
    TEXT, PASSWORD, EMAIL
}