package todo.boot;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

//@RestController
@Component
//커스텀 어노테이션이나 메타 어노테이션으로 컴포넌트가 포함되어있어도 Bean으로 등록됨.
//@MyComponent
//RestController 어노테이션에는 ReponseBody가 포함됨.ㄴ
@ResponseBody
@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String helloV1(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }

    @GetMapping
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
