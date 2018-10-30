<!-- Library Logo -->
<!-- <img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher.png?raw=true" align="left" hspace="1" vspace="1">-->

<!-- Buy me a cup of coffe 
<a href='https://ko-fi.com/A406JCM' style='margin:13px;' target='_blank' align="right"><img align="right" height='36' src='https://az743702.vo.msecnd.net/cdn/kofi4.png?v=f' alt='Buy Me a Coffee at ko-fi.com' /></a>
<a href='https://play.google.com/store/apps/details?id=com.vansuita.materialabout.sample&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1' target='_blank' align="right"><img align="right" height='36' src='https://s20.postimg.org/muzx3w4jh/google_play_badge.png' alt='Get it on Google Play' /></a>-->

# AndoidAboutUs


This is an [**Android About Us**](https://developer.android.com) project. You can buid your own about us screen using this library to make build easily.

</br>

# app
 This library has a lot more customization and features than is able to show here. Please check the sample app.


<!--<img src="images/screenshots/dark.jpg" height='auto' width='270'/><img src="images/screenshots/light.jpg" height='auto' width='270'/><img src="images/screenshots/custom.jpg" height='auto' width='270'/>

[![Appetize.io](https://img.shields.io/badge/Apptize.io-Run%20Now-brightgreen.svg?)](https://appetize.io/embed/3b4dpd5kv90mpa67mp5h8mugc0?device=nexus7&scale=50&autoplay=true&orientation=portrait&deviceColor=black) [![Demo](https://img.shields.io/badge/Demo-Download-blue.svg)](http://apk-dl.com/dl/com.vansuita.materialabout.sample) 
 [![Codacy Badge](https://api.codacy.com/project/badge/Grade/118bb89e3bed43e2b462201654224a60)](https://www.codacy.com/app/jrvansuita/MaterialAbout?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jrvansuita/MaterialAbout&amp;utm_campaign=Badge_Grade) 
 <a target="_blank" href="https://developer.android.com/reference/android/os/Build.VERSION_CODES.html#GINGERBREAD"><img src="https://img.shields.io/badge/API-9%2B-blue.svg?style=flat" alt="API" /></a> -->


# Setup

This library requires `minSdkVersion` to be set to `14` or above.

#### Step #1. Add the JitPack repository to your build file:

```gradle
allprojects {
    repositories {
	...
	maven { url "https://jitpack.io" }
    }
}
```

#### Step #2. Add the dependency ([See latest release](https://jitpack.io/#techhuntdevelopers/AndroidAboutUs)).

```groovy
dependencies {
       implementation 'com.github.techhuntdevelopers:AndroidAboutUs:x.y.z'
}
```
# Implementation

Create a **AboutView** instance with **AboutBuilder**.
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    AboutBuilder builder = AboutBuilder.with(MainActivity.this)
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .setPhoto(R.mipmap.profile_picture)
                .setCover(R.mipmap.profile_cover)
                .setLinksAnimated(true)
                .setDividerDashGap(13)
                .setName("TechHunt Developers")
                .setSubTitle("Android Appilication Developer")
                .setLinksColumnsCount(4)
                .setBrief("Develop Innovative")
                .addGooglePlayStoreLink("7399966994559253451")
                .addGitHubLink("techhuntdevelopers")
                .addFacebookLink("techhuntdevelopers")
                .addInstagramLink("techhunt_developers")
                .addEmailLink("techhunt00@gmail.com")
                .addWhatsappLink("Thoriya Prahalad", "+918155851357")
                .addFiveStarsAction()
                .addMoreFromMeAction("TechHunt Developers")
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .addUpdateAction()
                .setActionsColumnsCount(2)
                .addFeedbackAction("techhunt00@gmail.com")
                .addIntroduceAction((Intent) null)
                .addHelpAction((Intent) null)
                .addChangeLogAction((Intent) null)
                .addRemoveAdsAction((Intent) null)
                .addDonateAction((Intent) null)
                .setWrapScrollView(true)
                .setShowAsCard(true);

     AboutView view = builder.build();

     about.addView(view); //about is Layout
}
```


# Credit 
[Júnior Vansuita](https://github.com/jrvansuita/MaterialAbout)
