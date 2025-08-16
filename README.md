# asu-log

Lightweight logging based on [minlog](https://github.com/EsotericSoftware/minlog) (modified), 
designed for **testing**, **small tools**, or any project where a full-featured logging framework is unnecessary.

* ✅ **Java 8 compatible**
* ✅ **No Logback / Log4j needed**
* ✅ **SLF4J compatible** for easy integration

---

## Quick Example

```java
import me.asu.log.Log;

public class Example {
    public static void main(String[] args) {
        Log.info("Hello asu-log!");
        Log.debug("Debug message");
    }
}
```

Runtime log level can be controlled with:

```
-Dminlog.level=TRACE|DEBUG|INFO|WARN|ERROR|NONE
```

see asu-log-demo

---

## Why asu-log?

Most Java logging frameworks (e.g., **Logback**, **Log4j2**) are powerful but often **heavyweight**:

* Many transitive dependencies
* Complex XML/JSON/YAML configuration
* Longer startup times

**asu-log** is designed with a different philosophy:

* 🚀 **Lightweight & fast** — zero external dependencies, instant startup
* 🔧 **Simple API** — no complex configuration required
* 🧩 **Flexible integration** — works standalone or as an SLF4J binding/bridge
* 🌱 **Perfect for small tools, testing, and microservices**

When you need **just enough logging without the baggage**, `asu-log` is a practical choice.

---

## Modules

### asu-log-minlog

Modified version of EsotericSoftware’s `Log` code.

### asu-log-slf4j

SLF4J binding for `asu-log`.

* For testing or small tools
* Compatible with **SLF4J 1.7.x**

### asu-log-slf4j2

SLF4J binding for `asu-log`.

* For testing or small tools
* Compatible with **SLF4J 2.x**

### asu-log-to-slf4j

Bridge that routes **minlog output** to **SLF4J API**.

* For larger applications that already use SLF4J
* Ensures minlog logs are unified with the rest of your application logs

---

## Usage

Published via **JitPack**.

### Add Repository

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

### Add Dependency

Pick the module you need:

```xml
<dependency>
  <groupId>com.github.bruceasu</groupId>
  <artifactId>asu-log-slf4j</artifactId>
  <version>v1.0.0</version>
</dependency>
```

or

```xml
<dependency>
  <groupId>com.github.bruceasu</groupId>
  <artifactId>asu-log-slf4j2</artifactId>
  <version>v1.0.0</version>
</dependency>
```

or

```xml
<dependency>
  <groupId>com.github.bruceasu</groupId>
  <artifactId>asu-log-to-slf4j</artifactId>
  <version>v1.0.0</version>
</dependency>
```

⚠️ **Remove other SLF4J bindings** (`slf4j-simple`, `logback-classic`, `log4j-slf4j-impl`) to avoid conflicts.

---

## License

[Apache License 2.0](LICENSE)


