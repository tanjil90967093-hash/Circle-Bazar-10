package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.LocalShipping
import androidx.compose.material.icons.outlined.Payment
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onNavigateToSearch: () -> Unit, onNavigateToProduct: (String) -> Unit) {
    val scrollState = rememberScrollState()
    
    Column(modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        HomeHeader(onNavigateToSearch = onNavigateToSearch)
        
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            HeroBanner()
            CircleDealsSection(onNavigateToProduct = onNavigateToProduct)
            CategorySection()
            JustForYouSection(onNavigateToProduct = onNavigateToProduct)
            BenefitsSection()
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun HomeHeader(onNavigateToSearch: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo
        Row(
            modifier = Modifier.padding(end = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingBag,
                contentDescription = "Logo",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Column {
                Text(
                    text = "CIRCLE",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp,
                    lineHeight = 12.sp
                )
                Text(
                    text = "BAZAR",
                    color = Color.Black,
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp,
                    lineHeight = 12.sp
                )
            }
        }
        
        Row(
            modifier = Modifier
                .weight(1f)
                .height(44.dp)
                .border(1.dp, Color.LightGray.copy(alpha = 0.5f), RoundedCornerShape(22.dp))
                .clip(RoundedCornerShape(22.dp))
                .background(Color.White)
                .clickable { onNavigateToSearch() }
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Gray, modifier = Modifier.size(20.dp))
            Text(
                text = "Search for products, brands...",
                modifier = Modifier.weight(1f).padding(horizontal = 8.dp),
                color = Color.Gray,
                fontSize = 13.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Icon(Icons.Default.CameraAlt, contentDescription = "Image Search", tint = Color.Gray, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.Mic, contentDescription = "Voice Search", tint = Color.Gray, modifier = Modifier.size(20.dp))
        }
        
        Spacer(modifier = Modifier.width(8.dp))
        
        IconButton(onClick = { /* Notifications */ }, modifier = Modifier.size(32.dp)) {
            BadgedBox(
                badge = {
                    Badge(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = Color.White,
                        modifier = Modifier.offset(x = (-4).dp, y = 4.dp)
                    ) { Text("3") }
                }
            ) {
                Icon(Icons.Outlined.Notifications, contentDescription = "Notifications", tint = Color.Black)
            }
        }
    }
}

@Composable
fun HeroBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .aspectRatio(2.2f)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_hero_banner_new),
            contentDescription = "Promo Banner",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Special Offer",
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "MEGA SALE",
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "UP TO ",
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontSize = 22.sp
                )
                Text(
                    text = "70% OFF",
                    color = Color(0xFFFFEB3B),
                    fontWeight = FontWeight.Black,
                    fontSize = 22.sp
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Button(
                onClick = { /* Shop Now */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                modifier = Modifier.height(36.dp)
            ) {
                Text("Shop Now", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
            }
        }

        // Indicator Dots mock
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            repeat(4) { index ->
                Box(
                    modifier = Modifier
                        .height(6.dp)
                        .width(if (index == 0) 16.dp else 6.dp)
                        .clip(CircleShape)
                        .background(if (index == 0) Color.White else Color.White.copy(alpha = 0.5f))
                )
            }
        }
    }
}

@Composable
fun CircleDealsSection(onNavigateToProduct: (String) -> Unit) {
    val configuration = LocalConfiguration.current
    val cardWidth = configuration.screenWidthDp.dp * 0.23f
    val cardHeight = configuration.screenHeightDp.dp * 0.20f

    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.FlashOn,
                    contentDescription = null,
                    tint = Color(0xFFFFC107),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Circle Deals",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color.Black
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { /* Shop More */ }
            ) {
                Text("Shop More", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(16.dp))
            }
        }
        
        Spacer(modifier = Modifier.height(10.dp))
        
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            TimeBox("12", "HRS")
            TimeBox("48", "MINS")
            TimeBox("36", "SECS")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val deals = listOf(
                Deal("Haylou Solar Lite Smart Watch", "৳2,450", "৳4,450", R.drawable.img_product_watch, "-45%", 0.1f, "Only 10 Left"),
                Deal("Pro Wireless Earbuds", "৳1,250", "৳2,000", R.drawable.img_product_headphones, "-38%", 0.05f, "Only 5 Left"),
                Deal("Women's Premium Hand Bag", "৳1,290", "৳3,150", R.drawable.img_product_shoes, "-40%", 0.08f, "Only 8 Left"),
                Deal("Luxury Perfume For Women", "৳1,450", "৳2,900", R.drawable.img_product_watch, "-50%", 0.15f, "Only 7 Left")
            )
            items(deals) { deal ->
                CircleDealProductCard(
                    title = deal.title,
                    price = deal.price,
                    oldPrice = deal.oldPrice,
                    imageRes = deal.imageRes,
                    discount = deal.discount,
                    progress = deal.progress,
                    leftText = deal.leftText,
                    onNavigateToProduct = { onNavigateToProduct("deal_1") },
                    modifier = Modifier.width(cardWidth).height(cardHeight)
                )
            }
        }
    }
}

data class Deal(
    val title: String, val price: String, val oldPrice: String,
    val imageRes: Int, val discount: String, val progress: Float, val leftText: String
)

@Composable
fun TimeBox(number: String, label: String) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(Color(0xFFFFE066))
            .padding(horizontal = 4.dp, vertical = 1.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = number, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 11.sp, lineHeight = 12.sp)
        Text(text = label, color = Color.Black, fontSize = 6.sp, fontWeight = FontWeight.Bold, lineHeight = 8.sp)
    }
}

