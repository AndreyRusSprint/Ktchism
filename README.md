# Ktchism

[ ![Bintray](https://api.bintray.com/packages/absurdpalsy/Maven/ktchism-core/images/download.svg) ](https://bintray.com/absurdpalsy/Maven/ktchism-core/_latestVersion)
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

A complex of architectural and auxiliary components for building the better software products.

Inspired by Uncle Bob's Clean Architecture.

## Integration

Replace `ktchismVersion` with the latest version number:
[ ![Bintray](https://api.bintray.com/packages/absurdpalsy/Maven/ktchism-core/images/download.svg) ](https://bintray.com/absurdpalsy/Maven/ktchism-core/_latestVersion)

### Ktchism-core

[About](https://github.com/AndreyRusSprint/Ktchism/tree/master/ktchism-core)

```groovy
dependencies {
    // ...
    implementation "com.absurdpalsy.ktchism:ktchism-core:$ktchismVersion"
}
```

### Ktchism-rx

[About](https://github.com/AndreyRusSprint/Ktchism/tree/master/ktchism-rx)

For reactive extensions of the core module add this:

```groovy
dependencies {
    // ...
    implementation "com.absurdpalsy.ktchism:ktchism-rx:$ktchismVersion"
}
```

## License
```
MIT License

Copyright (c) 2017 absurdpalsy (@AndreyRusSprint)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
