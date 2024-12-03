package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication2.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // 调用主界面
                InputScreen()
            }
        }
    }
}

@Composable
fun InputScreen() {
    var inputText by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("结果显示在这里") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 输入框
        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("输入字符串") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp)) // 间距

        // 确认按钮
        Button(
            onClick = {
                resultText = if (inputText.isNotEmpty()) {
                    "输入成功：$inputText" // 显示输入结果
                } else {
                    "请输入有效的字符串"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("确认")
        }

        Spacer(modifier = Modifier.height(16.dp)) // 间距

        // 结果显示
        Text(
            text = resultText,
            style = MaterialTheme.typography.bodyMedium // 使用 Material3 的 typography 样式
        )
    }
}
