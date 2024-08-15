Created as example for: https://issuetracker.google.com/issues/360058652

```kotlin
object CurrencyOutputTransformation : OutputTransformation {
    override fun TextFieldBuffer.transformOutput() {
        if (asCharSequence().isNotBlank()) insert(length, " €")
    }
}
```
[direct link to sample code](https://github.com/lustikuss/OutputtransformationSuffixBug/blob/main/app/src/main/java/com/example/outputtransformationsuffixbugsample/MainActivity.kt)

Emulator: https://youtube.com/shorts/mL8R6skAR8g

Samsung: https://youtube.com/shorts/2FZamLx1Pgo
