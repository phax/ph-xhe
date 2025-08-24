# ph-xhe

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.helger/ph-xhe/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.helger/ph-xhe) 
[![javadoc](https://javadoc.io/badge2/com.helger/ph-xhe/javadoc.svg)](https://javadoc.io/doc/com.helger/ph-xhe)
[![CodeCov](https://codecov.io/gh/phax/ph-xhe/branch/master/graph/badge.svg)](https://codecov.io/gh/phax/ph-xhe)

OASIS XHE (Exchange Header Envelope) Java wrapper library.
It supports simple reading and writing of XHE 1.0 documents. This library supports the final version of XHE 1.0 (older versions support previous CS versions).
It allows conversion between Java domain objects and XML representations.

It is licensed under Apache 2.0 license.

It requires at least Java 17 to be used.

# Maven usage

Add the following to your pom.xml to use this artifact, replacing `x.y.z` with the effective version number:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-xhe</artifactId>
  <version>x.y.z</version>
</dependency>
```

# References

* [OASIS Exchange Header Envelope Version 1.0 OS](https://docs.oasis-open.org/bdxr/xhe/v1.0/xhe-v1.0-oasis.html)
* [OASIS Exchange Header Envelope Version 1.0 CS 03](https://docs.oasis-open.org/bdxr/xhe/v1.0/cs03/xhe-v1.0-cs03-oasis.html)
* [OASIS Exchange Header Envelope Version 1.0 CS 02](https://docs.oasis-open.org/bdxr/xhe/v1.0/cs02/xhe-v1.0-cs02-oasis.html)
* [OASIS Exchange Header Envelope Version 1.0 CS 01](https://docs.oasis-open.org/bdxr/xhe/v1.0/cs01/xhe-v1.0-cs01-oasis.html)

# News and noteworthy

v5.0.0 - 2025-08-24
* Requires Java 17 as the minimum version
* Updated to ph-commons 12.0.0
* Removed all deprecated methods marked for removal

v4.0.2 - 2025-02-20
* Switched JAXB Maven plugin to `org.jvnet.jaxb:jaxb-maven-plugin` 
* Deprecated marshaller constructors with a `boolean` parameter

v4.0.1 - 2023-04-22
* Moved XML Schema to folder `external/...`

v4.0.0 - 2023-01-08
* Using Java 11 as the baseline
* Updated to ph-commons 11
* Using JAXB 4.0 as the baseline

v3.0.0 - 2021-09-17
* Updated to XHE 1.0 OS
* Removed the separate handling of CS02 and CS03 packages - only the 1.0 OS version is supported

v2.2.1 - 2021-07-06
* Generating the JAXB stuff in a single execution to create a single episode file

v2.2.0 - 2021-05-02
* Updated to ph-commons 10.1

v2.1.0 - 2021-03-21
* Updated to ph-commons 10

v2.0.1 - 2021-03-18
* Updated to ph-commons 9.5.5
* Updated the XSDs to XHE 1.0 CS 03 - no changes except for XSD comments
* Changed the JAXB binding for `xs:dateTime` to `java.time.OffsetDateTime`

v2.0.0 - 2020-11-04
* Added support for XHE 1.0 CS03 - just changed namespace, hence not backwards compatible. The support for the old CS02 is still contained.
* The package `com.helger.xhe` was renamed to `com.helger.xhe.v10_cs02`
* The new package `com.helger.xhe.v10_cs03` for CS03 was added

v1.1.3 - 2020-09-17
* Updated to Jakarta JAXB 2.3.3

v1.1.2 - 2020-08-28
* Using Java 8 date and time classes for JAXB created classes

v1.1.1 - 2020-05-26
* Updated to ph-xsds 2.3.0 (changed Maven groupId)

v1.1.0 - 2020-04-01
* Added the `XHE10` prefix to all class names

v1.0.2 - 2020-03-30
* Fixed an invalid constant name in CXHE10
* Extended the API of the JAXB created classes

v1.0.1 - 2020-03-04
* Updated to CS02 - no changes in XSD
* Added new class `XHE10NamespaceContext`

v1.0.0 - 2019-05-28
* Initial version

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodingStyleguide.md) |
It is appreciated if you star the GitHub project if you like it.