@Composable
fun CategorySection() {
    val categories = listOf("Fashion", "Electronics", "Home", "Beauty", "Sports", "Toys", "Grocery", "More")
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(4.dp, RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Categories",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.height(180.dp),
            userScrollEnabled = false,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categories) { category ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(category.take(1), fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, fontSize = 24.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = category, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
            }
        }
    }
}

@Composable
fun JustForYouSection(onNavigateToProduct: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        Text(
            text = "Just For You",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp, top = 8.dp)
        )
        
        // Mock Grid since LazyVerticalGrid inside Scrollable Column is tricky without fixed height
        val products = listOf(
            Triple("j1", "Premium Over-Ear Headphones", R.drawable.img_product_headphones),
            Triple("j2", "Luxury Men's Watch", R.drawable.img_product_watch),
            Triple("j3", "Minimal White Sneakers", R.drawable.img_product_shoes),
            Triple("j4", "Premium Headphones Pro", R.drawable.img_product_headphones)
        )
        
        products.chunked(2).forEach { rowProducts ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                rowProducts.forEach { (id, title, img) ->
                    ProductCard(
                        id = id,
                        title = title,
                        price = "$249.00",
                        oldPrice = null,
                        imageRes = img,
                        discount = null,
                        rating = 4.9f,
                        soldCount = 1200,
                        onNavigateToProduct = onNavigateToProduct,
                        modifier = Modifier.weight(1f)
                    )
                }
                if (rowProducts.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun BenefitsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(4.dp, RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BenefitItem(Icons.Outlined.LocalShipping, "Free\nDelivery")
        BenefitItem(Icons.Outlined.CheckCircle, "Best\nQuality")
        BenefitItem(Icons.Outlined.Security, "Secure\nPayment")
        BenefitItem(Icons.Outlined.Payment, "Easy\nReturns")
    }
}

@Composable
fun BenefitItem(icon: ImageVector, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(28.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = text, fontSize = 11.sp, textAlign = androidx.compose.ui.text.style.TextAlign.Center, lineHeight = 14.sp)
    }
}

@Composable
fun ProductCard(
    id: String,
    title: String,
    price: String,
    oldPrice: String?,
    imageRes: Int,
    discount: String?,
    rating: Float,
    soldCount: Int,
    onNavigateToProduct: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .shadow(6.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .clickable { onNavigateToProduct(id) },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                
                // Favorite Icon
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.9f))
                        .clickable { /* Toggle Wishlist */ },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Wishlist", tint = Color.Gray, modifier = Modifier.size(18.dp))
                }
                
                // Discount Badge
                if (discount != null) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(horizontal = 6.dp, vertical = 4.dp)
                    ) {
                        Text(text = discount, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
            
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 18.sp,
                    modifier = Modifier.height(36.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = "Rating", tint = Color(0xFFFFC107), modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "$rating", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "($soldCount sold)", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
                Spacer(modifier = Modifier.height(8.dp))
                
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = price,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    if (oldPrice != null) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = oldPrice,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textDecoration = TextDecoration.LineThrough,
                            modifier = Modifier.padding(bottom = 2.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CircleDealProductCard(
    title: String,
    price: String,
    oldPrice: String,
    imageRes: Int,
    discount: String,
    progress: Float,
    leftText: String,
    onNavigateToProduct: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .border(1.dp, Color.LightGray.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
            .shadow(elevation = 1.dp, shape = RoundedCornerShape(8.dp), spotColor = Color.Red.copy(alpha = 0.05f))
            .clip(RoundedCornerShape(8.dp))
            .clickable { onNavigateToProduct() },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(4.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(6.dp))
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = title,
                    modifier = Modifier.fillMaxSize().padding(2.dp),
                    contentScale = ContentScale.Fit
                )
                
                // Discount Badge - Custom Shape Red Background
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .clip(RoundedCornerShape(topStart = 6.dp, bottomEnd = 4.dp, topEnd = 2.dp, bottomStart = 2.dp))
                        .background(Color(0xFFE53935))
                        .padding(horizontal = 3.dp, vertical = 1.dp)
                ) {
                    Text(text = discount, color = Color.White, fontSize = 7.sp, fontWeight = FontWeight.Bold)
                }
                
                // Favorite Icon
                Icon(
                    Icons.Default.FavoriteBorder, 
                    contentDescription = "Wishlist", 
                    tint = Color.Gray, 
                    modifier = Modifier.align(Alignment.TopEnd).size(12.dp)
                )
            }
            
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 2.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                // CIRCLE DEALS badge
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFFE8F5E9))
                        .padding(horizontal = 3.dp, vertical = 1.dp)
                ) {
                    Text("CIRCLE DEALS", color = MaterialTheme.colorScheme.primary, fontSize = 6.sp, fontWeight = FontWeight.ExtraBold)
                }
                
                Text(
                    text = title,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 10.sp
                )
                
                Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.padding(top = 1.dp)) {
                    Text(
                        text = price,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = oldPrice,
                        fontSize = 7.sp,
                        color = Color.Gray,
                        textDecoration = TextDecoration.LineThrough,
                        modifier = Modifier.padding(bottom = 1.dp)
                    )
                }
                
                // Progress Bar
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier.fillMaxWidth().padding(top = 2.dp).height(5.dp).clip(RoundedCornerShape(2.5.dp)),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = Color.LightGray.copy(alpha = 0.5f),
                )
                
                Text(
                    text = leftText,
                    color = Color(0xFFE53935), // Red
                    fontSize = 7.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 1.dp)
                )
            }
        }
    }
}
