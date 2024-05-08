package com.abby.metro.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abby.metro.R

@Composable
fun LoginX() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            val uiColor=if (isSystemInDarkTheme()) Color.White else Black
            Box(
                contentAlignment = Alignment.TopCenter
            ) {
                 Image(
                     modifier = Modifier
                         .fillMaxWidth()
                         .fillMaxHeight(fraction = 0.46f),
                     painter = painterResource
                     (id = R .drawable.shape),
                     contentDescription =null,
                     contentScale = ContentScale.FillBounds)

                Row (modifier = Modifier.padding(top=80.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        modifier = Modifier.size(42.dp),
                        painter = painterResource(id = R.drawable.bus),
                        contentDescription = stringResource(id = R.string.app_logo),
                        tint = uiColor
                    )
                    Spacer(modifier =Modifier.width(15.dp) )
                    Column {
                        Text(text = stringResource(id = R.string.Metro),
                            style = MaterialTheme.typography.headlineMedium,
                            color = uiColor
                        )
                        Text(text = stringResource(id = R.string.Bus),
                            style = MaterialTheme.typography.headlineMedium,
                            color = uiColor
                        )
                    }
                }
                Text(
                    modifier = Modifier.padding(bottom = 10.dp)
                        .align(alignment = Alignment.BottomCenter),
                    text = stringResource(id = R.string.Login),
                    style = MaterialTheme.typography.headlineLarge,
                    color = uiColor
                )
            }

        }

    }

}