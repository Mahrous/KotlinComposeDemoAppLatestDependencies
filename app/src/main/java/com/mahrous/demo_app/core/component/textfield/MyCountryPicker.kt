package com.mahrous.demo_app.core.component.textfield

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import com.mahrous.demo_app.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

import com.utkuglsvn.countrycodepicker.libData.CountryCode
import com.utkuglsvn.countrycodepicker.libData.utils.getFlagMasterResID
import com.utkuglsvn.countrycodepicker.libData.utils.getLibCountries
import com.utkuglsvn.countrycodepicker.libUtils.searchCountryList
import kotlin.collections.first
import kotlin.text.isEmpty

class MyCountryPicker {


    @Composable
    fun CountryCodeDialog(
        modifier: Modifier = Modifier,
        isOnlyFlagShow: Boolean = false,
        defaultSelectedCountry: CountryCode = getLibCountries().first(),
        pickedCountry: (CountryCode) -> Unit,
        dialogSearch: Boolean = true,
        dialogRounded: Int = 12
    ) {
        val countryList: List<CountryCode> = getLibCountries()
        var isPickCountry by remember { mutableStateOf(defaultSelectedCountry) }
        var isOpenDialog by remember { mutableStateOf(false) }
        var searchValue by remember { mutableStateOf("") }

//        Card(backgroundColor = colorResource(id = R.color.transparent), elevation = 0.dp,
//            modifier = modifier
//                .background(Color.Transparent)
//                .clickable { isOpenDialog = true }
//        ) {
        Box(modifier = Modifier
//            .height(AppSize.size50)
//            .background(color = MaterialTheme.colors.surface,RoundedCornerShape(
//                8.dp
//            ))

//            .border(
//                border = BorderStroke((1).dp,  MaterialTheme.colors.primary.copy(alpha = 0.3f)),
//                shape = RoundedCornerShape(
//                    8.dp
//                )
//            )
            .clickable { isOpenDialog = true }) {
            Row(
                modifier.padding(10.dp).align(Alignment.Center),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        id = getFlagMasterResID(
                            isPickCountry.countryCode
                        )
                    ), contentDescription = null
                )
                if (!isOnlyFlagShow) {
                    Text(
//                            "${isPickCountry.countryPhoneCode} ${isPickCountry.countryCode}"
                        isPickCountry.countryPhoneCode,
                        Modifier.padding(horizontal = 8.dp),
                        color = MaterialTheme.colorScheme.onBackground,

                        fontSize = 12.sp,
                    )
                }
//                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
            }
        }

        //Dialog
        if (isOpenDialog) {
            Dialog(
                onDismissRequest = { isOpenDialog = false },
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.85f),
                    elevation = CardDefaults.cardElevation(4.dp) ,
                    shape = RoundedCornerShape(dialogRounded.dp)
                ) {
                    Column {
                        if (dialogSearch) {
                            searchValue = DialogSearchView()
                        }
                        LazyColumn {
                            items(
                                (if (searchValue.isEmpty()) {
                                    countryList
                                } else {
                                    countryList.searchCountryList(searchValue)
                                })
                            ) { countryItem ->
                                Row(
                                    Modifier
                                        .padding(
                                            horizontal = 18.dp,
                                            vertical = 18.dp
                                        )
                                        .clickable {
                                            pickedCountry(countryItem)
                                            isPickCountry = countryItem
                                            isOpenDialog = false
                                        }) {
                                    Image(
                                        painter = painterResource(
                                            id = getFlagMasterResID(
                                                countryItem.countryCode
                                            )
                                        ), contentDescription = null
                                    )
                                    Text(
                                        countryItem.countryName,
                                        Modifier.padding(horizontal = 18.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    @Composable
    private fun DialogSearchView(): String {
        var searchValue by remember { mutableStateOf("") }
        Row {
            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                value = searchValue,
                onValueChange = {
                    searchValue = it
                },
                fontSize = 14.sp,
                hint = "Search ...",
                textAlign = TextAlign.Start,
            )
        }
        return searchValue
    }

    @Composable
    private fun CustomTextField(
        modifier: Modifier = Modifier,
        value: String,
        onValueChange: (String) -> Unit,
        hint: String = "",
        fontSize: TextUnit = 16.sp,
        textAlign: TextAlign = TextAlign.Center
    ) {
        Box(
            modifier = modifier
                .background(
                    color = Color.White.copy(alpha = 0.1f)
                )
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = value,
                onValueChange = onValueChange,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = textAlign,
                    fontSize = fontSize
                ),
                singleLine = true,
                leadingIcon = {
                    Icon(
                       painter = painterResource(R.drawable.ic_search),
                        contentDescription = null,
                        tint = Color.Black.copy(0.2f)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground,

                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,

                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            if (value.isEmpty()) {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                    modifier = Modifier.then(
                        Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 52.dp)
                    )
                )
            }
        }
    }
}