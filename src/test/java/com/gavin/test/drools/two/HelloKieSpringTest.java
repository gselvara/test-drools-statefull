package com.gavin.test.drools.two;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:com/redhat/gss/kie/kmodule-spring.xml" })
public class HelloKieSpringTest {

	@Autowired
	private ApplicationContext ctx;

	@Test
	public void hello() {
		methodTwo();
	}

	private void methodTwo() {
		KieSession kieSession = (KieSession) ctx.getBean("kieSession");
		String[] names = new String[] { "kitchen", "bedroom", "office", "livingroom" };
		Map<String, Room> name2room = new HashMap<String, Room>();
		for (String name : names) {
			Room room = new Room(name);
			name2room.put(name, room);
			kieSession.insert(room);
			Sprinkler sprinkler = new Sprinkler(room);
			kieSession.insert(sprinkler);
		}

		Fire kitchenFire = new Fire( name2room.get( "kitchen" ) );
		Fire officeFire = new Fire( name2room.get( "office" ) );

		FactHandle kitchenFireHandle = kieSession.insert( kitchenFire );
		FactHandle officeFireHandle = kieSession.insert( officeFire );
		
		kieSession.fireAllRules();

		kieSession.delete( kitchenFireHandle );
		kieSession.delete( officeFireHandle );

		kieSession.fireAllRules();
	}

}
