Created as example for: https://issuetracker.google.com/issues/360058652

```kotlin
object CurrencyOutputTransformation : OutputTransformation {
    override fun TextFieldBuffer.transformOutput() {
        if (asCharSequence().isNotBlank()) insert(length, " €")
    }
}
```
