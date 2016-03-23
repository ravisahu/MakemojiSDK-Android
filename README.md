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
	* minSdkVersion 14
	* targetSDKVersion 23

* Add this to your projects build.gradle file

```
dependencies {
<<<<<<< HEAD
	compile 'com.makemoji:makemoji-sdk-android:0.9.52
=======
	compile 'com.makemoji:makemoji-sdk-android:0.9.51'
>>>>>>> 85d18947b41f1c05719f9aaeb1e1beb9b6e82990
}	 
repositories {
    jcenter()
}
```


SDK Usage
---------------------

**Initialization**

To start using the MakemojiSDK you will first have to add a few lines to your Application class. 

If you haven't already, declare an application class in your AndroidManifest.xml using it's fully qualified class name.

```xml
    <application
        android:name="com.makemoji.sbaar.mojilist.App"
        ...
```
Then in App.java onCreate, setup your SDK key.

```java
	public void onCreate(){
        super.onCreate();
        Moji.initialize(this,"YOUR_KEY_HERE");
    }

```


**Setup the Makemoji TextInput**

First you will want to add the component to your activity content layout. You can change the colors and drawables and layout for the 'Send' button by specifying a style inheriting from MojiInputLayoutDefaultStyle.

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
```

**Send a Message**

The SendLayoutClickListener will be called when a user clicks on the send button in the text input. This should be set in onCreate

```java
        mojiInputLayout.setSendLayoutClickListener(new MojiInputLayout.SendClickListener() {
            @Override
            public boolean onClick(String html, Spanned spanned) {
                // send html to backend, display message
                return true;//true to clear the field, false to keep it
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


To handle the display of a webpage when tapping on a Hypermoji ( a emoji with a URL link), use the HyperMojiClickListener callback. 

```java
        mojiInputLayout.setHyperMojiClickListener(new HyperMojiListener() {
            @Override
            public void onClick(String url) {
				// handle opening URL
            }
        });

```

**Displaying Messages**

We have included a optimized ListView Adapter for displaying HTML messages and customizing HyperMoji click action (MAdapater) . It is recommended to use this as a starting point to building your own message display.  Take note of how it uses Moji class methods to set text  and how to set a HyperMojiListener on an individual TextView.

**Detatched Input**

To hide the built in Edit Text and use your own that is somewhere else on the screen as the input target, call attatchMojiEditText(MojiEditText outsideMojiEdit) on the MojiInputLayout. Call detachMojiEditText() to restore the default behavior. Note that attatchMojiEditText requires an EditText that is an intanceof MojiEditText to ensure keyboard compatibility and correct copy paste functionality.
```java
            mojiInputLayout.attatchMojiEditText(outsideMojiEdit);
            outsideMojiEdit.setVisibility(View.VISIBLE);
            outsideMojiEdit.requestFocus();
```

**Plain Text Converter**

If you need to convert an html message to a platform that does not support MakeMoji, you can use the plain text converter to produce a message with a human-friendly reading that converts emojis into the form [flashtagname.base62emojiid hypermojiurl]. For example, "Aliens are real [alien.gG iwanttobelieve.com]." It is reccommended to store the html of the message as the cannonical version, but you can also convert from plain text back to html if needed.
```java
        mojiInputLayout.setSendLayoutClickListener(new MojiInputLayout.SendClickListener() {
            @Override
            public boolean onClick(String html, Spanned spanned) {
                    String plainText = Moji.htmlToPlainText(html);
                    String htmlFromPlain = Moji.plainTextToHtml(plainText);
                    }});
```

**Proguard Setup**

If you need to use proguard when signing your app, add the following to your proguard-rules.pro file
```
-keep class com.makemoji.** { *; }
-keep class com.retrofit2.** { *; }
-keep class com.viewpagerindicator.** { *; }
-keep class org.ccil.** { *; }
-keep class com.squareup.** { *; }

-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**
-dontwarn okio.**
-dontwarn retrofit2.**
-dontwarn com.viewpagerindicator.**
-dontwarn rx.**

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

-keepattributes Signature
-keepattributes Exceptions
```


FAQ
---------------------

*	The Makemoji SDK is completely free.

*	All emojis are served from AWS S3.

*	We do not store your messages. Your app backend will have to process and serve messages created with our SDK.

*	We do not send push notifications.

*	Your app's message volume does not affect the performance of our SDK.

*	Messages are composed of simple HTML containing image and paragraph tags. Formatting is presented as inline CSS.

*  All network operations happen asynchronously and do not block the User Interface

Service Performance
---------------------

* Avg Service Repsonse Time: 100ms
 
* Hosted with AWS using Elastic Beanstalk & RDS

* Scales seamlessly to meet traffic demands
