/*
	ApplicationContext can notify beans of application events
	Besn receive events if they implement ApplicationListener
	Interface is parameterized, so only appropriately typed events are received
	Container proved 3 standard events:
		1. ContextRefresedEvent - published when ApplicationContext is initialized or refreshed (ie. appContext.refresh(); )
		2. ContextClosedEvent - published when ApplicationContext is closed (ie. appContext.cloas(); )
		3. RequestHandledEvent - web-specific event telling all eans taht a HTTP request has been serviced.

	Beans can pulbish events by calling publishEvent() on ApplicatoinContest
*/
public class MyListener implements ApplicationListener<ApplicationEvent> {
	
	void onApplicaitonEvent(ApplicationEvent event) {
		// do stuff
	}
}