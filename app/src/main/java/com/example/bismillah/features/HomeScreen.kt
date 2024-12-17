package com.example.bismillah.features

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.ui.theme.White
import com.example.bismillah.ui.theme.YaleBlue
import com.example.bismillah.ui.theme.Grey
import com.example.bismillah.R
import com.example.bismillah.ui.theme.Poppins
import com.example.bismillah.others.BottomBar
import androidx.navigation.NavHostController
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.example.bismillah.ui.theme.LemonChiffon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.draw.clip
import com.example.bismillah.others.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun HomeScreen(navController: NavHostController) {
    val auth = FirebaseAuth.getInstance()
    val firestore = FirebaseFirestore.getInstance()

    var userName by remember { mutableStateOf("") }
    var userAge by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(auth.currentUser) {
        val user = auth.currentUser
        user?.let {
            userName = it.displayName ?: it.email ?: "Nama Tidak Tersedia"

            val docRef = firestore.collection("users").document(it.uid)
            docRef.get().addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    userAge = document.getString("age") ?: "Tidak ada usia"
                } else {
                    userAge = "Tidak ada usia"
                }
                isLoading = false
            }.addOnFailureListener {
                isLoading = false
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFF7F7F7))
                .padding(start=16.dp, top=48.dp, end=16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UserProfileSection(userName, userAge)

            ActivityCategories(onCategoryClick = { category ->
                when (category) {
                    "Tumbuh" -> navController.navigate(Screen.Tumbuh.route)
                    "Kembang" -> navController.navigate(Screen.Kembang.route)
                    "Kalkulator" -> navController.navigate(Screen.Kalkulator.route)
                }
            })

            StuntingWarningSection()

//            Column {
//                Text(
//                    text = "Kegiatan Stimulasi",
//                    fontFamily = Poppins,
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
                    .fillMaxHeight()

            ) {
                PictureSection()
//                StimulationActivities()
                Spacer(modifier = Modifier.height(48.dp))
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        BottomBar(navController = navController, modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun UserProfileSection(userName: String, userAge: String) {
    Column(modifier = Modifier
        .fillMaxWidth()) {

        UserProfileImage(userName, userAge)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier.padding(9.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {

                    Spacer(modifier = Modifier.width(4.dp))

                    Column {
                        Text(
                            text = "Halo, $userName",
                            fontFamily = Poppins,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFC107)
                        )
                        Text(
                            text = "Selamat datang kembali di NutriC",
                            fontSize = 12.sp,
                            fontFamily = Poppins,
                            color = Color(0xFF0D3B66),
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier.padding(9.3.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "Selalu Pastikan",
                            fontFamily = Poppins,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFC107)
                        )
                        Text(text = "Tumbuh kembang anak sehat!", fontSize = 12.sp, color = Color(0xFF0D3B66), fontFamily = Poppins)
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(4.dp))
}

@Composable
fun UserProfileImage(userName: String, userAge: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = userName,
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFF0D3B66),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = userAge,
                fontFamily = Poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                color = Color.Gray,
            )
        }
        Spacer(modifier = Modifier.weight(1f))

    }
}
@Composable
fun ActivityCategories(onCategoryClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ActivityCategory(
            icon = painterResource(id = R.drawable.tumbuh),
            title = "Tumbuh",
            onClick = { onCategoryClick("Tumbuh") }
        )
        ActivityCategory(
            icon = painterResource(id = R.drawable.gizi),
            title = "Kembang",
            onClick = { onCategoryClick("Kembang") }
        )
        ActivityCategory(
            icon = painterResource(id = R.drawable.kembang),
            title = "Cek Gizi",
            onClick = { onCategoryClick("Kalkulator") }
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun ActivityCategory(icon: Painter, title: String, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = icon,
            contentDescription = title,
            modifier = Modifier
                .size(100.dp)
                .clickable(onClick = onClick),
            tint = Color.Unspecified
        )
        Text(
            text = title,
            fontFamily = Poppins,
            fontSize = 12.sp,
            color = Color(0xFF0D3B66),
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun StuntingWarningSection() {
    Card(
        backgroundColor = White,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Waspada Stunting! Kondisi ini dapat menghambat pertumbuhan dan perkembangan anak secara fisik dan kognitif. Pastikan asupan gizi tercukupi sejak dini!",
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    color = Color(0xFF0D3B66),
                    modifier = Modifier
                        .weight(2.5f)
                        .height(72.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun PictureSection() {
    Column {
            Image(
                painter = painterResource(id = R.drawable.landing),
                contentDescription = "Happy Kids",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),

            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Cegah Stunting, Wujudkan Generasi Cerdas!",
                fontFamily = Poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0D3B66),
                modifier = Modifier.padding(start=28.dp, top=12.dp, end=28.dp)
            )
    }
}


@Composable
//fun StimulationActivities() {
//    val activities = listOf(
//      "Ajak anak bermain menumpuk balok untuk melatih motorik halus",
//      "Perkenalkan anak pada berbagai suara, seperti suara burung, musik",
//      "Bantu anak belajar mengguling ke depan dan ke belakang",
//      "Dorong anak untuk meraih mainan yang dipegang di atas kepala atau di depan mereka",
//      "Ajak anak bermain dengan mainan bertekstur (bola berbulu atau mainan empuk)",
//      "Mainkan permainan ciluk-ba untuk membangun pemahaman anak tentang objek yang tidak terlihat",
//      "Biarkan anak merangkak di atas permukaan berbeda",
//      "Ajak anak melihat wajahnya di cermin kecil, biarkan dia mengenali bayangannya sendiri",
//      "Bermain sambil bernyanyi dan bertepuk tangan bersama anak agar ia belajar mengikuti irama dan kata-kata",
//      "Bacakan buku dengan gambar berwarna-warni, ajak anak menunjukkan atau menyebutkan benda-benda di dalamnya"
//  )
//
//  val checkboxStates = remember { mutableStateListOf(*List(activities.size) { false }.toTypedArray()) }
//
//  LaunchedEffect(Unit) {
//      loadCheckboxStates { states ->
//          checkboxStates.clear()
//          checkboxStates.addAll(states)
//      }
//  }

//  activities.forEachIndexed { index, activity ->
//      StimulationActivity(
//          activity = activity,
//          isChecked = checkboxStates[index],
//          onCheckedChange = { isChecked ->
//              checkboxStates[index] = isChecked
//              saveCheckboxStates(checkboxStates)
//          }
//      )
//  }
//}
//    Column {
//        Text(
//            text = "Kegiatan Stimulasi",
//            fontFamily = Poppins,
//            fontSize = 14.sp,
//            fontWeight = FontWeight.Bold
//        )
//        Spacer(modifier = Modifier.height(8.dp))

//    Spacer(modifier = Modifier.height(20.dp))
//}

//@Composable
// fun StimulationActivity(activity: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
//     Card(
//         backgroundColor = LemonChiffon,
//        shape = RoundedCornerShape(0.dp),
//        modifier = Modifier
//           .fillMaxWidth()
//           .padding(vertical = 6.dp)
//   ) {
//      Row(
//          modifier = Modifier
//              .fillMaxWidth()
//              .padding(5.dp),
//          horizontalArrangement = Arrangement.SpaceBetween,
//          verticalAlignment = Alignment.CenterVertically
//      ) {
//          Text(
//              text = activity,
//              modifier = Modifier.weight(1f),
//              fontFamily = Poppins,
//              fontSize = 12.sp
//          )
//          Checkbox(
//              checked = isChecked,
//              onCheckedChange = onCheckedChange
//          )
//      }
//  }
// }


// fun saveCheckboxStates(checkboxStates: List<Boolean>) {
//   val currentUser = FirebaseAuth.getInstance().currentUser
//  val firestore = FirebaseFirestore.getInstance()

//  currentUser?.let { user ->
//      firestore.collection("users")
//          .document(user.uid)
//          .collection("checkboxStates")
//          .document("states")
//          .set(mapOf("checkboxStates" to checkboxStates))
//          .addOnSuccessListener {
//              Log.d("Firestore", "Checkbox states saved successfully")
//      }
//          .addOnFailureListener { e ->
//              Log.e("Firestore", "Error saving checkbox states: ${e.message}")
//          }
//  }
// }

// fun loadCheckboxStates(onLoaded: (List<Boolean>) -> Unit) {
//  val currentUser = FirebaseAuth.getInstance().currentUser
//  val firestore = FirebaseFirestore.getInstance()

//  currentUser?.let { user ->
//      val docRef = firestore.collection("users")
//          .document(user.uid)
//          .collection("checkboxStates")
//          .document("states")

//      docRef.get().addOnSuccessListener { document ->
//          if (document.exists()) {
//              val states = document.get("checkboxStates") as? List<Boolean>
//              if (states != null) {
//                  onLoaded(states)
//              } else {
//                  onLoaded(List(10) { false })
//              }
//          } else {
//              onLoaded(List(10) { false })
//          }
//      }.addOnFailureListener { e ->
//          Log.e("Firestore", "Error loading checkbox states: ${e.message}")
//          onLoaded(List(10) { false })
//      }
//  }
// }

@Preview
fun HomescreenPreview() {
    HomeScreen(navController = rememberNavController())
}
