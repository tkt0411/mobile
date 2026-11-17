package ddwu.com.mobile.mvvmsample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel : ViewModel(){
    private var _countValue by mutableStateOf(0)

    val countValue: Int
        get() = _countValue

    fun fetchCount(value:String){
        viewModelScope.launch {
            var i = value.toInt()
            while (i >= 0) {
                _countValue = i--
                delay(1000)
            }
        }
    }
}