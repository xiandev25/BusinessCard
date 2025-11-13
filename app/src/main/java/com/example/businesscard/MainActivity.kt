package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            //.systemBarsPadding()
            .background(color = Color(0xFFA6D0BA)),
    ) {
        PersonalInformationSection(
            modifier = Modifier
                .weight(weight = 3F)
        )
        ContactSection(
            modifier = Modifier
                .weight(weight = 1F)
        )
    }
}

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column {
            ContactItem(
                itemIcon = Icons.Rounded.Phone,
                itemContent = "+11 (123) 444 555 666",
                itemContentDescription = null
            )
            ContactItem(
                itemIcon = Icons.Rounded.Share,
                itemContent = "@AndroidDev",
                itemContentDescription = null,
                modifier = Modifier
                    .padding(
                        top = 12.dp,
                        bottom = 12.dp
                    )
            )
            ContactItem(
                itemIcon = Icons.Rounded.Email,
                itemContent = "jen.doe@android.com",
                itemContentDescription = null
            )
        }
    }
}

@Composable
fun ContactItem(
    itemIcon: ImageVector,
    itemContent: String,
    itemContentDescription: String?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Icon(
            imageVector = itemIcon,
            contentDescription = itemContentDescription,
            tint = Color(color = 0xFF218D50),
        )
        Spacer(
            modifier = Modifier
                .size(size = 10.dp)
        )
        Text(
            text = itemContent,
            fontSize = 12.sp
        )
    }
}

@Composable
fun PersonalInformationSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .background(color = Color.Black)
        )
        Text(
            text = "Jennifer Doe",
            fontSize = 36.sp
        )
        Text(
            text = "Android Developer Extraordinaire",
            color = Color(0xFF218D50),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}