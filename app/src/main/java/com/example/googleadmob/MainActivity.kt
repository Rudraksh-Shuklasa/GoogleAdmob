package com.example.googleadmob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var TAG="Banner"
    private lateinit var mInterstitialAd: InterstitialAd


    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}


//        mAdView =findViewById(R.id.adView)
//        val adLoad=AdRequest.Builder().addTestDevice("AB2BDCA14E90EADD9BBCAAFE965C5FFF").build()
//        mAdView.loadAd(adLoad)

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        t.setOnClickListener {
            mInterstitialAd.show()
        }


        mInterstitialAd.adListener=object: AdListener() {
            override fun onAdLoaded() {
                Log.d(TAG, "onAdLoaded")
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                Log.d(TAG, "onAdFailedToLoad" + errorCode)
            }

            override fun onAdOpened() {
                Log.d(TAG, "onAdOpened")
            }

            override fun onAdClicked() {
                Log.d(TAG, "onAdClicked")
            }

            override fun onAdLeftApplication() {
                Log.d(TAG, "onAdLeftApplication")
            }

            override fun onAdClosed() {
                Log.d(TAG, "onAdClosed")
                mInterstitialAd.loadAd(AdRequest.Builder().build())
            }
        }




//        mAdView.adListener=object  : AdListener(){
//            override fun onAdClicked() {
//                super.onAdClicked()
//                Log.d(TAG,"onAdClicked")
//            }
//
//            override fun onAdClosed() {
//                super.onAdClosed()
//                Log.d(TAG,"onAdClosed")
//            }
//
//            override fun onAdFailedToLoad(p0: Int) {
//                super.onAdFailedToLoad(p0)
//                Log.d(TAG,"onAdFailedToLoad"+p0)
//
//
//            }
//
//            override fun onAdLoaded() {
//                super.onAdLoaded()
//                Log.d(TAG,"onAdLoaded")
//            }
//
//            override fun onAdImpression() {
//                super.onAdImpression()
//                Log.d(TAG,"onAdImpression")
//            }
//
//            override fun onAdLeftApplication() {
//                super.onAdLeftApplication()
//                Log.d(TAG,"onAdLeftApplication")
//            }
//
//            override fun onAdOpened() {
//                super.onAdOpened()
//                Log.d(TAG,"onAdOpened")
//            }
//        }

    }
}
