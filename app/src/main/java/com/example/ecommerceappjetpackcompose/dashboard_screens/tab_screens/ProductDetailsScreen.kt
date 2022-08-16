package com.example.ecommerceappjetpackcompose.dashboard_screens.screens

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
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.ecommerceappjetpackcompose.R
import com.example.ecommerceappjetpackcompose.ui.theme.*

@Preview(showBackground = true)
@Composable
fun ProductDetailsScreen() {
    Scaffold(
        topBar = {
            TopAppBarWithBack(
                onBackClick = {

                },
            )
        }, backgroundColor = lightgraybg,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                backgroundColor = orange
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Add To Cart",
                    tint = white
                )
            }
        },

        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize().background(Color.White)
                    .verticalScroll(rememberScrollState())
            ) {
                ConstraintLayout {
                    val (imagesliderref, addtocartref) = createRefs()
                    Box(modifier = Modifier
                        .height(280.dp)
                        .constrainAs(imagesliderref) {
                            top.linkTo(imagesliderref.top)
                            bottom.linkTo(imagesliderref.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }) {
                        HeaderImagesSlider()
                    }
                    Surface(
                        color = white,
                        shape = RoundedCornerShape(40.dp)
                            .copy(
                                bottomStart = ZeroCornerSize,
                                bottomEnd = ZeroCornerSize
                            ),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 200.dp)
                            .constrainAs(addtocartref) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(30.dp)
                        ) {
                            ProductTitle()
                            Spacer(modifier = Modifier.padding(10.dp))
                            ProductItemColorWithDesc()
                        }
                    }
                }

            }
        }
    )

}


@Composable
fun HeaderImagesSlider() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            contentScale = ContentScale.Fit,
            painter = painterResource(id = R.drawable.redgear),
            contentDescription = "",
            modifier = Modifier
                .size(230.dp)
        )
    }
}

@Composable
fun ProductTitle() {
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
                text = "Redgear Pro Wireless Gamepad",
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
                            append("$ ")
                        }
                        withStyle(
                            style = SpanStyle(
                                titleTextColor
                            )
                        ) {
                            append("240")
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
fun ProductItemColorWithDesc() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Description",
            color = titleTextColor,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = "Gamepad comes equipped with2.4GHz wireless technology and supports up to 10 metres range, an ideal choice for those looking to enjoy your favourite games without the hassle of cables and wires.\n" +
                    "The built-in lithium-ion battery in the gamepad can provide uninterrupted gameplay for up to 2 hours in a single charge for upto 30-minute\n" +
                    "Integrated dual intensity motor which allows a realistic gaming experience.\n" +
                    "Integrated force feedback. Reset : When an exception occurs, such as Keys disorder, or crash, unable to connect. Remove the USB connection from the gamepad and device and reconnect.\n" +
                    "The gamepad comes with illuminated keys on the back which light up and allow visibility even in low light conditions.\n" +
                    "1 year warranty from the date of purchase",
            color = lightblack,
            fontSize = 14.sp
        )
    }

}


@Composable
fun TopAppBarWithBack(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
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





