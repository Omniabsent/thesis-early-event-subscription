public class FlexibleEventSubscriptionPEP implements ProcessEnginePlugin {
	@Override
	public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
		List<BpmnParseListener> postParseListeners = processEngineConfiguration.getCustomPostBPMNParseListeners();
		postParseListeners.add(new FlexibleSubscriptionParseListener());
	}
}

public class FlexibleSubscriptionParseListener implements BpmnParseListener {
	public void parseRootElement(Element rootElement, List<ProcessDefinitionEntity> processDefinitions) {
		ActivityImpl myActivity = ...
		// Subscribe at the end of that Activity
		myActivity.addListener(ExecutionListener.EVENTNAME_START, new SubscribeListener(subscriptionDefinition));
	}
}