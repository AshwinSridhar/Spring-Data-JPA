import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.service.EmployeeService;


public class MainApp {
	public static void main(String[] args){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(com.spring.configuration.config.class);
		EmployeeService emp = (EmployeeService) ctx.getBean("employeeService");
		//emp.insertEmployee();
		emp.readEmployee();
	}
}
