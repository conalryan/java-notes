/*
@Configuration
	Identify class as config class
	Used in Annotation-Based Config
	Used in Java-Based Config
	Class level

@PropertySource("claspath:myproperties.properties")	
@PropertySource("claspath:com/example/propertiesfolder/myproperties.properties")
	Adds the properties into the Spring environment
	To get the properties
		@Inject
		Environment env; 
		env.getProperty("myproperties.some.prop, SomeClass.class");

@Import({MyConfig2.class, MyConfig3.class})
	import more config classes as needed or leave out if only 1 config
	Class level

@ImportResource("classpath:otherConfig.xml")
	import an xml config
	Class level

@ComponentScan(basePackages = "com.some.package")
	Specify which packages to find Beans
	Used in Annotation-Based Config
	Class level

@Lazy
	ApplicationContext will eagerly pre-instantiate beans at startup.
	To lazy instantiated (ie. bean created when it is first requested) set:
	@Lazy(value = true)
	or in xml => lazy-init="true" attribute on you r<bean> element
	Method, Constructor, Parameter, Field

@Profile
	Support environments with different configurations (eg. "dev", "production")
	@Profile("dev")
	@Profile({"dev", "other"})
	Class level
	Field level

	Enable profiles
		in JVM
			-Dspring.profiles.active=dev
		in Spring
			context.getEnviornmnet().setActiveProfiles("dev");
		or multiple profiles
			context.getEnviornmnet().setActiveProfiles("dev", "other");

	Inheritance
	Have a base config and subclasses extend it adding correct implementation
	for a given profile
	
	@Configuration
	public Abastract class MyBaseConfig {
		abstract void setMyDb();		
	}

	@Configuration
	@Profile("dev")
	public class MyDevConfig extends MyBaseConfig {
		public void setMyDb() {
			// dev db
		}
	}

	@Configuration
	@Profile("production")
	public class MyProductionConfig extend MyBaseConfig {		
		public void setMyDb() {
			// producation db
		}
	}

To load into container
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
	MySimpleBean mySimpleBean = context.getBean(MySimpleBean.class);
*/
@Configuration
@Profile("dev")
@PropertySource("claspath:myproperties.properties")
@Import({MyConfig2.class, MyConfig3.class})
@ImportResource("classpath:otherConfig.xml")
@ComponentScan(basePackages = "com.some.package")
public class MyJavaConfig {
	
	/* ============================================================================================
	 * INJECT
	 * @Import(MyConfig2.class) does not give MyJavaConfig class access to it internally
	 * it only adds the class to the container. 
	 * if you need to use it in this class then use @Inject
	 */
	@Inject
	MyConfig2 myConfig2;

	/* ============================================================================================
	 * PROPERTIES FILE
	 * use @PropertySource("claspath:myproperties.properties")
	 * or @Inject Environment env; to get properties
	 */
	@Inject
	Environment env;
	String someProp = env.getProperty("myproperties.some.prop", String.class);

	@Value("${myproperties.some.prop")
	String propFromFile;
	
	/* ============================================================================================
	 * SIMPLE BEAN
	 */
	@Bean
	public MySimpleBean mySimpleBean() {
		return new MySimpleBean();
	}

	/* ============================================================================================
	 * SETTER INJECTION
	 */
	@Bean
	public MySetterBean mySetterBean() {
		MySetterBean mySetterBean = new MySetterBean();
		mySetterBean.setMyProp(mySimpleBean());
		return mySetterBean;
	}

	/* ============================================================================================
	 * CONSTRUCTOR INJECTION
	 * Container will try to match the constructors based on type
	 * Best strategy is to match the constructor argument order exactly
	 */
	@Bean
	public MyConstructorBean MyConstructorBean() {
		return new MyConstructorBean(mySimpleBean());
	}

	/* ============================================================================================
	 * NAMING
	 * SPECIFY UNIQUE NAME
	 */
	@Bean("newName")
	public MyOldNameBean myOldNameBean() {
		return new MyOldNameBean();
	}

	// MULTIPLE ALIASES
	@Bean(name = {"aliaseOne", "aliaseTwo"})
	public MyMultipleAliasesBean myMultipleAliasesBean() {
		return new MyMultipleAliasesBean();
	}

	/* ============================================================================================
	 * LIFECYCLE
	 * same as annotation config using @PostConstruct and @PreDestroy
	 * for complete controll have bean implement BeanPostProcessor
	 * not you could postProcessBeforeInitializatio and postProcessAfterInitialization
	 */
	@Bean(initMethod = "myInit", destroyMethod = "myDestroy")
	public MyInitDestroyBean myInitDestroyBean() {
		return new MyInitDestroyBean();
	}

	@Bean
	@Lazy
	// or @Lazy(value = "true") default is true
	public MyLazyBean myLazyBean() {
		return new MyLazyBean();
	}

	/* ============================================================================================
	 * SCOPE
	 * SCOPE_SINGLETON is not needed it's the default
	 * setting SCOPE_PROTOTYPE you essentially make a cache
	 * singleton 	(default) single instance (per Spring container)
	 * prototype 	(new every time bean is needed, useful for state)
	 * web-aware	(request, session, global session)		
	 */
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public MyCache myCache() {
		return new MyCache();
	}

	/* ============================================================================================
	 * EVENTS
	 * @see MyListener.java
	 */

	/* ============================================================================================
	 * PROPERTY EDITORS
	 * Spring has built-in support to convert Strings to Java types. Supported:
	 * 		numbers
	 * 		dates
	 * 		enumerations
	 * 		collections
	 * 	or create your own
	 */
	@Bean
	public ConversionService myConversionService() {
		return new ConverstionServiceFactoryBean().getObject();
	}

	/* ============================================================================================
	 * PROFILES
	 */
	@Bean
	@Profile("dev")
	public OrderFactory devOrderFactory() {}

	@Bean
	@Profile("production")
	public OrderFactory productionOrderFactory() {}
}