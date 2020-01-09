/*
	or in xml
	<bean if="myDecryptionPostProcessor" class="com.example.MyDecryptionPostProcessor" /?
*/
public class MyDecryptionPostProcessor implements BeanPostProcessor {
	
	Object postProcessBeforeInitialization(Object bean, String beanName) {
		// do stuff
	}

	Ojbect postProcessAfterInitialization(Object bean, String beanName) {
		// do stuff
	}
}