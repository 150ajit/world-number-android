package com.example.worldpopulation.presentation.datasource

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.domain.model.DataSourceMetadata
import com.example.worldpopulation.ui.theme.CyanAccent
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun DataSourceInfoScreen(
    metadataList: List<DataSourceMetadata>,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Navigate back",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "DATA SOURCES & TRACEABILITY",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Primary Demographic Provider",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = CyanAccent
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Provider: United Nations Population Division", fontWeight = FontWeight.SemiBold)
                    Text("Dataset: World Population Prospects (WPP)", fontSize = 13.sp)
                    Text("Revision: 2024 Revision", fontSize = 13.sp)
                    Text("Reference Year: 2026", fontSize = 13.sp)
                    Text("Classification: Medium Variant Projection", fontSize = 13.sp)
                    Text("Source URL: https://population.un.org/wpp/", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Supplementary Indicator Provider",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = CyanAccent
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Provider: The World Bank", fontWeight = FontWeight.SemiBold)
                    Text("Dataset: World Development Indicators", fontSize = 13.sp)
                    Text("Revision: 2024 Edition", fontSize = 13.sp)
                    Text("Reference Year: 2023–2024", fontSize = 13.sp)
                    Text("Classification: Official Estimates", fontSize = 13.sp)
                    Text("Source URL: https://data.worldbank.org/", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Data Integrity Policy",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "• All numbers originate from authoritative United Nations or World Bank public data.\n" +
                                "• No demographic statistics are fabricated or artificially simulated.\n" +
                                "• Historical records, official estimates, projections, and calculated metrics are explicitly identified.\n" +
                                "• When data is unavailable, 'Data not available' is shown instead of placeholder values.",
                        style = MaterialTheme.typography.bodySmall,
                        lineHeight = 20.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
