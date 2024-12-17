package com.example.bismillah.others

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bismillah.auth.presentation.ui.SigninScreen
import com.example.bismillah.auth.presentation.ui.SignupScreen
import com.example.bismillah.auth.SplashScreen
import com.example.bismillah.auth.StartScreen
import com.example.bismillah.auth.presentation.viewModel.AuthView
import com.example.bismillah.features.HomeScreen
import com.example.bismillah.features.Kalkulator.nutritionStatusCalculator
import com.example.bismillah.features.Konsultasi.Spesialis.Anak.spesialisAnakPage
import com.example.bismillah.features.Konsultasi.Spesialis.Gizi.spesialisGizi
import com.example.bismillah.features.Konsultasi.konsultasiScreen
import com.example.bismillah.features.Konten.KontenScreen
import com.example.bismillah.features.Konten.MiePage
import com.example.bismillah.features.Konten.PopSiclePage
import com.example.bismillah.features.Konten.sushiPage
import com.example.bismillah.features.Perkembangan.PerkembanganScreen
import com.example.bismillah.features.Pertumbuhan.PertumbuhanScreen
//import com.example.bismillah.features.VaksinScreen
import androidx.compose.runtime.getValue
import com.example.bismillah.features.Pertumbuhan.AddGrowthScreen
import com.example.bismillah.features.Konsultasi.Spesialis.Anak.DickyPage
import com.example.bismillah.features.Konsultasi.Spesialis.Anak.MayaPage
import com.example.bismillah.features.Konsultasi.Spesialis.Anak.PaulPage
import com.example.bismillah.features.Konsultasi.Spesialis.Anak.StellaPage
import com.example.bismillah.features.Konsultasi.Spesialis.Anak.SylviaPage
import com.example.bismillah.features.Konsultasi.Spesialis.Gizi.JonathanPage
import com.example.bismillah.features.Konsultasi.Spesialis.Gizi.MarianaPage
import com.example.bismillah.features.Konsultasi.Spesialis.Gizi.MichellePage
import com.example.bismillah.features.Konsultasi.Spesialis.Gizi.OliviaPage
import com.example.bismillah.features.Konsultasi.Spesialis.Gizi.VikaPage
import com.example.bismillah.features.Profil.profileScreen

@Composable
fun NavGraph(navController: NavHostController, authViewModel: AuthView){
    val authState by authViewModel.authState.observeAsState()

    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Start.route){
            StartScreen(navController)
        }
        composable(Screen.SignIn.route) {
            SigninScreen(navController, authViewModel)
        }
        composable(Screen.SignUp.route){
            SignupScreen(navController, authViewModel)
        }
        composable(Screen.Home.route){
            HomeScreen(navController)
        }
        composable(Screen.Profil.route){
            profileScreen(navController, authViewModel)
        }
        composable(Screen.Konten.route){
            KontenScreen(navController)
        }
        composable(Screen.Tumbuh.route){
            PertumbuhanScreen(navController)
        }
        composable(Screen.Kembang.route){
            PerkembanganScreen(navController)
        }
        composable(Screen.Sushi.route){
            sushiPage(navController)
        }
        composable(Screen.Popsicle.route){
            PopSiclePage(navController)
        }
        composable(Screen.Mie.route){
            MiePage(navController)
        }
        composable(Screen.SpesialisGizi.route){
            spesialisGizi(navController)
        }
        composable(Screen.SpesialisAnak.route){
            spesialisAnakPage(navController)
        }
        composable(Screen.Konsultasi.route){
            konsultasiScreen(navController)
        }
        composable(Screen.Kalkulator.route){
            nutritionStatusCalculator(navController)
        }
        composable(Screen.TambahTumbuh.route){
            AddGrowthScreen(navController)
        }
        composable(Screen.Vika.route) {
            VikaPage(navController)
        }
        composable(Screen.Michelle.route) {
            MichellePage(navController)
        }
        composable(Screen.Jonathan.route) {
            JonathanPage(navController)
        }
        composable(Screen.Olivia.route) {
            OliviaPage(navController)
        }
        composable(Screen.Mariana.route) {
            MarianaPage(navController)
        }
        composable(Screen.Stella.route){
            StellaPage(navController)
        }
        composable(Screen.Paul.route){
            PaulPage(navController)
        }
        composable(Screen.Maya.route){
            MayaPage(navController)
        }
        composable(Screen.Dicky.route){
            DickyPage(navController)
        }
        composable(Screen.Sylvia.route){
            SylviaPage(navController)
        }
    }
}

// Define the screens in your app
sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Start : Screen("start")
    data object SignIn : Screen("signIn")
    data object SignUp : Screen("signup")
    data object Home : Screen("home")
    data object Konten : Screen("konten")
    data object Konsultasi : Screen("konsultasi")
    data object Profil : Screen ("profil")
    data object Tumbuh : Screen("tumbuh")   // Rute baru
    data object Kembang : Screen("kembang")   // Rute baru
    //data object Vaksin : Screen("vaksin")
    data object Sushi : Screen("sushi")
    data object Popsicle : Screen("Popsicle")
    data object Mie : Screen("mie")
    data object SpesialisAnak : Screen("spesialisAnak")
    data object SpesialisGizi : Screen("spesialisGizi")
    data object Kalkulator : Screen("kalkulator")
    data object TambahTumbuh : Screen("tambahTumbuh")

    //data object list dokter gizi
    data object Vika : Screen("vikaPage")
    data object Michelle : Screen("michellePage")
    data object Jonathan : Screen("jonathanPage")
    data object Olivia : Screen("oliviaPage")
    data object Mariana : Screen("marianaPage")

    //data object list dokter anak
    data object Stella : Screen("stellaPage")
    data object Paul : Screen("paulPage")
    data object Maya : Screen("mayaPage")
    data object Dicky : Screen("dickyPage")
    data object Sylvia : Screen("sylviaPage")

}