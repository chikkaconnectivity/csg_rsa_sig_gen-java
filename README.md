# Java Chikka Service Gateway RSA Signature Generator

## Information

A simple library for the CSG (Chikka Service Gateway) clients for singing post
body requests to be sent to the CSG.

## Usage

Import or copy the contents of the ChikkaRSASigner.java file in your code and
simply use it as shown below:

```java
String signature = ChikkaRSASigner.sign("my message", new File("/home/user/myprivkey.der");
```

## Notes

This library uses keys in DER format instead of regular PEM formats. See
http://lmgtfy.com/?q=how+to+convert+pem+to+der+using+openssl for details on how
to convert PEM keys into DER formats using openssl.

## Open Source Licenses

### Java Chikka Service Gateway RSA Signature Generator by Chikka Philippines Inc.

Copyright 2014 Chikka Philippines Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

