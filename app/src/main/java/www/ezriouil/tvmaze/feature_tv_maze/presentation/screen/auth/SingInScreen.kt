package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.auth

import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import www.ezriouil.tvmaze.R
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component.CustomButton
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component.CustomText
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component.CustomTextField
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component.TextFieldType
import www.ezriouil.tvmaze.feature_tv_maze.presentation.view_model.SingInViewModel
import www.ezriouil.tvmaze.util.ManageUI
import www.ezriouil.tvmaze.util.Resource

@Composable
fun SingInScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: SingInViewModel = hiltViewModel()
) {
    val btnIsEnable = Patterns.EMAIL_ADDRESS.matcher(viewModel.emailTextField).matches() &&
            viewModel.emailTextField.isNotBlank() &&
            viewModel.passwordTextField.any { it.isLetter() } &&
            viewModel.passwordTextField.any { it.isDigit() }
    val result by viewModel.singInState.collectAsState()

    LaunchedEffect(result) {
        when (result) {
            is Resource.Loading -> Unit
            is Resource.Error -> Log.d("TAG", (result as Resource.Error).error)
            is Resource.Success -> {
                if ((result as Resource.Success).data) {
                    navHostController.navigate(ManageUI.HomeScreen.route)
                }
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //signIn
        CustomText(
            text = stringResource(R.string.sing_in),
            textColor = Color.White,
            textSize = 30,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(22.dp))
        CustomTextField(
            value = viewModel.emailTextField,
            onValueChange = { viewModel.emailTextField = it },
            label = stringResource(R.string.email),
            type = TextFieldType.EMAIL,
            textFieldColors = Color.White,
            backgroundColor = Color.Black,
        )
        Spacer(modifier = modifier.height(8.dp))
        CustomTextField(
            value = viewModel.passwordTextField,
            onValueChange = { viewModel.passwordTextField = it },
            label = stringResource(R.string.password),
            type = TextFieldType.PASSWORD,
            textFieldColors = Color.White,
            backgroundColor = Color.Black
        )
        Spacer(modifier = modifier.height(22.dp))
        CustomButton(
            onClick = {
                viewModel.onSubmit(
                    email = viewModel.emailTextField,
                    password = viewModel.passwordTextField
                )
            },
            text = stringResource(R.string.ok),
            enable = btnIsEnable
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CustomText(
                text = stringResource(R.string.you_do_not_have_acc),
                textColor = Color.LightGray,
                textSize = 12,
                fontWeight = FontWeight.ExtraLight,
                textAlign = TextAlign.Right,
                modifier = modifier.padding(end = 3.dp)
            )
            CustomText(
                text = stringResource(R.string.singUp), textColor = Color.White,
                textSize = 15,
                fontWeight = FontWeight.Light,
                textDecoration = TextDecoration.Underline,
                modifier = modifier.clickable {
                    navHostController.navigate(ManageUI.SingUpScreen.route) {
                        popUpTo(ManageUI.SingInScreen.route) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            )
        }
    }

    if (result == Resource.Loading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            ) {
                CircularProgressIndicator(
                    color = Color.White,
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .padding(25.dp)
                )
            }
        }
    }
}