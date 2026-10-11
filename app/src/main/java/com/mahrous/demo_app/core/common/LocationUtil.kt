package com.mahrous.demo_app.core.common

import android.app.PendingIntent
import android.content.Context
import android.location.Location
import android.location.LocationManager

import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.let
import kotlin.run

object LocationUtil {

    var latLng = LatLng(0.0, 0.0)

    fun isGpsOpen(context: Context): Boolean {
        val locationManger = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManger.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    fun getMyLocation(
        context: Context,
        onMyLocation: (LatLng) -> Unit
    ) {
        try {
            val fusedLocationClient =
                LocationServices.getFusedLocationProviderClient(context)
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                location?.let {
                    val currentLocation = LatLng(location.latitude, location.longitude)
                    onMyLocation(currentLocation)
                } ?: run {}
            }

        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }


    fun checkLocationSetting(
        context: Context,
        onDisabled: (PendingIntent) -> Unit,
        onEnabled: () -> Unit
    ) {
        val locationRequest = LocationRequest.Builder(100, 5000).build()
        val builder = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)
            .build()
        val settingsClient = LocationServices.getSettingsClient(context)
        val task = settingsClient.checkLocationSettings(builder)

        task.addOnSuccessListener {
            // Location settings are enabled, start your location-aware feature
            onEnabled()
        }.addOnFailureListener {exception ->
            // Location settings are not enabled, show a dialog to ask the user to enable them
            if (exception is ResolvableApiException) {
                onDisabled(exception.resolution)
            }
        }
    }

}

class LocationManger @Inject constructor() {
    suspend fun getCurrentLocation(context: Context): Flow<DataState<LatLng>> = flow {
        emit(DataState.Loading)
        try {
            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
            val response = fusedLocationClient.lastLocation.result
            val currentLocation = LatLng(response.latitude, response.longitude)
            emit(DataState.Success(currentLocation))
        } catch (e: SecurityException) {
            e.printStackTrace()
            emit(DataState.Failure(""))
        }
    }

}