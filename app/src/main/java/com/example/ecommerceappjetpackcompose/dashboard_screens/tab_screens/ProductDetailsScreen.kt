package com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.ecommerceappjetpackcompose.R
import com.example.ecommerceappjetpackcompose.dashboard_screens.viewmodel.SharedViewModel
import com.example.ecommerceappjetpackcompose.ui.theme.*

@Composable
fun ProductDetailsScreen(navController: NavHostController, viewModel: SharedViewModel) {

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBarWithBack(
                onBackClick = {
                    navController.navigateUp()
                },
            )
        }, backgroundColor = lightgraybg,
        floatingActionButton = {
        },

        content = {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(280.dp)
                ) {
                    HeaderImagesSlider(viewModel)
                }

                ProductTitle(viewModel)
                Spacer(modifier = Modifier.padding(10.dp))
                ProductItemColorWithDesc(viewModel)

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {

                    Button(modifier = Modifier.fillMaxWidth(),
                        onClick = {

                            viewModel.cartProducts.add(viewModel.selectedProduct)

                            Toast.makeText(
                                context,
                                "Product added to cart", Toast.LENGTH_LONG
                            ).show()

                        }) {

                        Text(text = "Add to cart")
                    }
                }
            }
        }
    )
}


@Composable
fun HeaderImagesSlider(viewModel: SharedViewModel) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            contentScale = ContentScale.Fit,
            painter = painterResource(id = viewModel.selectedProduct.image),
            contentDescription = "",
            modifier = Modifier
                .size(230.dp)
        )
    }
}

@Composable
fun ProductTitle(viewModel: SharedViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            color = grey,
            modifier = Modifier
                .height(4.dp)
                .width(40.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = viewModel.selectedProduct.name,
                color = titleTextColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Column(modifier = Modifier.wrapContentHeight()) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                orange,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("₹ ")
                        }
                        withStyle(
                            style = SpanStyle(
                                titleTextColor
                            )
                        ) {
                            append(viewModel.selectedProduct.price.toString())
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


@Composable
fun ProductItemColorWithDesc(viewModel: SharedViewModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Description",
            color = titleTextColor,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = viewModel.selectedProduct.details,
            color = lightblack,
            fontSize = 14.sp
        )
    }

}


@Composable
fun TopAppBarWithBack(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Card(
            modifier = Modifier.width(50.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = 5.dp
        ) {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = ""
                )
            }

        }
        Card(
            modifier = Modifier.width(50.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = 5.dp
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "",
                    tint = orange
                )
            }

        }
    }
}





