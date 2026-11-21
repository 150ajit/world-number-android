# Proguard rules for World Population Live

-keepattributes *Annotation*
-keepattributes Signature
-keepattributes InnerClasses
-keepattributes EnclosingMethod

-dontwarn javax.annotation.**
-dontwarn okhttp3.**
-dontwarn okio.**

# Room
-keep class androidx.room.** { *; }
-dontwarn androidx.room.**
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class * { *; }
-keep @androidx.room.Dao class * { *; }

# Entities and Domain Models
-keep class com.example.worldpopulation.data.local.entity.** { *; }
-keep class com.example.worldpopulation.domain.model.** { *; }

# DTOs & Serialization
-keep class com.example.worldpopulation.data.remote.un.dto.** { *; }
-keep class com.example.worldpopulation.data.remote.worldbank.dto.** { *; }
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# Retrofit
-keepattributes Exceptions
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-dontwarn retrofit2.**

# Hilt & Dagger
-keep class * extends dagger.hilt.android.lifecycle.HiltViewModel
-dontwarn com.google.errorprone.annotations.**

# Coroutines
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
