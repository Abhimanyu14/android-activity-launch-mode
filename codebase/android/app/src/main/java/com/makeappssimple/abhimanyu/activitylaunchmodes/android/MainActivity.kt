package com.makeappssimple.abhimanyu.activitylaunchmodes.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.makeappssimple.abhimanyu.activitylaunchmodes.android.ui.theme.ActivityLaunchModesTheme

private const val ACTIVITY_NAME = "MainActivity"

open class Stu{}


data class CounterEvents(
    val onAdd: () -> Unit,
    val onSubtract: () -> Unit,
)

class MainActivity : ComponentActivity() {
    private var count = mutableStateOf(0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Abhi", "onCreate")
        startActivity(Intent(this, StandardActivity::class.java))
        finish()
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

    override fun onStart() {
        super.onStart()
        Log.e("Abhi", "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Abhi", "onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Abhi", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Abhi", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Abhi", "onDestroy")
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

@Composable
fun CommonUI(
    name: String,
    count: Int,
    events: CounterEvents,
) {
    val context = LocalContext.current
    var isNewTask by remember {
        mutableStateOf(false)
    }
    var isSingleTop by remember {
        mutableStateOf(false)
    }
    var isClearTop by remember {
        mutableStateOf(false)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 32.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = events.onSubtract,
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = null,
                )
            }
            Text(
                text = count.toString(),
                modifier = Modifier,
            )
            IconButton(
                onClick = events.onAdd,
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowForward,
                    contentDescription = null,
                )
            }
        }
        Text(
            text = name,
            modifier = Modifier,
        )
        Button(
            onClick = {
                val intent = Intent(context, StandardActivity::class.java)
                if (isNewTask) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                if (isSingleTop) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                }
                if (isClearTop) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                }
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 32.dp,
                ),
        ) {
            Text(
                text = "StandardActivity",
            )
        }
        Button(
            onClick = {
                val intent = Intent(context, SingleTopActivity::class.java)
                if (isNewTask) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                if (isSingleTop) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                }
                if (isClearTop) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                }
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 32.dp,
                ),
        ) {
            Text(
                text = "SingleTopActivity",
            )
        }
        Button(
            onClick = {
                val intent = Intent(context, SingleTaskActivity::class.java)
                if (isNewTask) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                if (isSingleTop) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                }
                if (isClearTop) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                }
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 32.dp,
                ),
        ) {
            Text(
                text = "SingleTaskActivity",
            )
        }
        Button(
            onClick = {
                val intent = Intent(context, SingleInstanceActivity::class.java)
                if (isNewTask) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                if (isSingleTop) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                }
                if (isClearTop) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                }
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 32.dp,
                ),
        ) {
            Text(
                text = "SingleInstanceActivity",
            )
        }
        Button(
            onClick = {
                val intent = Intent(context, SingleInstancePerTaskActivity::class.java)
                if (isNewTask) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                if (isSingleTop) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                }
                if (isClearTop) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                }
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 32.dp,
                ),
        ) {
            Text(
                text = "SingleInstancePerTaskActivity",
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 32.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = isNewTask,
                onCheckedChange = {
                    isNewTask = it
                },
            )
            Text(
                text = "NEW_TASK",
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 32.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = isSingleTop,
                onCheckedChange = {
                    isSingleTop = it
                },
            )
            Text(
                text = "SINGLE_TOP",
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 32.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = isClearTop,
                onCheckedChange = {
                    isClearTop = it
                },
            )
            Text(
                text = "CLEAR_TOP",
            )
        }
    }
}
