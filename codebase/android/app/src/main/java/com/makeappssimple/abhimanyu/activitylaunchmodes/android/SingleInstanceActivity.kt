package com.makeappssimple.abhimanyu.activitylaunchmodes.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.makeappssimple.abhimanyu.activitylaunchmodes.android.ui.theme.ActivityLaunchModesTheme

private const val ACTIVITY_NAME = "SingleInstanceActivity"

class SingleInstanceActivity : ComponentActivity() {
    private var count = mutableStateOf(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityLaunchModesTheme {
                ActivityView(
                    count = count.value,
                    events = CounterEvents(
                        onAdd = {
                            Log.e("Abhi", count.toString())
                            count.value += 1
                        },
                        onSubtract = {
                            Log.e("Abhi", count.toString())
                            count.value -= 1
                        }
                    )
                )
            }
        }
    }
}

@Composable
private fun ActivityView(
    count: Int,
    events: CounterEvents,
) {
    CommonUI(
        name = ACTIVITY_NAME,
        count = count,
        events = events,
    )
}
