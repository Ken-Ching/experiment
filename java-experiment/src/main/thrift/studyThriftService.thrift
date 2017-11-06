namespace java team.kc.experiment.thrift.service

include "studyThriftDto.thrift"

/* Service Define */
service HelloWorldService {
	string sayHello (1:studyThriftDto.HelloVo helloVo);
}