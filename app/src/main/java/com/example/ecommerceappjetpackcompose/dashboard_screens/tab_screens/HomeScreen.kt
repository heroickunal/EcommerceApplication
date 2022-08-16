package com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecommerceappjetpackcompose.R
import com.example.ecommerceappjetpackcompose.dashboard_screens.navigation.Screen
import com.example.ecommerceappjetpackcompose.dashboard_screens.viewmodel.SharedViewModel
import com.example.ecommerceappjetpackcompose.ui.theme.*

@Composable
fun HomeScreen(navController: NavHostController, viewModel: SharedViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(30.dp)) {
            Products()
            Spacer(modifier = Modifier.padding(20.dp))
            ProductCategory()
            Spacer(modifier = Modifier.padding(20.dp))
            ProductWidget(navController, viewModel)
        }
    }


}

@Composable
fun Products() {
    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                    withStyle(
                        style = SpanStyle(
                            color = subTitleTextColor,
                            fontSize = 24.sp
                        )
                    ) {
                        append("Our\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = titleTextColor,
                            fontSize = 24.sp
                        )
                    ) {
                        append("Products")
                    }

                }
            }
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(78.dp)
                .padding(top = 30.dp)
        ) {
            TextField(
                modifier = Modifier
                    .weight(0.85f),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = lightbox,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                value = search,
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                onValueChange = { search = it },
                placeholder = {
                    Text(
                        text = "Search Products",
                        color = lightGrey
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = lightblack
                    )
                },
            )
            Spacer(modifier = Modifier.width(5.dp))
            Card(
                modifier = Modifier
                    .width(60.dp)
                    .padding(start = 16.dp)
                    .clickable { },
                elevation = 5.dp,
                shape = RoundedCornerShape(12.dp)
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(R.drawable.filter_list),
                        contentDescription = "Filter Icon",
                        modifier = Modifier.size(20.dp, 20.dp)
                    )

                }
            }

        }

    }
}

@Composable
fun ProductCategory() {
    val itemList = listOf("GamePads", "Sneakers", "Watch")
    val categoryImagesList = listOf<Int>(
        R.drawable.zebmax,
        R.drawable.shoe_thumb_2,
        R.drawable.watch
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(itemList.size) { item ->
            Box(
                modifier = Modifier
                    .border(
                        color = if (item == 0) orange else lightGrey,
                        width = 2.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(categoryImagesList[item]),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp, 30.dp)
                    )
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 5.dp,
                                end = 16.dp,
                                top = 8.dp,
                                bottom = 8.dp
                            ),
                        text = itemList[item],
                        color = if (item == 0) lightblack else Color.LightGray
                    )
                }

            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

data class ProductDetails(
    val name: String,
    val details: String,
    val price: String,
    val image: Int,
    val trending: String
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductWidget(navController: NavHostController, viewModel: SharedViewModel) {

    val productDetails = listOf<ProductDetails>(
        ProductDetails(
            name = "Zeb-MAX",
            details = "ZEBRONICS Zeb-MAX Play Windows Compatible 2.4GHz Wireless Gamepad with 10H* Backup, Turbo Mode, Dual Vibration Motors, Quad Front triggers, Type C Rechargeable and Plug & Play Setup",
            price = "1070",
            image = R.drawable.zebmax,
            trending = "Trending Now"
        ),
        ProductDetails(
            name = "Redgear Pro Wireless",
            details = "Redgear Pro Wireless Gamepad with 2.4GHz Wireless Technology, Integrated Dual Intensity Motor, Illuminated Keys for PC(Compatible with Windows 7/8/8.1/10 only)",
            price = "1299",
            image = R.drawable.redgear,
            trending = "Best Selling"
        ),
        ProductDetails(
            name = "Cosmic Byte C1070T",
            details = "ZEBRONICS Zeb-MAX Play Windows Compatible 2.4GHz Wireless Gamepad with 10H* Backup, Turbo Mode, Dual Vibration Motors, Quad Front triggers, Type C Rechargeable and Plug & Play Setup",
            price = "1419",
            image = R.drawable.cosmic,
            trending = "Best Selling"
        ),
        ProductDetails(
            name = "RPM Euro Games",
            details = "Eccentric 360 and #x2DA\n" +
                    "Double triggers and analog bumpers, 1 Year Warranty\n" +
                    "analog sticks for more comfort,Ultra-precise eight-way D Cross\n" +
                    "Integrated Dual Mode: X-input and Direct-input for greater games compatibility\n" +
                    "Dongle should be directly in sight of controller",
            price = "898",
            image = R.drawable.rpm,
            trending = "Trending Now"
        )
    )

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        content = {
            itemsIndexed(productDetails) { _, item ->

                var isChecked by remember {
                    mutableStateOf(false)
                }

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            viewModel.selectedProduct = item
                            navController.navigate(Screen.ProductDetailsScreen.route) }
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(24.dp),
                    elevation = 2.dp
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(12.dp)
                    ) {
                        IconButton(onClick = { isChecked = !isChecked }) {
                            Icon(
                                painter = painterResource(
                                    id =
                                    if (isChecked)
                                        R.drawable.ic_baseline_favorite_24
                                    else
                                        R.drawable.ic_baseline_favorite_border_24
                                ),
                                contentDescription = "",
                                tint = if (isChecked) redHeart else lightGrey
                            )

                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(100.dp),
                                painter = painterResource(item.image),
                                contentDescription = "",
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            Text(
                                text = item.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = titleTextColor,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            Text(
                                text = item.trending,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = orange,
                                modifier = Modifier.padding(bottom = 10.dp)
                            )

                            Text(
                                text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            orange,
                                            fontWeight = FontWeight.Bold
                                        )
                                    ) {
                                        append("₹")
                                    }
                                    withStyle(
                                        style = SpanStyle(
                                            titleTextColor
                                        )
                                    ) {
                                        append(item.price)
                                    }
                                },
                                style = MaterialTheme.typography.subtitle1,
                                modifier = Modifier,
                                fontSize = 16.sp

                            )
                        }


                    }
                }

            }
        }
    )
}
