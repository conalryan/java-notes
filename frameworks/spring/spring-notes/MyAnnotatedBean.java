/*
@Named
@Named("someName")
	Java annoation
	Best practice
	Class level

@Component 
@Component("someName")
	Spring annotation
	Avoid
	Class level

@Inject 
	Java annoation
	Best practice
	Field level

@Autowired 
	Spring annotation
	Avoid
	Field level

@Value
	Inject a property directly
	you will need a prepty placeholder declared (easiest done in XML)
	<context:property-placeholder />
	@Value("${myproperty.some.prop}")

	Spel
	@Value("#{someBean.someValue")

@Required
	Spring annotation
	Specify a given property must be set.
	Protects Spring from instantiating bean w/out setting need property

@Qualifier
	JSR-330
	Gives more control over wiring/DI. Allows you to create a DSL (Domain Specific-Language)
	Specify which implmentation of an interface to inject
		@Inject
		MyInterface myImpl;
		@Inject
		MyInterface myImplToo;	
*/
@Named
public class MyAnnotatedBean {

	/* ============================================================================================
	 * INJECT
	 */
	@Inject	
	private T myInjectedProperty;

	/* ============================================================================================
	 * QUALIFIER
	 */
	@Inject
	@Qualifier(MyEnum.SOMEVALUE)
	MyInterface myImpl;

	@Inject
	@Qualifier(MyEnum.OTHERVALUE)
	MyInterface myImpl2;

	/* ============================================================================================
	 * PROPERTIES FILE
	 * use @PropertySource or @Inject to get properties
	 */
	@Inject
	Environment env;
	String someProp = env.getProperty("myproperties.some.prop", String.class);

	@Value("${myproperties.some.prop")
	String propFromFile;

	/* ============================================================================================
	 * LIFECYCLE
	 */
	@PostConstruct
	public void myInit() {
		// method called after bean created and properties initialized
		// same as in Java config @Bean(initMethod = "myInit", destroyMethod = "myDestroy")
	}

	@PreDestory
	public void myDestroy() {
		// method called before container destroys bean
		// same as in Java config @Bean(initMethod = "myInit", destroyMethod = "myDestroy")
	}
}