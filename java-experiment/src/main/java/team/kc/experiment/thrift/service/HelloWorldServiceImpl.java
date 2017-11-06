package team.kc.experiment.thrift.service;

import org.apache.thrift.TException;

import team.kc.experiment.thrift.dto.HelloVo;

public class HelloWorldServiceImpl implements HelloWorldService.Iface {

	public String sayHello(HelloVo helloVo) throws TException {
		String str = String.format("Hello world! My name is %s, I am %d", helloVo.name, helloVo.age);
		System.out.println( str );
		return str;
	}

}
