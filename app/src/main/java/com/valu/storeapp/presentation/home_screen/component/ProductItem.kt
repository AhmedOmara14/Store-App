package com.valu.storeapp.presentation.home_screen.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.*
import com.valu.storeapp.R
import com.valu.storeapp.domain.model.all_products.AllProductsResponseItem

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductItem(items_: List<AllProductsResponseItem>, onExecuteMovie: (String) -> Unit) {
    LazyColumn(
        Modifier.fillMaxWidth()
    ) {
        items(items_) { products ->
            Row(modifier = Modifier.padding(end = 5.dp, bottom = 10.dp).clickable { onExecuteMovie(products.id.toString()) }) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(Color.White)
                            .wrapContentHeight()
                            .wrapContentWidth()
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(products.image),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .width(150.dp)
                                .height(150.dp)
                        )
                    }

                }

                Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.padding(start = 10.dp).fillMaxWidth()) {
                    Text(
                        products.title,
                        textAlign = TextAlign.Start,
                        maxLines = 2,
                        modifier = Modifier
                            .padding(
                                bottom = 5.dp,
                                end = 12.dp
                            ),
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontFamily = FontFamily(
                                Font(R.font.font_bold)
                            )

                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        products.category,
                        textAlign = TextAlign.Start,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(
                                end = 12.dp
                            ),
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray,
                            fontFamily = FontFamily(
                                Font(R.font.font_regular)
                            )

                        )
                    )
                }


            }
        }
    }

}


