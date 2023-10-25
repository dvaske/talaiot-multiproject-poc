## Reproduce hanging build


When a multiproject build enables the [talaiot](https://github.com/cdsap/Talaiot) plugin and one or more of the tasks invoked is `buildDependent` the build might hang.

This repository provides a minimal example of this. It might not happen on every run but should on some.
The commandline to invoke is:

``` 
./gradlew :sub-a:buildDependent
```

The build should now be hanging at:

```
./gradlew :sub-a:buildDependent
Starting a Gradle Daemon (subsequent builds will be faster)
<==========---> 83% EXECUTING [7s]
> :sub-b:buildDependents
> :sub-a:check

```