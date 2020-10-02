If `CopySpec.expand(Map)` is invoked with a map that contains only one entry, Gradle's copy function fails with the message:
```
> Could not copy file '...' to '...'.
   > java.lang.UnsupportedOperationException (no error message)
```

Look at build.gradle.kts. At defines two tasks that are almost identical. 
Task "workingTask" invokes `expand(Map)` with a map with two entries (even though the second of them is useless).
Task "failingTask" invokes `expand(Map)` with a map with one entry, and fails.

The current version of Gradle is 6.6.1.
