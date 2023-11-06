package com.rossana.littlelemon

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rossana.littlelemon.ui.theme.LittleLemonColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("user_info", Context.MODE_PRIVATE)

    val firstName = sharedPref.getString("first_name", "")
    val lastName = sharedPref.getString("last_name", "")
    val email = sharedPref.getString("email", "")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        item { Header() }

        item{
            Text(
                text = "Personal Information:",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item{ Spacer(modifier = Modifier.height(20.dp)) }

        item{
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "First name")
                OutlinedTextField(
                    value = firstName!!,
                    onValueChange = { },
                    readOnly = true,
                    enabled = false,
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = LittleLemonColor.cloud
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Last name")
                OutlinedTextField(
                    value = lastName!!,
                    onValueChange = { },
                    readOnly = true,
                    enabled = false,
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = LittleLemonColor.cloud
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Email")
                OutlinedTextField(
                    value = email!!,
                    onValueChange = { },
                    readOnly = true,
                    enabled = false,
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = LittleLemonColor.cloud
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                Column(

                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 20.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedButton(
                            onClick = {
                                navController.navigate(Onboarding.route)
                                sharedPref.edit().clear().apply()
                                sharedPref.edit().putBoolean("onboarding_complete", false).apply()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            border = BorderStroke(2.dp, LittleLemonColor.green),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = LittleLemonColor.yellow,
                            )
                        ) {
                            Text(text = "Log Out")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Profile(rememberNavController())
}