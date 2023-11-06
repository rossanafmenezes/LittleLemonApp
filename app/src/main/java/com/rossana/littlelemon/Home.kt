package com.rossana.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rossana.littlelemon.ui.theme.LittleLemonColor

@Composable
fun Home(navController: NavHostController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            HomeHeader(navController)
        }
        item {
            Spacer(modifier = Modifier.size(16.dp))
        }
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = LittleLemonColor.green)
                        .padding(8.dp), horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column() {
                        Text(
                            text = "Little Lemon", style = MaterialTheme.typography.titleMedium,
                            color = LittleLemonColor.yellow, fontWeight = FontWeight.Bold
                        )
                        Column(modifier = Modifier.fillMaxWidth(0.5f)) {
                            Text(
                                text = "Chicago", style = MaterialTheme.typography.titleSmall,
                                color = LittleLemonColor.cloud, fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text =
                                "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                                style = MaterialTheme.typography.bodySmall,
                                color = LittleLemonColor.cloud
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                        }
                    }

                    Column(verticalArrangement = Arrangement.Center) {
                        Image(
                            painter = painterResource(R.drawable.hero_image),
                            contentDescription = "Hero Image",
                            modifier = Modifier
                                .fillMaxWidth(0.6f)
                                .clip(RoundedCornerShape(8.dp))
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                    }

                }
            }
        }
    }
}

@Composable
fun HomeHeader(navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(50.dp)
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Profile",
            modifier = Modifier
                .size(50.dp)
                .clickable {
                    navController.navigate(Profile.route)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home(rememberNavController())
}