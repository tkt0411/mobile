package ddwu.com.mobile.mvvmsample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,

    countValue: Int = 0,
    onStartCounter: (String) -> Unit = {},
) {
    val coroutineScope = rememberCoroutineScope()

    var inputText by remember { mutableStateOf("") }

    Column(modifier = modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = inputText,
                onValueChange = { inputText = it },
                modifier = Modifier.weight(3f)
            )
            Button(
                onClick = {
//                    coroutineScope.launch {
//                        var i = inputText.toInt()
//                        while ( i >= 0) {
//                            countValue = i--
//                            delay(1000)
//                        }
//                    }
                    onStartCounter(inputText)
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text("확인")
            }
        }
        Text(
            text = "Received Value: $countValue",
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
