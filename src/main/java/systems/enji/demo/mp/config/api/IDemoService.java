package systems.enji.demo.mp.config.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("")
public interface IDemoService {

  /**
   * Returns a config property via injection.
   */
  @Path("injected")
  @GET
  String injected();

  /**
   * Returns a config property via programmatic lookup.
   */
  @Path("programmatic")
  @GET
  String programmatic();

  /**
   * Returns a config property via Java system property.
   */
  @Path("sysprop")
  @GET
  String sysprop();

  /**
   * Tries to return a config property that has not been set.
   */
  @Path("notset")
  @GET
  String notset();

  /**
   * Returns the default value for a config property that has not been set.
   */
  @Path("defaultValue")
  @GET
  String defaultValue();

  /**
   * Returns an integer config property.
   */
  @Path("intValue")
  @GET
  int intValue();

  /**
   * Returns a boolean config property.
   */
  @Path("booleanValue")
  @GET
  boolean booleanValue();
  
  /**
   * Returns a config property list.
   */
  @Path("list")
  @GET
  List<String> list();

}
