Makemoji SDK
====================

![](http://i.imgur.com/L10Uj9l.png)

**Makemoji** is a free emoji keyboard for mobile apps. 

By installing our keyboard SDK every user of your app will instantly have access to new and trending emojis. Our goal is to increase user engagement as well as provide actionable real time data on sentiment (how users feel) and affinity (what users like). With this extensive data collection your per-user & company valuation will increase along with your user-base.
 
**Features Include**

* Extensive library of free emoji
* 722 standard Unicode emoji
* Makemoji *Flashtag* inline search system
* New emoji load dynamically and does not require a app update
* Analytics Dashboard & CMS

To obtain your SDK key please email: sdk@makemoji.com

**[Learn More](http://makemoji.com)**


Library Setup
---------------------
* Copy mojilib-release.aar to your projects 'libs' folder
	* minSdkVersion 15
	* targetSDKVersion 23

* Add the following dependencies to your projects build.gradle file

```
	 compile (name:'mojilib-release',ext:'aar')
	 compile 'com.android.support:recyclerview-v7:23.1.1'
	 compile 'com.squareup.okhttp:okhttp:2.7.0'
	 compile 'com.squareup.retrofit2:retrofit:2.0.0-beta3'
	 compile 'com.squareup.retrofit2:converter-gson:2.0.0-beta3'
	 compile 'com.githang:viewpagerindicator:2.4.2@aar'
```


SDK Usage
---------------------

**Initialization**

To start using the MakemojiSDK you will first have to add a few lines to your AppDelegate. 

Add the Makemoji header file to you App.java file.

```java
import com.makemoji.mojilib.Moji;
```
Then onCreate, setup your SDK key.

```java
	public void onCreate(){
        super.onCreate();
        context=this;
        Moji.initialize(this,"YOUR_KEY_HERE");
    }

```


**Setup a the Makemoji TextInput**

First you will want to add the component to your activity content layout

```xml
<com.makemoji.mojilib.MojiInputLayout
       android:id="@+id/mojiInput"
       android:layout_height="wrap_content"
       android:layout_width="match_parent"
       />

```

In your activity during onCreate, find the view you added in your layout, and assign this to a variable.

```java
	MojiInputLayout mojiInputLayout = (MojiInputLayout)findViewById(R.id.mojiInput);
	final MAdapter mAdapter = new MAdapter(this,new ArrayList<MojiMessage>(),true);
```

**Send a Message**

The SendLayoutClickListener will be called when a user clicks on the send button in the text input. This should be set in onCreate

```java
        mojiInputLayout.setSendLayoutClickListener(new MojiInputLayout.SendClickListener() {
            @Override
            public boolean onClick(String html, Spanned spanned) {
                // send html to backend, display message
                return true;
            }
        });

```

**Camera Button**

The CameraButtonClickListener is called when a user taps on the camera button in the text input

```java
        mojiInputLayout.setCameraButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle camera click
            }
        });

```


**Hypermoji - Emoji with a URL**


To handle the display of a webpage when tapping on a Hypermoji ( a emoji with a URL link), use the HyperMojiClickListener callback

```java
        mojiInputLayout.setHyperMojiClickListener(new HyperMojiListener() {
            @Override
            public void onClick(String url) {
				// handle opening URL
            }
        });

```

**Displaying Messages**

We have included a optimized ListAdapter for displaying HTML messages (MAdapater). It is recommended to use this as a starting point to building your own message display. 



FAQ
---------------------

*	The Makemoji SDK is completely free.

*	All emojis are served from AWS S3.

*	We do not store your messages. Your app backend will have to process and serve messages created with our SDK.

*	We do not send push notifications.

*	Your app's message volume does not affect the performance of our SDK.

*	Messages are composed of simple HTML containing image and paragraph tags. Formatting is presented as inline CSS.

*  All network operations happen asyncronously and do not block the User Interface

Service Performance
---------------------

* Avg Service Repsonse Time: 100ms
 
* Hosted with AWS using Elastic Beanstalk & RDS

* Scales seamlessly to meet traffic demands