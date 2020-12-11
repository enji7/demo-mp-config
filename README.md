# Demo: MicroProfile Config

Basic tech demo for MicroProfile Config 1.4.

Tested with WildFly 21.

## Config Sources

Default config sources (from overriding to overridden):

 * system properties
 * environment variables
 * META-INF/microprofile-config.properties

Custom config sources must

 * implement the interface `org.eclipse.microprofile.config.spi.ConfigSource`
 * be registered in `/META-INF/services/org.eclipse.microprofile.config.spi.ConfigSource`

Alternatively, you can also implement a ConfigSourceProvider, which returns a list of ConfigSources and hence, allows for dynamic source discovery. A ConfigSourceProvider must

 * implement the interface `org.eclipse.microprofile.config.spi.ConfigSourceProvider`
 * be registered in `/META-INF/services/org.eclipse.microprofile.config.spi.ConfigSourceProvider`

## Resources

 * <https://github.com/eclipse/microprofile-config>
 * <https://github.com/eclipse/microprofile-config/releases>

Resources for the complete MicroProfile spec:

 * <https://projects.eclipse.org/projects/technology.microprofile>
 * <https://github.com/eclipse/microprofile>
 * <https://github.com/eclipse/microprofile/releases>