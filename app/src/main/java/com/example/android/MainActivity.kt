package com.example.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.android.ui.theme.ExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ContactRow(contact = Contact(name = "Taro", number = "090-1234-5678"))
                }
            }
        }
    }
}

@Composable
fun ContactRow(
    contact: Contact,
    modifier: Modifier = Modifier,
) {
    var selected by remember { mutableStateOf(false) }

    Row(modifier) {
        ContactDetails(contact)
        ToggleButton(selected, onToggled = { selected = !selected })
    }
}

@Composable
fun ToggleButton(
    selected: Boolean,
    onToggled: (Boolean) -> Unit,
) {
    Switch(checked = selected, onCheckedChange = onToggled)
}

@Composable
fun ContactDetails(contact: Contact) {
    Text(text = "Name ${contact.name}, Number: ${contact.number}")
}

data class Contact(var name: String, val number: String)
