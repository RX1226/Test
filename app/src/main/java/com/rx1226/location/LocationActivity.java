package com.rx1226.location;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

import static android.Manifest.permission.ACCESS_BACKGROUND_LOCATION;
import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.telephony.PhoneStateListener.LISTEN_CELL_LOCATION;
import static android.telephony.PhoneStateListener.LISTEN_SERVICE_STATE;

public class LocationActivity extends AppCompatActivity {
    private final String TAG = "LocationActivity";
    private final int REQUIRE_PERMISSIONS = 9527;
    private String[] permissions = {
            ACCESS_FINE_LOCATION,
            ACCESS_COARSE_LOCATION,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @AfterPermissionGranted(REQUIRE_PERMISSIONS)
    private void methodRequiresPermission() {
        if (EasyPermissions.hasPermissions(this, permissions)) {
            // Already have permission, do the thing
            getCellLocation();
        } else {
            EasyPermissions.requestPermissions(this, "定位需要GPS權限", REQUIRE_PERMISSIONS, permissions);
        }
    }

    private void getCellLocation() {
//        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
//        if (telephonyManager == null) return;
//        List<CellInfo> cellInfoList = telephonyManager.getAllCellInfo();
//        if(cellInfoList != null){
//            for (CellInfo info : cellInfoList) {
//               if(info instanceof CellInfoWcdma){
//                   final CellIdentityWcdma identityWcdma = ((CellInfoWcdma) info).getCellIdentity();
//
//                   // Cell Identity
//                   Log.d(TAG, "Lac = " + identityWcdma.getLac());
//                   Log.d(TAG, "Mcc = " + identityWcdma.getMcc());
//                   Log.d(TAG, "Mnc = " + identityWcdma.getMnc());
//                   Log.d(TAG, "Cid = " + identityWcdma.getCid());
//               }
//            }
//        }
    }

    private void checkWifiState() {
        if(isWifiConnect()) {
            WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            if(wifiManager != null && wifiManager.isWifiEnabled()){
                Toast.makeText(this, "Wifi 已啟動", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Wifi 未啟動", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this, "Wifi 沒有連接", Toast.LENGTH_LONG).show();
        }
    }
    private boolean isWifiConnect(){
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager == null) return false;
        NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return (networkInfo != null) && networkInfo.isConnected();
    }

    private void getLocationByManager() {
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        if (locationManager == null) return;
        List<String> providerList = locationManager.getProviders(true);
        String provider;
        if (providerList.contains(LocationManager.GPS_PROVIDER)) {
            provider = LocationManager.GPS_PROVIDER;
        } else if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
            provider = LocationManager.NETWORK_PROVIDER;
        } else {
            Toast.makeText(this, "沒有位置提供器可使用", Toast.LENGTH_LONG).show();
            provider = LocationManager.PASSIVE_PROVIDER;
//            startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
        }
        @SuppressLint("MissingPermission") Location location = locationManager.getLastKnownLocation(provider);
        if(location != null) {
            Toast.makeText(this, "location = " + location.getLatitude() + " , " + location.getLongitude(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "無法取得座標", Toast.LENGTH_LONG).show();
        }
    }

    public void getLocationFlow(View view) {
        methodRequiresPermission();
    }
}
