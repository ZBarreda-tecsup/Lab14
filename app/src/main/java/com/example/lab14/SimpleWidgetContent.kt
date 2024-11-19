package com.example.lab14

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionParametersOf
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.Text

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {

        provideContent {
            GlanceTheme {

                    MyContent()
            }
        }
    }

    @Composable
    private fun MyContent() {
        val DestinationKey = ActionParameters.Key<String>("destination")
        Column(
            modifier = GlanceModifier.fillMaxSize()
                .background(GlanceTheme.colors.background)
                .padding(16.dp),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "¿A dónde quieres dirigirte?", modifier = GlanceModifier.padding(12.dp))
            Button(
                text = "Página Principal",
                onClick = actionStartActivity<MainActivity>(
                    parameters = actionParametersOf(DestinationKey to "main")
                )
            )
            Spacer(modifier = GlanceModifier.height(30.dp))
            Button(
                text = "Página Secundaria",
                onClick = actionStartActivity<MainActivity>(
                    parameters = actionParametersOf(DestinationKey to "second")
                )
            )
        }
    }
}
