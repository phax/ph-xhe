# ph-xhe

OASIS XHE (Exchange Header Envelope) Java wrapper library.
It supports simple reading and writing of XHE 1.0 documents.
It allows conversion between Java domain objects and XML representations.

It is licensed under Apache 2.0 license.

It requires at least Java 8 to be used.

# Maven usage

Add the following to your pom.xml to use this artifact, replacing `x.y.z` with the real version number:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-xhe</artifactId>
  <version>x.y.z</version>
</dependency>
```

# References

* [OASIS Exchange Header Envelope Version 1.0 CS 02](https://docs.oasis-open.org/bdxr/xhe/v1.0/cs02/xhe-v1.0-cs02-oasis.html)
* [OASIS Exchange Header Envelope Version 1.0 CS 01](https://docs.oasis-open.org/bdxr/xhe/v1.0/cs01/xhe-v1.0-cs01-oasis.html)

# News and noteworthy

* v1.1.3 - 2020-09-17
    * Updated to Jakarta JAXB 2.3.3
* v1.1.2 - 2020-08-28
    * Using Java 8 date and time classes for JAXB created classes
* v1.1.1 - 2020-05-26
    * Updated to ph-xsds 2.3.0 (changed Maven groupId)
* v1.1.0 - 2020-04-01
    * Added the `XHE10` prefix to all class names
* v1.0.2 - 2020-03-30
    * Fixed an invalid constant name in CXHE10
    * Extended the API of the JAXB created classes
* v1.0.1 - 2020-03-04
    * Updated to CS02 - no changes in XSD
    * Added new class `XHE10NamespaceContext`
* v1.0.0 - 2019-05-28
    * Initial version


---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodingStyleguide.md) |
On Twitter: <a href="https://twitter.com/philiphelger">@philiphelger</a> |
Kindly supported by [YourKit Java Profiler](https://www.yourkit.com)