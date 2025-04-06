package com.example.tutorial_application.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorial_application.R

@Composable
fun LoginWidget(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            LoginTopAppBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        bottom = 64.dp
                    ),
                text = "必要なログイン情報をご入力ください",
            )
            InputTextField()
            Spacer(modifier = Modifier.height(50.dp))
            LoginButton()
            Spacer(modifier = Modifier.height(42.dp))
            OrDivider()
            Spacer(modifier = Modifier.height(35.dp))
            LoginButtonByGoogle()
            Spacer(modifier = Modifier.height(9.dp))
            LoginButtonByMail()
            Spacer(modifier = Modifier.height(47.dp))
            SignUpWithLink()

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "LOG IN",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        },
    )
}

@Composable
fun InputTextField() {
    var userId by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }


    Column(
        modifier = Modifier.padding(horizontal = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp
                ),
            text = "ユーザーID",
        )
        OutlinedTextField(
            value = userId,
            onValueChange = { userId = it },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
        )

        Spacer(modifier = Modifier.height(19.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp
                ),
            text = "パスワード",
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
        )
    }
}

@Composable
fun LoginButton() {

    Column{
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC6A457) // ボタンの背景色を指定
            ),
            onClick = {
                TODO("ログイン処理をここに実装してください")
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 32.dp
                )
                .height(50.dp)
        ) {
            Text(
                text = "ログイン",
                color = Color.White,
            )
        }
    }
}

@Composable
fun OrDivider() {

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(
                horizontal = 32.dp
            )
    ) {
        Row(
            modifier = Modifier.padding(vertical = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f))
            Text(" OR ", modifier = Modifier.padding(horizontal = 8.dp), color = Color.Gray)
            HorizontalDivider(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun LoginButtonByGoogle() {
    Column{
        OutlinedButton(
            onClick = {
                TODO("google ログイン処理をここに実装")
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 32.dp
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.icons8_google_96), // 追加した画像を指定
                contentDescription = "google logo",
                modifier = Modifier.padding(end = 44.dp)
            )
            Text(
                text = "Googleでログイン",
                color = Color.Black,
                modifier = Modifier.padding(end = 20.dp)
            )
        }
    }
}

@Composable
fun LoginButtonByMail() {
    Column{
        OutlinedButton(
            onClick = {
                TODO("mail ログイン処理をここに実装")
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 32.dp
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mail_icon), // 追加した画像を指定
                    contentDescription = "mail logo",
                )
            }
            Text(
                text = "メールアドレスでログイン",
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}

@Composable
fun SignUpWithLink() {
    val annotatedString = buildAnnotatedString {
        append("会員登録の方は ")

        val start = length
        append("こちら")
        addStyle(
            SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            ),
            start,
            length
        )
        addStringAnnotation(
            tag = "URL",
            annotation = "#", // 遷移先の画面を指定
            start = start,
            end = length
        )
    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    )
    {
        ClickableText(
            text = annotatedString,
            onClick = { offset ->
                annotatedString.getStringAnnotations(tag = "URL", start = offset, end = offset)
                    .firstOrNull()?.let { annotation ->
                        println("開くURL: ${annotation.item}") // 実際のアプリではブラウザを開く処理を実装
                    }
            }
        )

    }
}

@Preview(device = Devices.PIXEL_7)
@Composable
fun LoginViewPreview() {
    LoginWidget()
}