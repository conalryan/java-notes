/*
DSL annotations clarify your wiring
	Annotate a type to indicate it has the rubber stamp
		@Named @MyQualifier(MyEnum.SOMEVALUE)
		public class MyImpl implements MyInterface {}
	Annotate an injection to show you want a particular stamp
		@Inject @MyQualifier(MyEnum.SOMEVALUE)
		MyInterface myImpl;

If your element is named value, and it's the only element you are using in the annotation
you can leave out the value=
	@MyQualifier(value = MyEnum.OTHERVALUE) becomes @MyQualifier(MyEnum.SOMEVALUE)

*/
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface MyQualifier {
	MyEnum value();

	// call @MyQualifier(MyEnum.SOMEVALUE) or @MyQualifier(value = MyEnum.OTHERVALUE)
}