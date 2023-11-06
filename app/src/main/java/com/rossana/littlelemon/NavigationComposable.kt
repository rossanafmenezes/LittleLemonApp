package com.rossana.littlelemon

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Onboarding.route) {
        composable(Onboarding.route) {
            Onboarding()
        }
        composable(Home.route) {

        }
        composable(Profile.route) {

        }
    }
}