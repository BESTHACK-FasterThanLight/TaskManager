-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
-dontwarn com.google.errorprone.annotations.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

-keep class com.tozny.crypto.android.AesCbcWithIntegrity$PrngFixes$* { *; }

-dontwarn kotlin.**
-repackageclasses