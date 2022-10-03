package com.valu.storeapp.presentation.details_screen

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize
import com.valu.storeapp.R
import com.valu.storeapp.domain.model.product_details.ProductDetails

@Composable
fun ProductDetailsScreen(
    viewModel: DetailsProductViewModel = hiltViewModel()
) {
    val detailsMovieState = viewModel.detailsProductState.value
    val productDetails: ProductDetails? = detailsMovieState.productDetails
    val context = LocalContext.current

    Box() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.back_main))
                .verticalScroll(rememberScrollState())
        )
        {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(detailsMovieState.productDetails?.image),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(250.dp)
                )
            }

            productDetails?.title?.let {
                Text(
                    it,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(
                            top = 5.dp,
                            bottom = 5.dp,
                            end = 12.dp,
                            start = 15.dp
                        ),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(
                            Font(R.font.font_bold)
                        )

                    )
                )
            }
            productDetails?.rating?.rate?.toFloat()?.let {
                RatingBar(
                    value = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, top = 10.dp),
                    config = RatingBarConfig()
                        .activeColor(colorResource(id = R.color.active_rate))
                        .inactiveColor(Color.Gray)
                        .stepSize(StepSize.HALF)
                        .numStars(5)
                        .size(15.dp)
                        .padding(2.dp)
                        .style(RatingBarStyle.Normal),
                    onValueChange = {
                    },
                    onRatingChanged = {
                    }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            productDetails?.category?.let {
                Text(
                    it,
                    textAlign = TextAlign.Start,
                    maxLines = 1,
                    modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(
                            Font(R.font.font_bold)
                        )

                    )
                )
            }

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "Description",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(
                        top = 5.dp,
                        start = 15.dp,
                        bottom = 5.dp,
                        end = 15.dp
                    )
                    .fillMaxWidth(),
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(
                        Font(R.font.font_bold)
                    )

                )
            )
            Spacer(modifier = Modifier.width(5.dp))
            productDetails?.description?.let {
                Text(
                    text = it,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(
                            top = 5.dp,
                            start = 15.dp,
                            bottom = 5.dp,
                            end = 15.dp
                        )
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(
                            Font(R.font.font_regular)
                        )

                    )
                )
            }


            Spacer(modifier = Modifier.width(5.dp))


        }

        if (detailsMovieState.error.isNotBlank()) {
            Toast.makeText(context, detailsMovieState.error, Toast.LENGTH_SHORT).show()
        }
        if (detailsMovieState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
}