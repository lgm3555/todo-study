package todo.boot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@SpringBootApplication

//Sping Container가 보고 Bean 어노테이션이 있는 클래스구나 알 수 있음.
@Configuration
//이 클래스 하위 패키지를 찾아서 Component가 붙은 모든 클래스를 Bean으로 등록
@ComponentScan
public class TodoSpringbootApplication {

	/*
	case5
	@Bean
	public HelloController helloController(HelloService helloService) {
		return new HelloController(helloService);
	}

	@Bean
	public HelloService helloService() {
		return new SimpleHelloService();
	}
	*/

	public static void main(String[] args) {

		/*
		case1 : 서블릿 컨테이너 직접 구현
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			servletContext.addServlet("hello", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					String name = req.getParameter("name");

					resp.setStatus(200);
					//resp.setHeader("Content-Type", "text/plain");
					resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
					resp.getWriter().print("Hello " + name);
				}
			}).addMapping("/hello");
		});
		webServer.start();
		 */

		/*
		서블릿 컨테이너 관리, name 바인딩 작업 처리를 직접 해줘야 해서 불편함.
		GenericApplicationContext applicationContext = new GenericApplicationContext();
		applicationContext.registerBean(HelloController.class);
		applicationContext.registerBean(SimpleHelloService.class);
		applicationContext.refresh();
		*/

		/*
		case2 : 프론트 컨틀롤러 전환
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			//bean 등록 후 사용 방식으로 변경
			//HelloController helloController = new HelloController();

			servletContext.addServlet("hello", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					// 인증, 보안, 다국어, 공통 기능
					if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
						String name = req.getParameter("name");

						HelloController helloController = applicationContext.getBean(HelloController.class);
						String ret = helloController.helloV1(name);

						resp.setStatus(200);
						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().print(ret);
					} else if (req.getRequestURI().equals("/user")) {

					} else {
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*");
		});
		webServer.start();
		 */

		/*
		case3 : 컨트롤러 매핑과 호출
		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
		applicationContext.registerBean(HelloController.class);
		applicationContext.registerBean(SimpleHelloService.class);
		applicationContext.refresh();

		//서블릿 컨테이너
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			servletContext.addServlet("dispatcherServlet",
					new DispatcherServlet(applicationContext)
			).addMapping("/*");
		});
		webServer.start();
  		*/

		/*
		case4 : 스프링 컨테이너와 서블릿 컨테이너 통합
		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				//서블릿 컨테이너
				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServlet",
							new DispatcherServlet(this)
					).addMapping("/*");
				});
				webServer.start();
			}
		};
		applicationContext.registerBean(HelloController.class);
		applicationContext.registerBean(SimpleHelloService.class);
		applicationContext.refresh();
		*/

		/*
		case5 : 자바 코드로 구성 정보 사용.
		GenericWebApplicationContext applicationContext = new AnnotationConfigServletWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				//서블릿 컨테이너
				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServlet",
							new DispatcherServlet(this)
					).addMapping("/*");
				});
				webServer.start();
			}
		};
		applicationContext.registerBean(TodoSpringbootApplication.class);
		applicationContext.refresh();
		*/

		GenericWebApplicationContext applicationContext = new AnnotationConfigServletWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				//서블릿 컨테이너
				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServlet",
							new DispatcherServlet(this)
					).addMapping("/*");
				});
				webServer.start();
			}
		};
		applicationContext.registerBean(TodoSpringbootApplication.class);
		applicationContext.refresh();
	}
}
