package systems.enji.demo.mp.config;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import systems.enji.demo.mp.config.api.IDemoService;

/**
 * Demo service returning values using MicroProfile Config.
 * 
 * See interface for high-level documentation.
 */
public class DemoService implements IDemoService {

  @Inject
  @ConfigProperty(name="demo.string")
  private String _string; 

  // config parameters that might not have been set require the use of Optional
  // (would result in DeploymentException otherwise)
  @Inject
  @ConfigProperty(name="demo.notset")
  private Optional<String> _notset; 

  // the value for this is provided via system property
  @Inject
  @ConfigProperty(name="demo.sysprop")
  private Optional<String> _sysprop; 

  // a default value can be provided at injection time
  @Inject
  @ConfigProperty(name="demo.default", defaultValue="defaultValue")
  private String _default; 

  @Inject
  @ConfigProperty(name="demo.boolean")
  private boolean _boolean; 

  @Inject
  @ConfigProperty(name="demo.int")
  private int _int; 

  @Inject
  @ConfigProperty(name="demo.list")
  private List<String> _list; 

  static {
    // usually, you would set this from outside via "java -Ddemo.sysprop=syspropValue"
    System.getProperties().setProperty("demo.sysprop", "syspropValue");
  }
  
  @Override
  public String injected() {
    return _string;
  }
  
  @Override
  public String programmatic() {
    Config config = ConfigProvider.getConfig();
    return config.getValue("demo.string", String.class);
  }

  @Override
  public String sysprop() {
    return _sysprop.orElse(null);
  }
  
  @Override
  public String notset() {
    return _notset.orElse(null);
  }

  @Override
  public String defaultValue() {
    return _default;
  }

  @Override
  public boolean booleanValue() {
    return _boolean;
  }

  @Override
  public int intValue() {
    return _int;
  }

  @Override
  public List<String> list() {
    return _list;
  }

}
