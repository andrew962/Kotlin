# Splash Screen

- Kotlin

Configuracion para agregar una animacion al iniciar una aplicacion.

## Configuracion
Se tiene que agregar un dependencia para poder utilizar los Gif

[Documentacion](https://github.com/koral--/android-gif-drawable)


`build.gradle(Module:<nombre-de-app>.app)`
```
dependencies {
    ...
    implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.23'
}
```

Agregamos un nuevo "Activity"

-  `New` > `Activity` > `Empty Activity`
    * `Activity Name` "SplashScreenActivity" (nombre opcional)

>**SplashScreenActivity.kt**
```kotlin
 class SplashScreenActivity : AppCompatActivity() {
    private val splashScreenTime: Int = 4000
    ...
    Handler(Looper.getMainLooper()).postDelayed({
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }, this.splashScreenTime.toLong())
```
__Agregamos el gif o la imagen a la carpeta de drawable__

>**activity_splash.xml**
```xml
    ...
    <pl.droidsonroids.gif.GifImageView
        android:layout_width="300dp"
        android:layout_height="170dp"
        android:src="@drawable/splashscreen_dark"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
    ...
```